Reactor Pattern

There are several components participating in this pattern. I will go through them first so it would be easy to understand the diagram.

Reactor Initiator: This is the component which would initiate the non blocking server by configuring and initiating the dispatcher. First it would bind the server socket and register it with the demultiplexer for client connection accept readiness events. Then the event handler implementations for each type of readiness events (read/ write/ accept etc..) will be registered with the dispatcher. Next the dispatcher event loop will be invoked to handle event notifications.

Dispatcher : Defines an interface for registering, removing, and dispatching Event Handlers responsible for reacting on connection events which include connection acceptance, data input/output and timeout events on a set of connections. For servicing a client connection the related event handler (e.g: accept event handler) would register the accepted client channel (wrapper for underlying client socket) with the demultiplexer along side with the type of readiness events to listen for that particular channel. Afterwards the dispatcher thread will invoke the blocking readiness selection operation on demultiplexer for the set of registered channels. Once one or more registered channels are ready for I/O the dispatcher would service each returned “Handle” associated with the each ready channel one by one using registered event handlers. It is important that these event handlers don’t hold up dispatcher thread since it will delay dispatcher servicing other ready connections. Since the usual logic within an event handler includes transferring data to/from the ready connection which would block until all the data are transferred between user space and kernel space data buffers normally it is the case that these handlers are run in different threads from a thread pool.

Handle : A handle is returned once a channel is registered with the demultiplexer which encapsulates connection channel and readiness information. A set of ready Handles would be returned by demultiplexer readiness selection operation. Java NIO equivalent is SelectionKey.

Demultiplexer : Waits for readiness events of in one or more registered connection channels. Java NIO equivalent is Selector.

Event Handler : Specifies the interface having hook methods for dispatching connection events. These methods need to be implemented by application specific event handler implementations.

Concrete Event Handler : Contains the logic to read/write data from underlying connection and to do the required processing or initiate client connection acceptance protocol from the passed Handle.
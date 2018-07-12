import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;


/**
 * @see <a href="http://static.javadoc.io/org.mockito/mockito-core/2.19.0/org/mockito/Mockito.html">Mockito</a>
 */
public class MockBasicDemoTest {

    @Test
    public void echo() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void TestStubbing() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
//        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        when(mockedList.get(anyInt())).thenReturn("element");
        //following prints "null" because get(999) was stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    /**
     * 测试集合 迭代
     *
     * @see <a href="https://stackoverflow.com/a/6379456/1616023">Testing Java enhanced for behavior with Mockito</a>
     */
    @Test
    public void TestIterator() {
        Iterator fruitIterator = mock(Iterator.class);
        when(fruitIterator.hasNext()).thenReturn(true, true, true, false);
        when(fruitIterator.next())
                .thenReturn("Apple")
                .thenReturn("Banana")
                .thenReturn("Pear");

        Collection fruits = mock(Collection.class);
        when(fruits.iterator()).thenReturn(fruitIterator);

        for (Object fruit : fruits) {
            System.out.println("fruit = " + fruit);
        }
    }

    /**
     * 调用某方法后直接回车
     */
    @Test
    public void TestCallbackMock() {
        Animal mock = mock(Animal.class);
        when(mock.getFixValue()).thenCallRealMethod();


        when(mock.sayHello(anyString())).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();

                System.out.println("mock = " + ((Animal) mock).getName());

                return "called with arguments: " + args[0];
            }
        });

        //the following prints "called with arguments: foo"
        System.out.println(mock.sayHello("foo"));
        System.out.println("real method get:" + mock.getFixValue());
    }
}
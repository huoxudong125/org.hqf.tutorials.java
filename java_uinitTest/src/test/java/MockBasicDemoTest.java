import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

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

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    /**
     * 测试集合 迭代
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
}
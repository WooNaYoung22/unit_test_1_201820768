
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 25);
        assertThat(result, is(25));
        assertFalse(result == 20);
        System.out.println("result :: " + result);

        int result2 = customCalculator.add(7,22);
        assertThat(result2, is(29));
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 13);
        assertFalse(result == 12);
        assertThat(result, is(13));
        System.out.println("result :: " + result);

        int result2 = customCalculator.subtract(2,10);
        assertThat(result2, is(-8));
    }

    @Test
    public void 빼기테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(22,7);
        assertFalse(result == 12);
        assertThat(result, is(15));

        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, is(45));
        assertTrue(result == 45);
        System.out.println("result :: " + result);

        int result2 = customCalculator.multiply(7,7);

        assertThat(result2, is(49));
        System.out.println("result2 :: " + result2);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, is(5));
        assertTrue(result == 5);
        assertFalse(result == 25);
        System.out.println("result :: " + result);

        int result2 = customCalculator.divide(49,7);
        assertThat(result2, is(7));
        System.out.println("result2 :: " + result2);
    }

    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(3000);
        Thread.sleep(5000);
    }

    @Test(timeout = 3000)
    public void 시간제한체크() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyIndexOutOfBoundException() {
        new ArrayList<Object>().get(0);
        new ArrayList<Object>().get(1);

        List<String> myList = Arrays.asList("a", "b", "c", "d");
        myList.get(0);
    }

    @Test
    public void testMethod() {
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList, is(empty()));

        List<String> abcdList = Arrays.asList("a", "b", "c", "d");
        assertThat(abcdList, is(empty()));
    }

    @Test
    public void isEmptyArray() {
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList, is(empty()));

        List<String> nameList = Arrays.asList("John", "Juily", "Tom", "Han");
        assertThat(nameList, is(empty()));
    }

}
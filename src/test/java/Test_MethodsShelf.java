import org.junit.jupiter.api.*;

import java.util.Calendar;

class TestMethodsShelf {
    static private long startTime;
    static private int testCounter = 0;

    @BeforeAll
    public static void beginning() {
        startTime = Calendar.getInstance().getTimeInMillis();
    }

    @AfterAll
    public static void ending() {
        System.out.println("Test passed for in milliseconds: " +
                ((Calendar.getInstance().getTimeInMillis()) - startTime));
    }

    @AfterEach
    public void message() {
        testCounter++;
        System.out.println(testCounter + " test completed");
    }

    @Test
    public void testIsNumberCorrect() {
        String[] products = {
                "Diet Pepsi 0,5",
                "Strawberry Donut",
                "Choco Pie with orange"
        };
        String firstNumber = "2";
        String secondNumber = "15";

        Assertions.assertTrue(MethodsShelf.isNumberCorrect(firstNumber, secondNumber, products));
    }

    @Test
    public void testIsCharNotLetter() {
        String text = "123";

        Assertions.assertTrue(MethodsShelf.isCharNotLetter(text));
    }

    @Test
    public void testIsSpaceSecond() {
        String text = "1das5";

        Assertions.assertFalse(MethodsShelf.isSpaceSecond(text));
    }
}
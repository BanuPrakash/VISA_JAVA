import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionOneTest {
    QuestionOne question;
    @Before
    public void setUp() {
        question = new QuestionOne();
    }

    @Test
    public void testMaxSubArrayUTC1() {
        int[] input = {-2, 1,-3, 4,-1, 2, 1,-5,4};
        int result = question.maxSubArray(input);
        int expected = 6;
        assertEquals(result, expected);
    }

    @Test
    public void testMaxSubArrayUTC2() {
        int[] input = {1};
        int result = question.maxSubArray(input);
        int expected = 1;
        assertEquals(result, expected);
    }

    @Test
    public void testMaxSubArrayUTC3() {
        int[] input = {5, 4, -1, 7, 8};
        int result = question.maxSubArray(input);
        int expected = 23;
        assertEquals(result, expected);
    }
}

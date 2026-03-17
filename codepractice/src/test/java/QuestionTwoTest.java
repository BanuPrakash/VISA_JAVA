import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionTwoTest {

    @Test
    public void maxProfitTestUTC1() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 5;
        assertEquals(QuestionTwo.maxProfit(prices), expected);
    }

    @Test
    public void maxProfitTestUTC2() {
        int[] prices = {7, 6, 3, 1};
        int expected = 0;
        assertEquals(QuestionTwo.maxProfit(prices), expected);
    }
}

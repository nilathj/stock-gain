import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StockGainTest {
    @Test(expected = StockGainException.class)
    public void shouldThrowExceptionWhenPriceDataIsEmpty() {
        StockGain stockGain = new StockGain(new int[] {});
        stockGain.getMaxProfit();
    }

    @Test(expected = StockGainException.class)
    public void shouldThrowExceptionWhenPriceDataIsNull() {
        StockGain stockGain = new StockGain(null);
        stockGain.getMaxProfit();
    }

    @Test(expected = StockGainException.class)
    public void shouldThrowExceptionWhenPriceDataIsIncomplete() {
        StockGain stockGain = new StockGain(new int[] {1});
        stockGain.getMaxProfit();
    }

    @Test
    public void shouldGetProfitWithMinIncreasingPriceData() {
        StockGain stockGain = new StockGain(new int[] {1,3});
        assertThat(stockGain.getMaxProfit(), is(2));
    }

    @Test
    public void shouldGetProfitWithContiguousIncreasingPriceData() {
        StockGain stockGain = new StockGain(new int[] {1,3,4});
        assertThat(stockGain.getMaxProfit(), is(3));
    }

    @Test
    public void shouldGetProfitWithNonContiguousIncreasingPriceData() {
        StockGain stockGain = new StockGain(new int[] {1,3,4,6,10});
        assertThat(stockGain.getMaxProfit(), is(9));
    }

    @Test
    public void shouldGetProfitWithSecondElementAsBestBuyPriceWithIncreasingPriceData() {
        StockGain stockGain = new StockGain(new int[] {2,1,4,6,10});
        assertThat(stockGain.getMaxProfit(), is(9));
    }

    @Test
    public void shouldGetProfitWithThirdElementAsBestBuyPriceWithIncreasingPriceData() {
        StockGain stockGain = new StockGain(new int[] {2,4,1,6,10});
        assertThat(stockGain.getMaxProfit(), is(9));
    }

    @Test
    public void shouldGetProfitWithLastElementAsBestBuySellPrice() {
        StockGain stockGain = new StockGain(new int[] {20,18,14,12,13});
        assertThat(stockGain.getMaxProfit(), is(1));
    }

    @Test
    public void shouldBreakEvenWithLastElementAsSameBuyPrice() {
        StockGain stockGain = new StockGain(new int[] {20,18,14,12,12});
        assertThat(stockGain.getMaxProfit(), is(0));
    }

    @Test
    public void shouldBreakEvenWithZeroBuyAndSellPrice() {
        StockGain stockGain = new StockGain(new int[] {0,0,0,0,0});
        assertThat(stockGain.getMaxProfit(), is(0));
    }

    @Test
    public void shouldBreakEvenWithOneBuyAndSellPrice() {
        StockGain stockGain = new StockGain(new int[] {1,1,1,1,1});
        assertThat(stockGain.getMaxProfit(), is(0));
    }

    @Test
    public void shouldBreakEvenWhenSameBuyAndSellPrice() {
        StockGain stockGain = new StockGain(new int[] {3,1,1,1,1});
        assertThat(stockGain.getMaxProfit(), is(0));
    }

    @Test
    public void shouldBreakEvenWhenMultipleSameBuyAndSellPrice() {
        StockGain stockGain = new StockGain(new int[] {11,11,1,1,1});
        assertThat(stockGain.getMaxProfit(), is(0));
    }

    @Test
    public void shouldMakeAProfitWhenBuyAtStartThenSellHigh() {
        StockGain stockGain = new StockGain(new int[] {10,11,9,9,9});
        assertThat(stockGain.getMaxProfit(), is(1));
    }

    @Test
    public void shouldMakeALossWhenBuyHighSellLow() {
        StockGain stockGain = new StockGain(new int[] {10,9});
        assertThat(stockGain.getMaxProfit(), is(-1));
    }
}
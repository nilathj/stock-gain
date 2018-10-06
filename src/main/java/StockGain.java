
public class StockGain {

    private static final int MIN_PRICE_DATA_POINTS = 2;
    private int[] yesterdaysPrices;

    StockGain(int[] yesterdaysPrices) {
        if(yesterdaysPrices == null || yesterdaysPrices.length < MIN_PRICE_DATA_POINTS) {
            throw new StockGainException("Missing or incomplete price data");
        }
        this.yesterdaysPrices = yesterdaysPrices;
    }

    public int getMaxProfit() {
        int bestBuyPrice = yesterdaysPrices[0];
        int bestSellPrice = yesterdaysPrices[1];
        int maxProfit = bestSellPrice - bestBuyPrice;

        if (hasMoreElements()) {
            for (int currentPrice: yesterdaysPrices) {

                if (currentPrice > bestSellPrice) {
                    bestSellPrice = currentPrice;
                    int currentProfit = bestSellPrice - bestBuyPrice;
                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                    }
                } else if (currentPrice < bestBuyPrice) {
                    bestBuyPrice = currentPrice;
                    bestSellPrice = currentPrice;
                }
            }
        }

        return maxProfit;
    }

    private boolean hasMoreElements() {
        return yesterdaysPrices.length > MIN_PRICE_DATA_POINTS;
    }
}

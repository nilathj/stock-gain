# Stock gain - Calculates the maximum possible gain using yesterdays price data for a stock, by buying low and selling high.

## System Requirements
- JDK 8 or newer

## Building and running tests
1) cd into the root of the project and type "./gradlew build"
2) To see the test results type "./gradlew test"

## Solution
1) Loop over the prices from left to right
2) Set bestBuyPrice as the first element in array
3) Set the bestSellPrice as the second element in array
4) If there are no more elements in the array return the difference as maxProfit

5) If the current price is more than bestSellPrice:
    Update the bestSellPrice
    If current profit is more than maxProfit, update maxProfit.  This is what we are after.
6) If the current price is less than bestBuyPrice, then reset the bestBuyPrice and bestSellPrice to it.

Since I'm only looping over the array of prices only once and keeping track of maxProfit as I go, the time
requirement for this algorithm is linear with the size of the input array O(n).  The space required for this algorithm is constant O(1), as I'm not
using recursion with a stack or creating sub arrays to store extra data.

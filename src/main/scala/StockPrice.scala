object StockPrice extends App {
  def maxProfit(prices: Array[Int]): Either[String, Int] = {
    def maxProfitHelper(prices: Array[Int], minPrice: Int, maxProfit: Int): Int = {
      if (prices.isEmpty) maxProfit
      else {
        val newMinPrice = math.min(minPrice, prices.head)
        val newMaxProfit = math.max(maxProfit, prices.head - minPrice)
        maxProfitHelper(prices.tail, newMinPrice, newMaxProfit)
      }
    }

    if (prices.isEmpty) Left("Input array is empty")
    else Right(maxProfitHelper(prices.tail, prices.head, 0))
  }

  // Test cases
  val stockPrices1 = Array(7, 1, 5, 3, 6, 4)
  maxProfit(stockPrices1) match {
    case Left(error) => println("Error: " + error)
    case Right(profit) => println("Maximum Profit (Case 1): " + profit) // Output should be 5
  }

  val stockPrices2 = Array.empty[Int]
  maxProfit(stockPrices2) match {
    case Left(error) => println("Error: " + error) // Output should be "Input array is empty"
    case Right(profit) => println("Maximum Profit (Case 2): " + profit)
  }
}





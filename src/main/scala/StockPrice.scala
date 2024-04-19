object StockPrice extends App {

  def maxProfit(prices: Array[Int]): Either[String, Int] = {
    if (prices.isEmpty) Left("Input array is empty")
    else {
      var minPrice = prices(0)
      var maxProfit = 0

      for (i <- 1 until prices.length) {
        maxProfit = math.max(maxProfit, prices(i) - minPrice)
        minPrice = math.min(minPrice, prices(i))
      }

      Right(maxProfit)
    }
  }

  // Test Cases for checking both the constraints
  val stockPrices1 = Array(7, 1, 5, 3, 6, 4)
  maxProfit(stockPrices1) match {
    case Left(error) => println("Error: " + error)
    case Right(profit) => println("Maximum Profit (Case 1): " + profit) // case 1: Output should be 5
  }

  val stockPrices2 = Array.empty[Int]
  maxProfit(stockPrices2) match {
    case Left(error) => println("(Case 2): " + error) // cae 2: Output should be "Input array is empty"
    case Right(profit) => println("Maximum Profit (Case 2): " + profit)
  }
}





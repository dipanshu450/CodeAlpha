import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance = 10000; // starting balance

    void buyStock(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (balance >= cost) {
            holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
            balance -= cost;
            System.out.println("Bought " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void sellStock(String symbol, int quantity, double price) {
        if (holdings.containsKey(symbol) && holdings.get(symbol) >= quantity) {
            holdings.put(symbol, holdings.get(symbol) - quantity);
            balance += quantity * price;
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    void viewPortfolio() {
        System.out.println("---- Portfolio ----");
        holdings.forEach((symbol, qty) -> {
            System.out.println(symbol + ": " + qty + " shares");
        });
        System.out.printf("Balance: $%.2f\n", balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Stock> market = new HashMap<>();
        Portfolio portfolio = new Portfolio();

        market.put("AAPL", new Stock("AAPL", 150));
        market.put("GOOGL", new Stock("GOOGL", 2800));
        market.put("TSLA", new Stock("TSLA", 700));
        market.put("MSFT", new Stock("MSFT", 330));

        int choice;
        do {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("---- Market ----");
                    market.forEach((symbol, stock) ->
                        System.out.printf("%s: $%.2f\n", stock.symbol, stock.price));
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySym = sc.next().toUpperCase();
                    if (!market.containsKey(buySym)) {
                        System.out.println("Invalid symbol.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    portfolio.buyStock(buySym, buyQty, market.get(buySym).price);
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSym = sc.next().toUpperCase();
                    if (!market.containsKey(sellSym)) {
                        System.out.println("Invalid symbol.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    portfolio.sellStock(sellSym, sellQty, market.get(sellSym).price);
                    break;

                case 4:
                    portfolio.viewPortfolio();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

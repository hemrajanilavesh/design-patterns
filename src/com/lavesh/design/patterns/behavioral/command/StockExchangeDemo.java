package com.lavesh.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject on which commands will get executed.
 * Receiver of Command.
 */
class Stock {

    String stockTicker;
    int units;

    public Stock(String stockTicker, int units) {
        this.stockTicker = stockTicker;
        this.units = units;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void sellStock() {
        System.out.println("Selling " + this.getUnits() + " units of " + this.getStockTicker());
    }

    public void buyStock() {
        System.out.println("Buying " + this.getUnits() + " units of " + this.getStockTicker());
    }

}

// command contract
interface StockOrder {
    void execute();
}

// implementation of command contract
// this is a command
class BuyStock implements StockOrder {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.buyStock();
    }
}

// implementation of command contract
// this is a command
class SellStock implements StockOrder {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sellStock();
    }
}

/**
 * Invoker of commands
 */
class StockBroker {

    public static void processOrders(List<StockOrder> orders) {
        for (StockOrder order : orders) {
            order.execute();
        }
    }
}

/**
 * Client program
 */
public class StockExchangeDemo {

    public static void main(String[] args) {
        Stock stockNetflix = new Stock("Netflix", 10);
        StockOrder buyStock = new BuyStock(stockNetflix);

        Stock stockApple = new Stock("Apple", 15);
        StockOrder sellStock = new SellStock(stockApple);

        List<StockOrder> orders = new ArrayList<>();
        orders.add(buyStock);
        orders.add(sellStock);

        StockBroker.processOrders(orders);
    }

}

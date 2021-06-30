package com.lavesh.design.patterns.behavioral.strategy;

import java.util.HashMap;

public class ShoppingCart {

    private int totalBillAmount;

    private HashMap<Item, Integer> itenary;

    public ShoppingCart() {
        itenary = new HashMap<>(5);
    }

    public ShoppingCart(HashMap<Item, Integer> itenary) {
        itenary = new HashMap<>(5);
        this.itenary = itenary;
    }

    public void addItem(Item item, int quantity) {
        itenary.put(item, quantity);
    }

    public void calculateTotal() {
        int processingTotalAmount = 0;
        for (Item item : itenary.keySet()) {
            processingTotalAmount += itenary.get(item) * item.getItemPrice();
        }
        this.setTotalBillAmount(processingTotalAmount);
    }

    public void setTotalBillAmount(int totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public void printCartItems() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Shopping Cart Items:\n");
        for (Item item :
                itenary.keySet()) {
            stringBuilder.append(item.toString()).append(", Quantity=").append(itenary.get(item));
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        this.calculateTotal();
        stringBuilder.append("Total=").append(this.getTotalBillAmount());
        System.out.println(stringBuilder.toString());
    }

    public int getTotalBillAmount() {
        return totalBillAmount;
    }
}

package com.lavesh.design.patterns.behavioral.strategy;

public class Item {
    
    private String itemName;
    private String itemCode;
    private int itemPrice;

    public Item(String itemName, String itemCode, int itemPrice) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}

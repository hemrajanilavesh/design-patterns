package com.lavesh.design.patterns.behavioral.strategy;

public class StrategyDemo {
    public static void main(String[] args) {

        Item item = new Item("Fogg", "fogg1", 150);
        Item item2 = new Item("AXE", "axe1", 140);
        Item item3 = new Item("Denver", "devner1", 130);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item, 2);
        shoppingCart.addItem(item2, 3);
        shoppingCart.addItem(item3, 5);

        shoppingCart.calculateTotal();

        shoppingCart.printCartItems();

        // payment using credit card strategy
        PaymentStrategy creditCard = new CreditCardStrategy(123,1234,"ABCD", "121214");
        creditCard.pay(shoppingCart.getTotalBillAmount());

        // payment using upi strategy
        PaymentStrategy upi = new UPIStrategy("123@paytm", 1234);
        upi.pay(shoppingCart.getTotalBillAmount());
    }
}

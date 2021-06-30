package com.lavesh.design.patterns.creational.factory;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/11/18
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */

interface IHotDrink {
    public void consume();
}

class Tea implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("The tea is delicious.");
    }
}

class Coffee implements IHotDrink {
    @Override
    public void consume() {
        System.out.println("The coffee is delicious.");
    }
}

interface IHotDrinkFactory {
    public IHotDrink prepare(int amount);
}

class TeaFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour "
                + amount + "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements IHotDrinkFactory {
    @Override
    public IHotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour "
                + amount + " ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}

class HotDrinkMachine {

    public enum AvailableDrinks {
        TEA, COFFEE
    }

    private List<Pair<String,IHotDrinkFactory>> namedFactories = new ArrayList<>();
    private Dictionary<AvailableDrinks, IHotDrinkFactory> factories =
            new Hashtable<>();

    HotDrinkMachine() throws Exception {

        for (AvailableDrinks drink : AvailableDrinks.values())
        {
            String s = drink.toString();
            String factoryName = "" + Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
            Class<?> factory = Class.forName("com.lavesh.design.patterns.creational.factory." + factoryName + "Factory");
            factories.put(drink, (IHotDrinkFactory) factory.getDeclaredConstructor().newInstance());
        }
    }

        public IHotDrink makeDrink() throws IOException
        {
            System.out.println("Available drinks");
            for (int index = 0; index < namedFactories.size(); ++index)
            {
                Pair<String, IHotDrinkFactory> item = namedFactories.get(index);
                System.out.println("" + index + ": " + item.getKey());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                String s;
                int i, amount;
                if ((s = reader.readLine()) != null
                        && (i = Integer.parseInt(s)) >= 0
                        && i < namedFactories.size())
                {
                    System.out.println("Specify amount: ");
                    s = reader.readLine();
                    if (s != null
                            && (amount = Integer.parseInt(s)) > 0)
                    {
                        return namedFactories.get(i).getValue().prepare(amount);
                    }
                }
                System.out.println("Incorrect input, try again.");
            }
        }

        public IHotDrink makeDrink(AvailableDrinks drink, int amount)
        {
            return factories.get(drink).prepare(amount);
        }

}


public class AbstractFactoryDemo {

    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        IHotDrink tea = machine.makeDrink(HotDrinkMachine.AvailableDrinks.TEA, 200);
        tea.consume();

        // interactive
        IHotDrink drink = machine.makeDrink();
        drink.consume();
        Integer.valueOf(1);
    }

}

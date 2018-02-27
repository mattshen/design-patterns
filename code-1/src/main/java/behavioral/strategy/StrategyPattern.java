package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

interface BillingStrategy {
    double getActPrice(final double rawPrice);
}

public class StrategyPattern {
    public static void main(String[] args) {
        Customer firstCustomer = new Customer(new NormalStrategy());

        //start happy hour
        firstCustomer.add(1.0, 1);
        firstCustomer.setStrategy(new HappyHourStrategy());
        firstCustomer.add(1.0, 2);

        Customer secondCustomer = new Customer(new HappyHourStrategy());
        secondCustomer.add(0.8, 1);
        firstCustomer.printBill();

        //end happy hour
        secondCustomer.setStrategy(new NormalStrategy());
        secondCustomer.add(1.3, 2);
        secondCustomer.add(2.5, 1);
        secondCustomer.printBill();
    }
}

class Customer {
    private List<Double> drinks;
    private BillingStrategy strategy;

    public Customer(final BillingStrategy strategy) {
        this.drinks = new ArrayList<>();
        this.strategy = strategy;
    }

    public void add(final double price, final int quantity) {
        drinks.add(strategy.getActPrice(price * quantity));
    }

    public void printBill() {
        double sum = 0;
        for (Double i : drinks) {
            sum += i;
        }
        System.out.println("Total due:" + sum);
        drinks.clear();
    }

    public void setStrategy(final BillingStrategy strategy) {
        this.strategy = strategy;
    }
}

class NormalStrategy implements BillingStrategy {
    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice;
    }
}

class HappyHourStrategy implements BillingStrategy {

    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice * 0.5;
    }
}


package com.github.gorden5566.drools.fact;

public class Order {
    // 订单总额
    private double amount;
    // 订单运费
    private double freight;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public void printMessage() {
        System.out.print("订单总额 " + amount + " 元. ");
        if (freight > 0) {
            System.out.print("需付运费 " + freight + " 元");
        } else {
            System.out.print("免运费");
        }
        System.out.println();
    }
}

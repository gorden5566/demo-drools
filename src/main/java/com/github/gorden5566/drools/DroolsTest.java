package com.github.gorden5566.drools;

import com.github.gorden5566.drools.fact.Order;
import com.github.gorden5566.drools.util.DroolsHelper;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsTest {
    public static void main(String[] args ) {
        test1();
    }

    public static void test1() {
        StatelessKnowledgeSession ksession = DroolsHelper.buildKsession("order.drl");

        for (int i = 1; i <= 123; ++i) {
            Order order = new Order();
            order.setAmount(i);

            ksession.execute(order);

            order.printMessage();
        }
    }
}

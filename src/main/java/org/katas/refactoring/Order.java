package org.katas.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> lineItem;

    public Order(String customerName, String customerAddress, List<LineItem> lineItem) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItem = lineItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItem;
    }
}

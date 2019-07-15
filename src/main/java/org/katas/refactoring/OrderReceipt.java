package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        printHeader();
//        output.append("Date - " + order.getDate();
        printCustomerNameAndAddress(order.customerName, order.customerAddress);
//        output.append(order.getCustomerLoyaltyNumber());
        return printLineItems(order);

    }

    private void printHeader() {
        System.out.println("======Printing Orders======\n");
    }

    private void printCustomerNameAndAddress(String customerName, String customerAddress) {
        System.out.println(customerName+customerAddress);
    }

    private String printLineItems(Order order) {
        StringBuilder output = new StringBuilder();
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.totalAmount()).append('\n');
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }
        output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }
}
package com.example.shahi.kamonstore.serialNo;

/**
 * Created by shahi on 07/02/2019.
 */

public class invoiceDet {
    private int barcode;
    private String pName;
    private int price;
    private int Qty;
    private int discount;
    private boolean isDelivered;
    private int  total;

    public invoiceDet(int barcode, String pName, int price, int qty, int discount, boolean isDelivered, int total) {
        this.barcode = barcode;
        this.pName = pName;
        this.price = price;
        Qty = qty;
        this.discount = discount;
        this.isDelivered = isDelivered;
        this.total = total;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getpName() {
        return pName;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return Qty;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public int getTotal() {
        return total;
    }
}

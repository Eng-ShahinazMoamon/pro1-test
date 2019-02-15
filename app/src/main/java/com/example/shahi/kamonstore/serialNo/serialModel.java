package com.example.shahi.kamonstore.serialNo;

import java.util.List;

/**
 * Created by shahi on 24/01/2019.
 */

public class serialModel {
    private int invoiceNo;
    private String invoiceDate;
    private String custName;
    private String PayMethod;
    private int invoiceDiscount;
    private int residual;
    private int payments;
    private int invoiceNet;
    private String desciption;
    private String Type;
    private boolean isDelivered;
    private List<invoiceDet>InvoiceDetails;

    public serialModel(int invoiceNo,String invoiceDate, String custName,
                       String payMethod, int invoiceDiscount, int residual,
                       int payments, int invoiceNet, String desciption, String type,
                       boolean isDelivered, List<invoiceDet> invoiceDetails) {
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.custName = custName;
        this.PayMethod = payMethod;
        this.invoiceDiscount = invoiceDiscount;
        this.residual = residual;
        this.payments = payments;
        this.invoiceNet = invoiceNet;
        this.desciption = desciption;
        this.Type = type;
        this.isDelivered = isDelivered;
        this.InvoiceDetails = invoiceDetails;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustName() {
        return custName;
    }

    public String getPayMethod() {
        return PayMethod;
    }

    public int getInvoiceDiscount() {
        return invoiceDiscount;
    }

    public int getResidual() {
        return residual;
    }

    public int getPayments() {
        return payments;
    }

    public int getInvoiceNet() {
        return invoiceNet;
    }

    public String getDesciption() {
        return desciption;
    }

    public String getType() {
        return Type;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public List<invoiceDet> getInvoiceDetails() {
        return InvoiceDetails;
    }
}

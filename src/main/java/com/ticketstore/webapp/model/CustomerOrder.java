package com.ticketstore.webapp.model;

import java.sql.Date;

public class CustomerOrder {
    private String id;
    private Date order_time;
    private String delivery_email_address;
    private Date time_paid;
    private Number total_price;
    private String payment_method;
    private String customer_id;
    private String payment_code;
    private String ticket_amount;
    private Number pay_stat;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getOrder_time() {
        return order_time;
    }
    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }
    public String getDelivery_email_address() {
        return delivery_email_address;
    }
    public void setDelivery_email_address(String delivery_email_address) {
        this.delivery_email_address = delivery_email_address;
    }
    public Date getTime_paid() {
        return time_paid;
    }
    public void setTime_paid(Date time_paid) {
        this.time_paid = time_paid;
    }
    public Number getTotal_price() {
        return total_price;
    }
    public void setTotal_price(Number total_price) {
        this.total_price = total_price;
    }
    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    public String getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public String getPayment_code() {
        return payment_code;
    }
    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }
    public String getTicket_amount() {
        return ticket_amount;
    }
    public void setTicket_amount(String ticket_amount) {
        this.ticket_amount = ticket_amount;
    }
    public Number getPay_stat() {
        return pay_stat;
    }
    public void setPay_stat(Number pay_stat) {
        this.pay_stat = pay_stat;
    } 
    
}

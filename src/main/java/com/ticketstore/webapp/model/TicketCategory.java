package com.ticketstore.webapp.model;

public class TicketCategory {
    private String id;
    private String desctiption;
    private Number price;
    private String concert_id;
    private Number stock;

    public Number getStock() {
        return stock;
    }
    public void setStock(Number stock) {
        this.stock = stock;
    }
    public String getConcert_id() {
        return concert_id;
    }
    public void setConcert_id(String concert_id) {
        this.concert_id = concert_id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDesctiption() {
        return desctiption;
    }
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
    public Number getPrice() {
        return price;
    }
    public void setPrice(Number price) {
        this.price = price;
    }

}

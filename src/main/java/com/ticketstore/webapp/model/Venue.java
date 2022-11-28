package com.ticketstore.webapp.model;

public class Venue {
    private String ID;
    private String venue_name;
    private String location;
    private String type;
    private Number capacity;
    
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getVenue_name() {
        return venue_name;
    }
    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Number getCapacity() {
        return capacity;
    }
    public void setCapacity(Number capacity) {
        this.capacity = capacity;
    }

    
}

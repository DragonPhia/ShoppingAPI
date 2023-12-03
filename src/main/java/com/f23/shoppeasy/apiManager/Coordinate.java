package com.f23.shoppeasy.apiManager;

public class Coordinate {
    public double longitude;
    public double latitude;
    
    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    @Override
    public String toString() {
        return String.format("%.6f", longitude) + ","
                + String.format("%.6f", latitude) + ";";
    }
}

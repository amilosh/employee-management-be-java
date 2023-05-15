package com.amilosh.entity.enumeration;

public enum Office implements BaseEnum<Office> {

    US(1, "USA", "New York", "US/NewYork"),
    GE(2, "Germany", "Berlin", "Europe/Berlin");

    private final int code;
    private final String country;
    private final String city;
    private final String timeZone;

    Office(int code, String country, String city, String timeZone) {
        this.code = code;
        this.country = country;
        this.city = city;
        this.timeZone = timeZone;
    }

    @Override
    public int getCode() {
        return code;
    }
}

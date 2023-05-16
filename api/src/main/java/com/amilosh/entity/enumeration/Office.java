package com.amilosh.entity.enumeration;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, Office> BY_COUNTRY = new HashMap<>();
    private static final Map<Office, String> COUNTRIES_BY_OFFICES = new EnumMap<>(Office.class);
    private static final Map<Office, String> CITIES_BY_OFFICES = new EnumMap<>(Office.class);
    private static final Map<Office, String> TIME_ZONES_BY_OFFICES = new EnumMap<>(Office.class);

    static {
        for (Office o : values()) {
            BY_COUNTRY.put(o.country, o);
            COUNTRIES_BY_OFFICES.put(o, o.country);
            CITIES_BY_OFFICES.put(o, o.city);
            TIME_ZONES_BY_OFFICES.put(o, o.timeZone);
        }
    }

    public static Office getOfficeByCountry(String country) {
        return BY_COUNTRY.get(country);
    }

    public static String getCountryByOffice(Office office) {
        return COUNTRIES_BY_OFFICES.get(office);
    }

    public static String getCityByOffice(Office office) {
        return CITIES_BY_OFFICES.get(office);
    }

    public static String getTimeZoneByOffice(Office office) {
        return TIME_ZONES_BY_OFFICES.get(office);
    }
}

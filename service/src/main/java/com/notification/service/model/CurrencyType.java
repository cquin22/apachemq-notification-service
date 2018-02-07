package com.notification.service.model;

public enum CurrencyType {
    USD("USD"),
    EUR("EUR"),
    JPY("JPY"),
    CRC("CRC"),
    PAB("PAB"),
    COP("COP");

    private String type;

    CurrencyType(String type) {
        this.type = type;
    }
}

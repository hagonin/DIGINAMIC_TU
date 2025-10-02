package com.mycompany.ex3;

public class ApiService {
    private final ApiClient client;

    public ApiService(ApiClient client) {
        this.client = client;
    }

    public String fetchUppercasedData() {
        return this.client.getData().toUpperCase();
    }

    public boolean hasData() {
        return this.client.getData() != null;
    }
}

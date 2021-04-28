package com.softnovo.controller;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTests {
    public static void main(String[] args) {
        getEmployees();
    }

    private static void getEmployees(){
        final String uri = "http://localhost:8080/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
    }
}

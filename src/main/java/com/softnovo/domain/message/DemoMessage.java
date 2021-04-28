package com.softnovo.domain.message;

public class DemoMessage {
    public static final String TOPIC = "DEMO_01";
    private Integer id;

    public static String getTOPIC() {
        return TOPIC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DemoMessage{" +
                "id=" + id +
                '}';
    }
}

package com.softnovo.aop;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author cgm
 */
@Builder
@ToString
@Getter
@Setter
public class UserParam {
    private String name;
    private Integer age;
    private String address;

    public static void main(String[] args) {
        UserParam userParam = UserParam.builder().address("aa").age(11).name("vvv").build();
        System.out.println(userParam);
        userParam.setName("bbb");

        System.out.println(userParam);
    }
}

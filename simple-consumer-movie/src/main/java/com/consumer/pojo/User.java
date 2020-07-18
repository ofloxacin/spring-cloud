package com.consumer.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author chenshuai
 * @date 2020/07/18
 */
@Getter
@Setter
public class User {

    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;
}

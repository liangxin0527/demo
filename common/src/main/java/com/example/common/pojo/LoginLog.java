package com.example.common.pojo;

import lombok.Data;

import java.time.LocalTime;

/**
 * @author 34480
 */
@Data
public class LoginLog {
    private String username;
    private String Method;
    private String description;
    private LocalTime loginTime;
}

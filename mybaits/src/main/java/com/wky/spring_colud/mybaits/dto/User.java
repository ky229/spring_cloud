package com.wky.spring_colud.mybaits.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private Integer userID;
    private String userName;
    private String passWord;
}

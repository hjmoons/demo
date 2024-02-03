package com.demo.user.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Long id;
    private String pw;
    private String name;
    private String email;
}

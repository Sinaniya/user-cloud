package com.app.user.model.request;


import lombok.Data;

@Data
public class UserCreationRequest {
    String username;
    String password;
}

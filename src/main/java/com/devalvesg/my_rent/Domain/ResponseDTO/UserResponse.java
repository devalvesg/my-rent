package com.devalvesg.my_rent.Domain.ResponseDTO;

import lombok.Data;

@Data
public class UserResponse {

    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String document;
    public String phone;
}

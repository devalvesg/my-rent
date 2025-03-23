package com.devalvesg.my_rent.Domain.RequestDTO;

public record UserRequest(String email, String password, String firstName, String lastName, String document) {
}

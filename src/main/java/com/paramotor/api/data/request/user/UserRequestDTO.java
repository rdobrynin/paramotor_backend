package com.paramotor.api.data.request.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserRequestDTO {
    private String first_name;
    private String last_name;
    private String nick_name;
    private String email;
    private String username;
    private String phone;
    private String home_location;
    private String home_address;
}

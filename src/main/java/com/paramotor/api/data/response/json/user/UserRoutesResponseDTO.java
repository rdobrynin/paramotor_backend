package com.paramotor.api.data.response.json.user;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paramotor.api.data.response.json.route.RouteResponseDTO;

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

public class UserRoutesResponseDTO {

    @JsonProperty("list")
    private List<RouteResponseDTO> route;

    private UserResponseDTO user;

//    public UserRoutesResponseDTO(List<RouteResponseDTO> route, UserResponseDTO user) {
//        this.route = route;
//        this.user = user;
//    }
}

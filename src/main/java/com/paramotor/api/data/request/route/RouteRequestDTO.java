package com.paramotor.api.data.request.route;


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

public class RouteRequestDTO {
    private long author_id;
    private String title;
    private String token;
    private String description;
    private String path;
}

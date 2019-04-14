package com.paramotor.api.data.response.json.route;


import java.util.Date;

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

public class RouteResponseDTO {
    private Long route_id;
    private String title;
    private String token;
    private String description;
    private String distance;
    private String path;
    private Date date_created;
    private Date start_date;
    private Date end_date;
    private boolean completed;
    private boolean deletable;
    private boolean sharebale;
}

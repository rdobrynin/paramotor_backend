package com.paramotor.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route", schema = "paramotor")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long route_id;
    private long author_id;
    private String title;
    private String token;
    private String description;
    private int type;
    private int distance;
    private String path;
    private int status;
    private Date date_created;
    private Date date_modified;
    private Date start_date;
    private Date end_date;
    private boolean completed;
    private boolean deletable;
    private boolean sharebale;
}
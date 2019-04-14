package com.paramotor.entity;

import java.util.Date;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "paramotor")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long person_id;
    private String first_name;
    private String last_name;
    private String nick_name;
    private String email;
    private String username;
    private String password_hash;
    private String phone;
    private boolean active;
    private int status;
    private String home_location;
    private String home_address;
    private int role;
    private Date date_created;
    private Date date_modified;

    public User(String first_name, String last_name, String nick_name, String email, String username, String password_hash, String phone, boolean active, int status, String home_location, String home_address, int role, Date date_created, Date date_modified) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nick_name = nick_name;
        this.email = email;
        this.username = username;
        this.password_hash = password_hash;
        this.phone = phone;
        this.active = active;
        this.status = status;
        this.home_location = home_location;
        this.home_address = home_address;
        this.role = role;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }
}
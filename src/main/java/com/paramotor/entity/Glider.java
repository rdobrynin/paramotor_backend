package com.paramotor.entity;

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
@Table(name = "glider", schema = "paramotor")
public class Glider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long glider_id;
    private String model;
    private String engine;
    private String hp;
    private int tank;
    private String wing_ratio;
    private int max_speed;
}
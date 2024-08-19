package com.TwentySevenFour.back.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "traffic")
public class Traffic {

    @Id
    @Column(name = "ID_traffic")
    private long ID;

    @Column(name = "route_ID")
    private String route_ID;

    @Column(name = "planet_origin")
    private String planet_origin;

    @Column(name = "planet_destination")
    private String planet_destination;
    
    @Column(name = "distance_light_years")
    private String distance_light_years;

}

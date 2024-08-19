package com.TwentySevenFour.back.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planet_names")
public class PlanetNames {

    @Id
    @Column(name = "ID_planet_names")
    private long ID;

    @Column(name = "planet_node")
    private String planet_node;

    @Column(name = "planet_name")
    private String planet_name;

    public PlanetNames() {
    }

    public PlanetNames(long ID, String planet_node, String planet_name) {
        this.ID = ID;
        this.planet_node = planet_node;
        this.planet_name = planet_name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getPlanet_node() {
        return planet_node;
    }

    public void setPlanet_node(String planet_node) {
        this.planet_node = planet_node;
    }

    public String getPlanet_name() {
        return planet_name;
    }

    public void setPlanet_name(String planet_name) {
        this.planet_name = planet_name;
    }
}




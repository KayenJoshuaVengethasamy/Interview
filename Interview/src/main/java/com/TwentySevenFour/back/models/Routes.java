package com.TwentySevenFour.back.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @Column(name = "ID_routes")
    private long ID;

    @Column(name = "route_ID")
    private long route_ID;

    @Column(name = "planet_origin")
    private String planet_origin;

    @Column(name = "planet_destination")
    private String planet_destination;

    @Column(name = "distance_light_years")
    private double distance_light_years; // Changed to double

    public Routes() {
    }

    public Routes(String planet_origin, String planet_destination, double distance_light_years) {
        this.planet_origin = planet_origin;
        this.planet_destination = planet_destination;
        this.distance_light_years = distance_light_years; // Changed to double
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(long route_ID) {
        this.route_ID = route_ID;
    }

    public String getPlanet_origin() {
        return planet_origin;
    }

    public void setPlanet_origin(String planet_origin) {
        this.planet_origin = planet_origin;
    }

    public String getPlanet_destination() {
        return planet_destination;
    }

    public void setPlanet_destination(String planet_destination) {
        this.planet_destination = planet_destination;
    }

    public double getDistance_light_years() {
        return distance_light_years;
    }

    public void setDistance_light_years(double distance_light_years) {
        this.distance_light_years = distance_light_years;
    }
}
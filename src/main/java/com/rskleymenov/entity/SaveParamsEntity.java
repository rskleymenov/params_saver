package com.rskleymenov.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SaveParamsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "station_name")
    private String stationName;
    @Column(name = "action")
    private String action;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "saved_time")
    private Date savedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(Date savedTime) {
        this.savedTime = savedTime;
    }
}

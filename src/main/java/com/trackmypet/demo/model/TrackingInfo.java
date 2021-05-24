package com.trackmypet.demo.model;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(TrackingInfoId.class)
public class TrackingInfo implements Serializable {

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;

    @Id
    private String collarId;

    @Column(name = "location")
    private Point geom;
}

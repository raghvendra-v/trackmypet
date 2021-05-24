package com.trackmypet.demo.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class TrackingInfoId implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;


    private String collarId;
}

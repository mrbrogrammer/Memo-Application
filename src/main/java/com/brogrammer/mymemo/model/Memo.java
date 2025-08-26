package com.brogrammer.mymemo.model;

import java.util.Date;
import java.io.Serializable;

public class Memo implements Serializable {

    private static final long serialVersionUID = -57892374598329L;

    private String description;
    private Date created;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}

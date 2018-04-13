package fr.isedia.springboot.webfluxdemo.domain;

import java.util.Date;

/**
 * Created by nchapon on 13/04/18.
 */
public class ShowEvent {

    private String id;
    private Date date;

    public ShowEvent(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

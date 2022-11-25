package com.aqms.app.rest.Models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Entity
public class data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to produce unique id in DB/mysql
    private long id;
    @Column
    public long o2;
    @Column
    public long co2;
    @Column
    public long so2;
    @Column
    public long co;
    @Column
    public long c;

    @Column
    public int floor;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Date date;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Time time;


    //getter and setters

    //id
    public long getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //o2
    public long getO2(){
        return o2;
    }
    public void setO2(){
        this.o2 = this.o2;
    }

    //co2
    public long getCo2(){
        return co2;
    }
    public void setCo2(){
        this.co2 = this.co2;
    }

    //c
    public long getC(){
        return c;
    }
    public void setC(){
        this.c = this.c;
    }

    //so2
    public long getSo2(){
        return so2;
    }
    public void setSo2(){
        this.so2 = this.so2;
    }

    //co
    public long getCo(){
        return co;
    }
    public void setCo(){
        this.co = this.co;
    }

    //floor
    public int getFloor(){
        return floor;
    }
    public void setFloor(){
        this.floor = this.floor;
    }
    //date
    public Date getDate(){
        return date;
    }
    public void setDate(Timestamp date){
        this.date = this.date;
    }
    //time
    public Time getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time = this.time;
    }

}

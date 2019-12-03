package com.softwaree.softwaree.backend.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {

    private String ordered;
    private String accept;
    private String produce;
    private String ship;  //发货的意思
    private String tally;

    public String getOrdered() {
        return ordered;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getTally() {
        return tally;
    }

    public void setTally(String tally) {
        this.tally = tally;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "ordered='" + ordered + '\'' +
                ", accept='" + accept + '\'' +
                ", produce='" + produce + '\'' +
                ", ship='" + ship + '\'' +
                ", tally='" + tally + '\'' +
                '}';
    }
}

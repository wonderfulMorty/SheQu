package com.shequ.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Pay {
    private int id;
    private String uid;
    private String itemName;
    private double payment;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date paytime;
    private String name;


    public Pay() {
    }

    public Pay(int id, String uid, String itemName, double payment, Date paytime, String name) {
        this.id = id;
        this.uid = uid;
        this.itemName = itemName;
        this.payment = payment;
        this.paytime = paytime;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", itemName='" + itemName + '\'' +
                ", payment=" + payment +
                ", paytime=" + paytime +
                ", name='" + name + '\'' +
                '}';
    }
}

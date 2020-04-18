package com.shequ.pojo;

public class Choice {
    private int cid;
    private int qid;
    private int su_id;
    private String moption;
    private String content;
    private String title;
    private String ch;
    private String uid;
    private String name;

    public Choice() {
    }

    public Choice(int cid, int qid, int su_id, String moption, String content, String title, String ch, String uid, String name) {
        this.cid = cid;
        this.qid = qid;
        this.su_id = su_id;
        this.moption = moption;
        this.content = content;
        this.title = title;
        this.ch = ch;
        this.uid = uid;
        this.name = name;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }

    public String getMoption() {
        return moption;
    }

    public void setMoption(String moption) {
        this.moption = moption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "cid=" + cid +
                ", qid=" + qid +
                ", su_id=" + su_id +
                ", moption='" + moption + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", ch='" + ch + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.shequ.pojo;

public class Sur_Que {
    private int id;
    private int su_id;
    private int qid;
    private String title;
    private String content;

    public Sur_Que() {
    }

    public Sur_Que(int id, int su_id, int qid, String title, String content) {
        this.id = id;
        this.su_id = su_id;
        this.qid = qid;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sur_Que{" +
                "id=" + id +
                ", su_id=" + su_id +
                ", qid=" + qid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

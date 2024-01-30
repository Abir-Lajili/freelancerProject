package khadamni.modeles;


import java.util.Date;

import java.util.Date;

public class Commentaire {
    private int commentaireId;
    private String content;
    private Date date;
    private int userId;

    public Commentaire(int commentaireId, String content, Date date, int userId) {
        this.commentaireId = commentaireId;
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Commentaire(String content, Date date, int userId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Commentaire(String content) {
        this.content = content;
        this.date = new Date();
    }

    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }



  
}



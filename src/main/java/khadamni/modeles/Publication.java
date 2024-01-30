package khadamni.modeles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publication {
    private int publicationId;
    private String title;
    private String content;
    private Date date;

    private String status;

    public Publication() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Publication(int publicationId, String title, String content, Date date, String status) {
        this.publicationId = publicationId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.status = status;
    }

    public Publication(String title, String content, String status) {
        this.title = title;
        this.content = content;
        this.date=new Date();   ;
        this.status = status;
    }


    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    private int clientId;
    private int freelancerId;
    private List<Commentaire> commentaires;

    public Publication(int publicationId, String title, String content, Date date, int clientId, int freelancerId) {
        this.publicationId = publicationId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.clientId = clientId;
        this.freelancerId = freelancerId;
        this.commentaires = new ArrayList<>();
    }

    public Publication(String title, String content, Date date, int clientId, int freelancerId) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.clientId = clientId;
        this.freelancerId = freelancerId;

    }

    // Getters and Setters

    public int getPublicationId() {
        return publicationId;
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

    public Date getDate() {
        return date;
    }

    public int getclientId() {
        return clientId;
    }

    public void setclientId(int clientId) {
        this.clientId = clientId;
    }

    public int getUser() {
        return freelancerId;
    }

    public void setUser(int freelancerId) {
        this.freelancerId = freelancerId;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void addCommentaire(Commentaire commentaire) {
        this.commentaires.add(commentaire);
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

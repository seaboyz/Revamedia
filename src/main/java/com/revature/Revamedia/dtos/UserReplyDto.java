package com.revature.Revamedia.dtos;

import java.sql.Timestamp;

public class UserReplyDto {

    private Integer reply_id;
    private Integer owner_id;
    private Integer comment_id;
    private String message;
    private String giphyUrl;
    private Timestamp dateCreated;

    public UserReplyDto() {
    }

    public UserReplyDto(Integer reply_id, Integer owner_id, Integer comment_id, String message, String giphyUrl, Timestamp dateCreated) {
        this.reply_id = reply_id;
        this.owner_id = owner_id;
        this.comment_id = comment_id;
        this.message = message;
        this.giphyUrl = giphyUrl;
        this.dateCreated = dateCreated;
    }

    public UserReplyDto(Integer reply_id, String message) {
        this.reply_id = reply_id;
        this.message = message;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}

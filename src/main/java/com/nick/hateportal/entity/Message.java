package com.nick.hateportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_messages")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post_id;

    @Column(name = "like_count")
    private int like;

    @Column(name = "message_date")
    private Date message_date;

    public Message() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }

//    @Override
//    public String toString() {
//        return "Message{" +
//                "id=" + id +
//                ", message='" + message + '\'' +
//                ", user_id=" + user_id +
//                ", post_id=" + post_id +
//                ", message_date=" + message_date +
//                '}';
//    }
}

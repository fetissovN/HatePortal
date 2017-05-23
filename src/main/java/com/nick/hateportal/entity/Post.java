package com.nick.hateportal.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "target")
    private String target;

    @Column(name = "title")
    private String title;

    @Column(name = "post")
    private String post;

    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "like")
    private int like;

    @Column(name = "photo")
    private byte[] photo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post_id")
    private List<Message> postRelatedMessages;

    public Post() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Message> getPostRelatedMessages() {
        return postRelatedMessages;
    }

    public void setPostRelatedMessages(List<Message> postRelatedMessages) {
        this.postRelatedMessages = postRelatedMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", title='" + title + '\'' +
//                ", post='" + post + '\'' +
//                ", postDate=" + postDate +
//                ", photo=" + Arrays.toString(photo) +
//                ", postRelatedMessages=" + postRelatedMessages +
//                '}';
//    }
}

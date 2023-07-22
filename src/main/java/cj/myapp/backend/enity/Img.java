package cj.myapp.backend.enity;

import java.util.Objects;

public class Img {
    private Integer img_id;
    private String img_name;
    private String img_path;
    private String createTime;
    private String userId;
    private String userName;

    public Img() {
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Img{" +
                "img_id=" + img_id +
                ", img_name='" + img_name + '\'' +
                ", img_path='" + img_path + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Img img = (Img) o;
        return Objects.equals(img_id, img.img_id) && Objects.equals(img_name, img.img_name) && Objects.equals(img_path, img.img_path) && Objects.equals(createTime, img.createTime) && Objects.equals(userId, img.userId) && Objects.equals(userName, img.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img_id, img_name, img_path, createTime, userId, userName);
    }
}

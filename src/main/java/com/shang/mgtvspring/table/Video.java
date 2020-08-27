package com.shang.mgtvspring.table;

import javax.persistence.*;

@Entity
@Table(name = "vidoes")
public class Video {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "vod_id")
    private Integer vod_id;
    @Column(name = "parentVod_id")
    private Integer parentVod_id;
    @Column(name = "ctype")
    private Integer ctype;
    @Column(name = "totalnum")
    private Integer totalnum;
    @Column(name = "updatenum")
    private Integer updatenum;
    @Column(name = "price")
    private Integer price;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "keyWords")
    private String keyWords;
    @Column(name = "area")
    private String area;
    @Column(name = "years")
    private String years;
    @Column(name = "classify")
    private String classify;
    @Column(name = "poster1")
    private String poster1;
    @Column(name = "poster2")
    private String poster2;
    @Column(name = "poster3")
    private String poster3;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private String updated_at;

    public Video(Integer vod_id, Integer parentVod_id, String title, String type, String area, String years, String classify) {
        this.vod_id = vod_id;
        this.parentVod_id = parentVod_id;
        this.title = title;
        this.type = type;
        this.area = area;
        this.years = years;
        this.classify = classify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVod_id() {
        return vod_id;
    }

    public void setVod_id(Integer vod_id) {
        this.vod_id = vod_id;
    }

    public Integer getParentVod_id() {
        return parentVod_id;
    }

    public void setParentVod_id(Integer parentVod_id) {
        this.parentVod_id = parentVod_id;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getUpdatenum() {
        return updatenum;
    }

    public void setUpdatenum(Integer updatenum) {
        this.updatenum = updatenum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getPoster1() {
        return poster1;
    }

    public void setPoster1(String poster1) {
        this.poster1 = poster1;
    }

    public String getPoster2() {
        return poster2;
    }

    public void setPoster2(String poster2) {
        this.poster2 = poster2;
    }

    public String getPoster3() {
        return poster3;
    }

    public void setPoster3(String poster3) {
        this.poster3 = poster3;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

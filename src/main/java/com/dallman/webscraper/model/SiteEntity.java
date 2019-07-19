package com.dallman.webscraper.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class SiteEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "website_name")
    private String websiteName;

    @Column(name = "website_url")
    private String webUrl;

    @Column(name = "website_added")
    private String dateAdded;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "SiteEntity{" +
                "websiteUrl='" + webUrl + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}

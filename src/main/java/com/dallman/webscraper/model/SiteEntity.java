package com.dallman.webscraper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @Column(name = "website_added", insertable = false, updatable = false)
    private LocalDateTime dateAdded;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SiteEntity{" +
                "websiteUrl='" + webUrl + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}

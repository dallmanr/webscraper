package com.dallman.webscraper.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class SiteEntity extends BaseEntity implements Serializable {

    @Column(name = "id")
    private int id;

    @Column(name = "website_name")
    private String websiteName;

    @Column(name = "website_url")
    private String webUrl;

    @Column(name = "website_parsed")
    private String dateParsed;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDateParsed() {
        return dateParsed;
    }

    public void setDateParsed(String dateParsed) {
        this.dateParsed = dateParsed;
    }

    @Override
    public String toString() {
        return "SiteEntity{" +
                "websiteUrl='" + webUrl + '\'' +
                ", dateFormat=" + dateParsed +
                '}';
    }
}

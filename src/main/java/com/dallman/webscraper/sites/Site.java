package com.dallman.webscraper.sites;

import com.dallman.webscraper.model.SiteEntity;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "websites")
public class Site extends SiteEntity implements Serializable {


    private Integer id;

    private String websiteName;

    private String webUrl;

    private LocalDateTime dateAdded;

    private LocalDateTime lastUpdated;

    public Site() {
    }

    public Site(String websiteName, String webUrl) {
        this.websiteName = websiteName;
        this.webUrl = webUrl;
        this.dateAdded = LocalDateTime.now();
    }



    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded() {
        this.dateAdded = LocalDateTime.now();
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setDateUpdated(LocalDateTime latUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @ModelAttribute
    public Site getSiteObject() {
        return new Site();
    }

    @Override
    public Integer getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Site{" +
                "website_url=" + webUrl +
                " website_name='" + websiteName + '\'' +
                ", website_added=" + dateAdded +
                '}';
    }
}

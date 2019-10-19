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

    public Site() {
    }

    public Site(String websiteName, String webUrl) {
        this.websiteName = websiteName;
        this.webUrl = webUrl;
        this.dateAdded = LocalDateTime.now();
    }

//    @Override
//    public Integer getId() {
//        return id;
//    }

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

    @ModelAttribute
    public Site getSiteObject() {
        return new Site();
    }

    @Override
    public String toString() {
        return "Site{" +
                super.getWebUrl() +
                " website_name='" + websiteName + '\'' +
                ", website_added=" + dateAdded +
                '}';
    }
}

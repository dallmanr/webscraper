package com.dallman.webscraper.sites;

import com.dallman.webscraper.model.SiteEntity;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "websites")
public class Site extends SiteEntity implements Serializable {

    private Integer id;

    private String websiteName;

    private String webUrl;

    private String dateAdded;

    public Site() {
    }

    public Site(Integer id, String websiteName, String webUrl, String dateAdded) {
        this.id = id;
        this.websiteName = websiteName;
        this.webUrl = webUrl;
        this.dateAdded = dateAdded;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateParsed) {
        this.dateAdded = dateParsed;
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
        return "SiteEntity{" +
                "website_name='" + websiteName + '\'' +
                ", website_added=" + dateAdded +
                '}';
    }
}

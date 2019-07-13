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

    private String dateParsed;

    public Site() {
    }

    public Site(int id, String webUrl, String dateParsed) {
        this.id = id;
        this.webUrl = webUrl;
        this.dateParsed = dateParsed;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
                ", website_parsed=" + dateParsed +
                '}';
    }
}

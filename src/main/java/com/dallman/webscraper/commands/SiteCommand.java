package com.dallman.webscraper.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SiteCommand {

    private int id;
    private String webUrl;
    private String dateParsed;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateParsed() {
        return dateParsed;
    }

    public void setDateParsed(String dateParsed) {
        this.dateParsed = dateParsed;
    }
}

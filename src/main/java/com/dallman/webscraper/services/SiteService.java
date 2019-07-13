package com.dallman.webscraper.services;

import com.dallman.webscraper.commands.SiteCommand;
import com.dallman.webscraper.sites.Site;

import java.util.Set;

public interface SiteService {

    Set<Site> getSites();

    Site findById(Integer i);

    void saveSite(Site site);

    void save();

    SiteCommand saveSiteCommand(SiteCommand siteCommand);
}

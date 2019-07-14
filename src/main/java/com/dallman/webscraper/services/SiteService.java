package com.dallman.webscraper.services;

import com.dallman.webscraper.commands.SiteCommand;
import com.dallman.webscraper.sites.Site;

import java.util.Set;

public interface SiteService {

    Set<Site> getSites();

    Site findById(Integer i);

    Site save(Site site);

    SiteCommand saveSiteCommand(SiteCommand siteCommand);
}

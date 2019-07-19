package com.dallman.webscraper.services;

import com.dallman.webscraper.commands.SiteCommand;
import com.dallman.webscraper.convertors.SiteCommandToSite;
import com.dallman.webscraper.convertors.SiteToSiteCommand;
import com.dallman.webscraper.repositories.SiteRepository;
import com.dallman.webscraper.sites.Site;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final SiteToSiteCommand siteToSiteCommand;
    private final SiteCommandToSite siteCommandToSite;

    public SiteServiceImpl(SiteRepository siteRepository, SiteCommandToSite siteCommandToSite, SiteToSiteCommand siteToSiteCommand) {
        this.siteRepository = siteRepository;
        this.siteToSiteCommand = siteToSiteCommand;
        this.siteCommandToSite = siteCommandToSite;
    }

    @Override
    public Set<Site> getSites() {
        Set<Site> siteSet = new HashSet<>();
        siteRepository.findAll().iterator().forEachRemaining((siteSet::add));
        return siteSet;
    }

    @Override
    public Site findById(Integer i) {
        Optional<Site> siteOptional = siteRepository.findById(i);
        if (!siteOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return siteOptional.get();
    }

    @Override
    public Site save(Site site) {
        Site aSite = siteRepository.save(site);
        return aSite;
    }

    @Override
    @Transactional
    public SiteCommand saveSiteCommand(SiteCommand source) {
        Site detachedSite = siteCommandToSite.convert(source);

        Site savedSite = siteRepository.save(detachedSite);
        return siteToSiteCommand.convert(savedSite);

    }
}

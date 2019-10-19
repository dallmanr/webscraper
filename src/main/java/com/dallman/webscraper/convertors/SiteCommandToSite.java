package com.dallman.webscraper.convertors;

import com.dallman.webscraper.commands.SiteCommand;
import com.dallman.webscraper.sites.Site;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SiteCommandToSite implements Converter<SiteCommand, Site> {

    public SiteCommandToSite() {

    }

    @Synchronized
    @Nullable
    @Override
    public Site convert(SiteCommand source) {
        if (source == null) {
            return null;
        }

        final Site site = new Site();
        site.setDateAdded(LocalDateTime.now());
        site.setWebUrl(source.getWebUrl());
        site.setId(source.getId());

        return site;
    }
}

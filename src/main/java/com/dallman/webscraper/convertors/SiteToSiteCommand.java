package com.dallman.webscraper.convertors;

import com.dallman.webscraper.commands.SiteCommand;
import com.dallman.webscraper.sites.Site;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class SiteToSiteCommand implements Converter<Site, SiteCommand> {

    public SiteToSiteCommand() {

    }

    @Synchronized
    @Nullable
    @Override
    public SiteCommand convert(Site source) {
        if (source == null) {
            return null;
        }

        final SiteCommand command = new SiteCommand();
        command.setId(source.getId());
        command.setWebUrl(source.getWebUrl());
        command.setDateParsed(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString());
        return command;
    }
}

package com.dallman.webscraper.sites;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;

public class SiteParser {

    private Site site;
    private Document doc;

    public SiteParser(Site site) throws IOException {
        this.site = site;
        this.doc = Jsoup.connect(site.getWebUrl()).get();
    }

    public void getSiteTitle() {
        System.out.println(doc.title());
    }

    public void getTableContents() {
        Element tables = doc.select("table").get(0);
//        Elements rows = tables.select("tr");
        Iterator<Element> iterator = tables.select("td").iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().text());
        }
    }

}

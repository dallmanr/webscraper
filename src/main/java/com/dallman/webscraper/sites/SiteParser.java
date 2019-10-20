package com.dallman.webscraper.sites;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SiteParser {

    private static Site site;
    private static Document doc;

    public SiteParser() throws IOException {
        site = new Site();
        site.setWebsiteName("Swindon web");
        site.setWebUrl("http://www.swindonweb.com/event/?event_date=complete&start_date=21%2F08%2F2019&end_date=21%2F08%2F2019&cat=1162&cat=848&cat=849&cat=1089&cat=835&cat=243&cat=840&cat=841&cat=828&cat=963&cat=846&cat=1098&cat=844&cat=892&cat=1075&cat=658&cat=969&cat=1004&cat=740&cat=843&cat=104&cat=837&cat=1083&cat=845&cat=842&cat=851&cat=839&cat=1074&search=event&imageField.x=12&imageField.y=6");
        site.setDateAdded();
        this.doc = Jsoup.connect(site.getWebUrl()).get();
        getSiteTitle(site);
        getTableContents();
    }

    public static void getSiteTitle(Site aSite) throws IOException {
//        System.out.println(doc.title());
        doc = Jsoup.connect(aSite.getWebUrl()).get();
        System.out.println("Site parser doc title: " + doc.title());
    }

    public static void getTableContents() {
        Element content = doc.getElementById("content");
        Elements eventHeadingOneElements = content.getElementsByClass("text_yellow");
        Elements eventHeadingTwoElements = content.getElementsByClass("text_white");
//        Iterator<Element> iterator = doc.select("td").iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().text());
//        }

        for (int i = 0, j = 1; i < eventHeadingOneElements.size(); i++, j++) {
            String eventName = eventHeadingOneElements.get(j).toString();
            String location = eventHeadingTwoElements.get(i).toString();
            int indexOfClassYellow = eventName.indexOf("class=\"text_yellow\">") + 20;
            int indexOfClassTextWhite = location.indexOf("class=\"text_white\">") + 19;
            System.out.println("Location: ");
            System.out.println(location.substring(indexOfClassTextWhite, location.length() - 4));
            System.out.println("Event name: ");
            System.out.println(eventName.substring(indexOfClassYellow, eventName.length() - 4));
        }


    }

}

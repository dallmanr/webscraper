package com.dallman.webscraper;

import com.dallman.webscraper.sites.SiteParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebscraperApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebscraperApplication.class, args);
        System.out.println("Running.....");

        SiteParser sp = new SiteParser();
    }

}

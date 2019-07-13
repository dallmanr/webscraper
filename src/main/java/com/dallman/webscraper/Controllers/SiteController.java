package com.dallman.webscraper.Controllers;

import com.dallman.webscraper.services.SiteService;
import com.dallman.webscraper.sites.Site;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;


@Controller
public class SiteController {
    //Changed this from SiteRepository
    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/sites/index")
    public String getSites(Model model) {
        model.addAttribute("sites", siteService.getSites());
        return "sites/index";
    }

    @RequestMapping(value = "sites/newsite", method = RequestMethod.GET)
    public String addNewSiteForm(Model model) {
        Site site = new Site();
        model.addAttribute("site", site);
        return "sites/newsite";
    }

    @PostMapping(value = "/sites/newsite")
    public String addNewSiteForm(@ModelAttribute Site site, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "Error";
        }

        Site aSite = new Site();
        aSite.setWebUrl(site.getWebUrl());
        aSite.setWebsiteName(site.getWebsiteName());
        aSite.setDateParsed(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString());

        siteService.save();
        model.addAttribute("websiteUrlInput");
        model.addAttribute("websiteNameInput");
        model.addAttribute("website_parsed", new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString());

//        siteService.saveSiteCommand();
        return "site";
    }

    @RequestMapping("/sites/show/{id}")
    public String findBySiteId(@PathVariable String id, Model model) {
        model.addAttribute("site", siteService.findById(new Integer(id)));
        return "sites/show";
    }
}

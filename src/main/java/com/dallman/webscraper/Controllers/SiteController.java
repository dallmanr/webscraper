package com.dallman.webscraper.Controllers;

import com.dallman.webscraper.services.SiteService;
import com.dallman.webscraper.sites.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/sites")
public class SiteController {

    private final SiteService siteService;
    private final Logger logger = LoggerFactory.getLogger(SiteController.class);

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/index")
    public String getSites(Model model) {
        model.addAttribute("sites", siteService.getSites());
        return "sites/index";
    }

    @RequestMapping(value = "/newsite", method = RequestMethod.GET)
    public String addNewSiteForm(Model model) {
        System.out.println("addNewSiteForm /newsite");
        Site site = new Site();
        model.addAttribute("site", site);
        return "sites/newsite";
    }

    @PostMapping(value = "/newsite")
    @ResponseBody
    public String saveSite(@ModelAttribute Site site) {
        System.out.println("Saving site....");
        System.out.println(site.toString());
        Site siteResponse = siteService.save(site);
        return "/sites/index";
    }

    @RequestMapping(value = "/sitedetails/{id}")
    public String showSite(@PathVariable("id") Integer id, Model model) {
        logger.debug("showSite() id: {}", id);
        System.out.println("showSite() id: " + id);
        Site site = siteService.findById(id);
        model.addAttribute("site", site);
        return "/sites/sitedetails";
    }
}

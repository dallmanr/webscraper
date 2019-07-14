package com.dallman.webscraper.Controllers;

import com.dallman.webscraper.services.SiteService;
import com.dallman.webscraper.sites.Site;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/sites")
public class SiteController {

    private final SiteService siteService;

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
        Site siteResponse = siteService.save(site);
        return "redirect:/sites/index";
    }

    @RequestMapping("/show/{id}")
    public String findBySiteId(@PathVariable String id, Model model) {
        model.addAttribute("site", siteService.findById(new Integer(id)));
        return "sites/show";
    }
}

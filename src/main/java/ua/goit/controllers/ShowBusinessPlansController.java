package ua.goit.controllers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.goit.dao.AddressDao;
import ua.goit.dao.ProjectDao;
import ua.goit.entity.*;
import ua.goit.services.AddressService;
import ua.goit.services.BusinessPlanService;
import ua.goit.services.ProjectService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Guillaume Gingembre on 15/09/2017.
 */

@Controller
@RequestMapping(value = "/businessplan")
@Transactional
public class ShowBusinessPlansController {

    private final BusinessPlanService businessPlansService;

    private final Logger logger = LoggerFactory.getLogger(ShowProjectsController.class);

    @Autowired
    public ShowBusinessPlansController(BusinessPlanService businessPlansService) {
        this.businessPlansService = businessPlansService;
    }

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AddressService addressService;

    @ModelAttribute("regions")
    public Region[] regions() {
        return Region.values();
    }

    @ModelAttribute("countries")
    public Country[] countries() { return Country.values(); }

    @RequestMapping(method = RequestMethod.GET, value = "/showAll")
    public ModelAndView showBusinessPlans() {
        List<BusinessPlan> businessPlans = businessPlansService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("businessPlans");
        modelAndView.addObject("businessPlans", businessPlans);
        return modelAndView;
    }

    @RequestMapping(value="/{businessPlanId}") //, method=RequestMethod.GET)
    public String showProject(Model model, @PathVariable long businessPlanId) {

        BusinessPlan businessPlan = businessPlansService.findOne(businessPlanId);
        model.addAttribute("businessPlan", businessPlan);

        return "businessPlanView";
    }

    // delete business plan
    @RequestMapping(value = "/{businessPlanId}/delete")
    public String deleteBusinessPlan(@PathVariable long businessPlanId){ //, final RedirectAttributes redirectAttributes) {

        //logger.debug("delete Business Plan() : {}", id);

        businessPlansService.delete(businessPlanId);

        //redirectAttributes.addFlashAttribute("css", "success");
        //redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "businessPlanDeleted";

    }

    @GetMapping("/add")
    public String businessPlanForm(Model model) {
        model.addAttribute("businessPlanRegistration", new BusinessPlanRegistrationForm());
        return "businessPlanRegistration";
    }

    @PostMapping("/add")
    public String BusinessPlanSubmit(@ModelAttribute BusinessPlanRegistrationForm businessPlanRegistrationForm){

        // saving address
        Address address = businessPlanRegistrationForm.getAddress();

        addressService.save(address);

        // saving business plan
        BusinessPlan businessPlan = businessPlanRegistrationForm.getBusinessPlan();
        businessPlan.setAddress(address);
        businessPlan.setBusinessPlanLastChange(LocalDate.now());
        businessPlan.setActive(true);
        businessPlansService.save(businessPlan);

        //adding to project
        Project project = projectService.findOne(businessPlan.getProjectId());
        project.getBusinessPlans().add(businessPlan);
        projectService.save(project);

        return "businessPlanResult";
    }

    @GetMapping("/search")
    public String projectSearch(Model model) {
        model.addAttribute("businessPlanSearch", new BusinessPlanRegistrationForm());
        return "businessPlanSearch";
    }

    @PostMapping("/search")
    public ModelAndView SearchResults(@ModelAttribute BusinessPlanRegistrationForm businessPlanRegistrationForm){

        // get address and business plan
        Address address = businessPlanRegistrationForm.getAddress();
        BusinessPlan businessPlan = businessPlanRegistrationForm.getBusinessPlan();
        businessPlan.setAddress(address);
        businessPlan.setActive(true);

        // search with query by example based on String criteria
        List<BusinessPlan> businessPlans = businessPlansService.findAllExample(businessPlan);

        // getting rid of projects not matching number criteria
        if (businessPlan.getBusinessPlanMinInv() != null){
            businessPlans.removeIf(p -> p.getBusinessPlanMinInv().compareTo(businessPlan.getBusinessPlanMinInv()) == 1);
        }

        if (businessPlan.getBusinessPlanExpectedRaise() != null){
            businessPlans.removeIf(p -> p.getBusinessPlanExpectedRaise().compareTo(businessPlan.getBusinessPlanExpectedRaise()) == -1);
        }

        if (businessPlan.getBusinessPlanReturn() != 0.0) {
            businessPlans.removeIf(p -> p.getBusinessPlanReturn() < businessPlan.getBusinessPlanReturn());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("businessPlanSearchResult");
        modelAndView.addObject("businessPlans", businessPlans);
        return modelAndView;
    }

    // show update form
    @GetMapping(value = "/{businessPlanId}/update")
    public ModelAndView showUpdateProjectForm(@PathVariable("businessPlanId") long businessPlanId) {
        logger.debug("showUpdateProjectForm() : {}", businessPlanId);

        BusinessPlan businessPlan = businessPlansService.findById(businessPlanId);

        return new ModelAndView("businessPlanUpdateForm","command",businessPlan);
    }

    // save updated business plan
    @PostMapping(value="/updated")
    public String updateProject(@ModelAttribute ("businessPlan") BusinessPlan businessPlan){
        businessPlan.setActive(true);
        businessPlan.setBusinessPlanLastChange(LocalDate.now());
        addressService.save(businessPlan.getAddress()); // if I do not do that i get: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance beforeQuery flushing
        businessPlansService.save(businessPlan);
        return "businessPlanUpdated";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    /*
    @PostConstruct
    public void initDefaultBusinessPlans() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("creating default business plans");

        Address addressKherson = new Address ("Kherson", Region.Kherson, Country.UKRAINE);
        Address addressOdessa = new Address ("Odessa", Region.Odessa, Country.UKRAINE);

        BigDecimal previousRounds = new BigDecimal(50000);
        BigDecimal expectedRaise = new BigDecimal(100000);
        BigDecimal raised = new BigDecimal(10000);
        BigDecimal mininv = new BigDecimal(1000);

        BusinessPlan businessplan1 = new BusinessPlan(2, addressKherson, "grow stuff in Kherson", "small production, I need scale",
                "stuff market in Ukraine","make more money", "get bigger", "big guys but i am better",
                "technical skills, organic, high quality", "grow organic and sell at a high price to premium shops",
                "acquire more land and machinery to grow scale", "God", "weather, raids, currency, economy", "weburl",
                "docurl", expectedRaise ,raised ,mininv,20,"really great returns",
                previousRounds,  "real estate and machinery" , LocalDate.parse("10/09/2017", formatter), true);

        BigDecimal previousRounds2 = new BigDecimal(30000);
        BigDecimal expectedRaise2 = new BigDecimal(300000);
        BigDecimal raised2 = new BigDecimal(20000);
        BigDecimal mininv2 = new BigDecimal(2000);

        BusinessPlan businessPlan2 = new BusinessPlan(3, addressOdessa, "export stuff from Odessa", "I need to expand",
                "export market","make more money", "get bigger", "big guys but i am better",
                "technical skills", "export products that big guys are too dumb to handle",
                "acquire more terminals and machinery to grow scale", "Fedex", "raids, currency, economy, politics",
                "weburl", "docurl", expectedRaise2, raised2, mininv2, 30,
                "really great returns", previousRounds2, "real estate and machinery",
                LocalDate.parse("15/09/2017", formatter), true);

        System.out.println("saving default business plans");

        businessPlansService.save(businessplan1);
        businessPlansService.save(businessPlan2);

        System.out.println("updating projects");

        Project project2 = projectDao.findOne(Long.valueOf(2));
        project2.getBusinessPlans().add(businessplan1);
        projectDao.saveAndFlush(project2);

        Project project3 = projectDao.findOne(Long.valueOf(23));
        project3.getBusinessPlans().add(businessPlan2);
        projectDao.saveAndFlush(project3);

        System.out.println("success!");

    } */

}

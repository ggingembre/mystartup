package ua.goit.controllers;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.entity.*;
import ua.goit.services.AddressService;
import ua.goit.services.ProjectService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Guillaume Gingembre on 15/09/2017.
 */

@Controller
@RequestMapping(value = "/project")
@Transactional
public class ShowProjectsController {

    private final ProjectService projectsService;

    private final Logger logger = LoggerFactory.getLogger(ShowProjectsController.class);

    /*
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(HttpMessageNotReadableException e) {
        logger.warn("Returning HTTP 400 Bad Request", e);
    } */

    @Autowired
    public ShowProjectsController(ProjectService projectsService) {
        this.projectsService = projectsService;
    }

    @Autowired
    private AddressService addressService;

    @ModelAttribute("regions")
    public Region[] regions() {
        return Region.values();
    }

    @ModelAttribute("countries")
    public Country[] countries() { return Country.values(); }

    @ModelAttribute("industries")
    public Industry[] industries() {
        return Industry.values();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showAll")
    public ModelAndView showProjects() {
        /*List<String> projectnames =
                projectsService.findAll().stream().map(Project::toString).collect(Collectors.toList()); */
        List<Project> projects = projectsService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(value="/{projectId}") //, method=RequestMethod.GET)
    public ModelAndView showProject(@PathVariable long projectId) {

        Project project = projectsService.findOne(projectId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectView");
        modelAndView.addObject("project", project);
        return modelAndView;
    }

    // delete project
    @RequestMapping(value = "/{projectId}/delete", method = RequestMethod.GET)
    public String deleteProject(@PathVariable long projectId) { //, final RedirectAttributes redirectAttributes) {

        //logger.debug("deleteProject() : {}", id);

       projectsService.delete(projectId);

        //redirectAttributes.addFlashAttribute("css", "success");
        //redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "projectDeleted";

    }

    @GetMapping("/add")
    public String projectForm(Model model) {
        model.addAttribute("projectRegistration", new ProjectRegistrationForm());
        //return new ModelAndView("projectRegistration", "command", new Project());
        return "projectRegistration";
    }

    @PostMapping("/add")
        public String ProjectSubmit(@ModelAttribute ProjectRegistrationForm projectRegistrationForm){
        /*
        model.addAttribute("projectName", project.getProjectName());
        model.addAttribute("projectIndustry", project.getProjectIndustry());
        model.addAttribute("projectAddress", project.getProjectAddress());
        model.addAttribute("projectDescription", project.getProjectDescription());
        model.addAttribute("projectSiteLink", project.getProjectSiteLink());
        model.addAttribute("projectExpectedRaise", project.getProjectExpectedRaise());
        model.addAttribute("projectAmountRaised", project.getProjectAmountRaised());
        model.addAttribute("ProjectMinInv", project.getProjectMinInv());
        model.addAttribute("projectReturn", project.getProjectReturn());
        model.addAttribute("projectPreviousRounds", project.getProjectPreviousRounds());
        model.addAttribute("projectLastChange", project.getProjectLastChange());
        //model.addAttribute("isActive", project.isActive());
        */

        // save address
        Address address = projectRegistrationForm.getAddress();
        addressService.save(address);

        Project project = projectRegistrationForm.getProject();

        //System.out.println("User:" + projectRegistrationForm.getUser().getUsername());

        project.setProjectAddress(address);
        project.setActive(true);
        project.setProjectLastChange(LocalDate.now());
        projectsService.save(project);
        return "projectResult";
    }

    @GetMapping("/search")
    public String projectSearch(Model model) {
        model.addAttribute("projectSearch", new ProjectRegistrationForm());
        //return new ModelAndView("projectRegistration", "command", new Project());
        return "projectSearch";
    }

    @PostMapping("/search")
    public ModelAndView SearchResults(@ModelAttribute ProjectRegistrationForm projectRegistrationForm){

        // get address and project
        Address address = projectRegistrationForm.getAddress();
        Project project = projectRegistrationForm.getProject();
        project.setProjectAddress(address);
        project.setActive(true);

        // search with query by example based on String criteria
        List<Project> projects = projectsService.findAllExample(project);

        // getting rid of projects not matching number criteria
        if (project.getProjectMinInv() != null){
            projects.removeIf(p -> p.getProjectMinInv().compareTo(project.getProjectMinInv()) == 1);
        }

        if (project.getProjectExpectedRaise() != null){
            projects.removeIf(p -> p.getProjectExpectedRaise().compareTo(project.getProjectExpectedRaise()) == -1);
        }

        if (project.getProjectReturn() != 0.0) {
            projects.removeIf(p -> p.getProjectReturn() < project.getProjectReturn());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectSearchResult");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    // show update form
    @GetMapping(value = "/{projectId}/update")
    public ModelAndView showUpdateProjectForm(@PathVariable("projectId") long projectId) {

        logger.debug("showUpdateProjectForm() : {}", projectId);

        Project project = projectsService.findById(projectId);
        //model.addAttribute("project", project);

        return new ModelAndView("projectUpdateForm","command",project); // "projectUpdateForm"; //"users/userform";
    }

    // save updated project
    @PostMapping(value="/updated")
    public String updateProject(@ModelAttribute ("project") Project project){
        addressService.save(project.getProjectAddress()); // if I do not do that i get: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance beforeQuery flushing
        projectsService.save(project);
        return "projectUpdated";
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
    public void initDefaultProjects() {

        System.out.println("creating default projects");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Address addressKherson = new Address ("Kherson", Region.Kherson, Country.UKRAINE);
        Address addressOdessa = new Address("Odessa", Region.Odessa, Country.UKRAINE);

        BigDecimal previousRounds = new BigDecimal(10000);
        BigDecimal inv = new BigDecimal(100000);
        BigDecimal raised = new BigDecimal(10000);
        BigDecimal mininv = new BigDecimal(1000);

        Project project1 = new Project ("Kherson Farm", Industry.Agriculture, addressKherson,
                "Grow stuff in Kherson","logourl", "docurl", "weburl",
                inv, raised, mininv, 20, LocalDate.parse("10/09/2017", formatter), true, previousRounds);

        BigDecimal previousRounds2 = new BigDecimal(20000);
        BigDecimal inv2 = new BigDecimal(200000);
        BigDecimal raised2 = new BigDecimal(20000);
        BigDecimal mininv2 = new BigDecimal(2000);

        Project project2 = new Project ("Odessa Terminal", Industry.Transportation, addressOdessa,
                "Export stuff from Odessa","logourl", "docurl", "weburl",
                inv2, raised2, mininv2, 30, LocalDate.parse("15/09/2017", formatter), true, previousRounds2);

        System.out.println("saving default projects");

        projectsService.save(project1);
        projectsService.save(project2);

        System.out.println("success!");

    } */

}

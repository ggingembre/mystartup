package ua.goit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.entity.*;
import ua.goit.services.ProjectService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Guillaume Gingembre on 15/09/2017.
 */

@Controller
@RequestMapping(value = "/project")
public class ShowProjectsController {

    private final ProjectService projectsService;

    @Autowired
    public ShowProjectsController(ProjectService projectsService) {
        this.projectsService = projectsService;
    }

    @ModelAttribute("industries")
    public Industry[] industries() {
        return Industry.values();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showAll")
    public ModelAndView showProjects() {
        List<String> projectnames =
                projectsService.findAll().stream().map(Project::toString).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projects");
        modelAndView.addObject("projects", projectnames);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public ModelAndView showForm() {
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("projectRegistration");
        //modelAndView.addObject(new Project());
        //modelAndView.addObject("industries", Industry.values());
        //return modelAndView;
        return new ModelAndView("projectRegistration", "command", new Project());
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("projectView")Project project,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "projectInputError";
        }

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
        return "projectView";
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

package ua.goit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.entity.*;
import ua.goit.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maryna Kontar on 21.08.2017.
 * @KontarMaryna
 */
@Controller
@RequestMapping(value = "/user")
public class ShowUsersController {

    private final UserService usersService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ShowUsersController(UserService usersService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public ModelAndView showUsers() {
        List<String> usernames =
                usersService.findAll().stream().map(User::toString).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", usernames);
        return modelAndView;
    }

    @PostConstruct
    public void initDefaultUsers() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        Collection<Role> roles = Arrays.asList(Role.DEVELOPER, Role.ADMIN);
        user.setRoles(roles);
        Contact contact = new Contact("email","0503357740", City.KYIV, Country.UKRAINE);
        user.setContact(contact);
//        Experience experience = new Experience();
//        user.setExperiences(Arrays.asList(experience));
        user.setPersonalPageFotoLink("jpeg/personalPageFoto/adminFoto.jpg");//TODO Как ссылку указывать?
        user.setYoutubeLink("https://www.youtube.com/watch?v=3wBteulZaAs&index=1&list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t");
        user.setAboutMe("I'm admin!");
        user.setSkills("JavaCore, Spring, Hibernate");
        usersService.save(user);


        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("user"));
        Collection<Role> roles1 = Arrays.asList(Role.DEVELOPER, Role.ADMIN);
        user1.setRoles(roles1);
        Contact contact1 = new Contact("emailuser","555", City.KYIV, Country.UKRAINE);
        user1.setContact(contact1);
        usersService.save(user1);

        User user2 = new User();
        user2.setUsername("user1");
        user2.setPassword(passwordEncoder.encode("user1"));
        Collection<Role> roles2 = Arrays.asList(Role.DEVELOPER, Role.INVESTOR);
        user2.setRoles(roles2);
        Contact contact2 = new Contact("emailuser1","333", City.KYIV, Country.UKRAINE);
        user2.setContact(contact2);
        usersService.save(user2);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public void createUser(@RequestParam("username") @NotEmpty String username,
//                           @NotEmpty String password,
//                           @RequestParam(required = false) String email
////                           ,@RequestHeader(value = "x", required = false) String x,
////                           @CookieValue(value = "y", required = false) String y
//                            ) throws IOException {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setEmail(email);
//        usersService.save(user);
//    }
//
//
//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    public String logout() {
//        // http://localhost:8080/login?logout
//        return "redirect:/login?logout";
//    }
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }
//    @ExceptionHandler(IOException.class)
//    public ResponseEntity<String> handleIOException(IOException ex) {
//        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).build();
//    }
}

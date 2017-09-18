package ua.goit.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import ua.goit.entity.*;
import ua.goit.services.UserService;

import java.util.Arrays;
import java.util.Collection;

/**
 * Util class for creating default entities for test
 *
 * @KontarMaryna
 */
public class InitDefaultEntities {

    public static void initDefaultUsers(UserService usersService,PasswordEncoder passwordEncoder){
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        Collection<Role> roles = Arrays.asList(Role.DEVELOPER, Role.ADMIN);
        user.setRoles(roles);
        Contact contact = new Contact("email", "0503357740", City.KYIV, Country.UKRAINE);
        user.setContact(contact);
        Experience experience1 = new Experience("companyadmin1", "position1",
                "responsibility1");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));
        Experience experience2 = new Experience("companyadmin2", "position2",
                "responsibility2");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));

        user.setPersonalPageFotoLink("jpeg/personalPageFoto/adminFoto.jpg");//TODO Как ссылку указывать?
        user.setYoutubeLink("https://www.youtube.com/watch?v=3wBteulZaAs&index=1&list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t");
        user.setAboutMe("I'm admin!");
        user.setSkills("JavaCore, Spring, Hibernate");
        user.setExperiences(Arrays.asList(experience1,experience2));
        Education education1 = new Education("institution1", "stage1",
                "faculty1","fieldOfStudy", ModeOfStudy.FULL_TIME);
        user.setEducations(Arrays.asList(education1));
        usersService.save(user);


        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("user"));
        Collection<Role> roles1 = Arrays.asList(Role.DEVELOPER, Role.ADMIN);
        user1.setRoles(roles1);
        Contact contact1 = new Contact("emailuser", "555", City.KYIV, Country.UKRAINE);
        user1.setContact(contact1);
        Experience experience3 = new Experience("companyadmin3", "position3",
                "responsibility3");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));
        Experience experience4 = new Experience("companyadmin4", "position4",
                "responsibility4");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));
        user1.setExperiences(Arrays.asList(experience3,experience4));
        Education education2 = new Education("institution2", "stage2",
                "faculty2","fieldOfStudy2", ModeOfStudy.EVENING);
        user1.setEducations(Arrays.asList(education2));
        usersService.save(user1);


        User user2 = new User();
        user2.setUsername("user1");
        user2.setPassword(passwordEncoder.encode("user1"));
        Collection<Role> roles2 = Arrays.asList(Role.DEVELOPER, Role.INVESTOR);
        user2.setRoles(roles2);
        Contact contact2 = new Contact("emailuser1", "333", City.KYIV, Country.UKRAINE);
        user2.setContact(contact2);
        Experience experience5 = new Experience("companyadmin5", "position5",
                "responsibility5");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));
        Experience experience6 = new Experience("companyadmin6", "position6",
                "responsibility6");
//                ,LocalDate.of(2002, 9, 1),
//                LocalDate.of(2007, 6, 30));
        user2.setExperiences(Arrays.asList(experience5,experience6));
        Education education3 = new Education("institution3", "stage3",
                "faculty3","fieldOfStudy3", ModeOfStudy.REMOTE);
        user2.setEducations(Arrays.asList(education3));
        usersService.save(user2);
    }
}

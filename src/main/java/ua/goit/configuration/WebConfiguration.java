package ua.goit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC configuration used to configure all kind of resources.
 * @KontarMaryna
 */
@Configuration
@EnableWebMvc
@ComponentScan({"ua.goit.controllers"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    //прописала, как маппить странички браузера с *.jpeg, *.css, *.html на ресурсы в файловой системе
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/*.jpeg").addResourceLocations("/WEB_INF/jpeg/");
//        registry.addResourceHandler("/*.css").addResourceLocations("/WEB_INF/css/");
//        registry.addResourceHandler("/*.html").addResourceLocations("/WEB_INF/html/");
//
//    }

    //TODO 7 переадресакция не работает. проверить почему
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // View -> RedirectView
        registry.addRedirectViewController("/login", "/user/show");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        //TODO 4. пока используем jsp для View (-> JstlView)
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

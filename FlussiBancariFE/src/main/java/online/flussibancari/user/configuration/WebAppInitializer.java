package online.flussibancari.user.configuration;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import online.flussibancari.user.security.SecurityConfiguration;
 
public class WebAppInitializer {
//implements WebApplicationInitializer {
 /*
    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        @SuppressWarnings("resource")
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(HibernateConfiguration.class, SecurityConfiguration.class, AppInitializer.class);
 

        // Create the dispatcher servlet's Spring application context
        @SuppressWarnings("resource")
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AppConfig.class);
                      
    }
 */
 }

package net.arthur.springsecurityapp.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    //Dev commit
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfiguration.class);
        ctx.setServletContext(servletContext);

        //Again dev commit
        final ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(ctx)
        );

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    //test commit
}

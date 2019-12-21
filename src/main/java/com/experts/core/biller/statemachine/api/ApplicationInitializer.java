package com.experts.core.biller.statemachine.api;

import com.experts.core.biller.statemachine.api.activemq.standers.config.CustomerConfig;
import com.experts.core.biller.statemachine.api.activemq.standers.config.SwaggerConfigurations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Configuration
public class ApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { CustomerConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringConfigMvc.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/*" };
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        //初始化webApplicationContext
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfigMvc.class);
        context.register(SwaggerConfigurations.class);
        context.refresh();

        //注册dispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }
}

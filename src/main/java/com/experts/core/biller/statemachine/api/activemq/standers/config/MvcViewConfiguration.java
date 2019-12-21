package com.experts.core.biller.statemachine.api.activemq.standers.config;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;
import java.util.Locale;


@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = "com.experts.core.biller.statemachine.api.service.impl")
@Import({SwaggerConfigurations.class})
public class MvcViewConfiguration extends WebMvcConfigurerAdapter {

    private Logger log = LoggerFactory.getLogger(MvcViewConfiguration.class);

    @Autowired
    private TypeResolver typeResolver;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // Make Swagger UI available via <baseURL>/swagger-ui.html
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("**/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("**/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }



    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale(DistTxConstants.LOCALE_ENGLISH));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptorLng() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    @Profile("dev")
    public static PropertySourcesPlaceholderConfigurer devPropertyConfigurer() {
        return preparePlaceholder(DistTxConstants.DEV_PROPERTIES_RESOURCE);
    }

    @Bean
    @Profile("test")
    public static PropertySourcesPlaceholderConfigurer testPropertyConfigurer() {
        return preparePlaceholder(DistTxConstants.TEST_PROPERTIES_RESOURCE);
    }

    private static PropertySourcesPlaceholderConfigurer preparePlaceholder(String propResource) {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource resource = new ClassPathResource(propResource);
        placeholderConfigurer.setLocation(resource);
        return placeholderConfigurer;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);
        builder.featuresToDisable(
                SerializationFeature.FAIL_ON_EMPTY_BEANS,
                DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        builder.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return builder.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE","POST","GET")
                .allowCredentials(false).maxAge(3600);
    }

    @Bean
    public HandlerMethodResolver handlerMethodResolver(){
        return new HandlerMethodResolver(typeResolver);
    }

}

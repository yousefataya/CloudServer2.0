package com.experts.core.biller.statemachine.api;

import com.experts.core.biller.statemachine.api.activemq.standers.config.MvcViewConfiguration;
import com.experts.core.biller.statemachine.api.service.impl.PaymentNotificationController;
import com.experts.core.biller.statemachine.api.service.impl.PaymentPrePaidController;
import com.experts.core.biller.statemachine.api.service.impl.PaymentServiceController;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;*/

import java.nio.charset.Charset;
import java.util.*;

/*import org.springframework.cloud.dataflow.server.EnableDataFlowServer;*/
/*import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

@Configuration
@EnableWebMvc
/*@EnableSpringDataWebSupport*/
/*@EnableSwagger2WebMvc*/
@EnableSwagger2
@ComponentScan(basePackageClasses = { PaymentNotificationController.class  , PaymentServiceController.class , PaymentPrePaidController.class })
@Import({ PaymentNotificationController.class , PaymentPrePaidController.class , PaymentServiceController.class , MvcViewConfiguration.class})
/*@EnableHypermediaSupport(type= {EnableHypermediaSupport.HypermediaType.HAL})*/
public class SpringConfigMvc extends WebMvcConfigurerAdapter {

    @Bean
    public StringHttpMessageConverter stringMessageConverter() {
        return new StringHttpMessageConverter();
    }

    @Autowired
    private ObjectMapper objectMapper;

    private MappingJackson2HttpMessageConverter jacksonConverter() {
       ObjectMapper mapper = objectMapper;
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        SimpleModule simpleModule = new SimpleModule("SimpleModule", Version.unknownVersion());
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.registerModule(simpleModule);
        mapper.setVisibility(PropertyAccessor.FIELD, com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY);
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jacksonConverter.setObjectMapper(mapper);
        return jacksonConverter;
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add( jacksonConverter());
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new StringHttpMessageConverter(Charset.defaultCharset().forName("UTF-8")));

    }

    @Bean
    public SessionLocaleResolver sessionLocaleResolver(){
        Locale locale = new Locale("ko");
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(locale);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public DefaultRequestToViewNameTranslator defaultRequestToViewNameTranslator(){
        return new DefaultRequestToViewNameTranslator();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver;
    }

    @Bean(name="viewNameTranslator")
    public DefaultRequestToViewNameTranslator viewNameTranslator(){
        return new DefaultRequestToViewNameTranslator();
    }

    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.experts.core.biller.statemachine.api"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("Employee Management REST API")
                .contact(new Contact("Ramesh Fadatare", "www.javaguides.net", "ramesh24fadatare@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }*/


    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(){
        ContentNegotiatingViewResolver negotiating = new ContentNegotiatingViewResolver();
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("jsonp", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml",  MediaType.APPLICATION_XML);
        mediaTypes.put("atom", MediaType.APPLICATION_ATOM_XML);
        ContentNegotiationStrategy pathExtensionContentNegotiationStrategy = new PathExtensionContentNegotiationStrategy(mediaTypes);
        ContentNegotiationStrategy  headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
        ContentNegotiationManager contentNegotiationManager = new ContentNegotiationManager(pathExtensionContentNegotiationStrategy, headerContentNegotiationStrategy);
        negotiating.setContentNegotiationManager(contentNegotiationManager);
        List<View> JsonView = new ArrayList<>();
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setExtractValueFromSingleKeyModel(true);
        JsonView.add(mappingJackson2JsonView);
        negotiating.setDefaultViews(JsonView);
        negotiating.setOrder(2);
        return negotiating;
    }

    @Bean(name = "BillPullRequest")
    @Order(-1)
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema billpull) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BillPullResponse");
        wsdl11Definition.setLocationUri("/billpull");
        wsdl11Definition.setTargetNamespace("http://localhost:8070/ws/billpull");
        wsdl11Definition.setSchema(billpull);
        wsdl11Definition.setCreateSoap11Binding(true);
        return wsdl11Definition;
    }


    @Bean(name = "NotificationRequest")
    @Order(-3)
    public DefaultWsdl11Definition defaultWsdlNotifactionDefinition(XsdSchema notification) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("NotificationRequest");
        wsdl11Definition.setLocationUri("/notifaction");
        wsdl11Definition.setTargetNamespace("http://localhost:8070/ws/notifaction");
        wsdl11Definition.setSchema(notification);

        return wsdl11Definition;
    }

    @Bean(name = "PrePaidRequest")
    @Order(-4)
    public DefaultWsdl11Definition defaultWsdlPerpaidDefinition(XsdSchema prepaid) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PrePaidRequest");
        wsdl11Definition.setLocationUri("/prepaid");
        wsdl11Definition.setTargetNamespace("http://localhost:8070/ws/prepaid");
        wsdl11Definition.setSchema(prepaid);

        return wsdl11Definition;
    }


    @Bean(name = "PaymentRequest")
    @Order(-5)
    public DefaultWsdl11Definition paymentWsdl11Definition(XsdSchema payment) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PaymentRequest");
        wsdl11Definition.setLocationUri("/payment");
        wsdl11Definition.setTargetNamespace("http://localhost:8070/ws/payment");
        wsdl11Definition.setSchema(payment);

        return wsdl11Definition;
    }

    @Bean(name = "InquiryRequest")
    @Order(-6)
    public DefaultWsdl11Definition inquiryWsdl11Definition(XsdSchema inquiry) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("InquiryRequest");
        wsdl11Definition.setLocationUri("/inquiry");
        wsdl11Definition.setTargetNamespace("http://localhost:8070/ws/inquiry");
        wsdl11Definition.setSchema(inquiry);
        wsdl11Definition.setCreateSoap11Binding(true);
        return wsdl11Definition;
    }


    @Bean(name  = "billpull")
    @Order(-1)
    public XsdSchema billpull(){
        return new SimpleXsdSchema(new ClassPathResource("billpull.xsd"));}

    @Bean(name  = "inquiry")
    @Order(-8)
    public XsdSchema inquiry(){
        return new  SimpleXsdSchema(new ClassPathResource("inquiry-xsd.xsd"));}


    @Bean(name  = "pdpext")
    @Order(-2)
    public XsdSchema pdpext(){
        return new  SimpleXsdSchema(new ClassPathResource("pdp-ext.xsd"));
    }


    @Bean(name  = "notification")
    public XsdSchema notification(){
        return new  SimpleXsdSchema(new ClassPathResource("pay-notification.xsd"));
    }


    @Bean(name  = "prepaid")
    @Order(-4)
    public XsdSchema prepaid(){
        return new  SimpleXsdSchema(new ClassPathResource("prepaid-service-validation.xsd"));
    }


    @Bean(name  = "payment")
    @Order(-5)
    public XsdSchema payment(){
        return new  SimpleXsdSchema(new ClassPathResource("payment-service.xsd"));
    }


    @Bean
    public XsdSchemaCollection quotesSchemaCollection() {
        return new XsdSchemaCollection() {

            public XsdSchema[] getXsdSchemas() {
                return new XsdSchema[]{new SimpleXsdSchema(new ClassPathResource("billpull.xsd")) , new SimpleXsdSchema(new ClassPathResource("pdp-ext.xsd")) };
            }

            public XmlValidator createValidator() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Bean
    public HttpComponentsMessageSender messageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        return httpComponentsMessageSender;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE","POST","GET")
                .allowCredentials(false).maxAge(3600);
    }

}

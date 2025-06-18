package com.chuong.emsbackend.config.locale;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocalResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";

    List<Locale> SUPPORTED_LOCALES = List.of(Locale.US, Locale.of("vn"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String languageHeader = request.getHeader(ACCEPT_LANGUAGE_HEADER);

        return StringUtils.hasLength(languageHeader) ?
                Locale.lookup(Locale.LanguageRange.parse(languageHeader),
                        SUPPORTED_LOCALES) :
                Locale.US;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("i18/messages");
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        rs.setCacheSeconds(3600);
        return rs;
    }


//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }


}

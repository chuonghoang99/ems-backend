package com.chuong.emsbackend.config.locale;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

//@Component
//public class Translator  {
//    private static ResourceBundleMessageSource messageSource;
//
//    @Autowired
//    public void setMessageSource(ResourceBundleMessageSource messageSource) {
//        Translator.messageSource = messageSource;
//    }
//
//    public static String toLocale(String code) {
//        Locale locale = LocaleContextHolder.getLocale();
//        return messageSource.getMessage(code, null, locale);
//    }
//}
@Component
public class Translator {
    private static ResourceBundleMessageSource messageSource;

    private final ResourceBundleMessageSource localMessageSource;

    @Autowired
    public Translator(ResourceBundleMessageSource messageSource) {
        this.localMessageSource = messageSource;
    }

    @PostConstruct
    private void init() {
        Translator.messageSource = this.localMessageSource;
    }

    public static String toLocale(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }
}

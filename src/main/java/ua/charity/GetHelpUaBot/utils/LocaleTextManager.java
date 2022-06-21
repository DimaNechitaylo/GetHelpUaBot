package ua.charity.GetHelpUaBot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Locale;

public class LocaleTextManager {
    private static Locale locale;
    private static MessageSource messageSource;

    public static String getMessageText(String mne, @Value("${localeTag}") String localeTag) {
        return messageSource.getMessage(mne, null, locale);
    }

    public static String getMessageText(String mne, Object... args) {
        return messageSource.getMessage(mne, args, locale);
    }
}

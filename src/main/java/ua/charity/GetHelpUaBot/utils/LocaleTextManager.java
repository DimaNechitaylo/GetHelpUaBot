package ua.charity.GetHelpUaBot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleTextManager {
    private static Locale locale;
    private static MessageSource messageSource;

    @Autowired
    public LocaleTextManager(@Value("${localeTag}") String localeTag, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag(localeTag);
    }


    public static String getMessageText(String mne) {
        return messageSource.getMessage(mne, null, locale);
    }

    public static String getMessageText(String mne, Object... args) {
        return messageSource.getMessage(mne, args, locale);
    }
}

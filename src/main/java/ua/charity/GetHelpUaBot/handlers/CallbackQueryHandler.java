package ua.charity.GetHelpUaBot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

/**
 * @author Dmitry Nechytailo
 */

public interface CallbackQueryHandler {
    SendMessage handleCallbackQuery(CallbackQuery callbackQuery);

    CallbackQueryType getHandlerQueryType();

}

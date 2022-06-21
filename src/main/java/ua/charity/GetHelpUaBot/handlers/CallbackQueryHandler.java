package ua.charity.GetHelpUaBot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

 

public interface CallbackQueryHandler {
    void handleCallbackQuery(CallbackQuery callbackQuery);

    CallbackQueryType getHandlerQueryType();

}

package ua.charity.GetHelpUaBot.handlers.callbackquery;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ua.charity.GetHelpUaBot.handlers.CallbackQueryHandler;
import ua.charity.GetHelpUaBot.handlers.CallbackQueryType;

@Component
public class TestCallbackHandler implements CallbackQueryHandler {
    @Override
    public void handleCallbackQuery(CallbackQuery callbackQuery) {
        return ;
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return CallbackQueryType.TEST;
    }
}

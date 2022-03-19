package ua.charity.GetHelpUaBot.handlers.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.DataCache;
import ua.charity.GetHelpUaBot.handlers.BotState;
import ua.charity.GetHelpUaBot.handlers.InputMessageHandler;
import ua.charity.GetHelpUaBot.service.ReplyMessageService;

@Component
public class StartMenuHendler implements InputMessageHandler {

    @Autowired
    private DataCache dataCache;

    @Autowired
    private MessageSender messageSender;

    private ReplyMessageService messageService;


    @Override
    public void handle(Message message) {
        messageSender.setChatId(dataCache.getCurrentUserId());
        messageSender.setText("Hooray");
        messageSender.sendMessage();

    }

    @Override
    public BotState getHandlerName() {
        return BotState.SIGN_UP;
    }
}

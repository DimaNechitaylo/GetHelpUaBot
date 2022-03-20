package ua.charity.GetHelpUaBot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

 

public interface InputMessageHandler {
    void handle(Message message);

    BotState getHandlerName();

}

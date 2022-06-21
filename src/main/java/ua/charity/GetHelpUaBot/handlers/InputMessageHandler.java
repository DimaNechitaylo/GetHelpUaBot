package ua.charity.GetHelpUaBot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.exceptions.InvalidCommandException;


public interface InputMessageHandler {
    void process(Message message) throws InvalidCommandException;

    BotState getStateName();
}

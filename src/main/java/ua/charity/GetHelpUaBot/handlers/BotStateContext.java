package ua.charity.GetHelpUaBot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmitry Nechytailo
 */

@Component
public class BotStateContext {
    private Map<BotState, InputMessageHandler> messageHandlers = new HashMap<>();

    public BotStateContext(List<InputMessageHandler> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }

    public void processInputMessage(BotState currentState, Message message) {
        findMessageHandler(currentState).handle(message);;
    }

    private InputMessageHandler findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }
}

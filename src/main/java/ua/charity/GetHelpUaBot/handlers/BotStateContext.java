package ua.charity.GetHelpUaBot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.exceptions.InvalidCommandException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

@Component
public class BotStateContext {
    private Map<BotState, InputMessageHandler> messageHandlers = new HashMap<>();

    public BotStateContext(List<InputMessageHandler> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getStateName(), handler));
    }

    public void processInputMessage(BotState currentState, Message message) throws InvalidCommandException {
        findMessageHandler(currentState).process(message);;
    }

    private InputMessageHandler findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }
}

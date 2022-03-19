package ua.charity.GetHelpUaBot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ua.charity.GetHelpUaBot.service.ReplyMessageService;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Nechytailo
 */

@Component
public class CallbackQueryFacade {
    private ReplyMessageService messageService;

    private List<CallbackQueryHandler> callbackQueryHandlers;

    public CallbackQueryFacade(ReplyMessageService messageService,
                               List<CallbackQueryHandler> callbackQueryHandlers) {
        this.messageService = messageService;
        this.callbackQueryHandlers = callbackQueryHandlers;
    }

    public SendMessage processCallbackQuery(CallbackQuery usersQuery) {
        CallbackQueryType usersQueryType = CallbackQueryType.valueOf(usersQuery.getData().split("\\|")[0]);

        Optional<CallbackQueryHandler> queryHandler = callbackQueryHandlers.stream().
                filter(callbackQuery -> callbackQuery.getHandlerQueryType().equals(usersQueryType)).findFirst();

        return queryHandler.map(handler -> handler.handleCallbackQuery(usersQuery)).
                orElse(messageService.getReplyMessage(usersQuery.getMessage().getChatId(), "Something went wrong"));
    }
}
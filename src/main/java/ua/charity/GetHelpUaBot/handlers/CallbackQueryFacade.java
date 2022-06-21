package ua.charity.GetHelpUaBot.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.exceptions.CallbackNotFoundException;
import ua.charity.GetHelpUaBot.utils.LocaleTextManager;

import java.util.List;
import java.util.Optional;

 

@Component
public class CallbackQueryFacade {
    private LocaleTextManager messageManager;

    @Autowired
    private MessageSender messageSender;

    private List<CallbackQueryHandler> callbackQueryHandlers;

    public CallbackQueryFacade(LocaleTextManager messageService,
                               List<CallbackQueryHandler> callbackQueryHandlers) {
        this.messageManager = messageService;
        this.callbackQueryHandlers = callbackQueryHandlers;
    }

    public void processCallbackQuery(CallbackQuery usersQuery) {
        CallbackQueryType usersQueryType = CallbackQueryType.valueOf(usersQuery.getData().split("\\|")[0]);

        Optional<CallbackQueryHandler> queryHandler = callbackQueryHandlers.stream().
                filter(callbackQuery -> callbackQuery.getHandlerQueryType().equals(usersQueryType)).findFirst();

//        queryHandler.map(handler -> handler.handleCallbackQuery(usersQuery)).orElseThrow(()
//                -> new CallbackNotFoundException("Callback handler doesn`t exist"));
    }
}
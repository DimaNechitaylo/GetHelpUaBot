package ua.charity.GetHelpUaBot.boilerplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ua.charity.GetHelpUaBot.botapi.Bot;
import ua.charity.GetHelpUaBot.exceptions.IllegalClassStateException;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class MessageSender {

    private Bot bot;

    private SendMessage sendMessage;

    public MessageSender(@Lazy Bot bot) {
        this.sendMessage = new SendMessage();
        this.bot = bot;
    }

    public void setText(String text) {
        this.sendMessage.setText(text);
    }

    public void setChatId(Long userid) {
        this.sendMessage.setChatId(userid.toString());
    }

    public void sendMessage() {
        if (this.sendMessage.getText().isEmpty()) {
            throw new IllegalClassStateException(
                    "Message can't be sent if its text is empty.");
        }
        if (this.sendMessage.getChatId() == null || this.sendMessage.getChatId().isEmpty()) {
            throw new IllegalClassStateException(
                    "Message can't be sent if its chatId is empty.");
        }
        bot.sendMessage(this.sendMessage);
        this.sendMessage = new SendMessage();
    }

}
package ua.charity.GetHelpUaBot.boilerplate;

import lombok.Builder;
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

    private List<Button> buttons;

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
        this.buttons = null;
        this.sendMessage = new SendMessage();
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
        setButtons();
    }

    public void setButtons(List<Button> buttons, int columnCount) {
        this.buttons = buttons;
        setButtonsWhithColumnCount(columnCount);
    }

    private void setButtons() {
        if (this.buttons == null || this.buttons.isEmpty()) {
            throw new IllegalClassStateException(
                    "Butttons can't be set if texts are not set. Use MessageSender#setTexts() before");
        }
        setButtonsWhithColumnCount(2);
    }

    public void setButtonsWhithColumnCount(int columnCount) {
        if (this.buttons == null || this.buttons.isEmpty()) {
            throw new IllegalClassStateException(
                    "Butttons can't be set if texts are not set. Use MessageSender#setTexts() before");
        }
        setSpecialButtons(columnCount);
    }
    public void setSpecialButtons(int columnCount) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        int rowsCount = (int) Math.round(buttons.size() / (double) columnCount);
        List<KeyboardRow> keyboard = new ArrayList<>(rowsCount);
        int buttonNum = 0;
        int totalButtons = buttons.size();
        for (int i = 0; i < rowsCount; i++) {
            KeyboardRow row = new KeyboardRow();
            int iter = 0;
            for (int j = buttonNum; j < totalButtons; j++) {
                Button button = buttons.get(buttonNum);
                KeyboardButton btn = new KeyboardButton(button.getText());
                if (button.isSetAsContactButton()) {
                    btn.setRequestContact(true);
                }
                if (button.isSetAsLocationButton()) {
                    btn.setRequestLocation(true);
                }
                row.add(btn);
                buttonNum++;
                if (iter == 1) {
                    break;
                }
                iter++;
            }
            keyboard.add(row);
        }
        replyKeyboardMarkup.setKeyboard(keyboard);
        this.sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    public void setInlineButtons(List<InlineButton> buttons) {
        if (buttons == null || buttons.isEmpty()) {
            throw new IllegalClassStateException("Inline buttons can't be set if the list is null or empty");
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        for (int i = 0; i < Math.round(buttons.size() / 2.0d); i++) {
            List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
            try {
                InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                inlineKeyboardButton1.setText(buttons.get(i * 2).getText());
                inlineKeyboardButton1.setCallbackData(buttons.get(i * 2).getCommand());
                try {
                    inlineKeyboardButton1
                            .setUrl(buttons.get(i * 2).getUrl().orElseThrow(() -> new NullPointerException()));
                } catch (NullPointerException npe) {
                    //do not add url if empty
                }
                keyboardButtonsRow1.add(inlineKeyboardButton1);
            } catch (Exception e) {
                // Do nothing if no such index
            }
            try {
                InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                inlineKeyboardButton2.setText(buttons.get(i * 2 + 1).getText());
                inlineKeyboardButton2.setCallbackData(buttons.get(i * 2 + 1).getCommand());
                try {
                    inlineKeyboardButton2
                            .setUrl(buttons.get(i * 2 + 1).getUrl().orElseThrow(() -> new NullPointerException()));
                } catch (NullPointerException npe) {
                    //do not add url if empty
                }
                keyboardButtonsRow1.add(inlineKeyboardButton2);
            } catch (Exception e) {
                // Do nothing if no such index
            }
            rowList.add(keyboardButtonsRow1);
        }
        inlineKeyboardMarkup.setKeyboard(rowList);
        this.sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }

}
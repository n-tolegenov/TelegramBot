package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "AlmatyTelBot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6517097624:AAFlKtkP_Ynsa3IWEnh2cTpGJzL1-kZbX9w"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
//        sendTextMessageAsync("Привет!");
//        sendTextMessageAsync("Привет! *Я вас всех люблю!*");
//        sendTextMessageAsync("Привет! _Я вас всех люблю!_");
//        sendTextMessageAsync("Привет! Меня зовут Нурбол!");

        if(getMessageText().equals("/bye")){
            sendTextMessageAsync("Asta la vista, baby!");
        }

        if(getMessageText().equals("smile")){
            var message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText() + ":)");
        }

        if(getMessageText().equals("/start")){
            sendTextMessageAsync(
                    "Ваше любимое животное?",
                    Map.of("Кот", "cat", "Собака", "dog"));
        }

        if(getCallbackQueryButtonKey().equals("cat")){
            sendPhotoMessageAsync("step_4_pic");
        }

        if(getCallbackQueryButtonKey().equals("dog")){
            sendPhotoMessageAsync("step_6_pic");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
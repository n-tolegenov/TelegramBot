package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "AlmatyTelBot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6517097624:AAFlKtkP_Ynsa3IWEnh2cTpGJzL1-kZbX9w"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {

        // Отобразим сообщение о начале игры - нужно взломать холодильник
        if(getMessageText().equals("/start")){
            addUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника!", "step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of( "Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! +20 славы", "step_2_btn"));
        }

        // Взламываем робот пылесос
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса!", "step_3_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of( "Отправить робот пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота пылесоса! +30 славы", "step_4_btn"));
        }

        // Взламываем камеру Go-Pro
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Включить и одеть камеру Go-Pro!", "step_5_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of( "Бегать по крышам и снимать все подряд! +40 славы", "step_6_btn",
                            "Нападать на кошек и снимать это на видео! +40 славы", "step_6_btn",
                            "Нападать из засады на собак! +40 славы", "step_6_btn"));
        }

        // Взламываем компьютер
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом компьютера!", "step_7_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of( "Выйти во двор и похвастаться! +50 славы", "step_8_btn"));
        }

        // Хвастаемся дворовым котам
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            addUserGlory(50);
//            sendPhotoMessageAsync("final_pic");
            sendImageMessageAsync(
                    "C:\\Users\\Nurbol\\Desktop\\TelegramBot\\src\\main\\resources\\images\\final_pic.jpg");
            sendTextMessageAsync(FINAL_TEXT);
        }

        if(getMessageText().equals("/glory")){
            sendTextMessageAsync("Накопленный количество очков славы : " + getUserGlory());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

// TODO: основной функционал бота будем писать здесь
//        sendTextMessageAsync("Привет!");
//        sendTextMessageAsync("Привет! *Я вас всех люблю!*");
//        sendTextMessageAsync("Привет! _Я вас всех люблю!_");
//        sendTextMessageAsync("Привет! Меня зовут Нурбол!");
//
//        if(getMessageText().equals("/bye")){
//                sendTextMessageAsync("Asta la vista, baby!");
//                }
//
//                if(getMessageText().equals("smile")){
//                var message = getLastSentMessage();
//                editTextMessageAsync(message.getMessageId(), message.getText() + ":)");
//                }
//
//                if(getMessageText().equals("/start")){
//                sendTextMessageAsync(
//                "Ваше любимое животное?",
//                Map.of("Кот", "cat", "Собака", "dog"));
//                }
//
//                if(getCallbackQueryButtonKey().equals("cat")){
//                sendPhotoMessageAsync("step_4_pic");
//                }
//
//                if(getCallbackQueryButtonKey().equals("dog")){
//                sendPhotoMessageAsync("step_6_pic");
//                }
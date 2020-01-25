package main;

import events.Forum;
import events.Help;
import events.Online;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class PricillaJDA extends ListenerAdapter {
//    Токен бота из https://discordapp.com/developers/applications/
    private static final String TOKEN = "NjY5OTI0MDc5MzM1Mzc0ODk4.Xisonw.hQRtsXEiWgoYSlaPBa7pfehv2GI";

    public static void main(String[] args) throws LoginException {
        JDABuilder jda = new JDABuilder(AccountType.BOT);
        jda.addEventListeners(new Forum());
        jda.addEventListeners(new Online());
        jda.addEventListeners(new Help());
        jda.setToken(TOKEN).build();

    }
}

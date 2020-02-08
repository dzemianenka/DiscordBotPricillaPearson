package main;

import events.*;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class PricillaJDA {
    public static JDA jda;
//    Token from https://discordapp.com/developers/applications/
    private static final String TOKEN = "NjY5OTI0MDc5MzM1Mzc0ODk4.XjVipg.zi56ICrq097kLjRadM0NAi4NN34";

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken(TOKEN).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("Elite Dangerous"));
        jda.addEventListener(new Links());
        jda.addEventListener(new Online());
        jda.addEventListener(new Info());
        jda.addEventListener(new ExpDate());
        jda.addEventListener(new SysCount());
        jda.addEventListener(new LastExp());

    }
}

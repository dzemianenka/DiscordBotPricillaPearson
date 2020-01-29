package events;

import main.Info;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Links extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(Info.PREFIX + "forum")) {
//            Текст сообщения в чат. Форум
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Наш форум находится по адресу:");
            embed.setDescription("<http://rci.mybb.ru>");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Info.PREFIX + "coriolis")) {
//            Текст сообщения в чат. Coriolis
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Elite: Dangerous Shipyard:");
            embed.setDescription("<http://coriolis.io>");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Info.PREFIX + "eddb")) {
//            Текст сообщения в чат. EDDB
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Elite: Dangerous Database - EDDB:");
            embed.setDescription("<http://eddb.io>");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Info.PREFIX + "inara")) {
//            Текст сообщения в чат. Inara
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("INARA - Elite: Dangerous companion:");
            embed.setDescription("<http://inara.cz>");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

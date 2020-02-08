package events;

import main.Prefix;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Links extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(Prefix.PREFIX + "forum")) {
//            text. Forum
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Наш форум находится по адресу:");
            embed.setDescription("<http://rci.mybb.ru>");
            embed.setColor(0xf56111);
//            send text to chat
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Prefix.PREFIX + "coriolis")) {
//            text. Coriolis
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Elite: Dangerous Shipyard:");
            embed.setDescription("<http://coriolis.io>");
            embed.setColor(0xf56111);
//            send text to chat
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Prefix.PREFIX + "eddb")) {
//            text. EDDB
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Elite: Dangerous Database - EDDB:");
            embed.setDescription("<http://eddb.io>");
            embed.setColor(0xf56111);
//            send text to chat
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        } else if (command[0].equalsIgnoreCase(Prefix.PREFIX + "inara")) {
//            text. Inara
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("INARA - Elite: Dangerous companion:");
            embed.setDescription("<http://inara.cz>");
            embed.setColor(0xf56111);
//            send text to chat
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

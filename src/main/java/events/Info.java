package events;

import main.Prefix;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Info extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(Prefix.PREFIX + "help")
                || command[0].equalsIgnoreCase(Prefix.PREFIX + "inf")
                || command[0].equalsIgnoreCase(Prefix.PREFIX + "info")) {
//            Текст сообщения в чат. Help
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Приветствую Вас,\n" +
                    " Я - спикер фракции Nagii Union");
            embed.setDescription("Список доступных команд:\n" +
                    "```\n" +
                    "!coriolis - Elite: Dangerous Shipyard\n" +
                    "!eddb - Elite: Dangerous Database\n" +
                    "!lastexp - Последняя экспансия фракции Nagii Union\n" +
                    "!expdate [название системы] - Дата проведения экспансии в систему\n" +
                    "!syscount - Колличество систем, в которых присутствует Nagii Union\n" +
                    "!forum - форум ICU\n" +
                    "!inara - Elite: Dangerous companion\n" +
                    "!online - информация о активности discord канала\n" +
                    "```");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

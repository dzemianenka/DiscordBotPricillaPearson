package events;

import main.Info;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Help extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equalsIgnoreCase(Info.PREFIX + "help")) {
            event.getChannel().sendMessage("Приветствую Вас, Я - спикер фракции Nagii Union\n" +
                    "Ниже привожу список доступных команд:\n" +
                    "**!coriolis** - Elite: Dangerous Shipyard\n" +
                    "**!eddb** - Elite: Dangerous Database\n" +
                    "**!forum** - форум ICU\n" +
                    "**!inara** - Elite: Dangerous companion\n" +
                    "**!online** - информация о активности discord канала\n").queue();
        }
    }
}

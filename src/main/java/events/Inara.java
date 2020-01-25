package events;

import main.Info;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Inara extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equalsIgnoreCase(Info.PREFIX + "inara")) {
            event.getChannel().sendMessage("http://inara.cz").queue();
        }
    }
}

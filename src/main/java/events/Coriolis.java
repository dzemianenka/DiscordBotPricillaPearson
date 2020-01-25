package events;

import main.Info;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Coriolis extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equalsIgnoreCase(Info.PREFIX + "coriolis")) {
            event.getChannel().sendMessage("http://coriolis.io").queue();
        }
    }
}

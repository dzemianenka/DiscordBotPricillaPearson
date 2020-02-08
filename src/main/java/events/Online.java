package events;

import main.Prefix;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

import static main.Helper.plurality;

public class Online extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(Prefix.PREFIX + "online")) {
            int online = 0;
//            cycle for counting online users
            for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
                if (event.getGuild().getMembers().get(i).getOnlineStatus().equals(OnlineStatus.ONLINE)
                        || event.getGuild().getMembers().get(i).getOnlineStatus().equals(OnlineStatus.DO_NOT_DISTURB)) {
                    online++;
                }
            }
//            create text string
            StringBuilder sb = new StringBuilder("Здесь ");
            sb.append(online);
            int members = event.getGuild().getMembers().size();
//            decline of online users
            switch (plurality(online)) {
                default:
                    sb.append(" online пользователей. Всего на канале ").append(members);
                    break;
                case 1:
                    sb.append(" online пользователь. Всего на канале ").append(members);
                    break;
                case 2:
                    sb.append(" online пользователя. Всего на канале ").append(members);
                    break;
            }
//            decline in the total number of users
            switch (plurality(members)) {
                default:
                    sb.append(" пользователей.");
                    break;
                case 1:
                    sb.append(" пользователь.");
                    break;
                case 2:
                    sb.append(" пользователя.");
                    break;
            }
//            text. Online
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Информация участников Discord канала:");
            embed.setDescription(sb.toString());
            embed.setColor(0xf56111);
//            send text to chat
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

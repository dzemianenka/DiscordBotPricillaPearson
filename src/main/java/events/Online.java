package events;

import main.Info;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Online extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(Info.PREFIX + "online")) {
            int online = 0;
//            Цикл для подсчета online-участников
            for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
                if (event.getGuild().getMembers().get(i).getOnlineStatus().equals(OnlineStatus.ONLINE)
                        || event.getGuild().getMembers().get(i).getOnlineStatus().equals(OnlineStatus.DO_NOT_DISTURB)) {
                    online++;
                }
            }
//            Текст сообщения
            StringBuilder sb = new StringBuilder("Здесь ");
            sb.append(online);
            int members = event.getGuild().getMembers().size();
//            Склонение online пользователей
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
//            Склонение общего числа пользователей
            switch (plurality(members)) {
                default:
                    sb.append(" пользователей.");
                    break;
                case 1:
                    sb.append(" пользователь");
                    break;
                case 2:
                    sb.append(" пользователя.");
                    break;
            }
//            Отправка сообщения
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Информация участников Discord канала:");
            embed.setDescription(sb.toString());
            embed.setColor(0xf56111);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }

    //    Склонение сущиствительных с числительными
    private static int plurality(int n) {
        n = n % 100;
        if (n == 0 || n > 10 && n < 20) return 0;
        int n1 = n % 10;
        if (n1 == 1) return 1;
        if (n1 > 1 && n1 < 5) return 2;
        return 0;
    }
}

package events;

import main.Info;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Online extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equalsIgnoreCase(Info.PREFIX + "online")) {
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
            switch (plurality(online)) {
                default:
                    sb.append(" online пользователей. Всего на канале ").append(members).append(" пользователей.");
                    break;
                case 1:
                    sb.append(" online пользователь. Всего на канале ").append(members).append(" пользователь.");
                    break;
                case 2:
                    sb.append(" online пользователя. Всего на канале ").append(members).append(" пользователя.");
                    break;
            }
//            Отправка сообщения
            event.getChannel().sendMessage(sb.toString()).queue();
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

package events;

import main.Helper;
import main.Info;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.sql.*;


public class SysCount extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        int count = 0;

        if (command[0].equalsIgnoreCase(Info.PREFIX + "syscount")) {
//            Строка запроса в БД
            String syscount = "SELECT COUNT(nagiisys.systems) FROM nagiisys";
            try {
                Connection con = new Helper().getConnectionBD();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(syscount);
                while (rs.next()) {
                    count = rs.getInt("COUNT(nagiisys.systems)");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            Склонение числа систем
            String str = count + (new Helper().plurality(count) == 1 ? " системе." : " системах.");
//            Текст сообщения в чат
            EmbedBuilder embed = new EmbedBuilder();
            embed.setDescription("Фракция **Nagii Union** присутствует в " + str);
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

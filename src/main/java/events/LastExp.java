package events;

import main.Helper;
import main.Info;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.sql.*;

public class LastExp extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ");
        String sys = "";

        if (command[0].equalsIgnoreCase(Info.PREFIX + "lastexp")) {
//            Строка запроса в БД
            String lastExp = "SELECT systems FROM nagiisys ORDER BY sys_id DESC LIMIT 1";
            try {
                Connection con = new Helper().getConnectionBD();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(lastExp);
                while (rs.next()) {
                    sys = rs.getString("systems");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            Текст сообщения в чат
            EmbedBuilder embed = new EmbedBuilder();
            embed.setDescription("Последняя экспансия фракции **Nagii Union** была в систему: **" + sys + "**");
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

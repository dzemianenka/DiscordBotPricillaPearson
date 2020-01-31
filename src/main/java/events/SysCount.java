package events;

import main.DBCon;
import main.Helper;
import main.Prefix;
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

        if (command[0].equalsIgnoreCase(Prefix.PREFIX + "syscount")) {
            try {
                Connection connection = new DBCon().getConnectionBD();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(nagiisys.systems) FROM nagiisys");
                while (resultSet.next()) {
                    count = resultSet.getInt("COUNT(nagiisys.systems)");
                }
//                Закрываем соединение с BD
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            Склонение числа систем
            String str = count + (new Helper().plurality(count) == 1 ? "** системе." : "** системах.");
//            Текст сообщения в чат
            EmbedBuilder embed = new EmbedBuilder();
            embed.setDescription("Фракция **Nagii Union** присутствует в **" + str);
            embed.setColor(0xf56111);
//            Отправка сообщения
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }
}

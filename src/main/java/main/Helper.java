package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
//    Соединение с БД
    public Connection getConnectionBD() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nagii_union?useUnicode=true&serverTimezone=UTC", "root", "12352");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
//    Склонение сущиствительных с числительными
    public int plurality(int n) {
        n = n % 100;
        if (n == 0 || n > 10 && n < 20) return 0;
        int n1 = n % 10;
        if (n1 == 1) return 1;
        if (n1 > 1 && n1 < 5) return 2;
        return 0;
    }
}

package Modul_1_3.Review_3;

import java.io.IOException;
import java.sql.SQLException;

public class test11 {
    public static void main(String[] args) {
        try {
            readFromFile();
            readFromDB();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
//            e = new SQLException("New Exception");
        }
        System.out.print("Done");
    }

    public static void readFromFile() throws IOException {
        System.out.print("Reading line ");
    }

    public static void readFromDB() throws SQLException {
        System.out.print("Read from DB ");
    }
}
/* в блоке try надо указать ошибку что мы ищем, а в catch её обрабатывать */

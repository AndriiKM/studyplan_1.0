import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Kuznetcov.An on 04.05.2017.
 */

public class MyDataBase {
    public static String message;
    String[] listTable = {"book", "link", "video"};
    private int tableName;
    private GetInfoStore inf;
    private int deleteId;


    MyDataBase(int tableName, GetInfoStore ob){
        this.tableName = tableName;
        inf = ob;
    }


    MyDataBase(int tableName){
        this.tableName=tableName;
    }

    MyDataBase(int tableName, int deleteId){
        this.tableName = tableName;
        this.deleteId = deleteId;
    }

    //соединение с базой
    private Connection getDBConnection() {
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","02122006");
        properties.setProperty("useUnicode","true");
        properties.setProperty("characterEncoding","utf8");
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка соединения");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studyplanbase?useSSL=false", properties);

            return conn;
        } catch (SQLException e) {
            System.out.println("База не обнаружена");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //метод получения времени
    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    //добаления данных в таблицу
    public void insertInTable() throws SQLException {
        Connection conn = null;
        Statement statement = null;

        String insertTableSQL = "INSERT INTO " + listTable[tableName]
                + "(name_column, info_column, link_column, date_column, status_column) " + "VALUES"
                + "('"+inf.getNameText()+"', '"+inf.getInfoText()+"', '"+inf.getLinkText()+"', '"
                + getCurrentTimeStamp()+"', '"+inf.getStatusText()+"')";

        try {
            conn = getDBConnection();
            statement = conn.createStatement();

            // выполнить SQL запрос
            statement.execute(insertTableSQL);
            message = "Данные успешно добаленны!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            message = "Ошибка добаленния!";
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    // метод чтения из базы
    public ResultSet getFromTable() {
        Connection conn = null;
        Statement statement = null;

        String selectTableSQL = "SELECT cell_id, name_column, info_column, link_column, date_column, status_column from "+listTable[tableName];

        ResultSet rs = null;
        try {
            conn = getDBConnection();
            statement = conn.createStatement();

            // выбираем данные с БД
            rs = statement.executeQuery(selectTableSQL);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка ..");
        }


        return rs;
    }

    // перезапись статуса
    public void changeStatusInCell() {
        Connection conn = null;
        Statement statement = null;

        String changestatus = "UPDATE " +listTable[tableName]+" SET status_column = '"+inf.getStatusText()+ "' WHERE cell_id = " + inf.getId();

        try {
            conn = getDBConnection();
            statement = conn.createStatement();

            // выполняем запрос delete SQL
            statement.execute(changestatus);
            message = "Статус удачно изменен!";
        } catch (SQLException e) {
            message = "Ошибка изменения статуса!";
        }

    }



    // удаление из базы
    public void deleteFromTable() {
        Connection conn = null;
        Statement statement = null;

        String deleteTableSQL = "DELETE FROM " +listTable[tableName]+ " WHERE cell_id = " + deleteId;

        try {
            conn = getDBConnection();
            statement = conn.createStatement();

            // выполняем запрос delete SQL
            statement.execute(deleteTableSQL);
            message = "Запись удалена из базы!";
        } catch (SQLException e) {
            message = "Ошибка удаления записи!";
        }

    }

    // очишение полное таблицы из базы
    public void emptyTable() {
        Connection conn = null;
        Statement statement = null;

        String deleteTableSQL = "TRUNCATE TABLE " +listTable[tableName];

        try {
            conn = getDBConnection();
            statement = conn.createStatement();

            // выполняем запрос delete SQL
            statement.execute(deleteTableSQL);
            message = "База данных очишена!";
        } catch (SQLException e) {
            message = "Ошибка удаления!";
        }

    }
}

package day3;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Day3 {

    public void getAllContacts() {

        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("M:\\private ITI\\labs\\Java_JDBC\\Day3\\src\\day3\\DBProp.properties");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day3.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            props.load(fis);
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl(props.getProperty("HOST"));
            rowSet.setUsername(props.getProperty("USER"));
            rowSet.setPassword(props.getProperty("PASS"));
            rowSet.setCommand("SELECT * FROM contacts");
            rowSet.execute();

            while (rowSet.next()) {
                System.out.println("id: " + rowSet.getInt("id"));
                System.out.println("Name: " + rowSet.getString("name"));
                System.out.println("Email: " + rowSet.getString("email"));
                System.out.println("Birthday: " + rowSet.getDate("birthday"));
                System.out.println("Profession: " + rowSet.getString("profession"));
            }

            rowSet.absolute(7);
            rowSet.setConcurrency(JdbcRowSet.CONCUR_UPDATABLE);
            rowSet.setConcurrency(JdbcRowSet.CONCUR_READ_ONLY);
            rowSet.updateString("name", "ITI - IoT");
            rowSet.updateRow();

            rowSet.setCommand("SELECT * FROM contacts");
            rowSet.execute();

            while (rowSet.next()) {
                System.out.println("id: " + rowSet.getInt("id"));
                System.out.println("Name: " + rowSet.getString("name"));
                System.out.println("Email: " + rowSet.getString("email"));
                System.out.println("Birthday: " + rowSet.getDate("birthday"));
                System.out.println("Profession: " + rowSet.getString("profession"));
            }

        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static void main(String[] args) {
        Day3 obj = new Day3();
        obj.getAllContacts();
    }

}

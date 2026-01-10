package org.thoth.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Michael
 */
public class CreateMain {

    public static void main(String[] args) throws Exception {
        String sql;
        String url 
//            = "jdbc:sqlite:example.db";
            = "jdbc:sqlite:D:/Documents/Databases/SQLite/example.db";
        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Connected to SQLite database.");
        }
        
        sql = """
            create table if not exists user (
                  id integer primary key autoincrement
                , name text unique not null
            );
            """;     
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("The gyms table created.");
        } catch (Exception e) {
            throw e;
        }     
        System.out.printf("Done!%n");
    }
}

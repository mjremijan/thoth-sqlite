package org.thoth.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Michael
 */
public class CreateMain {

    public static void main(String[] args) throws Exception {
        //String url = "jdbc:sqlite:example.db";
        String url = "jdbc:sqlite:D:/Documents/Databases/SQLite/anw.db";
        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Connected to SQLite database.");
        }
        
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT UNIQUE
            );
            """;     
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Table created.");
        } catch (Exception e) {
            throw e;
        }
        
        
        sql = """
            select * from users
            """;     
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("%s, %s, %s%n", rs.getString("id"), rs.getString("name"), rs.getString("email"));
            }
            System.out.println("Table created.");
        } catch (Exception e) {
            throw e;
        }
    }
}

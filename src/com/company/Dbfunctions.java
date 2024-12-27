package com.company;
import java.sql.*;
public class Dbfunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if(conn!=null){
                System.out.println("Connected to database");
            }
            else{
                System.out.println("Not connected to database");
            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try{
            String query = "create table " + table_name + " (id SERIAL, name VARCHAR(200), address VARCHAR(200),primary key (id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertData(Connection conn, String table_name, String name, String address) {
        Statement statement;
        try{
            String query = String.format("insert into %s (name, address) values ('%s', '%s');",table_name, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data inserted");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void readData(Connection conn, String table_name) {
        Statement statement;
        ResultSet rs= null ;
        try{
            String query = String.format("SELECT * FROM %s ",table_name);
            statement = conn.createStatement();
            rs =statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update_name(Connection conn, String table_name, String old_name, String new_name) {
        Statement statement;
        try{
            String query = String.format("update %s set name='%s' where name='%s' ",table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update_name_using_id(Connection conn, String table_name, int id, String new_name) {
        Statement statement;
        try{
            String query = String.format("update %s set name='%s' where id='%s' ",table_name, new_name, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_address(Connection conn, String table_name, String name, String new_address) {
        Statement statement;
        try{
            String query = String.format("update %s set address='%s' where name='%s' ",table_name, new_address, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update_address_using_id(Connection conn, String table_name, int id, String new_address) {
        Statement statement;
        try{
            String query = String.format("update %s set address='%s' where id='%s' ",table_name, new_address, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");

        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_Data_Using_Name(Connection conn, String table_name, String name) {
        Statement statement;
        try {
            String query = String.format("delete from %s where name='%s'", table_name, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_Data_Using_id(Connection conn, String table_name, int id) {
        Statement statement;
        try{
            String query = String.format("delete from %s where id='%s'",table_name,id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}

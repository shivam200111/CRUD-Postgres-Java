package com.company;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Dbfunctions db = new Dbfunctions();
        Connection conn = db.connect_to_db("learn1","postgres","roots");
        //db.createTable(conn,"employees1");

        //db.insertData(conn, "employees1","Rinkesh","India");

        //db.update_name(conn,"employees1","Neeraj","raj"); // For Update Name
        //db.update_name_using_id(conn,"employees1",3,"Mohit"); // For Update Name using id

        //db.update_address(conn,"employees1","Neeraj","US"); // For Update Address Using Name
        //db.update_address_using_id(conn,"employees1",3,"US"); // For Update Address Using id


        //db.delete_Data_Using_Name(conn,"employees1","Neeraj");        // For Delete From Name
        //db.delete_Data_Using_id(conn,"employees1",3);                 // For Delete From id
        db.readData(conn, "employees1");
    //write your code here

    }
}
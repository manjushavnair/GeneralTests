package com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import com.db.ValInfo;

public class Db {
    Connection con = null;
    PreparedStatement stmt = null;

    /* Store sj = null;
     public Store getRs() {
         return sj;
     }

     public void setRs(Store mk) {
         sj = mk;
     }*/
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public boolean openconnection() {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cache", "root", "akshit");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return true;
    }

    public boolean insert(Map<String, ?> params) {
        // TODO Auto-generated method stub
//		return true;
        int flag = 0;
        Set set = params.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.println("key is: " + mentry.getKey());
            //System.out.println((ValInfo)mentry.getValue());
            //  ValInfo vlf=(ValInfo)mentry.getValue();
            System.out.println("values are");
        }

        return true;
    }

    public List<String> read(List<String> key) {

        return null;
    }

    private String getString(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    private boolean next() {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean remove(Map<String, ?> params) {

        return true;


    }

    public void closeConnection() {
        // TODO Auto-generated method stub
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

package com.company;

import java.sql.*;

public class Database {
        public String DBname;
        public String DBtable;
        public String DBcolumn;

        public Database(String DBname, String DBtable, String DBcolumn){
            this.DBname = DBname;
            this.DBtable = DBtable;
            this.DBcolumn = DBcolumn;
        }

        public String GetFromDB(Database DB) {
            String Result = new String();
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

                Statement statement = connection.createStatement();

                ResultSet resultset = statement.executeQuery("select * from " +getDBtable(DB));

                while (resultset.next()){
                    Result = resultset.getString("" +getDBcolumn(DB));
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return Result;
        }

    public String getDBname(Database DB) {
        return DBname;
    }

    public String getDBtable(Database DB) {
        return DBtable;
    }

    public String getDBcolumn(Database DB) {
        return DBcolumn;
    }
}

package com.company;

import java.sql.*;

public class Database {
        String query;
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
                connection.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return Result;

        }
        public void UpdateDB(Database DB, String a) {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

                Statement statement = connection.createStatement();

                query = "update " +getDBtable(DB) + " set " +getDBcolumn(DB) + "= '" +a + "';";
                PreparedStatement preparedStmt = connection.prepareStatement(query);

                preparedStmt.executeUpdate();

                connection.close();


            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return;
        }

        public void AddColumnDB(Database DB, String NomeAttr) {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +DBname, "root", "ciccio00");

                Statement statement = connection.createStatement();

                query = "alter table " +getDBtable(DB) + " add " +NomeAttr + " varchar(2000);";
                PreparedStatement preparedStmt = connection.prepareStatement(query);

                preparedStmt.executeUpdate();

                connection.close();


            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return;
        }

         public void AddTableDB(Database DB, String NomeCittà) {
             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +DBname, "root", "ciccio00");

                 Statement statement = connection.createStatement();

                 query = "create table " +NomeCittà + " (GenDescript varchar(1000));";
                 PreparedStatement preparedStmt = connection.prepareStatement(query);


                 preparedStmt.executeUpdate();

                 connection.close();


             }catch (SQLException throwables) {
                 throwables.printStackTrace();
             }

             return;
        }
    public void CancColumnDB(Database DB) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            query = "alter table " +getDBtable(DB) + " drop column " +getDBcolumn(DB) + ";";
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.executeUpdate();

            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return;
    }
    public void CancTableDB(Database DB) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            query = "drop table " +getDBtable(DB) + ";";
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.executeUpdate();

            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return;
    }
    public String [] GetDBColumns(Database DB) {
        String [] tmp = new String[1];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select * from " +getDBtable(DB));

            ResultSetMetaData rsMetaData = resultset.getMetaData();
            int count = rsMetaData.getColumnCount();
            tmp = new String[count - 1];

            for(int i = 2; i<=count; i++) {
                tmp [i - 2] = rsMetaData.getColumnName(i);
            }
            connection.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tmp;
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

    public void setDBname(String DBname) {
        this.DBname = DBname;
    }

    public void setDBtable(String DBtable) {
        this.DBtable = DBtable;
    }

    public void setDBcolumn(String DBcolumn) {
        this.DBcolumn = DBcolumn;
    }
}

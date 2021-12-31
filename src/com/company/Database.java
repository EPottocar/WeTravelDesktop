package com.company;

import com.company.GUI.LOGIN;

import java.sql.*;
import java.util.ArrayList;

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
            DB.SetActiveDB(DB);
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
            DB.SetActiveDB(DB);
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
            DB.SetActiveDB(DB);
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +DBname, "root", "ciccio00");

                Statement statement = connection.createStatement();
                if (DB.getDBname(DB).equals("Commenti")){
                    query = "alter table " +getDBtable(DB) + " add " +NomeAttr + " varchar(500);";
                }
                else{
                    query = "alter table " +getDBtable(DB) + " add " +NomeAttr + " varchar(2000);";
                }
                PreparedStatement preparedStmt = connection.prepareStatement(query);

                preparedStmt.executeUpdate();

                connection.close();


            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return;
        }

         public void AddTableDB(Database DB, String NomeCittà) {
             DB.SetActiveDB(DB);
             try {
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +DBname, "root", "ciccio00");

                 Statement statement = connection.createStatement();
                 if (DB.getDBname(DB).equals("Commenti")){
                     query = "create table " +NomeCittà + " (Utenti varchar(20));";
                 }
                 else{
                     query = "create table " +NomeCittà + " (GenDescript varchar(1000));";
                 }
                 PreparedStatement preparedStmt = connection.prepareStatement(query);


                 preparedStmt.executeUpdate();

                 connection.close();


             }catch (SQLException throwables) {
                 throwables.printStackTrace();
             }

             return;
        }
    public void CancColumnDB(Database DB) {
        DB.SetActiveDB(DB);

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
        DB.SetActiveDB(DB);
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
        DB.SetActiveDB(DB);
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

    public void InsertUtenteDB(Database DB, String a) {
        DB.SetActiveDB(DB);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            query = "insert into " +getDBtable(DB) + "(" +getDBcolumn(DB) + ") " + "values ('" +a + "')" + ";";

            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.executeUpdate();

            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return;
    }

    public void SetActiveDB(Database DB){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            query = "use " +getDBname(DB) + ";";

            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.executeUpdate();

            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return;
    }
    public void UpdateCommentDB(Database DB, String a) {
        DB.SetActiveDB(DB);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            query = "update " +getDBtable(DB) + " set " +getDBcolumn(DB) + "= '" +a + "' " + "where Utenti = '" + LOGIN.Utente + "';";
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.executeUpdate();

            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return;
    }

    public ArrayList<String> GetCommentFromDB(Database DB) {
        DB.SetActiveDB(DB);
        ArrayList<String> Commenti = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select " +getDBcolumn(DB) + " from " +getDBtable(DB) + ";");

            while (resultset.next()) {
                Commenti.add(resultset.getString("" +getDBcolumn(DB)));
            }
            connection.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Commenti;

    }
    public boolean CheckUtenteDB(String Utente,Database DB){
        DB.SetActiveDB(DB);
        ArrayList<String> Utenti = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select " +getDBcolumn(DB) + " from " +getDBtable(DB) + ";");

            while (resultset.next()) {
                Utenti.add(resultset.getString("" +getDBcolumn(DB)));
            }
            connection.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for(String a : Utenti){
            if (a.equals(Utente)){
                return true;
            }
        }
        return false;
    }

    public boolean CheckPasswordDB(String Password,Database DB){
        DB.SetActiveDB(DB);
        String Result = new String();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +getDBname(DB), "root", "ciccio00");

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select " +getDBcolumn(DB) + " from " +getDBtable(DB) + " where Utenti =" + "'" +LOGIN.Utente + "';");
            while (resultset.next()){
                Result = resultset.getString("" +getDBcolumn(DB));
            }
            connection.close();
            if (Result.equals(Password)){
                return true;
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
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
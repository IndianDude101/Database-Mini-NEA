package DatabaseConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {
    private Connection conn = null;

    public static void main(String args[])
    {
        DatabaseConnect conn = new DatabaseConnect();
        if (conn != null)
        {
            conn.close();
        }
    }

    public DatabaseConnect()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");//Specify the SQLite Java driver
            conn = DriverManager.getConnection("jdbc:sqlite:AQA movie.db");//Specify the database, since relative in the main project folder
            conn.setAutoCommit(false);// Important as you want control of when data is written
            System.out.println("Opened database successfully");
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void close() 
    {
        try
        {
            conn.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(String tblName, Pairs<String, String>... pairs)
    {
        Statement stmt;

        try
        {
            stmt = conn.createStatement();
            String fields, values;
            fields = values = "";

            for(Pairs<String, String> p : pairs){
                fields += p.getKey() + ",";
                values += p.getValue() + ",";
            }

            String sql = String.format("INSERT INTO %s (%s) VALUES(%s);", tblName, fields.substring(0, fields.length() - 1), values.substring(0, values.length() - 1));

            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();



        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public ArrayList<ArrayList<String>> select(String tables, String fields, String conditions){
        Statement stmt;
        ResultSet rs;

        try{
            stmt = conn.createStatement();
            System.out.println(String.format("SELECT %s FROM %s WHERE %s;", fields, tables, conditions));
            rs = stmt.executeQuery(String.format("SELECT %s FROM %s WHERE %s;", fields, tables, conditions));

            // Add Later


            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            ArrayList<ArrayList<String>> results = new ArrayList<>(columnCount);
            while (rs.next()) {
                int i = 1;
                ArrayList<String> row = new ArrayList();
                while (i <= columnCount) {

                    row.add(rs.getString(i++));
                }
                results.add(row);
            }

            rs.close();
            stmt.close();
            return results;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

    }
    
    public boolean update()
    {
        boolean bUpdate = false;
        Statement stmt = null;

        try
        {
            stmt = conn.createStatement();
            String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            bUpdate = true;
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return bUpdate;
    }
}

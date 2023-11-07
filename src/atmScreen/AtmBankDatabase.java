package atmScreen;
//This class has the JDBC connection part


import java.sql.*;
//Database connection
public class AtmBankDatabase {
    public Connection con=null;
    Statement st=null;

    public AtmBankDatabase() {
        try{
            //Registering the mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountDB","root","");
            st=con.createStatement();
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    }



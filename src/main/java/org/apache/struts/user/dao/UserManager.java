package org.apache.struts.user.dao;

import java.sql.Connection;
import org.apache.struts.user.model.User;

import java.sql.*;

public class UserManager {
    public static Connection getConnection() {
        Connection con = null;
        String db = "jsp";
        String user = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.cj.jdbc.Driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, user, "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }

        return con;
    }

    public static int createUser(String firstName, String lastName, String email, String password, int type) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "insert into user(first_name, last_name, email, password, type) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setInt(5, type);
        int i = ps.executeUpdate();

        return i;
    }

    public static User read(int id, boolean all) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        while (rs.next()) {
            user.setEmail(rs.getString("email"));
        }

        return user;
        
    }

    public static User read(String col, String val) throws SQLException{
        Connection con = UserManager.getConnection();
        String sql = "select * from user where " + col + " = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, val);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        while (rs.next()) {
            user.setEmail(rs.getString("email"));
        }

        return user; 
    }


    public static boolean emailExists(String email) throws SQLException {
        User user = UserManager.read("email", email);
        if (user==null)
            return false;
        return true;
    }

    public static boolean login(String email, String password) throws SQLException {
        User user = UserManager.read("email", email);
        if (user.getPassword() == password) 
            return true;
        return false;
    }

    public static User search(String col, String val) throws SQLException {
        User user = UserManager.read(col, val);
        return user;
    }
}

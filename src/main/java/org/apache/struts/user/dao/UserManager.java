package org.apache.struts.user.dao;

import java.sql.Connection;
import java.sql.*;

import org.apache.struts.user.model.User;

public class UserManager {
    public static Connection getConnection() {
        Connection con = null;
        String db = "jsp";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver"); // com.mysql.cj.jdbc.Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, user, "");
        }
        catch(SQLException e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }

        return con;
    }

    public static int createUser(String firstName, String lastName, String email, String password, int type) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "insert into user(firstName, lastName, email, password, type) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setInt(5, type);
        int i = ps.executeUpdate();

        return i;
    }

    public static boolean emailExists(String email) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "select id from user where email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            return true;
        }

        return false;
    }

    public static boolean login(String email, String password) throws SQLException {
        Connection con = UserManager.getConnection();
        String sql = "select * from user where email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String dbpassword = rs.getString("password");
            if (password == dbpassword)
                return true;
        }

        return false;
    }
}

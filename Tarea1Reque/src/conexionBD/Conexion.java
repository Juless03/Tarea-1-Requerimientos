/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
/**
 *
 * @author Juley
 */
public class Conexion {
    
    //Conexión con la base de datos
    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "rootroot";
    private static final String url = "jdbc:mysql://localhost:3306/tarea1requerimientos";

    public static Connection conector() throws SQLException {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos");
        }
        return con;
    }

    public static int personId(String pCorreo) throws SQLException {
        Connection con = conector();
        CallableStatement stmt = con.prepareCall("{?= call getPersonId(?)}");
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setString(2, pCorreo);
        stmt.execute();
        int Resultado = stmt.getInt(1);
        return Resultado;
    }

    public static String personMail(String pCorreo) throws SQLException {
        Connection con = conector();
        CallableStatement stmt = con.prepareCall("{?= call getUserEmail(?)}");
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setString(2, pCorreo);
        stmt.execute();
        String Resultado = stmt.getString(1);
        return Resultado;
    }
    
    public static String personPassword(String pContrasenna) throws SQLException {
        Connection con = conector();
        CallableStatement stmt = con.prepareCall("{?= call getPersonPassword(?)}");
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setString(2, pContrasenna);
        stmt.execute();
        String Resultado = stmt.getString(1);
        return Resultado;
    }
    
      public static boolean addUser(String pCorreo, String pContra, String ptipo) throws SQLException, ParseException {

        Connection con = conector();
        CallableStatement stmt = con.prepareCall("{ call add_user(?,?,?) }");
        stmt.setString(1, pCorreo);
        stmt.setString(2, pContra);
        stmt.setString(3, ptipo);
        stmt.execute();
        return true;
    }
}

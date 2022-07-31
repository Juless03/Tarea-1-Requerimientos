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
import oracle.jdbc.OracleTypes;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
/**
 *
 * @author Juley
 */
public class Conexion {

    
    
    // Nueva conexión msql
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/mtec";
    /*
      public static Connection conectorBaseNueva() throws SQLException {
        
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
        }
    */
     public static Connection  conectorBaseNueva() throws SQLException {
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar a la base de datos");
        }
        return con;
      }  
}
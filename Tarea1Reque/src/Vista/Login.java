/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import conexionBD.Conexion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Dares
 */
public class Login extends javax.swing.JDialog {

    private Conexion Conexion = new Conexion();
    public String Correo;
    public String Contraseña;
    int contador = 0;
    ArrayList<String> arregloCorreos = new ArrayList<String>(); 
    ArrayList<String> arregloContrasennas = new ArrayList<String>(); 
        
    String archivo = "datospersonas.txt";
   
    
    
    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        panel2.setVisible(false);
        
        
    }

    public Login(crearcuenta aThis, boolean modal, Conexion inicrearcuenta) {
        super(aThis, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        panel2.setVisible(false);
    }

    private void cleanCorreo() {
        if (correoTexto.getText().equals("Correo Electrónico")) {
            correoTexto.setText("");
        }
        //incorrectUsername.setVisible(false);
        //incorrectPassword.setVisible(false);
    }

    private void resetCorreo() {
        if (correoTexto.getText().isEmpty()) {
            correoTexto.setText("Correo Electrónico");
        }
    }

    private void cleanPassword() {
        if (String.valueOf(passwordTexto.getPassword()).equals("Contraseña")) {
            passwordTexto.setText("");
            passwordTexto.setEchoChar('*');
            verContraseña.setVisible(true);
        }
    }

    private void resetPassword() {
        if (String.valueOf(passwordTexto.getPassword()).isEmpty()) {
            passwordTexto.setEchoChar((char) 0);
            passwordTexto.setText("Contraseña");
            verContraseña.setVisible(false);
        }
    }
    
     public static int algoritmoBinario(ArrayList<String> arreglo, String busqueda, int izquierda, int derecha){
        // Si izquierda es mayor que derecha significa que no encontramos nada
        if (izquierda > derecha) {
            return -1;
        }
        // Calculamos las mitades...
        int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
        String elementoDelMedio = arreglo.get(indiceDelElementoDelMedio);

        // Primero vamos a comparar y luego vamos a ver si el resultado es negativo,
        // positivo o 0
        int resultadoDeLaComparacion = busqueda.compareTo(elementoDelMedio);
        // Si el resultado de la comparación es 0, significa que ambos elementos son iguales
        // y por lo tanto quiere decir que hemos encontrado la búsqueda
        if (resultadoDeLaComparacion == 0) {
            return indiceDelElementoDelMedio;
        }
        // Si no, entonces vemos si está a la izquierda o derecha
        if (resultadoDeLaComparacion < 0) {
            derecha = indiceDelElementoDelMedio - 1;
            return algoritmoBinario(arreglo, busqueda, izquierda, derecha);
        } else {
            izquierda = indiceDelElementoDelMedio + 1;
            return algoritmoBinario(arreglo, busqueda, izquierda, derecha);
        }
    }
    public static void leerArchivo(String nombreArchivo,ArrayList<String> arregloCorreos,ArrayList<String>arregloContrasennas){
        File archivo = new File(nombreArchivo);
        try{
            Scanner sc = new Scanner(archivo);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                String[] parts = data.split(",");
                String correo = parts[0];
                String contrasenna = parts[1];
                arregloCorreos.add(correo);
                arregloContrasennas.add(contrasenna);
                //System.out.println(data);
                System.out.println(arregloCorreos + " Correo");
                System.out.println(arregloContrasennas +" contraseña");
                //System.out.println("Initial ArrayList:\n" + arregloCorreos);
            }
        }catch(FileNotFoundException e){
            System.out.println("Excepcion al abrir archivo" + e);
        }   
    }  
    private void escribirArchivo(String correo, String contraseña,String nombreArchivo){
        try{
            String filePath = nombreArchivo;
            FileWriter fw = new FileWriter(filePath, true);    
            String lineToAppend = correo+","+ contraseña;    
            fw.write(lineToAppend);
            fw.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static void enviarBuscar(ArrayList<String> arregloCorreos,ArrayList<String>arregloContrasennas,String buscar,boolean aBuscar,int izquierda, int derecha){
        if(aBuscar = true){
            algoritmoBinario(arregloCorreos,buscar,izquierda,derecha);
        }else{
            algoritmoBinario(arregloContrasennas,buscar,izquierda,derecha);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1IniciarSesion = new javax.swing.JPanel();
        logoLogin = new javax.swing.JLabel();
        iniciarSesionTitulo = new javax.swing.JLabel();
        separadorInicioSesion = new javax.swing.JSeparator();
        correoTexto = new javax.swing.JTextField();
        botonSiguiente = new javax.swing.JButton();
        tituloLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        logoLogin1 = new javax.swing.JLabel();
        iniciarSesionTitulo1 = new javax.swing.JLabel();
        separadorInicioSesion1 = new javax.swing.JSeparator();
        botonSiguiente1 = new javax.swing.JButton();
        tituloLogo1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        passwordTexto = new javax.swing.JPasswordField();
        botonRegresar = new javax.swing.JButton();
        verContraseña = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1IniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        panel1IniciarSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panel1IniciarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel1IniciarSesion.add(logoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        iniciarSesionTitulo.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        iniciarSesionTitulo.setText("Iniciar sesión");
        panel1IniciarSesion.add(iniciarSesionTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 295, -1));

        separadorInicioSesion.setForeground(new java.awt.Color(0, 5, 249));
        separadorInicioSesion.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        separadorInicioSesion.setMinimumSize(new java.awt.Dimension(40, 40));
        panel1IniciarSesion.add(separadorInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 410, 10));

        correoTexto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        correoTexto.setForeground(new java.awt.Color(102, 102, 102));
        correoTexto.setText("Correo Electrónico");
        correoTexto.setBorder(null);
        correoTexto.setName("Place"); // NOI18N
        correoTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoTextoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                correoTextoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                correoTextoMouseExited(evt);
            }
        });
        correoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoTextoActionPerformed(evt);
            }
        });
        correoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                correoTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoTextoKeyTyped(evt);
            }
        });
        panel1IniciarSesion.add(correoTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 401, 30));

        botonSiguiente.setBackground(new java.awt.Color(0, 5, 249));
        botonSiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        botonSiguiente.setText("Siguiente");
        botonSiguiente.setToolTipText("");
        botonSiguiente.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue));
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        panel1IniciarSesion.add(botonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 129, 33));

        tituloLogo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        tituloLogo.setForeground(new java.awt.Color(102, 102, 255));
        tituloLogo.setText("NBJ Corporation");
        panel1IniciarSesion.add(tituloLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, 40));
        panel1IniciarSesion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("¿No tiene una cuenta?");
        panel1IniciarSesion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Cree una.");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel1IniciarSesion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 130, 20));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel2.add(logoLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        iniciarSesionTitulo1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        iniciarSesionTitulo1.setText("Escribir contraseña");
        panel2.add(iniciarSesionTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 295, -1));

        separadorInicioSesion1.setForeground(new java.awt.Color(0, 5, 249));
        separadorInicioSesion1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        separadorInicioSesion1.setMinimumSize(new java.awt.Dimension(40, 40));
        panel2.add(separadorInicioSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 410, 10));

        botonSiguiente1.setBackground(new java.awt.Color(0, 5, 249));
        botonSiguiente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSiguiente1.setForeground(new java.awt.Color(255, 255, 255));
        botonSiguiente1.setText("Iniciar sesión");
        botonSiguiente1.setToolTipText("");
        botonSiguiente1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue));
        botonSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguiente1ActionPerformed(evt);
            }
        });
        panel2.add(botonSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 129, 33));

        tituloLogo1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        tituloLogo1.setForeground(new java.awt.Color(102, 102, 255));
        tituloLogo1.setText("NBJ Corporation");
        panel2.add(tituloLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, 40));
        panel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setEnabled(false);
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 230, 30));

        passwordTexto.setText("Contraseña");
        passwordTexto.setBorder(null);
        passwordTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordTextoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordTextoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordTextoMouseExited(evt);
            }
        });
        passwordTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextoActionPerformed(evt);
            }
        });
        passwordTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextoKeyPressed(evt);
            }
        });
        panel2.add(passwordTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 401, 43));

        botonRegresar.setText("←");
        botonRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 5, 249)));
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonRegresar.setFocusCycleRoot(true);
        botonRegresar.setFocusTraversalPolicyProvider(true);
        botonRegresar.setOpaque(true);
        botonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonRegresarMouseEntered(evt);
            }
        });
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        panel2.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 40, 30));

        verContraseña.setContentAreaFilled(false);
        verContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verContraseñaMouseClicked(evt);
            }
        });
        verContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                verContraseñaKeyPressed(evt);
            }
        });
        panel2.add(verContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel2.setText("Mostrar Contraseña");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(panel1IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void correoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoTextoActionPerformed

    
    
    private void correoTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoTextoMouseClicked
        cleanCorreo();
    }//GEN-LAST:event_correoTextoMouseClicked

    private void correoTextoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoTextoMouseExited
        resetCorreo();        // TODO add your handling code here:
    }//GEN-LAST:event_correoTextoMouseExited

    private void correoTextoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoTextoMouseEntered
        cleanCorreo();
    }//GEN-LAST:event_correoTextoMouseEntered

    private void correoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoTextoKeyPressed
        cleanCorreo();    // TODO add your handling code here:
    }//GEN-LAST:event_correoTextoKeyPressed

    private void correoTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoTextoKeyTyped

    }//GEN-LAST:event_correoTextoKeyTyped

    private void correoTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoTextoKeyReleased
       
    }//GEN-LAST:event_correoTextoKeyReleased

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed

        if(!correoTexto.getText().isEmpty()) {
            leerArchivo(archivo,arregloCorreos,arregloContrasennas);
                Correo = correoTexto.getText();
                int validandoCorreo;
                validandoCorreo = algoritmoBinario(arregloCorreos,Correo,0,contador);
                if(validandoCorreo != 0){
                    JOptionPane.showMessageDialog(null, "Error\nEl correo no se encuentra en el sistema. Intente de nuevo");
                } else {
                    JOptionPane.showMessageDialog(null,"Correo ingresado satisfactoriamente");
                    panel2.setVisible(true);
                    panel1IniciarSesion.setVisible(false);
                    jLabel1.setText(correoTexto.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error\nCampo vacío.");
            }    
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguiente1ActionPerformed
          if(!passwordTexto.getText().isEmpty()) {
            String ContraseñaIngresada;
            ContraseñaIngresada = String.valueOf(passwordTexto.getPassword());
            
            int validandoContraseña;
            validandoContraseña = algoritmoBinario(arregloContrasennas,ContraseñaIngresada,0,contador);
              if(validandoContraseña != 0){
                JOptionPane.showMessageDialog(null, "Error\nContraseña incorrecta.");
                } else {
                    JOptionPane.showMessageDialog(null,"Inició sesión con éxito.");
                    this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error\nCampo vacío.");
        }
    }//GEN-LAST:event_botonSiguiente1ActionPerformed
        
    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        panel1IniciarSesion.setVisible(true);
        panel2.setVisible(false);
        
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegresarMouseEntered
         botonRegresar.setFocusPainted(rootPaneCheckingEnabled);
    }//GEN-LAST:event_botonRegresarMouseEntered

    private void passwordTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseClicked
          cleanPassword();
    }//GEN-LAST:event_passwordTextoMouseClicked

    private void passwordTextoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseEntered
       cleanPassword();
    }//GEN-LAST:event_passwordTextoMouseEntered

    private void passwordTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextoKeyPressed
       cleanPassword();
    }//GEN-LAST:event_passwordTextoKeyPressed

    private void passwordTextoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseExited
       resetPassword();
    }//GEN-LAST:event_passwordTextoMouseExited

    private void verContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verContraseñaKeyPressed
       
    }//GEN-LAST:event_verContraseñaKeyPressed

    private void passwordTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextoActionPerformed

    private void verContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verContraseñaMouseClicked
       if(verContraseña.isSelected()){
              passwordTexto.setEchoChar((char)0);
          }
          else{
              passwordTexto.setEchoChar('*');
          }
    }//GEN-LAST:event_verContraseñaMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

       crearcuenta initcrearcuenta = new crearcuenta(this,true,Conexion);
       initcrearcuenta.setVisible(true);
       
    }//GEN-LAST:event_jLabel4MouseClicked
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = null;
                try {
                    dialog = new Login(new javax.swing.JFrame(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonSiguiente1;
    private javax.swing.JTextField correoTexto;
    private javax.swing.JLabel iniciarSesionTitulo;
    private javax.swing.JLabel iniciarSesionTitulo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logoLogin;
    private javax.swing.JLabel logoLogin1;
    private javax.swing.JPanel panel1IniciarSesion;
    private javax.swing.JPanel panel2;
    private javax.swing.JPasswordField passwordTexto;
    private javax.swing.JSeparator separadorInicioSesion;
    private javax.swing.JSeparator separadorInicioSesion1;
    private javax.swing.JLabel tituloLogo;
    private javax.swing.JLabel tituloLogo1;
    private javax.swing.JRadioButton verContraseña;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import conexionBD.Conexion;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author Dares
 */
public class crearcuenta extends javax.swing.JDialog {


    private Conexion inicrearcuenta;
    public String Correo;
    public String Contraseña;

    /**
     * Creates new form crearcuenta
     */
    public crearcuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    public crearcuenta(Login aThis, boolean modal, Conexion Conexion) {
        super(aThis, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        panel2.setVisible(false);      
        inicrearcuenta = Conexion;
    }
    
    private void cleanCorreo() {
        if (correoelectronicoTexto.getText().equals("Correo Electrónico")) {
            correoelectronicoTexto.setText("");
        }
        //incorrectUsername.setVisible(false);
        //incorrectPassword.setVisible(false);
    }

    private void resetCorreo() {
        if (correoelectronicoTexto.getText().isEmpty()) {
            correoelectronicoTexto.setText("Correo Electrónico");
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
      private void escribirArchivo(String correo, String contraseña,String nombreArchivo){
        try{
            String filePath = nombreArchivo;
            FileWriter fw = new FileWriter(filePath, true);    
            String lineToAppend = "\n" + correo+","+ contraseña;    
            fw.write(lineToAppend);
            fw.close();
        }
        catch(IOException e){
            System.out.println(e);
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

        panel3 = new javax.swing.JPanel();
        crearCuentaTitulo = new javax.swing.JLabel();
        separadorInicioSesion2 = new javax.swing.JSeparator();
        botonRegistrar = new javax.swing.JButton();
        tituloLogo2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        correoelectronicoTexto = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearCuentaTitulo.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        crearCuentaTitulo.setText("Crear cuenta");
        panel3.add(crearCuentaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, -1));

        separadorInicioSesion2.setForeground(new java.awt.Color(0, 5, 249));
        separadorInicioSesion2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        separadorInicioSesion2.setMinimumSize(new java.awt.Dimension(40, 40));
        panel3.add(separadorInicioSesion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 340, 20));

        botonRegistrar.setBackground(new java.awt.Color(0, 5, 249));
        botonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("Siguiente");
        botonRegistrar.setToolTipText("");
        botonRegistrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue));
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        panel3.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 129, 33));

        tituloLogo2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        tituloLogo2.setForeground(new java.awt.Color(102, 102, 255));
        tituloLogo2.setText("NBJ Corporation");
        panel3.add(tituloLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 40));
        panel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setEnabled(false);
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);
        panel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 230, 30));

        correoelectronicoTexto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        correoelectronicoTexto.setForeground(new java.awt.Color(102, 102, 102));
        correoelectronicoTexto.setText("Correo Electrónico");
        correoelectronicoTexto.setBorder(null);
        correoelectronicoTexto.setName("Place"); // NOI18N
        correoelectronicoTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoelectronicoTextoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                correoelectronicoTextoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                correoelectronicoTextoMouseExited(evt);
            }
        });
        correoelectronicoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoelectronicoTextoActionPerformed(evt);
            }
        });
        correoelectronicoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                correoelectronicoTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoelectronicoTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoelectronicoTextoKeyTyped(evt);
            }
        });
        panel3.add(correoelectronicoTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 340, 43));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarSesionTitulo1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        iniciarSesionTitulo1.setText("Creación de una contraseña");
        panel2.add(iniciarSesionTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 370, -1));

        separadorInicioSesion1.setForeground(new java.awt.Color(0, 5, 249));
        separadorInicioSesion1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        separadorInicioSesion1.setMinimumSize(new java.awt.Dimension(40, 40));
        panel2.add(separadorInicioSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 390, 10));

        botonSiguiente1.setBackground(new java.awt.Color(0, 5, 249));
        botonSiguiente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSiguiente1.setForeground(new java.awt.Color(255, 255, 255));
        botonSiguiente1.setText("Registrar");
        botonSiguiente1.setToolTipText("");
        botonSiguiente1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue));
        botonSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguiente1ActionPerformed(evt);
            }
        });
        panel2.add(botonSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 129, 33));

        tituloLogo1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        tituloLogo1.setForeground(new java.awt.Color(102, 102, 255));
        tituloLogo1.setText("NBJ Corporation");
        panel2.add(tituloLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, 40));
        panel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setEnabled(false);
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 230, 30));

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
        panel2.add(passwordTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 401, 43));

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
        panel2.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 40, 30));

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
        panel2.add(verContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel2.setText("Mostrar Contraseña");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Es necesario escribir la contraseña que se quiera utilizar con la cuenta");
        panel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 390, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        if(!correoelectronicoTexto.getText().isEmpty()) {
                boolean validandoEmail = false;
                Correo = correoelectronicoTexto.getText().toLowerCase();
                Pattern pattern = Pattern.compile("^[_a-z-A-Z0-9-]+(\\.[_a-z0-9-]+)*@" + 
                    "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
                Matcher mather = pattern.matcher(Correo);
                if (mather.find()) {
                    validandoEmail = true;
                    panel3.setVisible(false);
                    panel2.setVisible(true);
                    jLabel1.setText(Correo);
                } else {
                    JOptionPane.showMessageDialog(null,"El email ingresado es inválido."); 
                    validandoEmail = false;
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Error\nCampo vacío.");
            }
        
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void correoelectronicoTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoelectronicoTextoMouseClicked
        cleanCorreo();
    }//GEN-LAST:event_correoelectronicoTextoMouseClicked

    private void correoelectronicoTextoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoelectronicoTextoMouseEntered
        cleanCorreo();
    }//GEN-LAST:event_correoelectronicoTextoMouseEntered

    private void correoelectronicoTextoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoelectronicoTextoMouseExited
        resetCorreo();
    }//GEN-LAST:event_correoelectronicoTextoMouseExited

    private void correoelectronicoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoelectronicoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoelectronicoTextoActionPerformed

    private void correoelectronicoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoelectronicoTextoKeyPressed
        cleanCorreo();        // TODO add your handling code here:
    }//GEN-LAST:event_correoelectronicoTextoKeyPressed

    private void correoelectronicoTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoelectronicoTextoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_correoelectronicoTextoKeyReleased

    private void correoelectronicoTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoelectronicoTextoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_correoelectronicoTextoKeyTyped

    private void botonSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguiente1ActionPerformed
        boolean validandocontraseña = false;
        boolean validandoRegistro = false;
        if(!passwordTexto.getText().isEmpty()) {
            
            Contraseña = String.valueOf(passwordTexto.getPassword()).toLowerCase();
            if(Contraseña == null) {
                JOptionPane.showMessageDialog(null, "Error\nCampo contrasena está vacio");
            } else {
                validandocontraseña = true;
            }
        }
        if(validandocontraseña){
            escribirArchivo(Correo, Contraseña,"datospersonas.txt");
                JOptionPane.showMessageDialog(null, "Registro con exito");
                this.setVisible(false);
                this.dispose();
                Login initloign = new Login(this,true,inicrearcuenta);
                initloign.setVisible(true);   
            } else {
                JOptionPane.showMessageDialog(null, "Error\nRegistro fallido");
                
            }
        
    }//GEN-LAST:event_botonSiguiente1ActionPerformed

    private void passwordTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseClicked
        cleanPassword();
    }//GEN-LAST:event_passwordTextoMouseClicked

    private void passwordTextoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseEntered
        cleanPassword();
    }//GEN-LAST:event_passwordTextoMouseEntered

    private void passwordTextoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextoMouseExited
        resetPassword();
    }//GEN-LAST:event_passwordTextoMouseExited

    private void passwordTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextoActionPerformed

    private void passwordTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextoKeyPressed
        cleanPassword();
    }//GEN-LAST:event_passwordTextoKeyPressed

    private void botonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegresarMouseEntered
        botonRegresar.setFocusPainted(rootPaneCheckingEnabled);
    }//GEN-LAST:event_botonRegresarMouseEntered

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        panel3.setVisible(true);
        panel2.setVisible(false);

    }//GEN-LAST:event_botonRegresarActionPerformed

    private void verContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verContraseñaMouseClicked
        if(verContraseña.isSelected()){
            passwordTexto.setEchoChar((char)0);
        }
        else{
            passwordTexto.setEchoChar('*');
        }
    }//GEN-LAST:event_verContraseñaMouseClicked

    private void verContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verContraseñaKeyPressed

    }//GEN-LAST:event_verContraseñaKeyPressed



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
            java.util.logging.Logger.getLogger(crearcuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crearcuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crearcuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearcuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                crearcuenta dialog = new crearcuenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonSiguiente1;
    private javax.swing.JTextField correoelectronicoTexto;
    private javax.swing.JLabel crearCuentaTitulo;
    private javax.swing.JLabel iniciarSesionTitulo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPasswordField passwordTexto;
    private javax.swing.JSeparator separadorInicioSesion1;
    private javax.swing.JSeparator separadorInicioSesion2;
    private javax.swing.JLabel tituloLogo1;
    private javax.swing.JLabel tituloLogo2;
    private javax.swing.JRadioButton verContraseña;
    // End of variables declaration//GEN-END:variables
}

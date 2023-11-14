package elecciones;

import elecciones.Elecciones;
import Clases.conectar;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Candidatos extends javax.swing.JFrame {
    private static conectar con;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3307/tienda";
    public static final String usuario = "root";
    public static final String contraseña = "";
    ButtonGroup grupoBotones; 
    private String candidatoSeleccionado;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelCandidato;
    private javax.swing.JLabel labelLista;
    public int dniVotante;
    
    
     public int convertirDNANumero(String dni) {
    try {
        return Integer.parseInt(dni);
    } catch (NumberFormatException e) {
        
        return -1; // Valor inválido
    }
}
     
    public Candidatos(int dni) {
        initComponents();
        grupoBotones = new ButtonGroup();
            grupoBotones.add(jRadioButton1);
            grupoBotones.add(jRadioButton2);
            grupoBotones.add(jRadioButton3);
            grupoBotones.add(jRadioButton4);
            grupoBotones.add(jRadioButton5);
        
            labelNombre = new javax.swing.JLabel();
            labelCandidato = new javax.swing.JLabel();
            labelLista = new javax.swing.JLabel();
            dniVotante = dni;
    }
    
    private void cargarDatosCandidato(int candidatoId) {

    try {
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
        String consulta = "SELECT ID, NOMBRE, PARTIDO, LISTA FROM presidentes WHERE ID = ?";
        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setInt(1, candidatoId);
            try {
                ResultSet resultado = preparedStatement.executeQuery(); 
                if (resultado.next()) {
                    String nombre = resultado.getString("NOMBRE");
                    String partido = resultado.getString("PARTIDO");
                    String lista = resultado.getString("LISTA");

                    // ETIQUETAS
                    labelNombre.setText("NOMBRE: " + nombre);
                    labelCandidato.setText("PARTIDO: " + partido);
                    labelLista.setText("LISTA: " + lista);
                }
            }catch (SQLException e) {
                
            }
        } catch(SQLException e){
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos desde la base de datos: " + e.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        votebotton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Elecciones 2023 - Candidatos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jRadioButton1.setText("Javier Milei");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jRadioButton2.setText("Sergio Massa");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jRadioButton3.setText("Patricia Bullrich");
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 21));

        jRadioButton4.setText("Juan Schiaretti");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        jRadioButton5.setText("Myriam Bregman");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        votebotton.setText("Votar");
        votebotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votebottonActionPerformed(evt);
            }
        });
        getContentPane().add(votebotton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 60, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Milei.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/AvanzaLibertadLogo2022 (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/massa (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 40, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Logo_Union_por_la_Patria.svg (1)_1.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 70, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/bullrich.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 40, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/800px-Juntos_por_el_Cambio (1).png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 70, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Juan-Schiaretti.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 40, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Logo_Hacemos_por_nuestro_pais.svg (1).png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 80, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/bregman.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 40, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Frente_de_Izquierda_y_de_los_Trabajadores_Logo.svg (1).png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 70, 30));

        jRadioButton6.setText("Voto en Blanco");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:

    if (jRadioButton1.isSelected()) {
        cargarDatosCandidato(1);
        } else if (jRadioButton2.isSelected()) {
            cargarDatosCandidato(2);
            } else if (jRadioButton3.isSelected()) {
                cargarDatosCandidato(3);
                } else if (jRadioButton4.isSelected()) {
                    cargarDatosCandidato(4);
                    } else if (jRadioButton5.isSelected()) {
                        cargarDatosCandidato(5);
                    } else if (jRadioButton6.isSelected()){
                        cargarDatosCandidato(6);
                    }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private String obtenerCandidatoSeleccionado() {
    
    if (jRadioButton1.isSelected()) {
        return jRadioButton1.getText();
    } else if (jRadioButton2.isSelected()) {
        return jRadioButton2.getText();
    } else if (jRadioButton3.isSelected()) {
        return jRadioButton3.getText();
    } else if (jRadioButton4.isSelected()) {
        return jRadioButton4.getText();
    } else if (jRadioButton5.isSelected()) {
        return jRadioButton5.getText();
    } else if (jRadioButton6.isSelected()) {
        return jRadioButton6.getText();
    }
    return null; 
}
    
    private void votebottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votebottonActionPerformed
        // TODO add your handling code here:
        candidatoSeleccionado = obtenerCandidatoSeleccionado();

    if (candidatoSeleccionado != null && !candidatoSeleccionado.isEmpty()) {
        
            int idCandidato = obtenerIdCandidato(candidatoSeleccionado);
            if (idCandidato > 0) {
                registrarVotoEnBaseDeDatos();

                JOptionPane.showMessageDialog(this, "Voto registrado con éxito.");

                votebotton.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró candidato.");
            }
        
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción.");
    
    }
    }//GEN-LAST:event_votebottonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private int obtenerIdCandidato(String nombreCandidato) {
    int idCandidato = -1;

    try {
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
        String sql = "SELECT ID FROM presidentes WHERE NOMBRE = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombreCandidato);

            try{
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    idCandidato = resultSet.getInt("ID");
                }
            }catch (SQLException e){
                
            }
        } catch (SQLException e){
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
    return idCandidato;
}    
    
    private void registrarVotoEnBaseDeDatos() {
        int cont = 0; 
       try{
           conectar con = new conectar();
           PreparedStatement ps = con.getConnection().prepareStatement("SELECT Votos FROM votacion WHERE candidato = ?"); 
           
           ps.setString(1, candidatoSeleccionado);

           ResultSet rs = ps.executeQuery();

        if (rs.next()) {
        cont = rs.getInt(1);
        }
       
       }catch(SQLException e){
           
    }
    try {
        conectar con = new conectar();
        String sql = "UPDATE votacion set Votos = ? where candidato = ?";
       
        PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, cont+1);
            preparedStatement.setString(2, candidatoSeleccionado);
               
            preparedStatement.executeUpdate();
           
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
    
    try{
        conectar con = new conectar();
       
        String sql1 = "UPDATE padron set Voto = ? where DNI = ?"; 
        PreparedStatement preparedStatement1 = con.getConnection().prepareStatement(sql1);
        
            preparedStatement1.setInt(1, 1);
            preparedStatement1.setInt(2, dniVotante);
            
            preparedStatement1.executeUpdate();
    
    } catch (SQLException e){
        
    }
}
    public static void main1(String args[]) {
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
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidatos(0).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JButton votebotton;
    // End of variables declaration//GEN-END:variables
}
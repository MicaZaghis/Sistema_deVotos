package elecciones;

import static elecciones.Candidatos.contraseña;
import static elecciones.Candidatos.url;
import static elecciones.Candidatos.usuario;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.time.LocalTime;
import Clases.conectar; 


public class login extends javax.swing.JFrame {
    private static boolean VotacionesCerradas = false;
    
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3307/tienda";
    private final String usuario = "root";
    private final String contraseña = "";

    public login() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        passtext = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Cerrar Mesa");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingreso");

        jLabel2.setText("Usuario");

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña");

        ButtonLogin.setText("Ingresar");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar mesa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonLogin)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usertext, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(passtext)))
                            .addComponent(jButton2))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(ButtonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
 
        String usuario = this.usertext.getText();
        String contraseña = this.passtext.getText();

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete los campos solicitados.");
            return;
        }

        String sql = "SELECT * FROM presidentes_demesa WHERE USUARIO = ? AND PASS = ?";
        String sql_cont ="UPDATE presidentes_demesa SET Acceso = 1";
        String sql_hora ="UPDATE presidentes_demesa SET AperturaReal = NOW()";
        
        try {
            Connection conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
            
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getBoolean("Acceso")){
                    JOptionPane.showMessageDialog(null, "Ya se registró un ingreso.");
                    
                }else{
                    
               try{
                    PreparedStatement preparedStatementIngreso = conexion.prepareStatement(sql_cont);
                    preparedStatementIngreso.executeUpdate();
            }catch (SQLException e){
                
            }
               try{
                    PreparedStatement preparedStatementIngreso = conexion.prepareStatement(sql_hora);
                    preparedStatementIngreso.executeUpdate();
            } catch (SQLException e){
                
            }
                
                JOptionPane.showMessageDialog(this, "Ingreso Exitoso.");
                Incidencia.MostrarIncidencia(usuario, "Se registró un ingreso");
                Elecciones elecciones = new Elecciones();
                elecciones.setVisible(true);
                this.dispose();
                }
            } else {
            String insertFallidoSQL = "INSERT INTO intentos_login (Usuario, Hora_Cierre, Acceso, AperturaReal) VALUES (?, '18:00:00', 0, NOW())";
            
            try{
                PreparedStatement preparedStatementFallido = conexion.prepareStatement(insertFallidoSQL);
                preparedStatementFallido.setString(1, usuario);
                preparedStatementFallido.executeUpdate();
            } catch (SQLException e){
                
            }
            JOptionPane.showMessageDialog(null, "Datos incorrectos.");
        }
            
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al consultar la base de datos: " + e.getMessage());
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
}     
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertextActionPerformed
    private void CerrarVotacion (){
        String sqlCierre = "UPDATE presidentes_demesa SET Hora_cierre = NOW(), Cierre_mesa = 1";
        
        try{
            Connection conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
            conexion.setAutoCommit(false);
            try{
                try{
                    PreparedStatement preparedStatementCierre = conexion.prepareStatement(sqlCierre);
                    preparedStatementCierre.executeUpdate();
                }catch(SQLException e){
                    
                }
                conexion.commit();
                
                Incidencia.MostrarIncidencia("","CIERRE DE MESA EXITOSO");
                JOptionPane.showMessageDialog(this, "Cierre de votacion exitoso.");
            
            }catch (SQLException e){
                conexion.rollback();
                JOptionPane.showMessageDialog(this, "Error en el proceso de cierre de mesa: "+ e.getMessage());
                Incidencia.MostrarIncidencia("","Error durante el cierre de mesa");
            
            } finally{
                conexion.setAutoCommit(true);
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error al cierre de votacion: "+ e.getMessage());
            Incidencia.MostrarIncidencia("", "ERROR AL CERRAR VOTACIONES");
        }
    }
    
    private void CalcularEstadisticas (){
      
        String sqlEstadisticas = "SELECT candidato, votos FROM votacion";
        String sqlTotal = "SELECT SUM(votos) as total FROM votacion";
        String user = usertext.getText();

    try{
        Connection conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
        PreparedStatement preparedStatementEstadisticas = conexion.prepareStatement(sqlEstadisticas);
        PreparedStatement preparedStatementTotal = conexion.prepareStatement(sqlTotal);

    // Obtener el total de votos
        ResultSet resultSetTotal = preparedStatementTotal.executeQuery();
        resultSetTotal.next(); 
        int totalVotos = resultSetTotal.getInt("total");

    // Obtener votos por candidato
        ResultSet resultSet = preparedStatementEstadisticas.executeQuery();
        StringBuilder estadisticas = new StringBuilder("Porcentaje de votos por candidato: \n");

    while (resultSet.next()) {
        String candidato = resultSet.getString("candidato");
        int votosRecibidos = resultSet.getInt("votos");
        double porcentaje = (double) votosRecibidos / totalVotos * 100;

        estadisticas.append(candidato)
                    .append(": ")
                    .append(votosRecibidos)
                    .append(" votos (")
                    .append(String.format("%.2f%%", porcentaje))
                    .append(")\n");
    }
    
    // Muestra los resultados en un mensaje
    JOptionPane.showMessageDialog(null, estadisticas.toString(), "Resultados de la votación", JOptionPane.INFORMATION_MESSAGE);

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error al obtener estadísticas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    Incidencia.MostrarIncidencia(user, "ERROR AL OBTENER ESTADÍSTICAS");
}
    }
    private void CerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarMesaActionPerformed
        VotacionesCerradas = true;
        
        CerrarVotacion();
        CalcularEstadisticas();
        
        String user = usertext.getText();
        Incidencia.MostrarIncidencia(user,"MUESTRA LAS ESTADISTICAS");
        System.exit(0);
    }//GEN-LAST:event_CerrarMesaActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                login ventanaLogin = new login();
                if (VotacionesCerradas) {
                ventanaLogin.CalcularEstadisticas();
                System.exit(0); 
                } else {
                ventanaLogin.setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
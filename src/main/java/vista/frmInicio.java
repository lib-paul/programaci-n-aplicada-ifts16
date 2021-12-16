package vista;

import controlador.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import modelo.*;
import vista.*;

public class frmInicio extends javax.swing.JFrame {


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Bajas = new javax.swing.JButton();
        btn_modTurno = new javax.swing.JButton();
        btn_bajaTurno = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_Altas = new javax.swing.JButton();
        btn_altaTurno = new javax.swing.JButton();
        btn_Mod = new javax.swing.JButton();
        lbl_bienvenida = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Bajas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Bajas.setText("Baja pacientes/medicos");
        btn_Bajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BajasActionPerformed(evt);
            }
        });

        btn_modTurno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_modTurno.setText("Modificacion turno");

        btn_bajaTurno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_bajaTurno.setText("Baja turnos");

        btn_cerrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_cerrar.setText("Cerrar sesion");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_Altas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Altas.setText("Alta pacientes/medicos");
        btn_Altas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AltasActionPerformed(evt);
            }
        });

        btn_altaTurno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_altaTurno.setText("Turnos disponibles");
        btn_altaTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_altaTurnoActionPerformed(evt);
            }
        });

        btn_Mod.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Mod.setText("Mod pacientes/medicos");
        btn_Mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModActionPerformed(evt);
            }
        });

        lbl_bienvenida.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_bienvenida.setText("Bienvenid@");

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_usuario.setText("Usuario");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Bajas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Altas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_altaTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                            .addComponent(btn_bajaTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_altaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btn_modTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_bajaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_Altas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Mod, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Bajas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1046, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void iniciar(){
        this.setVisible(true);
    }
    private void btn_AltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AltasActionPerformed

        this.setVisible(false);
        formAlta form = new formAlta();
        form.setVisible(true);
        /* Creación de objetos */
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        /* CONSULTAS a la BDD */
        Consultas consultas = new Consultas();
        /* ALTAS */
        ctrlAltas controladorAlta = new ctrlAltas(medico, paciente, form, consultas);
        controladorAlta.iniciar();
    }//GEN-LAST:event_btn_AltasActionPerformed

    private void btn_ModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModActionPerformed
        this.setVisible(false);
        formMod form = new formMod();
        form.setVisible(true);
        /* Creación de objetos */
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        /* CONSULTAS a la BDD */
        Consultas consultas = new Consultas();
        /* MODIFICACIONES */
        ctrlMod controladorMod = new ctrlMod(medico, paciente, form, consultas);
        controladorMod.iniciar();
    }//GEN-LAST:event_btn_ModActionPerformed
    public void setearUsuario(String usuario) {
        this.lbl_usuario.setText(usuario);
    }
    private void btn_BajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BajasActionPerformed
        this.setVisible(false);
        formBaja form = new formBaja();
        form.setVisible(true);
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        /* CONSULTAS a la BDD */
        Consultas consultas = new Consultas();
        /* BAJAS */
        ctrlBajas controladorBajas = new ctrlBajas(medico, paciente, form, consultas);
        controladorBajas.iniciar();
    }//GEN-LAST:event_btn_BajasActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_altaTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altaTurnoActionPerformed
        this.setVisible(false);
        formTurnos form = new formTurnos();
        form.setVisible(true);
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        /* CONSULTAS a la BDD */
        ConsultasTurnos consultas = new ConsultasTurnos();
        /* Inicializador de TURNOS */
        
        ctrlTurnos controladorTurnos = new ctrlTurnos(medico, paciente, form, consultas);
        try {
            controladorTurnos.iniciar();
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_altaTurnoActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Altas;
    private javax.swing.JButton btn_Bajas;
    private javax.swing.JButton btn_Mod;
    private javax.swing.JButton btn_altaTurno;
    private javax.swing.JButton btn_bajaTurno;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_modTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_bienvenida;
    private javax.swing.JLabel lbl_usuario;
    // End of variables declaration//GEN-END:variables
}

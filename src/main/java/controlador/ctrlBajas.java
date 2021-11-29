package controlador;

import java.awt.event.ActionListener;
import modelo.Consultas;
import modelo.Medico;
import modelo.Paciente;
import vista.formMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class ctrlBajas implements ActionListener {
    
    private Medico medico;
    private Paciente paciente;
    private formBaja frm;
    private Consultas consulta;

    /* Constructor */
    public ctrlBajas(Medico medico, Paciente paciente, formBaja frm, Consultas consulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.frm = frm;
        this.consulta = consulta;
        this.frm.btnVolver.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.cmbTipo.addActionListener(this);

    }

    /* Start */
    public void iniciar() {
        frm.setTitle("Bajas");
        frm.setLocationRelativeTo(null);
        System.out.println("algo");
    }

    /* Controlador BAJA */
    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {
        if ("Pacientes".equals(frm.cmbTipo.getItemAt(frm.cmbTipo.getSelectedIndex()))) {
            if (e.getSource() == frm.cmbTipo) {
                try {
                    consulta.cargarTabla(frm.tablaDatos,"Paciente");
                    System.out.println("llegue");
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlBajas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if( e.getSource() == frm.btnEliminar){
                try {
                    consulta.eliminarRegistroTabla(frm.tablaDatos, "Paciente");
                    consulta.cargarTabla(frm.tablaDatos,"Paciente");
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlBajas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if("Medicos".equals(frm.cmbTipo.getItemAt(frm.cmbTipo.getSelectedIndex()))){
            if (e.getSource() == frm.cmbTipo) {
                try {
                    consulta.cargarTabla(frm.tablaDatos,"Medico");
                    System.out.println("llegue");
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlBajas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}

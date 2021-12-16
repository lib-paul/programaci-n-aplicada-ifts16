
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;
import modelo.ConsultasTurnos;
import vista.formBajaTurnos;



public class ctrlBajaTurnos implements ActionListener {
    
    private formBajaTurnos frm;
    private ConsultasTurnos consultaTurnos;
    

    public ctrlBajaTurnos(formBajaTurnos frm, ConsultasTurnos consulta) {
        
        this.frm = frm;
        this.consultaTurnos = consulta;
        this.frm.btnEliminar.addActionListener(this);
       
    }

    public void iniciar() throws SQLException {
        frm.setTitle("Baja Turnos");
        frm.setLocationRelativeTo(null);
        consultaTurnos.cargarTablaTurnos(frm.tbTurnos);
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnEliminar){
            try {
                consultaTurnos.eliminarTurnoSeleccionado(frm.tbTurnos);
                consultaTurnos.cargarTablaTurnos(frm.tbTurnos);
            } catch (SQLException ex) {
                Logger.getLogger(ctrlBajaTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

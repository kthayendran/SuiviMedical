package Vues;

import Controlers.*;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FrmConsulter extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblConsultations;
    private JTable tblConsultations;
    private JLabel lblMedicaments;
    private JTable tblMedicaments;

    private CtrlConsultation ctrlConsultation;
    private CtrlMedicament ctrlMedicament;
    private CtrlMedecin ctrlMedecin;
    private CtrlPatient ctrlPatient;
    private ModelJTable modelJTable;

    public FrmConsulter()
    {
        this.setTitle("Consulter");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ctrlConsultation = new CtrlConsultation();
        ctrlMedecin = new CtrlMedecin();
        ctrlMedicament = new CtrlMedicament();
        ctrlPatient = new CtrlPatient();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

                modelJTable = new ModelJTable();
                try {
                    modelJTable.loadDatasConsultation(ctrlConsultation.GetAllConsultations());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                tblConsultations.setModel(modelJTable);


            }
        });
        tblConsultations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InfosMedicaments();


            }
        });


        tblMedicaments.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);




            }
        });
    }
    public void InfosMedicaments()
    {
        int numConsultation = Integer.parseInt(tblConsultations.getValueAt(tblConsultations.getSelectedRow(), 0).toString());
        modelJTable = new ModelJTable();
        modelJTable.loadDatasMedicament(ctrlMedicament.GetAllMedicamentsByIdConsultations(numConsultation));
        tblMedicaments.setModel(modelJTable);

    }
}


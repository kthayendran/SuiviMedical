package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations() throws SQLException {
        ArrayList<Consultation> lesconsultations = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("select  idConsult, dateConsult,nomPatient from consultation inner join patient on numPatient = idPatient");
            rs = ps.executeQuery();
            while (rs.next()) {
                Consultation consultation = new Consultation(rs.getInt("idConsult"), rs.getDate("dateConsult"), rs.getString("nomPatient"));
                lesconsultations.add(consultation);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
        return lesconsultations;





    }
}
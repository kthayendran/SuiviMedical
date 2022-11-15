package Entities;

import java.sql.Date;

public class Consultation
{
    private int numero;
    private String date;
    private String nomPatient;
    private String nomMedecin;
    private double montant;



    public Consultation(int unNum,String uneDate, String unNomPat, String unNomMed, double unMontant)
    {
        this.numero = unNum;
        this.date = uneDate;
        this.nomPatient = unNomPat;
        this.nomMedecin = unNomMed;
        this.montant = unMontant;
    }

    public Consultation(int idConsult, Date dateConsult, String nomPatient) {
    }

    public int getNumero() {
        return numero;
    }

    public String getDate() {
        return date;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public double getMontant() {
        return montant;
    }
}

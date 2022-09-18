package com.retispec.demo.PatientModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "Patients")
public class Patients {

    @Id
    private int Patient_ID;
    private String First_name;
    private String Last_name;
    private Date Date_of_birth;
    private String Sex;

    public Patients(int patient_ID, String first_name, String last_name, Date date_of_birth, String sex) {
        Patient_ID = patient_ID;
        First_name = first_name;
        Last_name = last_name;
        Date_of_birth = date_of_birth;
        Sex = sex;
    }

    public int getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(int patient_ID) {
        Patient_ID = patient_ID;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public Date getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "Patient_ID=" + Patient_ID +
                ", First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Date_of_birth=" + Date_of_birth +
                ", Sex='" + Sex + '\'' +
                '}';
    }
}

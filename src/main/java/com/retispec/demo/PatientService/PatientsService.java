package com.retispec.demo.PatientService;

import com.retispec.demo.PatientModel.Patients;
import com.retispec.demo.RetispecRepository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    @Autowired
    private Repository patientrepo;

    public Patients getPatientbyId(Integer id){

        return patientrepo.findById(id).orElse(null);
    }

    public Patients addPatients(Patients patients){

        return patientrepo.save(patients);
    }

    public List<Patients> getPatienyByFirstandLast(String firstname, String lastname){

        return patientrepo.findByName(firstname, lastname);
    }

    public String deletePatientById(Integer id){

        patientrepo.deleteById(id);
        String str = "The Patient is deleted ";
        return str;
    }

}

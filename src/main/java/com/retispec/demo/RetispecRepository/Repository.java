package com.retispec.demo.RetispecRepository;

import com.retispec.demo.PatientModel.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Patients, Integer> {

    public List<Patients> findByName(String firstName, String lastName);

}

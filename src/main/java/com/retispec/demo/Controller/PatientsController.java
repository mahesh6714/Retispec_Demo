package com.retispec.demo.Controller;

import com.retispec.demo.AcqusitionService.AcquisitionService;
import com.retispec.demo.PatientModel.Patients;
import com.retispec.demo.PatientService.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @Autowired
    private AcquisitionService acquisitionService;

    @GetMapping("/Patients/{id}")
    public ResponseEntity<Patients> getPatientById(@PathVariable Integer id){

        return new ResponseEntity<>(patientsService.getPatientbyId(id), HttpStatus.OK);
    }

    @PostMapping("/Patients/add")
    public ResponseEntity<Patients> addPatient(@RequestBody Patients patients){

        return new ResponseEntity<>(patientsService.addPatients(patients), HttpStatus.OK);
    }
    @GetMapping("/Patients/name/firstname/lastname")
    public ResponseEntity<List<Patients>> getPatientByFirstNameAndLastName(@RequestParam String firstname, @RequestParam String lastname){

        return new ResponseEntity<>( patientsService.getPatienyByFirstandLast(firstname, lastname), HttpStatus.OK);

    }

    @DeleteMapping("/Patients/{id}")
    public String deletePatientById(@PathVariable Integer id){

        return patientsService.deletePatientById(id);
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = acquisitionService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=acquisitionService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }



}

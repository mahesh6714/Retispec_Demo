package com.retispec.demo.AcqusitionService;

import com.retispec.demo.AcquisitionModel.Acquisitions;
import com.retispec.demo.PatientModel.Patients;
import com.retispec.demo.RetispecRepository.AcquistionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AcquisitionService {

    private static final String FOLDER_PATH = "/Users/maheshnagabhairu/Desktop/FOLDER_PATH";
    @Autowired
    private AcquistionRepository acquistionRepository;

    @Autowired
    private Acquisitions acquisitions;

    @Autowired
    private Patients patients;
    

    public List<Acquisitions> getAllAcquisitionById() {

        List<Integer> idList = Arrays.asList(patients.getPatient_ID());
        List<Acquisitions> findAll = acquistionRepository.findAllById(idList);
        findAll.forEach(System.out::println);
        return findAll;
    }

    public String deleteAcqusition(Integer Id) {

        acquistionRepository.deleteById(Id);
        String S = "The Acquisition is deleted";
        return S;
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        Acquisitions fileData = AcquistionRepository.save(Acquisitions.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {

        Optional<Acquisitions> fileData = AcquistionRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}

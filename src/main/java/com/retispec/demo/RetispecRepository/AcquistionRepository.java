package com.retispec.demo.RetispecRepository;

import com.retispec.demo.AcquisitionModel.Acquisitions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcquistionRepository extends JpaRepository<Acquisitions,Integer> {


    Optional<Acquisitions> findByName(String fileName);


}
    //List<Acquisitions> findAllById(List<Long> idList);


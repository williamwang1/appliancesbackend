package com.capgemini.test.repository;

import com.capgemini.test.domain.Appliances;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface AppliancesRepo extends CrudRepository<Appliances, Long> {

    List<Appliances> findAll();

    Optional<Appliances> findById(Long id);

    Appliances save(Appliances a);

    //Appliances update(Appliances a);

    @Query("select a from Appliances a where a.serialNumber = ?1 and a.brand = ?2 and a.model = ?3")
    List<Appliances> findBySerialNumberAndBrandAndModel(String serialNumber, String brand, String model);

//    @Query("select a from Appliances a where a.serial_number like ?1 or a.brand like ?1 or a.model like ?1")
//    List<Appliances> searchByKeyword(String keyword);


    @Query("SELECT a FROM Appliances a WHERE LOWER(a.serialNumber) LIKE LOWER(concat('%', concat(?1, '%'))) or LOWER(a.brand) LIKE LOWER(concat('%', concat(?1, '%'))) or LOWER(a.model) LIKE LOWER(concat('%', concat(?1, '%')))")
    List<Appliances> searchByKeywaord(String keyword);
//
//    List<Appliances> findBySerialNumberIgnoreCase(String serialNumber);
//
//    List<Appliances> findByBrandIgnoreCase(String brand);
//
//    List<Appliances> findByModelIgnoreCase(String model);

    @Override
    void deleteById(Long id);


}
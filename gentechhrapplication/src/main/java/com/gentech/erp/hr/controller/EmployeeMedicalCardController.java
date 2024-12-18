package com.gentech.erp.hr.controller;


import com.gentech.erp.hr.dto.EmployeeMedicalCardDto;
import com.gentech.erp.hr.service.EmployeeMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-cards")
public class EmployeeMedicalCardController {

    @Autowired
    private EmployeeMedicalCardService employeeMedicalCardService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeMedicalCardDto>> getAllEmployeeMedicalCards() {
        return ResponseEntity.ok(employeeMedicalCardService.getAllEmployeeMedicalCard());
    }

    @GetMapping("/{eCard}")
    public ResponseEntity<EmployeeMedicalCardDto> getEmployeeMedicalCardByECard(@PathVariable String eCard) throws  Exception
    {
        try {
            EmployeeMedicalCardDto medicalCard = employeeMedicalCardService.getEmployeeMedicalCardByECard(eCard);
            return ResponseEntity.ok(medicalCard);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeMedicalCardDto> createEmployeeMedicalCard(@RequestBody EmployeeMedicalCardDto employeeMedicalCard) {
        EmployeeMedicalCardDto savedEmployeeMedicalCard = employeeMedicalCardService.saveEmployeeMedicalCard(employeeMedicalCard);
        return ResponseEntity.ok(savedEmployeeMedicalCard);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeMedicalCardDto> updateByid(@RequestBody  EmployeeMedicalCardDto upd,@PathVariable 	String id) throws Exception
    {
        upd.seteCard(id);
        return new ResponseEntity<EmployeeMedicalCardDto>(employeeMedicalCardService.updateItem(upd,id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id)
    {
        employeeMedicalCardService.deleteItemById(id);
        return new ResponseEntity<String>("Item with Id "+id+" was successfully deleted",HttpStatusCode.valueOf(200));
    }
}

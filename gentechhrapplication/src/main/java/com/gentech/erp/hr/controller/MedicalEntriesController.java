package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.service.MedicalEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/api/medical-entry")
public class MedicalEntriesController {

    @Autowired
    private MedicalEntriesService medicalEntriesService;

    @PostMapping("/add")
    public ResponseEntity<String> addMedicalEntry(
            @RequestParam("dependantId") Long dependantId,
            @RequestParam("medicalFiles") MultipartFile medicalFiles,
            @RequestParam("requestAmount") Double requestAmount
    ) {

        try {
            medicalEntriesService.saveMedicalEntry(dependantId, medicalFiles, requestAmount);
            return ResponseEntity.status(HttpStatus.CREATED).body("Medical entry saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving medical entry: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntries() {
        return ResponseEntity.ok(medicalEntriesService.getAllMedicalEntries());
    }



    @GetMapping("/{medicalEntryId}")
    public ResponseEntity<MedicalEntriesDto> getMedicalEntryByMRno(@PathVariable Long medicalEntryId) throws Exception {
        MedicalEntriesDto medicalEntry = medicalEntriesService.getMedicalEntryByMRno(medicalEntryId);
        return medicalEntry != null ? ResponseEntity.ok(medicalEntry) : ResponseEntity.notFound().build();
    }


    @GetMapping("/employee/{medicalEntryId}")
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntriesByEmpId(@PathVariable Long medicalEntryId) {
        return ResponseEntity.ok(medicalEntriesService.getMedicalEntryByeEmployeeId(medicalEntryId));
    }


    @PutMapping("/add")
    public ResponseEntity<String> updateByid(
            @RequestParam Long dependantId,
            @RequestParam MultipartFile medicalFiles,
            @RequestParam Double requestAmount,
            @RequestParam("medicalEntryId") Long id
    ) {
        System.out.println("medicalEntryId: " + id + ", Dependant ID: " + dependantId + ", Request Amount: " + requestAmount);
        try {
            medicalEntriesService.updateItem(dependantId, medicalFiles, requestAmount, id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Medical entry Edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving medical entry: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{medicalEntryId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long medicalEntryId) {
        medicalEntriesService.deleteItemById(medicalEntryId);
        return new ResponseEntity<String>("Item with Id " + medicalEntryId + " was successfully deleted", HttpStatusCode.valueOf(200));
    }
}
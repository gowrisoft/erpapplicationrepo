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
@RequestMapping("/api/medical-entry")
public class MedicalEntriesController {

    @Autowired
    private MedicalEntriesService medicalEntriesService;

    @PostMapping("/add")
    public ResponseEntity<String> addMedicalEntry(
            @RequestParam("empId") Long empId,
            @RequestParam("dependantId") Long dependantId,
            @RequestParam("medicalFiles") MultipartFile medicalFiles,
            @RequestParam("requestAmount") Double requestAmount) {

        try {
            medicalEntriesService.saveMedicalEntry(empId, dependantId, medicalFiles, requestAmount);
            return ResponseEntity.status(HttpStatus.CREATED).body("Medical entry saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving medical entry: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntries() {
        return ResponseEntity.ok(medicalEntriesService.getAllMedicalEntries());
    }

    @GetMapping("/{MRno}")
    public ResponseEntity<MedicalEntriesDto> getMedicalEntryByMRno(@PathVariable Long MRno) throws Exception {
        MedicalEntriesDto medicalEntry = medicalEntriesService.getMedicalEntryByMRno(MRno);
        return medicalEntry != null ? ResponseEntity.ok(medicalEntry) : ResponseEntity.notFound().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalEntriesDto> updateByid(@RequestBody MedicalEntriesDto upd, @PathVariable Long id) throws Exception {
        upd.setMRno(id);
        return new ResponseEntity<MedicalEntriesDto>(medicalEntriesService.updateItem(upd, id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        medicalEntriesService.deleteItemById(id);
        return new ResponseEntity<String>("Item with Id " + id + " was successfully deleted", HttpStatusCode.valueOf(200));
    }
}
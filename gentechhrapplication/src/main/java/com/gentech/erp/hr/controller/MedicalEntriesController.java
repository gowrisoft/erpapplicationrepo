package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.service.MedicalEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/medical-entry")
public class MedicalEntriesController {

    @Autowired
    private MedicalEntriesService medicalEntriesService;

    @PostMapping("/add")
    public ResponseEntity<MedicalEntriesDto> addMedicalEntry(
            @RequestParam("dependantId") Long dependantId,
            @RequestParam("medicalFiles") MultipartFile medicalFiles,
            @RequestParam("requestAmount") Double requestAmount) throws IOException {
        return ResponseEntity.ok(medicalEntriesService.saveMedicalEntry(dependantId, medicalFiles, requestAmount));
    }

    @GetMapping
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntries() {
        return ResponseEntity.ok(medicalEntriesService.getAllMedicalEntries());
    }

    @GetMapping("/medicalentryid/{medicalEntryId}")
    public ResponseEntity<MedicalEntriesDto> getMedicalEntryByMRno(@PathVariable Long medicalEntryId)  {
        MedicalEntriesDto medicalEntry = medicalEntriesService.getMedicalEntryById(medicalEntryId);
        return medicalEntry != null ? ResponseEntity.ok(medicalEntry) : ResponseEntity.notFound().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntriesByEmpId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(medicalEntriesService.getMedicalEntryByeEmployeeId(employeeId));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateByid(
            @RequestParam Long dependantId,
            @RequestParam MultipartFile medicalFiles,
            @RequestParam Double requestAmount,
            @RequestParam("medicalEntryId") Long id
    ) {
        System.out.println("medicalEntryId: " + id + ", Dependant ID: " + dependantId + ", Request Amount: " + requestAmount);
        try {
            medicalEntriesService.updateMedicalEntry(dependantId, medicalFiles, requestAmount, id);
            return ResponseEntity.status(HttpStatus.OK).body("Medical entry Edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving medical entry: " + e.getMessage());
        }
    }

    @DeleteMapping("/{medicalEntryId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long medicalEntryId) {
        medicalEntriesService.deleteItemById(medicalEntryId);
        return new ResponseEntity<>("Item with Id " + medicalEntryId + " was successfully deleted", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update-status")
    public ResponseEntity<String> updateStatus(
            @RequestParam("medicalEntryId") Long id,
            @RequestParam("status") String status
    ) {
        try {
            medicalEntriesService.updateMedicalEntryStatus(id, status);
            return ResponseEntity.status(HttpStatus.OK).body("Medical entry status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating medical entry status: " + e.getMessage());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<MedicalEntriesDto>> getAllMedicalEntriesByStatus(@RequestParam String status) {
        return ResponseEntity.ok(medicalEntriesService.getAllMedicalEntryByStatus(status));
    }
}
package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.DependantDto;
import com.gentech.erp.hr.service.DependantService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DependantsController {

    @Autowired
    private DependantService depService;

    @PostMapping("/dependant")
    public ResponseEntity<DependantDto> addDependant(@RequestBody DependantDto dependant) {
        DependantDto savedDependant = depService.saveDependant(dependant);
        return ResponseEntity.ok(savedDependant);
    }

    @PostMapping("user/dependant")
    public ResponseEntity<DependantDto> addDependantByEmployee(@RequestBody DependantDto dependantDto, HttpServletRequest request) {
        dependantDto.setEmployeeId((Long) request.getAttribute("employeeId"));
        DependantDto savedDependant = depService.saveDependant(dependantDto);
        return ResponseEntity.ok(savedDependant);
    }

    @GetMapping("/dependants")
    public ResponseEntity<List<DependantDto>> getAllDependants() {
        return ResponseEntity.ok(depService.getAllDependant());
    }

    @GetMapping("/dependant/{id}")
    public ResponseEntity<DependantDto> getDependantById(@PathVariable Long id) throws Exception {
        DependantDto dependant = depService.getDependantById(id);
        if (dependant != null) {
            return ResponseEntity.ok(dependant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dependant/employee/{id}")
    public ResponseEntity<List<DependantDto>> getDependantByEmployeeId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(depService.getDependantByEmployeeId(id));
    }

    @GetMapping("user/dependant/employee")
    public ResponseEntity<List<DependantDto>> getDependantByEmployee(HttpServletRequest request) throws Exception {
        return ResponseEntity.ok(depService.getDependantByEmployeeId((Long) request.getAttribute("employeeId")));
    }

    @GetMapping("/dependant/dependant/{id}")
    public ResponseEntity<List<DependantDto>> getDependantByDependantId(@PathVariable Long id) {
        return ResponseEntity.ok(depService.getDependantByDependantId(id));
    }

    @PutMapping("/dependant/{id}")
    public ResponseEntity<DependantDto> updateByid(@RequestBody DependantDto upd, @PathVariable Long id) throws Exception {
        upd.setDependantId(id);
        return new ResponseEntity<>(depService.updateItem(upd, id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/dependant/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        depService.deleteItemById(id);
        return new ResponseEntity<>("Item with Id " + id + " was successfully deleted", HttpStatusCode.valueOf(200));
    }
}
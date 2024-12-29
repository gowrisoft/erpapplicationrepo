package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.DependantDto;
import com.gentech.erp.hr.service.DependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/v1/api/dependant")
public class DependantsController {

    @Autowired
    private DependantService depService;

    @PostMapping("/")
    public ResponseEntity<DependantDto> addDependant(@RequestBody DependantDto dependant) {
        DependantDto savedDependant = depService.saveDependant(dependant);
        return ResponseEntity.ok(savedDependant);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DependantDto>> getAllDependants() {
        return ResponseEntity.ok(depService.getAllDependant());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DependantDto> getDependantById(@PathVariable Long id) throws Exception {
        DependantDto dependant = depService.getDependantById(id);
        if (dependant != null) {
            return ResponseEntity.ok(dependant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DependantDto> updateByid(@RequestBody DependantDto upd, @PathVariable Long id) throws Exception {
        upd.setDependantId(id);
        return new ResponseEntity<DependantDto>(depService.updateItem(upd, id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        depService.deleteItemById(id);
        return new ResponseEntity<String>("Item with Id " + id + " was successfully deleted", HttpStatusCode.valueOf(200));
    }
}
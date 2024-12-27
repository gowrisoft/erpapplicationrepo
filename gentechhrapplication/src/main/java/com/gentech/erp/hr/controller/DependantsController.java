package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.DependantsDto;
import com.gentech.erp.hr.service.DependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/v1/api")
public class DependantsController {

    @Autowired
    private DependantService depService;

    @PostMapping("/dependant")
    public ResponseEntity<DependantsDto> addDependant(@RequestBody DependantsDto dependant) {
        DependantsDto savedDependant = depService.saveDependant(dependant);
        return ResponseEntity.ok(savedDependant);
    }

    @GetMapping("/dependants")
    public ResponseEntity<List<DependantsDto>> getAllDependants() {
        return ResponseEntity.ok(depService.getAllDependant());
    }

    @GetMapping("/dependant/{id}")
    public ResponseEntity<DependantsDto> getDependantById(@PathVariable Long id) throws Exception {
        DependantsDto dependant = depService.getDependantById(id);
        if (dependant != null) {
            return ResponseEntity.ok(dependant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/dependant/{id}")
    public ResponseEntity<DependantsDto> updateByid(@RequestBody DependantsDto upd, @PathVariable Long id) throws Exception {
        upd.setDependantId(id);
        return new ResponseEntity<DependantsDto>(depService.updateItem(upd, id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/dependant/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        depService.deleteItemById(id);
        return new ResponseEntity<String>("Item with Id " + id + " was successfully deleted", HttpStatusCode.valueOf(200));
    }
}
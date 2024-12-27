package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.ModifyLeaveDto;
import com.gentech.erp.hr.service.ModifyLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ModifyLeaveController {
    @Autowired
    private ModifyLeaveService modifyService;

    @PostMapping("/modifyLeave")
    public ResponseEntity<ModifyLeaveDto> addModifyLeave(@RequestBody ModifyLeaveDto modifyDto) {
        return new ResponseEntity<ModifyLeaveDto>(modifyService.addModifyLeave(modifyDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllModifiedLeaves")
    ResponseEntity<List<ModifyLeaveDto>> getAllModifiedLeaves() {
        return new ResponseEntity<List<ModifyLeaveDto>>(modifyService.getAllModifiedLeaves(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getModifyLeaveById")
    ResponseEntity<ModifyLeaveDto> getModifyLeaveById(@RequestParam int id) {
        return new ResponseEntity<ModifyLeaveDto>(modifyService.getModifyLeaveById(id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteModifyLeave")
    ResponseEntity<String> deleteModifyLeaveById(@RequestParam int id) {
        return new ResponseEntity<String>(modifyService.deleteModifyLeaveById(id), HttpStatusCode.valueOf(200));
    }
}

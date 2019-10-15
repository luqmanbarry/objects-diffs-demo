package com.hamidou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
public class EmployeeRestController {

    private ChangeLogService changeLogService;

    @Autowired
    public EmployeeRestController(ChangeLogService changeLogService) {
        this.changeLogService = changeLogService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("A Javers implementation demo program. The library allows object graph comparison", HttpStatus.OK);
    }

    @GetMapping("/compute-diffs/{employee-id}")
    public ResponseEntity<List<ChangeEntry>> computeChangeLogEntries(@PathVariable("employee-id") @Positive int employeeId) {
        return new ResponseEntity(changeLogService.computeEmployeeChanges(employeeId), HttpStatus.OK);
    }
}

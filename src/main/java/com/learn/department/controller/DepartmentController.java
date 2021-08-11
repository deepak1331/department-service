package com.learn.department.controller;

import com.learn.department.entity.Department;
import com.learn.department.exception.ResourceNotFoundException;
import com.learn.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping(method = RequestMethod.POST, path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
        return new ResponseEntity(service.saveDepartment(department), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveAll", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveDepartments(@RequestBody List<Department> departmentList) {
        return new ResponseEntity(service.saveDepartments(departmentList), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fetch/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) throws ResourceNotFoundException {

        return new ResponseEntity(service.findDepartmentById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fetchAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDepartments() throws ResourceNotFoundException {

        return new ResponseEntity(service.findAllDepartments(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fetchAll/page/{pageNo}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDepartments(@PathVariable int pageNo) throws ResourceNotFoundException {

        return new ResponseEntity(service.findAllDepartments(pageNo), HttpStatus.OK);
    }
}

package com.antoalex07.mongoDBDemo.controller;

import com.antoalex07.mongoDBDemo.entity.Department;
import com.antoalex07.mongoDBDemo.error.DepartmentNotFoundException;
import com.antoalex07.mongoDBDemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping()
    public List<Department> fetchAllDepartments(){
        LOGGER.info("Inside fetchAllDepartments of DepartmentController");
        return departmentService.fetchAllDepartments();
    }

    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department fetchDepartmentById(@PathVariable ObjectId id) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(id);
    }

    @GetMapping("/{key}")
    public Department fetchDepartmentByKey(@PathVariable Long deptKey){
        LOGGER.info("Inside fetchDepartmentByKey of DepartmentController");
        return departmentService.fetchDepartmentByKey(deptKey);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable ObjectId id){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(id);
        return "Department Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@Valid @RequestBody Department department,
                                       @PathVariable ObjectId id) throws DepartmentNotFoundException {
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(department, id);
    }

    @GetMapping("name/{name}")
    public Department fetchDepartmentByName(@PathVariable String deptName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(deptName);
    }
}

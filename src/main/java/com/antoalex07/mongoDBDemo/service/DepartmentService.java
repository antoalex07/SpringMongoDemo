package com.antoalex07.mongoDBDemo.service;

import com.antoalex07.mongoDBDemo.entity.Department;
import com.antoalex07.mongoDBDemo.error.DepartmentNotFoundException;
import org.bson.types.ObjectId;

import java.util.List;


public interface DepartmentService {
    public List<Department> fetchAllDepartments();

    public Department saveDepartment(Department department);

    public Department fetchDepartmentById(ObjectId id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(ObjectId id);

    public Department updateDepartment(Department department, ObjectId id) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String deptName);

    public Department fetchDepartmentByKey(Long deptKey);
}

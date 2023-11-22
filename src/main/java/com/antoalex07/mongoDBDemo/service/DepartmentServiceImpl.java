package com.antoalex07.mongoDBDemo.service;

import com.antoalex07.mongoDBDemo.entity.Department;
import com.antoalex07.mongoDBDemo.error.DepartmentNotFoundException;
import com.antoalex07.mongoDBDemo.repository.DepartmentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentById(ObjectId id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(ObjectId id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department, ObjectId id) throws DepartmentNotFoundException {
        Optional<Department> dept1 = departmentRepository.findById(id);

        if(dept1.isEmpty()){
            throw new DepartmentNotFoundException("Incorrect id, Department not Available");
        }

        Department dept = dept1.get();

        if(Objects.nonNull(department.getDeptName()) &&
        !"".equalsIgnoreCase(department.getDeptName())){
            dept.setDeptName(department.getDeptName());
        }

        if(Objects.nonNull(department.getDeptAddress()) &&
        !"".equalsIgnoreCase(department.getDeptAddress())){
            dept.setDeptAddress(department.getDeptAddress());
        }

        if(Objects.nonNull(department.getDeptCode()) &&
        !"".equalsIgnoreCase(department.getDeptCode())){
            dept.setDeptCode(department.getDeptCode());
        }

        return departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String deptName) {
        return departmentRepository.findByDeptName(deptName);
    }
}

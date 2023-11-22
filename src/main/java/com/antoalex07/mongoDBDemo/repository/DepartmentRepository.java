package com.antoalex07.mongoDBDemo.repository;

import com.antoalex07.mongoDBDemo.entity.Department;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, ObjectId> {
    public Department findByDeptName(String deptName);
}

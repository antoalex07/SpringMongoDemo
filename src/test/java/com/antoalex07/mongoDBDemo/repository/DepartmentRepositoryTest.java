package com.antoalex07.mongoDBDemo.repository;

import com.antoalex07.mongoDBDemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .deptKey(1L)
                        .deptName("Computer Science")
                        .deptCode("CS-23")
                        .deptAddress("Bengaluru")
                        .build();

        mongoTemplate.save(department);

    }

    @Test
    public void whenFindByIf_thenReturnDepartment(){

        Department department = departmentRepository.findByDeptKey(1L);
        assertEquals(department.getDeptName(), "Computer Science");
        mongoTemplate.remove(department);
    }
}
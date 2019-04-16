package com.jaywade.myoa.dao;

import com.jaywade.myoa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(String sn);
    void update(Department department);
    Department select(String sn);
    List<Department> selectAll();
}

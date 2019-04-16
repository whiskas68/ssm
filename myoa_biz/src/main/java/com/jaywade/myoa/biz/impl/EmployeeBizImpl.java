package com.jaywade.myoa.biz.impl;

import com.jaywade.myoa.biz.EmployeeBiz;
import com.jaywade.myoa.dao.EmployeeDao;
import com.jaywade.myoa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {
    @Autowired
    @Qualifier("employeeDao")
    private EmployeeDao employeeDao;

    public void add(Employee employee){
        employeeDao.insert(employee);
    }
    public void edit(Employee employee){
        employeeDao.update(employee);
    }

    public void remove(String sn){
        employeeDao.delete(sn);
    }
    public Employee get(String sn){
        return employeeDao.select(sn);
    }
    public List<Employee> getAll(){
        return employeeDao.selectAll();
    }
}

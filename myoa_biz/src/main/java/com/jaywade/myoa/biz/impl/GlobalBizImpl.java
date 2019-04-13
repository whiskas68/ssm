package com.jaywade.myoa.biz.impl;

import com.jaywade.myoa.biz.GlobalBiz;
import com.jaywade.myoa.dao.EmployeeDao;
import com.jaywade.myoa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    @Autowired
    @Qualifier("employeeDao")
    private EmployeeDao employeeDao;

    public Employee login(String sn,String password){
        Employee employee = employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee){
        employeeDao.update(employee);
    }
}

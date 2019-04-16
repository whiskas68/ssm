package com.jaywade.myoa.biz;

import com.jaywade.myoa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn,String password);
    void changePassword(Employee employee);
}

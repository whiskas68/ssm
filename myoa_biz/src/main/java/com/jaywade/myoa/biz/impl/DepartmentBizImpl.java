package com.jaywade.myoa.biz.impl;

import com.jaywade.myoa.biz.DepartmentBiz;
import com.jaywade.myoa.dao.DepartmentDao;
import com.jaywade.myoa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
    @Autowired
    @Qualifier("departmentDao")
    private DepartmentDao departmentDao;

    public void add(Department department){
        departmentDao.insert(department);
    }
    public void edit(Department department){
        departmentDao.update(department);
    }

    public void remove(String sn){
        departmentDao.delete(sn);
    }
    public Department get(String sn){
        return departmentDao.select(sn);
    }
    public List<Department> getAll(){
        return departmentDao.selectAll();
    }
}

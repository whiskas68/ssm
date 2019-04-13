package com.jaywade.myoa.controller;

import com.jaywade.myoa.biz.ClaimVoucherBiz;
import com.jaywade.myoa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Autowired
    @Qualifier("claimVoucherBiz")
    private ClaimVoucherBiz claimVoucherBiz;

    @RequestMapping("/detail")
    public String detail(int id, Map<String,Object> map){
        map.put("claimVoucher",claimVoucherBiz.get(id));
        map.put("items",claimVoucherBiz.getItem(id));
        map.put("records",claimVoucherBiz.getRecords(id));
        return "claim_voucher_detail";
    }

    @RequestMapping("/self")
    public String self(HttpSession session,Map<String,Object> map){
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("list",claimVoucherBiz.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }


}

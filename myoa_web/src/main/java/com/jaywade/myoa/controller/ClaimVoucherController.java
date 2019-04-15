package com.jaywade.myoa.controller;

import com.jaywade.myoa.biz.ClaimVoucherBiz;
import com.jaywade.myoa.dto.ClaimVoucherInfo;
import com.jaywade.myoa.entity.Employee;
import com.jaywade.myoa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static java.awt.SystemColor.info;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Autowired
    @Qualifier("claimVoucherBiz")
    private ClaimVoucherBiz claimVoucherBiz;

    private ClaimVoucherInfo info;

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

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("items", Contant.getItems());
        map.put("info", new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    @RequestMapping("/add")
    public String add(HttpSession session,ClaimVoucherInfo info){
        Employee employee =(Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherBiz.save(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }

    @RequestMapping("/deal")
    public String deal(HttpSession session,Map<String,Object> map){
        Employee employee = (Employee) session.getAttribute("employee");
        map.put("list",claimVoucherBiz.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }


}

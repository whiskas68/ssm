package com.jaywade.myoa.biz;

import com.jaywade.myoa.entity.ClaimVoucher;
import com.jaywade.myoa.entity.ClaimVoucherItem;
import com.jaywade.myoa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItem(int cvid);
    List<DealRecord> getRecords(int cvid);
    List<ClaimVoucher> getForSelf(String sn);
}

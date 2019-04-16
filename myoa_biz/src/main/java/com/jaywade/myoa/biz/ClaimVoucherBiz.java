package com.jaywade.myoa.biz;

import com.jaywade.myoa.entity.ClaimVoucher;
import com.jaywade.myoa.entity.ClaimVoucherItem;
import com.jaywade.myoa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items);
    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItem(int cvid);
    List<DealRecord> getRecords(int cvid);
    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);
    void update(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items);
}

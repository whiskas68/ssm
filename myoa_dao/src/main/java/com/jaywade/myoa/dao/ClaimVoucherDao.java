package com.jaywade.myoa.dao;

import com.jaywade.myoa.entity.ClaimVoucher;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByCreateSn(String sn);
    List<ClaimVoucher> selectByNextDealSn(String sn);
}

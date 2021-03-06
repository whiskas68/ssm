package com.jaywade.myoa.biz.impl;

import com.jaywade.myoa.biz.ClaimVoucherBiz;
import com.jaywade.myoa.dao.ClaimVoucherDao;
import com.jaywade.myoa.dao.ClaimVoucherItemDao;
import com.jaywade.myoa.dao.DealRecordDao;
import com.jaywade.myoa.entity.ClaimVoucher;
import com.jaywade.myoa.entity.ClaimVoucherItem;
import com.jaywade.myoa.entity.DealRecord;
import com.jaywade.myoa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("claimVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

    @Autowired
    @Qualifier("claimVoucherDao")
    private ClaimVoucherDao claimVoucherDao;

    @Autowired
    @Qualifier("claimVoucherItemDao")
    private ClaimVoucherItemDao claimVoucherItemDao;

    @Autowired
    @Qualifier("dealRecordDao")
    private DealRecordDao dealRecordDao;

    public void save(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items){
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucherDao.insert(claimVoucher);
    }

    public ClaimVoucher get(int id){
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItem(int cvid){
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid){
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn){
        return claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn){ return claimVoucherDao.selectByNextDealSn(sn);}

}

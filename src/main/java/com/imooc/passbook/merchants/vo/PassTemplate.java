package com.imooc.passbook.merchants.vo;

import com.imooc.passbook.merchants.constant.ErrorCode;
import com.imooc.passbook.merchants.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投放优惠券对象定义
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    //字段信息含义见笔记
    private Integer id;
    private String title;
    private String summary;
    private String desc;
    private Long limit;
    private Boolean hasToken;
    private Integer background;
    private Date start;
    private Date end;

    //校验优惠券对象的有效性
    public ErrorCode validate(MerchantsDao merchantsDao) {

        if (merchantsDao.findById(id) == null) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }

        return ErrorCode.SUCCESS;
    }
}

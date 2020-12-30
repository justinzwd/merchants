package com.imooc.passbook.merchants.vo;

import com.imooc.passbook.merchants.constant.ErrorCode;
import com.imooc.passbook.merchants.dao.MerchantsDao;
import com.imooc.passbook.merchants.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户请求对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    private String name;
    private String logoUrl;
    private String businessLicenseUrl;
    private String phone;
    private String address;

    public ErrorCode validate(MerchantsDao merchantsDao) {
        //商户已经存在，不能创建新的对象
        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }

        if (this.logoUrl == null) {
            return ErrorCode.EMPTY_LOGO;
        }

        if (this.businessLicenseUrl == null) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if (this.address == null) {
            return ErrorCode.EMPTY_ADDRESS;
        }

        if (this.phone == null) {
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    //将请求对象转换为商户对象，然后保存在数据库当中
    public Merchants toMerchants() {
        Merchants merchants = new Merchants();

        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }

}

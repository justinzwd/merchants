package com.imooc.passbook.merchants.service;

import com.imooc.passbook.merchants.vo.CreateMerchantsRequest;
import com.imooc.passbook.merchants.vo.PassTemplate;
import com.imooc.passbook.merchants.vo.Response;

/**
 * 商户服务接口定义
 */
public interface IMerchantsServ {

    //创建商户服务
    Response createMerchants(CreateMerchantsRequest request);

    //根据id构造商户信息 buildMerchantsInfoById
    Response buildMerchantsInfoById(Integer id);

    //投放优惠券
    Response dropPassTemplate(PassTemplate template);
}

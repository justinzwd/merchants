package com.imooc.passbook.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.merchants.service.IMerchantsServ;
import com.imooc.passbook.merchants.vo.CreateMerchantsRequest;
import com.imooc.passbook.merchants.vo.PassTemplate;
import com.imooc.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    //商户服务接口
    @Autowired
    private IMerchantsServ merchantsServ;

    public MerchantsController(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(Integer id) {
        log.info("BuildMerchantsInfo:{}",id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(PassTemplate passTemplate) {
        log.info("DropPassTemplate: {}",JSON.toJSONString(passTemplate));
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}

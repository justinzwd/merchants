package com.imooc.passbook.merchants.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.merchants.vo.CreateMerchantsRequest;
import com.imooc.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
    //@Transactional
    public void testCreateMerchantServ() {
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课网123");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("1234567979");
        request.setAddress("北京市朝阳区");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById() {
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(18)));
    }

    @Test
    public void testDropTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(18);
        passTemplate.setTitle("title: 幕课");
        passTemplate.setSummary("简介：慕课");
        passTemplate.setDesc("详情：慕课网");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}

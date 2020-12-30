package com.imooc.passbook.merchants.dao;

import com.imooc.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Merchants Dao 接口
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    /**
     * 根据id获取商户对象
     * @param id 商户id
     * @return Mechants 对象
     */
    //Optional<Merchants>
    //Merchants findById(Integer id);
    Optional<Merchants> findById(Integer id);

    //根据name获取商户对象
    Merchants findByName(String name);
}

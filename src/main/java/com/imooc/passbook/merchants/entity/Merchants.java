package com.imooc.passbook.merchants.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 商户对象模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {

    //商户ID，主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    //商户名称
    @Basic
    @Column(name = "name",unique = true,nullable = false)
    private String name;

    //商户logo
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String logoUrl;

    //商户营业执照
    @Basic
    @Column(name = "business_url",nullable = false)
    private String businessLicenseUrl;

    //商户联系电话
    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    //商户地址
    @Basic
    @Column(name = "address",nullable = false)
    private String address;

    //是否通过审核
    @Basic
    @Column(name = "is_audit",nullable = false)
    private Boolean isAudit = false;
}

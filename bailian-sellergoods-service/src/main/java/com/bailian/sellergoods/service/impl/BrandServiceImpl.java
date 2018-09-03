package com.bailian.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.bailian.mapper.TbBrandMapper;
import com.bailian.pojo.TbBrand;
import com.bailian.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
//远程调用
@Service
@Component
public class BrandServiceImpl implements BrandService {

    @Resource
    private TbBrandMapper brandMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }


 /* @Autowired
  private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
       *//* List<TbBrand> tbBrands=new ArrayList<>();
       TbBrand tbBrand=new TbBrand();
       tbBrand.setName("测试");
       tbBrand.setFirstChar("555");
       tbBrand.setId(5l);
        tbBrands.add(tbBrand);


        //传入null，返回全部列表
        return tbBrands;*//*

      return tbBrandMapper.selectByExample(null);
    }*/
}

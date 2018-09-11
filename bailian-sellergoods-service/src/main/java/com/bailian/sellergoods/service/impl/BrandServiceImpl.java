package com.bailian.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.bailian.mapper.TbBrandMapper;
import com.bailian.pojo.TbBrand;
import com.bailian.pojo.TbBrandExample;
import com.bailian.sellergoods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageResult findPage(int pageNum, int PageSize) {
      //分页插件
        PageHelper.startPage(pageNum,PageSize);
       Page<TbBrand> page=(Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }
    /**
     * 修改
     */
    @Override
    public void update(TbBrand brand){
        brandMapper.updateByPrimaryKey(brand);
    }
    /**
     * 根据 ID 获取实体
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(Long id){
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<TbBrand> page= (Page<TbBrand>)brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 列表数据
     */
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }
}

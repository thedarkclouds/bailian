package com.bailian.sellergoods.service;

import com.bailian.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

    /*
    * 分页
    * pageNum  当前页码
    * pageSize 每页记录数
    * */
    public PageResult findPage(int pageNum, int PageSize);


    /**
     * 增加
     */
    public void add(TbBrand brand);

    /**
     * 修改
     */
    public void update(TbBrand brand);
    /**
     * 根据 ID 获取实体
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long [] ids);

    /**
     * 分页查询
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(TbBrand brand, int pageNum,int pageSize);

}

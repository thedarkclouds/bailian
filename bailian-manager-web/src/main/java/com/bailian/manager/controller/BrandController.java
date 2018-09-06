package com.bailian.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.bailian.pojo.TbBrand;
import com.bailian.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//组合注解，代表 responseBody和Controller
@RequestMapping("/brand")
public class BrandController {
     @Reference
    private BrandService brandService;


     @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }


    @RequestMapping("/findPage")
    public PageResult findPage(int page, int size){
        return brandService.findPage(page, size);
    }
    /**北京市昌平区建材城西路金燕龙办公楼一层 电话： 400-618-9090
     * 增加
     * @param brand
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }

       /*
        * 批量删除
        * @param ids
        * @return
        */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int rows ){
        return brandService.findPage(brand, page, rows);
    }

}

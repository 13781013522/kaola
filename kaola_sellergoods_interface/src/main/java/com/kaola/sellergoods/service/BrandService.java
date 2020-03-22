package com.kaola.sellergoods.service;

import com.kaola.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {

    List<Map> selectOptionList();

    //查询所有
    public List<TbBrand> findAll();
    //分页查询
    public PageResult findPage(int page,int pageSize);
    //添加
    public void save(TbBrand tbBrand);
    //修改
    public void update(TbBrand tbBrand);
    //删除
    public void  del(Long[] id);
    //修改前的查询
    public TbBrand findOne(Long id);

    //条件搜索方法
    public PageResult search(int page,int pageSize,TbBrand brand);
}

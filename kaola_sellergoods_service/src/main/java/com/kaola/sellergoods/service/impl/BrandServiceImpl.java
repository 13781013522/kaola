package com.kaola.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kaola.mapper.TbBrandMapper;
import com.kaola.pojo.TbBrand;
import com.kaola.pojo.TbBrandExample;
import com.kaola.sellergoods.service.BrandService;
import entity.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    private TbBrandMapper brandMapper;


    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }

    //查询所有
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }
    //分页查询
    @Override
    public PageResult findPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        Page<TbBrand> tbBrands = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(tbBrands.getTotal(),tbBrands.getResult());
    }
    //添加
    @Override
    public void save(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }
    //修改
    @Override
    public void update(TbBrand tbBrand) {
    brandMapper.updateByPrimaryKey(tbBrand);
    }
    //删除
    @Override
    public void del(Long[] id) {
        for (Long ids: id){
            brandMapper.deleteByPrimaryKey(ids);
        }
    }
    //修改前的查询
    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //条件搜索方法
    @Override
    public PageResult search(int page, int pageSize, TbBrand brand) {
        PageHelper.startPage(page,pageSize);
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand!=null){
            if (StringUtils.isNotBlank(brand.getName())){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (StringUtils.isNotBlank(brand.getFirstChar())){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<TbBrand> tbBrands = (Page<TbBrand>) brandMapper.selectByExample(example);

        return new PageResult(tbBrands.getTotal(),tbBrands.getResult());
    }
}

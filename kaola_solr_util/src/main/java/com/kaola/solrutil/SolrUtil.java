package com.kaola.solrutil;

import com.alibaba.fastjson.JSON;
import com.kaola.mapper.TbItemMapper;
import com.kaola.pojo.TbItem;
import com.kaola.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SolrUtil {
    //把数据库的数据导入到索引库中
    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private SolrTemplate solrTemplate;
    //导入索引库
    public void importData(){
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");//通过审核
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        System.out.println("===商品开始导入");
        for (TbItem tbItem:tbItems){
            Map jsonObject = JSON.parseObject(tbItem.getSpec(),Map.class);
            tbItem.setSpecMap(jsonObject);
            System.out.println(tbItem.getTitle());
        }
        solrTemplate.saveBeans(tbItems);
        solrTemplate.commit();
        System.out.println("===倒入结束");
    }

    public static void main(String[] args) {
        //读取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
        SolrUtil solrUtil = (SolrUtil) context.getBean("solrUtil");
        solrUtil.importData();
    }
}

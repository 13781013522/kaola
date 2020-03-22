package com.kaola.pojogroup;



import com.kaola.pojo.TbGoods;
import com.kaola.pojo.TbGoodsDesc;
import com.kaola.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    private TbGoods goods;   //商品SPU表
    private TbGoodsDesc goodsDesc;  //商品描述
    private List<TbItem>  itemList;  //商品SKU表

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }
}

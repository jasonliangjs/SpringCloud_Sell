package com.imooc.service;

import com.imooc.DTO.CartDTO;
import com.imooc.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by jason on 2019/4/23.
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList 订单id列表
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);



    /**
     * 扣库存 需要考虑到多个订单 -> productId的情况
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);


}

package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jason on 2019/4/23.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /**
     * 根据商品状态查询商品信息
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据productIdList 查询商品详情
     * @param productIdList 所有productId列表
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}

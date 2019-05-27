package com.imooc.service.impl;

import com.imooc.DTO.CartDTO;
import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.ProductException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by jason on 2019/4/23.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    /**
     * 查询所有 在架商品列表
     */
    @Override
    public List<ProductInfo> findUpAll() {
        //ProductStatusEnum.UP.getCode() 值为0
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存 需要考虑到多个订单 -> productId的情况
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
//            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).orElse(null);
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //1.判断商品不存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.商品存货 < 订单数
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).orElse(null);
            //2.判断库存是否足够
            Integer resultCount = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(resultCount < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(resultCount);
            //完成扣库存
            productInfoRepository.save(productInfo);
        }
    }



}

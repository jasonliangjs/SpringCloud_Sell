package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jason on 2019/4/23.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /** 名字 **/
    private String productName;

    /** 单价 **/
    private BigDecimal productPrice;

    /** 库存 **/
    private Integer productStock;

    /** 描述 **/
    private String productDescription;

    /** 小图 **/
    @JsonProperty(value = "icon")
    private String productIcon;

    /**商品状态,0正常 1下架**/

    private Integer productStatus;


    /** 类目编号 **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}

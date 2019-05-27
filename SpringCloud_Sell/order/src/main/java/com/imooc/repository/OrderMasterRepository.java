package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jason on 2019/4/23.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}

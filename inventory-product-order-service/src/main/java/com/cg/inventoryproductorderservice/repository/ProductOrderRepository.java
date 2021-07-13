/**
 * @author Santosh Kudale
 * @email santosh.kudale96@gmail.com
 * @create date 2020-10-30 23:58:10
 * @modify date 2020-10-30 23:58:10
 * @desc [description]
 */
package com.cg.inventoryproductorderservice.repository;

import com.cg.inventoryproductorderservice.entity.ProductOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
  
}

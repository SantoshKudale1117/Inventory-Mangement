/**
 * @author Santosh Kudale
 * @email santosh.kudale96@gmail.com
 * @create date 2020-10-30 15:47:08
 * @modify date 2020-10-30 15:47:08
 * @desc Thrown when Invalid status is provided
 */
package com.cg.inventoryproductorderservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidOrderUpdateStatusException extends RuntimeException {
  
  
  private static final long serialVersionUID = 1L;
  private String errorName;
  private String errorDescription;
}

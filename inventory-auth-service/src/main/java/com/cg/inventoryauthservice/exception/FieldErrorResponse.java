/**
 * @author Santosh Kudale
 * @email santosh.kudale96@gmail.com
 * @create date 2020-10-28 14:42:27
 * @modify date 2020-10-28 14:42:27
 * @desc Filed Error List
 */
package com.cg.inventoryauthservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldErrorResponse {
  private String field;
  private String message;
}

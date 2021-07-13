/**
 * @author Santosh Kudale
 * @email santosh.kudale96@gmail.com
 * @create date 2020-11-05 08:57:35
 * @modify date 2020-11-05 08:57:35
 * @desc Product Model
 */
import { Warehouse } from './warehouse.model';

export class Product {
  materialName: string;
  productId: number;
  description: string;
  quantityAvailable: number;
  quantityUnit: string;
  warehouse: Warehouse;
}

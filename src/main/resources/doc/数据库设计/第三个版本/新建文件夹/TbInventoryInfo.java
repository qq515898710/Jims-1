/***********************************************************************
 * Module:  TbInventoryInfo.java
 * Author:  Administrator
 * Purpose: Defines the Class TbInventoryInfo
 ***********************************************************************/

import java.util.*;

/** 库存信息
 * 
 * @pdOid 835af067-26f6-4f17-a884-d2dd44a7729b */
public class TbInventoryInfo {
   /** 编号
    * 
    * @pdOid 8af785e2-1e84-48b9-910d-804a763cb480 */
   public java.lang.String id;
   /** 商品简称
    * 
    * @pdOid f8e032d0-29e2-4595-9786-8313a5f675f1 */
   public java.lang.String abbreviation;
   /** 产地
    * 
    * @pdOid 98a89385-88b0-40d0-96b6-82c8eb1be5c1 */
   public java.lang.String origin;
   /** 规格
    * 
    * @pdOid 798cabe7-c57d-4f87-9b18-b495e844b4e6 */
   public java.lang.String specification;
   /** 包装
    * 
    * @pdOid 6b431f20-9018-4932-a295-9cd4a869684d */
   public java.lang.String pack;
   /** 单位
    * 
    * @pdOid 80d46a74-9985-47ff-946c-92a620b914c4 */
   public java.lang.String units;
   /** 单价
    * 
    * @pdOid f6a9ddeb-076b-4231-a536-57150098035d */
   public float unitCost;
   /** 库存数量
    * 
    * @pdOid 65af4053-1874-43a6-9962-df238af34a3c */
   public int amount;
   
   /** @pdRoleInfo migr=no name=TbUser assc=reference19 mult=0..1 side=A */
   public TbUser tbUser;
   
   
   /** @pdGenerated default parent getter */
   public TbUser getTbUser() {
      return tbUser;
   }
   
   /** @pdGenerated default parent setter
     * @param newTbUser */
   public void setTbUser(TbUser newTbUser) {
      if (this.tbUser == null || !this.tbUser.equals(newTbUser))
      {
         if (this.tbUser != null)
         {
            TbUser oldTbUser = this.tbUser;
            this.tbUser = null;
            oldTbUser.removeTbInventoryInfo(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbInventoryInfo(this);
         }
      }
   }

}
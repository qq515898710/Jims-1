/***********************************************************************
 * Module:  TbStock.java
 * Author:  Administrator
 * Purpose: Defines the Class TbStock
 ***********************************************************************/

import java.util.*;

/** 入库信息主要内容
 * 
 * @pdOid c385af57-8302-4d65-b68d-557ef6146e7b */
public class TbStock {
   /** 入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀
    * 
    * @pdOid 2df05911-0f91-4cb0-bf78-ee3f8cc58a8e */
   public java.lang.String id;
   /** 品种数量
    * 
    * @pdOid 320666e5-44e4-4eb0-9ca0-be170605b466 */
   public int varietyAmount;
   /** 单价
    * 
    * @pdOid eef4b05e-d043-47df-a24a-8ca27c2df373 */
   public float unitCost;
   /** 数量
    * 
    * @pdOid e22d3712-5ed1-4c31-8fa0-ddf12693983f */
   public int amount;
   /** 合计金额
    * 
    * @pdOid 08a7dc79-e4e8-411e-aa2c-afd6af392fff */
   public float sum;
   /** 验收结论
    * 
    * @pdOid 0ccc32b3-36cf-4f72-861c-a111bf480124 */
   public java.lang.String check;
   /** 入货时间
    * 
    * @pdOid ff7f0523-6310-41d2-b8e2-85443168a0ca */
   public java.util.Date time;
   /** 结算方式
    * 
    * @pdOid ceed1569-3790-4a23-8098-da785f2616f9 */
   public java.lang.String clearingForm;
   /** 经手人
    * 
    * @pdOid 6250b5e5-de20-4210-ba89-b3e9954bc048 */
   public java.lang.String handler;
   
   /** @pdRoleInfo migr=no name=TbProviderInfo assc=reference9 mult=0..1 side=A */
   public TbProviderInfo tbProviderInfo;
   /** @pdRoleInfo migr=no name=TbUser assc=reference13 mult=0..1 side=A */
   public TbUser tbUser;
   /** @pdRoleInfo migr=no name=TbGoodInfo assc=reference16 mult=0..1 side=A */
   public TbGoodInfo tbGoodInfo;
   
   
   /** @pdGenerated default parent getter */
   public TbProviderInfo getTbProviderInfo() {
      return tbProviderInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTbProviderInfo */
   public void setTbProviderInfo(TbProviderInfo newTbProviderInfo) {
      if (this.tbProviderInfo == null || !this.tbProviderInfo.equals(newTbProviderInfo))
      {
         if (this.tbProviderInfo != null)
         {
            TbProviderInfo oldTbProviderInfo = this.tbProviderInfo;
            this.tbProviderInfo = null;
            oldTbProviderInfo.removeTbStock(this);
         }
         if (newTbProviderInfo != null)
         {
            this.tbProviderInfo = newTbProviderInfo;
            this.tbProviderInfo.addTbStock(this);
         }
      }
   }
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
            oldTbUser.removeTbStock(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbStock(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TbGoodInfo getTbGoodInfo() {
      return tbGoodInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTbGoodInfo */
   public void setTbGoodInfo(TbGoodInfo newTbGoodInfo) {
      if (this.tbGoodInfo == null || !this.tbGoodInfo.equals(newTbGoodInfo))
      {
         if (this.tbGoodInfo != null)
         {
            TbGoodInfo oldTbGoodInfo = this.tbGoodInfo;
            this.tbGoodInfo = null;
            oldTbGoodInfo.removeTbStock(this);
         }
         if (newTbGoodInfo != null)
         {
            this.tbGoodInfo = newTbGoodInfo;
            this.tbGoodInfo.addTbStock(this);
         }
      }
   }

}
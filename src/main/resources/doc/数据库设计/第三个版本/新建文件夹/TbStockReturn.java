/***********************************************************************
 * Module:  TbStockReturn.java
 * Author:  Administrator
 * Purpose: Defines the Class TbStockReturn
 ***********************************************************************/

import java.util.*;

/** 进货退货信息
 * 
 * @pdOid e83d99f5-364f-46b6-8dd9-e974a1f52d56 */
public class TbStockReturn {
   /** 入库编号,以"rk"字符串为前缀,加上商品的入库日期,再以3位数字作为后缀
    * 
    * @pdOid cde07ba7-ab0d-405b-8538-30f5c7fa2f14 */
   public java.lang.String id;
   /** 品种数量
    * 
    * @pdOid 3dd6fd3f-19b5-4791-9379-da2039c14282 */
   public int varietyAmount;
   /** 单价
    * 
    * @pdOid f7b7bad1-1e7c-4c62-b8b3-29cc4fd2d0f6 */
   public float unitCost;
   /** 数量
    * 
    * @pdOid 66fb87a9-79aa-40fc-afab-8bcd5660a52e */
   public int amount;
   /** 合计金额
    * 
    * @pdOid 1f2d4a08-b4f1-46ce-87e8-3d5e87527c69 */
   public float sum;
   /** 验收结论
    * 
    * @pdOid 6e8ac723-9c4d-47c0-8903-77e631e3356f */
   public java.lang.String check;
   /** 退货时间
    * 
    * @pdOid d2455414-1fca-4c3a-b9df-4fc131c1fb14 */
   public java.util.Date time;
   /** 结算方式
    * 
    * @pdOid 4a1d7ef8-7f69-4e24-9d05-0f69386208e1 */
   public java.lang.String clearingForm;
   /** 经手人
    * 
    * @pdOid f1d3f8c8-310c-4a35-9292-4f3493be7810 */
   public java.lang.String handler;
   
   /** @pdRoleInfo migr=no name=TbProviderInfo assc=reference14 mult=0..1 side=A */
   public TbProviderInfo tbProviderInfo;
   /** @pdRoleInfo migr=no name=TbUser assc=reference15 mult=0..1 side=A */
   public TbUser tbUser;
   /** @pdRoleInfo migr=no name=TbGoodInfo assc=reference17 mult=0..1 side=A */
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
            oldTbProviderInfo.removeTbStockReturn(this);
         }
         if (newTbProviderInfo != null)
         {
            this.tbProviderInfo = newTbProviderInfo;
            this.tbProviderInfo.addTbStockReturn(this);
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
            oldTbUser.removeTbStockReturn(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbStockReturn(this);
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
            oldTbGoodInfo.removeTbStockReturn(this);
         }
         if (newTbGoodInfo != null)
         {
            this.tbGoodInfo = newTbGoodInfo;
            this.tbGoodInfo.addTbStockReturn(this);
         }
      }
   }

}
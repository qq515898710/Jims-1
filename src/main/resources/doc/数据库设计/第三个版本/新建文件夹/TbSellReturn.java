/***********************************************************************
 * Module:  TbSellReturn.java
 * Author:  Administrator
 * Purpose: Defines the Class TbSellReturn
 ***********************************************************************/

import java.util.*;

/** 销售退货信息
 * 
 * @pdOid 7c6d1fd3-7bec-41f3-acb5-e5e78ad394a8 */
public class TbSellReturn {
   /** @pdOid 3a0f6936-0576-401f-a45f-69de50b36964 */
   public java.lang.String id;
   /** @pdOid 90acddfc-618b-4d7e-a49a-a1e9450684c7 */
   public float unitCost;
   /** @pdOid 96e1b52a-00b8-496f-ad91-1c9e1df80233 */
   public int amount;
   /** @pdOid 7b82b475-b090-42cb-a23a-d110c4135982 */
   public float sum;
   /** @pdOid cee6f56b-79db-4ca9-8afa-f5f96ac2d7dd */
   public java.util.Date time;
   /** @pdOid 88ce8667-8a36-47b0-8ca0-0c1db0c9b82e */
   public java.lang.String clearingForm;
   /** @pdOid 57f65e55-93e5-4770-ba95-5f3625b58899 */
   public java.lang.String handler;
   
   /** @pdRoleInfo migr=no name=TbGoodInfo assc=reference10 mult=0..1 side=A */
   public TbGoodInfo tbGoodInfo;
   /** @pdRoleInfo migr=no name=TbCustomerInfo assc=reference11 mult=0..1 side=A */
   public TbCustomerInfo tbCustomerInfo;
   /** @pdRoleInfo migr=no name=TbUser assc=reference12 mult=0..1 side=A */
   public TbUser tbUser;
   
   
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
            oldTbGoodInfo.removeTbSellReturn(this);
         }
         if (newTbGoodInfo != null)
         {
            this.tbGoodInfo = newTbGoodInfo;
            this.tbGoodInfo.addTbSellReturn(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TbCustomerInfo getTbCustomerInfo() {
      return tbCustomerInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTbCustomerInfo */
   public void setTbCustomerInfo(TbCustomerInfo newTbCustomerInfo) {
      if (this.tbCustomerInfo == null || !this.tbCustomerInfo.equals(newTbCustomerInfo))
      {
         if (this.tbCustomerInfo != null)
         {
            TbCustomerInfo oldTbCustomerInfo = this.tbCustomerInfo;
            this.tbCustomerInfo = null;
            oldTbCustomerInfo.removeTbSellReturn(this);
         }
         if (newTbCustomerInfo != null)
         {
            this.tbCustomerInfo = newTbCustomerInfo;
            this.tbCustomerInfo.addTbSellReturn(this);
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
            oldTbUser.removeTbSellReturn(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbSellReturn(this);
         }
      }
   }

}
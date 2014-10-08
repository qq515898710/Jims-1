/***********************************************************************
 * Module:  TbSell.java
 * Author:  Administrator
 * Purpose: Defines the Class TbSell
 ***********************************************************************/

import java.util.*;

/** 销售信息
 * 
 * @pdOid 0b5b4f7f-4586-4d17-8ce2-48912d9cd3d7 */
public class TbSell {
   /** 前缀"s",后缀1000格式
    * 
    * @pdOid 0dc51c39-5253-42c7-a64c-12bf8ed9bcc5 */
   public java.lang.String id;
   /** 销售单价
    * 
    * @pdOid 23bf0e67-5262-467e-973e-29ddb5e55951 */
   public float unitCost;
   /** 数量
    * 
    * @pdOid 0fcdfb3b-934f-4705-86a0-24802edf4208 */
   public int amount;
   /** 金额
    * 
    * @pdOid dc8b338a-efe8-43de-9618-8bfa02920b55 */
   public float sum;
   /** 销售时间
    * 
    * @pdOid a674e54f-eaa1-495e-ac34-349374931fad */
   public java.util.Date time;
   /** 结算方式
    * 
    * @pdOid bdc7cf08-7cdd-4e17-b100-e7df1334bc22 */
   public java.lang.String clearingForm;
   /** @pdOid a8672c2b-edc7-42dc-8ef1-3e1904ceeb79 */
   public java.lang.String headler;
   
   /** @pdRoleInfo migr=no name=TbGoodInfo assc=reference6 mult=0..1 side=A */
   public TbGoodInfo tbGoodInfo;
   /** @pdRoleInfo migr=no name=TbCustomerInfo assc=reference7 mult=0..1 side=A */
   public TbCustomerInfo tbCustomerInfo;
   /** @pdRoleInfo migr=no name=TbUser assc=reference8 mult=0..1 side=A */
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
            oldTbGoodInfo.removeTbSell(this);
         }
         if (newTbGoodInfo != null)
         {
            this.tbGoodInfo = newTbGoodInfo;
            this.tbGoodInfo.addTbSell(this);
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
            oldTbCustomerInfo.removeTbSell(this);
         }
         if (newTbCustomerInfo != null)
         {
            this.tbCustomerInfo = newTbCustomerInfo;
            this.tbCustomerInfo.addTbSell(this);
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
            oldTbUser.removeTbSell(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbSell(this);
         }
      }
   }

}
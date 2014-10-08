/***********************************************************************
 * Module:  TbCustomerInfo.java
 * Author:  Administrator
 * Purpose: Defines the Class TbCustomerInfo
 ***********************************************************************/

import java.util.*;

/** 客户信息
 * 
 * @pdOid 0abf773c-983a-4bab-a6a9-869629f14410 */
public class TbCustomerInfo {
   /** 客户的ID编号，以字符串"c"为编号的前缀,加上4位数字做编号的后缀
    * 
    * @pdOid 4ba8fc7a-7382-43bf-b406-d8756d59c4ed */
   public java.lang.String id;
   /** 客户名称
    * 
    * @pdOid 2898a441-2cc6-41ce-8205-d9ccde7cfe94 */
   public java.lang.String cname;
   /** 简称
    * 
    * @pdOid c4e49bf1-230c-468e-be1e-bdec1d95977f */
   public java.lang.String abbreviation;
   /** 地址
    * 
    * @pdOid 5f7139e5-bc43-4211-9d8e-d72ede641439 */
   public java.lang.String address;
   /** 邮政编号
    * 
    * @pdOid 3a775725-0556-4684-a735-ce5823df0344 */
   public java.lang.String postalCode;
   /** 电话
    * 
    * @pdOid 8843a838-9061-4614-a1df-f3859fd23512 */
   public java.lang.String phone;
   /** 传真
    * 
    * @pdOid c483db7f-3eda-4725-91ec-949ee99ebb27 */
   public java.lang.String fax;
   /** 联系人
    * 
    * @pdOid 2101d749-9254-446e-b81e-73d8ce7250fb */
   public java.lang.String contacts;
   /** 联系人电话
    * 
    * @pdOid 97fd6c87-35ca-48ac-9ba4-6c29e8cafecc */
   public java.lang.String telephone;
   /** 电子邮箱
    * 
    * @pdOid 6b0cb26c-9dbb-461d-b541-e2222e179673 */
   public java.lang.String email;
   /** 开户行
    * 
    * @pdOid 65ca4267-6416-456a-84ce-c8e767fd77d7 */
   public java.lang.String depositBank;
   /** 帐号
    * 
    * @pdOid edca0cf4-7cad-4889-914b-edc8c617ad15 */
   public java.lang.String accountBank;
   
   /** @pdRoleInfo migr=no name=TbSell assc=reference7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbSell> tbSell;
   /** @pdRoleInfo migr=no name=TbSellReturn assc=reference11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbSellReturn> tbSellReturn;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TbSell> getTbSell() {
      if (tbSell == null)
         tbSell = new java.util.HashSet<TbSell>();
      return tbSell;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbSell() {
      if (tbSell == null)
         tbSell = new java.util.HashSet<TbSell>();
      return tbSell.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbSell */
   public void setTbSell(java.util.Collection<TbSell> newTbSell) {
      removeAllTbSell();
      for (java.util.Iterator iter = newTbSell.iterator(); iter.hasNext();)
         addTbSell((TbSell)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbSell */
   public void addTbSell(TbSell newTbSell) {
      if (newTbSell == null)
         return;
      if (this.tbSell == null)
         this.tbSell = new java.util.HashSet<TbSell>();
      if (!this.tbSell.contains(newTbSell))
      {
         this.tbSell.add(newTbSell);
         newTbSell.setTbCustomerInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbSell */
   public void removeTbSell(TbSell oldTbSell) {
      if (oldTbSell == null)
         return;
      if (this.tbSell != null)
         if (this.tbSell.contains(oldTbSell))
         {
            this.tbSell.remove(oldTbSell);
            oldTbSell.setTbCustomerInfo((TbCustomerInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbSell() {
      if (tbSell != null)
      {
         TbSell oldTbSell;
         for (java.util.Iterator iter = getIteratorTbSell(); iter.hasNext();)
         {
            oldTbSell = (TbSell)iter.next();
            iter.remove();
            oldTbSell.setTbCustomerInfo((TbCustomerInfo)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TbSellReturn> getTbSellReturn() {
      if (tbSellReturn == null)
         tbSellReturn = new java.util.HashSet<TbSellReturn>();
      return tbSellReturn;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbSellReturn() {
      if (tbSellReturn == null)
         tbSellReturn = new java.util.HashSet<TbSellReturn>();
      return tbSellReturn.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbSellReturn */
   public void setTbSellReturn(java.util.Collection<TbSellReturn> newTbSellReturn) {
      removeAllTbSellReturn();
      for (java.util.Iterator iter = newTbSellReturn.iterator(); iter.hasNext();)
         addTbSellReturn((TbSellReturn)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbSellReturn */
   public void addTbSellReturn(TbSellReturn newTbSellReturn) {
      if (newTbSellReturn == null)
         return;
      if (this.tbSellReturn == null)
         this.tbSellReturn = new java.util.HashSet<TbSellReturn>();
      if (!this.tbSellReturn.contains(newTbSellReturn))
      {
         this.tbSellReturn.add(newTbSellReturn);
         newTbSellReturn.setTbCustomerInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbSellReturn */
   public void removeTbSellReturn(TbSellReturn oldTbSellReturn) {
      if (oldTbSellReturn == null)
         return;
      if (this.tbSellReturn != null)
         if (this.tbSellReturn.contains(oldTbSellReturn))
         {
            this.tbSellReturn.remove(oldTbSellReturn);
            oldTbSellReturn.setTbCustomerInfo((TbCustomerInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbSellReturn() {
      if (tbSellReturn != null)
      {
         TbSellReturn oldTbSellReturn;
         for (java.util.Iterator iter = getIteratorTbSellReturn(); iter.hasNext();)
         {
            oldTbSellReturn = (TbSellReturn)iter.next();
            iter.remove();
            oldTbSellReturn.setTbCustomerInfo((TbCustomerInfo)null);
         }
      }
   }

}
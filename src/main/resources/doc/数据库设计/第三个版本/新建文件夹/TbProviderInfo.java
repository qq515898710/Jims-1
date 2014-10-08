/***********************************************************************
 * Module:  TbProviderInfo.java
 * Author:  Administrator
 * Purpose: Defines the Class TbProviderInfo
 ***********************************************************************/

import java.util.*;

/** 供应商信息
 * 
 * @pdOid 82476b17-334e-4302-a747-559f337289c9 */
public class TbProviderInfo {
   /** 以"p"作为前缀,加上4位数做编号的后缀
    * 
    * @pdOid 8347a3c1-4fc9-495b-abb5-01eacb258f79 */
   public java.lang.String id;
   /** 供应商名称
    * 
    * @pdOid dc994aa7-e3d0-47c1-bb17-26dda9ea2f79 */
   public java.lang.String pname;
   /** 简称
    * 
    * @pdOid 36e12419-b6fb-4f4f-a22c-357d51868b0a */
   public java.lang.String abbreviation;
   /** 地址
    * 
    * @pdOid ce797de3-cd3f-4767-b0d1-19691457e2f6 */
   public java.lang.String address;
   /** 邮政编码
    * 
    * @pdOid d586c4bd-bc89-41e8-9587-973d42ece5ec */
   public java.lang.String postalCode;
   /** 电话
    * 
    * @pdOid 3181b9e7-4210-4c3e-a6d1-1e70010ffb93 */
   public java.lang.String phone;
   /** 传真
    * 
    * @pdOid 74d9c7b6-6102-4a8a-9d4b-74f4dc37dcd9 */
   public java.lang.String fax;
   /** 联系人
    * 
    * @pdOid 5485c824-4aca-4428-a891-9ea2cfa76a2e */
   public java.lang.String contacts;
   /** 联系人电话
    * 
    * @pdOid 9a365d67-5683-4159-9112-aeb0aa6c662d */
   public java.lang.String telephone;
   /** 开户行
    * 
    * @pdOid 3192d883-fb7c-4399-a892-7ba718a7bdc0 */
   public java.lang.String depositBank;
   /** 电子邮箱
    * 
    * @pdOid ac89b4a4-ba57-43d9-beb2-cfdd5a601e81 */
   public java.lang.String email;
   
   /** @pdRoleInfo migr=no name=TbGoodInfo assc=reference5 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbGoodInfo> tbGoodInfo;
   /** @pdRoleInfo migr=no name=TbStock assc=reference9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbStock> tbStock;
   /** @pdRoleInfo migr=no name=TbStockReturn assc=reference14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbStockReturn> tbStockReturn;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TbGoodInfo> getTbGoodInfo() {
      if (tbGoodInfo == null)
         tbGoodInfo = new java.util.HashSet<TbGoodInfo>();
      return tbGoodInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbGoodInfo() {
      if (tbGoodInfo == null)
         tbGoodInfo = new java.util.HashSet<TbGoodInfo>();
      return tbGoodInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbGoodInfo */
   public void setTbGoodInfo(java.util.Collection<TbGoodInfo> newTbGoodInfo) {
      removeAllTbGoodInfo();
      for (java.util.Iterator iter = newTbGoodInfo.iterator(); iter.hasNext();)
         addTbGoodInfo((TbGoodInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbGoodInfo */
   public void addTbGoodInfo(TbGoodInfo newTbGoodInfo) {
      if (newTbGoodInfo == null)
         return;
      if (this.tbGoodInfo == null)
         this.tbGoodInfo = new java.util.HashSet<TbGoodInfo>();
      if (!this.tbGoodInfo.contains(newTbGoodInfo))
      {
         this.tbGoodInfo.add(newTbGoodInfo);
         newTbGoodInfo.setTbProviderInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbGoodInfo */
   public void removeTbGoodInfo(TbGoodInfo oldTbGoodInfo) {
      if (oldTbGoodInfo == null)
         return;
      if (this.tbGoodInfo != null)
         if (this.tbGoodInfo.contains(oldTbGoodInfo))
         {
            this.tbGoodInfo.remove(oldTbGoodInfo);
            oldTbGoodInfo.setTbProviderInfo((TbProviderInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbGoodInfo() {
      if (tbGoodInfo != null)
      {
         TbGoodInfo oldTbGoodInfo;
         for (java.util.Iterator iter = getIteratorTbGoodInfo(); iter.hasNext();)
         {
            oldTbGoodInfo = (TbGoodInfo)iter.next();
            iter.remove();
            oldTbGoodInfo.setTbProviderInfo((TbProviderInfo)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TbStock> getTbStock() {
      if (tbStock == null)
         tbStock = new java.util.HashSet<TbStock>();
      return tbStock;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbStock() {
      if (tbStock == null)
         tbStock = new java.util.HashSet<TbStock>();
      return tbStock.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbStock */
   public void setTbStock(java.util.Collection<TbStock> newTbStock) {
      removeAllTbStock();
      for (java.util.Iterator iter = newTbStock.iterator(); iter.hasNext();)
         addTbStock((TbStock)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbStock */
   public void addTbStock(TbStock newTbStock) {
      if (newTbStock == null)
         return;
      if (this.tbStock == null)
         this.tbStock = new java.util.HashSet<TbStock>();
      if (!this.tbStock.contains(newTbStock))
      {
         this.tbStock.add(newTbStock);
         newTbStock.setTbProviderInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbStock */
   public void removeTbStock(TbStock oldTbStock) {
      if (oldTbStock == null)
         return;
      if (this.tbStock != null)
         if (this.tbStock.contains(oldTbStock))
         {
            this.tbStock.remove(oldTbStock);
            oldTbStock.setTbProviderInfo((TbProviderInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbStock() {
      if (tbStock != null)
      {
         TbStock oldTbStock;
         for (java.util.Iterator iter = getIteratorTbStock(); iter.hasNext();)
         {
            oldTbStock = (TbStock)iter.next();
            iter.remove();
            oldTbStock.setTbProviderInfo((TbProviderInfo)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TbStockReturn> getTbStockReturn() {
      if (tbStockReturn == null)
         tbStockReturn = new java.util.HashSet<TbStockReturn>();
      return tbStockReturn;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbStockReturn() {
      if (tbStockReturn == null)
         tbStockReturn = new java.util.HashSet<TbStockReturn>();
      return tbStockReturn.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbStockReturn */
   public void setTbStockReturn(java.util.Collection<TbStockReturn> newTbStockReturn) {
      removeAllTbStockReturn();
      for (java.util.Iterator iter = newTbStockReturn.iterator(); iter.hasNext();)
         addTbStockReturn((TbStockReturn)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbStockReturn */
   public void addTbStockReturn(TbStockReturn newTbStockReturn) {
      if (newTbStockReturn == null)
         return;
      if (this.tbStockReturn == null)
         this.tbStockReturn = new java.util.HashSet<TbStockReturn>();
      if (!this.tbStockReturn.contains(newTbStockReturn))
      {
         this.tbStockReturn.add(newTbStockReturn);
         newTbStockReturn.setTbProviderInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbStockReturn */
   public void removeTbStockReturn(TbStockReturn oldTbStockReturn) {
      if (oldTbStockReturn == null)
         return;
      if (this.tbStockReturn != null)
         if (this.tbStockReturn.contains(oldTbStockReturn))
         {
            this.tbStockReturn.remove(oldTbStockReturn);
            oldTbStockReturn.setTbProviderInfo((TbProviderInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbStockReturn() {
      if (tbStockReturn != null)
      {
         TbStockReturn oldTbStockReturn;
         for (java.util.Iterator iter = getIteratorTbStockReturn(); iter.hasNext();)
         {
            oldTbStockReturn = (TbStockReturn)iter.next();
            iter.remove();
            oldTbStockReturn.setTbProviderInfo((TbProviderInfo)null);
         }
      }
   }

}
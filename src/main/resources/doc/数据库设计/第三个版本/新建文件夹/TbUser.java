/***********************************************************************
 * Module:  TbUser.java
 * Author:  Administrator
 * Purpose: Defines the Class TbUser
 ***********************************************************************/

import java.util.*;

/** 操作员信息
 * 
 * @pdOid 7c09b79e-519b-45ae-924c-e3dd2502e602 */
public class TbUser {
   /** 帐号
    * 
    * @pdOid 1ab073a4-857d-4d34-ada0-c41a871bc9c7 */
   public java.lang.String name;
   /** 用户名
    * 
    * @pdOid 2bab15dd-773a-4f29-87d9-46ff073e3586 */
   public java.lang.String username;
   /** 密码
    * 
    * @pdOid 8114ae77-3873-4541-8862-b02e32136009 */
   public java.lang.String password;
   
   /** @pdRoleInfo migr=no name=TbUserLog assc=reference1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbUserLog> tbUserLog;
   /** @pdRoleInfo migr=no name=TbSell assc=reference8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbSell> tbSell;
   /** @pdRoleInfo migr=no name=TbSellReturn assc=reference12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbSellReturn> tbSellReturn;
   /** @pdRoleInfo migr=no name=TbStock assc=reference13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbStock> tbStock;
   /** @pdRoleInfo migr=no name=TbStockReturn assc=reference15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbStockReturn> tbStockReturn;
   /** @pdRoleInfo migr=no name=TbInventoryInfo assc=reference19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbInventoryInfo> tbInventoryInfo;
   /** @pdRoleInfo migr=no name=TbUserRole assc=reference18 mult=0..1 side=A */
   public TbUserRole tbUserRole;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TbUserLog> getTbUserLog() {
      if (tbUserLog == null)
         tbUserLog = new java.util.HashSet<TbUserLog>();
      return tbUserLog;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbUserLog() {
      if (tbUserLog == null)
         tbUserLog = new java.util.HashSet<TbUserLog>();
      return tbUserLog.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbUserLog */
   public void setTbUserLog(java.util.Collection<TbUserLog> newTbUserLog) {
      removeAllTbUserLog();
      for (java.util.Iterator iter = newTbUserLog.iterator(); iter.hasNext();)
         addTbUserLog((TbUserLog)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbUserLog */
   public void addTbUserLog(TbUserLog newTbUserLog) {
      if (newTbUserLog == null)
         return;
      if (this.tbUserLog == null)
         this.tbUserLog = new java.util.HashSet<TbUserLog>();
      if (!this.tbUserLog.contains(newTbUserLog))
      {
         this.tbUserLog.add(newTbUserLog);
         newTbUserLog.setTbUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbUserLog */
   public void removeTbUserLog(TbUserLog oldTbUserLog) {
      if (oldTbUserLog == null)
         return;
      if (this.tbUserLog != null)
         if (this.tbUserLog.contains(oldTbUserLog))
         {
            this.tbUserLog.remove(oldTbUserLog);
            oldTbUserLog.setTbUser((TbUser)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbUserLog() {
      if (tbUserLog != null)
      {
         TbUserLog oldTbUserLog;
         for (java.util.Iterator iter = getIteratorTbUserLog(); iter.hasNext();)
         {
            oldTbUserLog = (TbUserLog)iter.next();
            iter.remove();
            oldTbUserLog.setTbUser((TbUser)null);
         }
      }
   }
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
         newTbSell.setTbUser(this);      
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
            oldTbSell.setTbUser((TbUser)null);
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
            oldTbSell.setTbUser((TbUser)null);
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
         newTbSellReturn.setTbUser(this);      
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
            oldTbSellReturn.setTbUser((TbUser)null);
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
            oldTbSellReturn.setTbUser((TbUser)null);
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
         newTbStock.setTbUser(this);      
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
            oldTbStock.setTbUser((TbUser)null);
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
            oldTbStock.setTbUser((TbUser)null);
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
         newTbStockReturn.setTbUser(this);      
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
            oldTbStockReturn.setTbUser((TbUser)null);
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
            oldTbStockReturn.setTbUser((TbUser)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TbInventoryInfo> getTbInventoryInfo() {
      if (tbInventoryInfo == null)
         tbInventoryInfo = new java.util.HashSet<TbInventoryInfo>();
      return tbInventoryInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbInventoryInfo() {
      if (tbInventoryInfo == null)
         tbInventoryInfo = new java.util.HashSet<TbInventoryInfo>();
      return tbInventoryInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbInventoryInfo */
   public void setTbInventoryInfo(java.util.Collection<TbInventoryInfo> newTbInventoryInfo) {
      removeAllTbInventoryInfo();
      for (java.util.Iterator iter = newTbInventoryInfo.iterator(); iter.hasNext();)
         addTbInventoryInfo((TbInventoryInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbInventoryInfo */
   public void addTbInventoryInfo(TbInventoryInfo newTbInventoryInfo) {
      if (newTbInventoryInfo == null)
         return;
      if (this.tbInventoryInfo == null)
         this.tbInventoryInfo = new java.util.HashSet<TbInventoryInfo>();
      if (!this.tbInventoryInfo.contains(newTbInventoryInfo))
      {
         this.tbInventoryInfo.add(newTbInventoryInfo);
         newTbInventoryInfo.setTbUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbInventoryInfo */
   public void removeTbInventoryInfo(TbInventoryInfo oldTbInventoryInfo) {
      if (oldTbInventoryInfo == null)
         return;
      if (this.tbInventoryInfo != null)
         if (this.tbInventoryInfo.contains(oldTbInventoryInfo))
         {
            this.tbInventoryInfo.remove(oldTbInventoryInfo);
            oldTbInventoryInfo.setTbUser((TbUser)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbInventoryInfo() {
      if (tbInventoryInfo != null)
      {
         TbInventoryInfo oldTbInventoryInfo;
         for (java.util.Iterator iter = getIteratorTbInventoryInfo(); iter.hasNext();)
         {
            oldTbInventoryInfo = (TbInventoryInfo)iter.next();
            iter.remove();
            oldTbInventoryInfo.setTbUser((TbUser)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TbUserRole getTbUserRole() {
      return tbUserRole;
   }
   
   /** @pdGenerated default parent setter
     * @param newTbUserRole */
   public void setTbUserRole(TbUserRole newTbUserRole) {
      if (this.tbUserRole == null || !this.tbUserRole.equals(newTbUserRole))
      {
         if (this.tbUserRole != null)
         {
            TbUserRole oldTbUserRole = this.tbUserRole;
            this.tbUserRole = null;
            oldTbUserRole.removeTbUser(this);
         }
         if (newTbUserRole != null)
         {
            this.tbUserRole = newTbUserRole;
            this.tbUserRole.addTbUser(this);
         }
      }
   }

}
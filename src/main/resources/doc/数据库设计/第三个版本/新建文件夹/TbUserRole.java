/***********************************************************************
 * Module:  TbUserRole.java
 * Author:  Administrator
 * Purpose: Defines the Class TbUserRole
 ***********************************************************************/

import java.util.*;

/** 角色
 * 
 * @pdOid b2051b83-0d71-4f96-8229-371842afb267 */
public class TbUserRole {
   /** 编号
    * 
    * @pdOid 84b54c77-89ac-4119-9277-30755a8cdd29 */
   public long id;
   /** 角色类型
    * 
    * @pdOid dc6c53d9-d958-4f83-9705-811986c8080e */
   public int type;
   
   /** @pdRoleInfo migr=no name=TbUserPermission assc=reference3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbUserPermission> tbUserPermission;
   /** @pdRoleInfo migr=no name=TbUser assc=reference18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TbUser> tbUser;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TbUserPermission> getTbUserPermission() {
      if (tbUserPermission == null)
         tbUserPermission = new java.util.HashSet<TbUserPermission>();
      return tbUserPermission;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbUserPermission() {
      if (tbUserPermission == null)
         tbUserPermission = new java.util.HashSet<TbUserPermission>();
      return tbUserPermission.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbUserPermission */
   public void setTbUserPermission(java.util.Collection<TbUserPermission> newTbUserPermission) {
      removeAllTbUserPermission();
      for (java.util.Iterator iter = newTbUserPermission.iterator(); iter.hasNext();)
         addTbUserPermission((TbUserPermission)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbUserPermission */
   public void addTbUserPermission(TbUserPermission newTbUserPermission) {
      if (newTbUserPermission == null)
         return;
      if (this.tbUserPermission == null)
         this.tbUserPermission = new java.util.HashSet<TbUserPermission>();
      if (!this.tbUserPermission.contains(newTbUserPermission))
      {
         this.tbUserPermission.add(newTbUserPermission);
         newTbUserPermission.setTbUserRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbUserPermission */
   public void removeTbUserPermission(TbUserPermission oldTbUserPermission) {
      if (oldTbUserPermission == null)
         return;
      if (this.tbUserPermission != null)
         if (this.tbUserPermission.contains(oldTbUserPermission))
         {
            this.tbUserPermission.remove(oldTbUserPermission);
            oldTbUserPermission.setTbUserRole((TbUserRole)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbUserPermission() {
      if (tbUserPermission != null)
      {
         TbUserPermission oldTbUserPermission;
         for (java.util.Iterator iter = getIteratorTbUserPermission(); iter.hasNext();)
         {
            oldTbUserPermission = (TbUserPermission)iter.next();
            iter.remove();
            oldTbUserPermission.setTbUserRole((TbUserRole)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TbUser> getTbUser() {
      if (tbUser == null)
         tbUser = new java.util.HashSet<TbUser>();
      return tbUser;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTbUser() {
      if (tbUser == null)
         tbUser = new java.util.HashSet<TbUser>();
      return tbUser.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTbUser */
   public void setTbUser(java.util.Collection<TbUser> newTbUser) {
      removeAllTbUser();
      for (java.util.Iterator iter = newTbUser.iterator(); iter.hasNext();)
         addTbUser((TbUser)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTbUser */
   public void addTbUser(TbUser newTbUser) {
      if (newTbUser == null)
         return;
      if (this.tbUser == null)
         this.tbUser = new java.util.HashSet<TbUser>();
      if (!this.tbUser.contains(newTbUser))
      {
         this.tbUser.add(newTbUser);
         newTbUser.setTbUserRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTbUser */
   public void removeTbUser(TbUser oldTbUser) {
      if (oldTbUser == null)
         return;
      if (this.tbUser != null)
         if (this.tbUser.contains(oldTbUser))
         {
            this.tbUser.remove(oldTbUser);
            oldTbUser.setTbUserRole((TbUserRole)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTbUser() {
      if (tbUser != null)
      {
         TbUser oldTbUser;
         for (java.util.Iterator iter = getIteratorTbUser(); iter.hasNext();)
         {
            oldTbUser = (TbUser)iter.next();
            iter.remove();
            oldTbUser.setTbUserRole((TbUserRole)null);
         }
      }
   }

}
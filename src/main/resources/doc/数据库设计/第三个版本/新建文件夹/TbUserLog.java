/***********************************************************************
 * Module:  TbUserLog.java
 * Author:  Administrator
 * Purpose: Defines the Class TbUserLog
 ***********************************************************************/

import java.util.*;

/** 登录日志信息
 * 
 * @pdOid fd64feed-a12d-4459-89b2-2c276a883e7a */
public class TbUserLog {
   /** 编号
    * 
    * @pdOid b7003600-1fa6-4690-ac86-95323788f46c */
   public long id;
   /** 登录时间
    * 
    * @pdOid 4443b2c2-dd9f-47c4-b952-75f84bfeefdf */
   public java.util.Date time;
   
   /** @pdRoleInfo migr=no name=TbUser assc=reference1 mult=0..1 side=A */
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
            oldTbUser.removeTbUserLog(this);
         }
         if (newTbUser != null)
         {
            this.tbUser = newTbUser;
            this.tbUser.addTbUserLog(this);
         }
      }
   }

}
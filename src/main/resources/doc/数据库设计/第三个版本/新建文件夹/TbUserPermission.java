/***********************************************************************
 * Module:  TbUserPermission.java
 * Author:  Administrator
 * Purpose: Defines the Class TbUserPermission
 ***********************************************************************/

import java.util.*;

/** 权限
 * 
 * @pdOid 502dadeb-2cf4-4526-9df3-e1cf0c46854d */
public class TbUserPermission {
   /** 编号
    * 
    * @pdOid ed6ebadb-e251-47a1-9e00-c66abaf1dfa5 */
   public int id;
   /** 客户信息管理 
    * 
    * @pdOid ea3b7e0f-6995-43cf-87a5-c9f8d6845b8c */
   public int keHuGuanLi;
   /** 商品信息管理 
    * 
    * @pdOid 84720bd5-1032-428d-a944-981d5aea3479 */
   public int shangPinGuanLi;
   /** 供应商信息管理 
    * 
    * @pdOid 0609befc-7e07-46e8-a8ee-bd3f9eab3150 */
   public int gongYingShangGuanLi;
   /** 进货单 
    * 
    * @pdOid fac0fb25-5c10-4576-98aa-e346daaca164 */
   public int jinHuoDan;
   /** 进货退货 
    * 
    * @pdOid 46d349e7-f23b-4e26-ae22-e5128111979f */
   public int jinHuoTuiHuo;
   /**  销售单 
    * 
    * @pdOid 32930a18-616f-4ba4-9946-822df52ad299 */
   public int xiaoShouDan;
   /**  销售退货 
    * 
    * @pdOid dd78b3d4-f896-4a5a-9d8d-bad7e82b3327 */
   public int xiaoShouTuiHuo;
   /**  客户查询 
    * 
    * @pdOid 4affc172-bbee-4a18-b1b3-677a850e7e1c */
   public int keHuChaXun;
   /**  商品查询 
    * 
    * @pdOid 10a4384e-590a-40fa-8edd-b9798fabf1ac */
   public int shangPinChaXun;
   /**  供应商查询 
    * 
    * @pdOid a92c3504-467b-4a49-9823-10d52e29d7f2 */
   public int gongYingShangChaXun;
   /** 销售查询 
    * 
    * @pdOid ec2e1405-f510-4e56-9c01-8bf2583d2265 */
   public int xiaoShouChaXun;
   /** 销售退货查询
    * 
    * @pdOid c88dc0b0-4e21-4d74-8a7d-e8d83727fa64 */
   public int xiaoShouTuiHuoChaXun;
   /** 入货查询
    * 
    * @pdOid f01e0f06-0e40-42f3-8d4b-cacc340038c3 */
   public int ruKuChaXun;
   /** 入库退货查询
    * 
    * @pdOid a1d13f86-4006-4a6a-9a54-cc74eaa18ace */
   public int ruKuTuiHuoChaXun;
   /** 销售排行
    * 
    * @pdOid f4a0a8a0-fff4-4603-a009-e47536228a32 */
   public int xiaoShouPaiHang;
   /** 库存盘点
    * 
    * @pdOid af773e3f-59a7-4c6e-9524-4c94c6360e9e */
   public int kuCunPanDian;
   /** 价格调整
    * 
    * @pdOid c30da361-3280-44c6-ad5f-462d33de67f2 */
   public int jiaGeTiaoZheng;
   /** 操作员管理
    * 
    * @pdOid 61aa4aa0-a53a-438b-9ea3-2f3dab7d5b16 */
   public int caoZuoYuanGuanLi;
   /** 更改密码
    * 
    * @pdOid 19652713-ca7d-481e-8d34-ee265c772ab7 */
   public int gengGaiMiMa;
   /** 权限管理
    * 
    * @pdOid 4eff34ce-0e51-49bd-80d9-46a60de9dfdd */
   public int quanXianGuanLi;
   
   /** @pdRoleInfo migr=no name=TbUserRole assc=reference3 mult=0..1 side=A */
   public TbUserRole tbUserRole;
   
   
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
            oldTbUserRole.removeTbUserPermission(this);
         }
         if (newTbUserRole != null)
         {
            this.tbUserRole = newTbUserRole;
            this.tbUserRole.addTbUserPermission(this);
         }
      }
   }

}
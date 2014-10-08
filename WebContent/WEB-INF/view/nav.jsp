<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.PropertyResourceBundle"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%PropertyResourceBundle configBundle = (PropertyResourceBundle)PropertyResourceBundle.getBundle("configs/scm"); %>
   <ul class="nav nav-list"> 
      <li id="baseManage"><a href="#" class="dropdown-toggle"> <i class="icon-dashboard"></i> <span class="menu-text"> <%=configBundle.getString("baseManage") %></span><b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="KeHuGuanLi"><a href="coop/cZKs8DCjl7PhWwE5HP9FeA==.html"> <i class="icon-double-angle-right"></i><%=configBundle.getString("KeHuGuanLi") %> </a></li> 
        <li id="ShangPinGuanLi"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("ShangPinGuanLi") %> </a></li> 
        <li id="GongYingShangGuanLi"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("GongYingShangGuanLi") %> </a></li> 
       </ul></li> 
      <li id="stockManage"><a href="javascript:void()" class="dropdown-toggle"> <i class="icon-text-width"></i> <span class="menu-text"> <%=configBundle.getString("stockManage") %> </span><b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="JinHuoDan"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("JinHuoDan") %> </a></li> 
        <li id="JinHuoTuiHuo"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("JinHuoTuiHuo") %> </a></li> 
       </ul></li> 
      <li id="sellManage"><a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> <%=configBundle.getString("sellManage") %> </span> <b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="XiaoShouDan"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("XiaoShouDan") %> </a></li> 
        <li id="XiaoShouTuiHuo"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("XiaoShouTuiHuo") %> </a></li> 
       </ul></li> 
      <li id="searchStatistic"><a href="#" class="dropdown-toggle"> <i class="icon-list"></i> <span class="menu-text"> <%=configBundle.getString("searchStatistic") %> </span> <b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="KeHuChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("KeHuChaXun") %> </a></li> 
        <li id="ShangPinChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("ShangPinChaXun") %> </a></li> 
        <li id="GongYingShangChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("GongYingShangChaXun") %> </a></li> 
        <li id="XiaoShouChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("XiaoShouChaXun") %> </a></li> 
        <li id="XiaoShouTuiHuoChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("XiaoShouTuiHuoChaXun") %> </a></li> 
        <li id="RuKuChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("RuKuChaXun") %> </a></li> 
        <li id="RuKuTuiHuoChaXun"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("RuKuTuiHuoChaXun") %> </a></li> 
        <li id="XiaoShouPaiHang"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("XiaoShouPaiHang") %> </a></li> 
       </ul></li> 
      <li id="depotManage"><a href="#" class="dropdown-toggle"> <i class="icon-edit"></i> <span class="menu-text"> <%=configBundle.getString("depotManage") %> </span> <b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="KuCunPanDian"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("KuCunPanDian") %> </a></li> 
        <li id="JiaGeTiaoZheng"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("JiaGeTiaoZheng") %> </a></li> 
       </ul></li> 
      <li id="sysManage"><a href="#" class="dropdown-toggle"> <i class="icon-tag"></i> <span class="menu-text"> <%=configBundle.getString("sysManage") %> </span> <b class="arrow icon-angle-down"></b> </a> 
       <ul class="submenu"> 
        <li id="CaoZuoYuanGuanLi"><a href="coop/sys/caozuoyuanguanli.html/1/10"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("CaoZuoYuanGuanLi") %> </a></li> 
        <li id="GengGaiMiMa"><a href="javascript:void()"> <i class="icon-double-angle-right"></i><%=configBundle.getString("GengGaiMiMa") %> </a></li> 
        <li id="QuanXianGuanLi"><a href="javascript:void()"> <i class="icon-double-angle-right"></i> <%=configBundle.getString("QuanXianGuanLi") %> </a></li> 
       </ul></li> 
     </ul>
     <input type="hidden" id="active" value="${active }"/>
     <input type="hidden" id="baseActive" value="${baseActive }"/>
<!-- /.nav-list --> 
<script type="text/javascript">
//点击那个就激活那个。。
var result = $("#active").val();
var result2 = $("#baseActive").val();
$(document).ready(function() {
	$("li[id="+result2+"]").addClass("active open");
	$("li[id="+result+"]").addClass("active");
});
</script>
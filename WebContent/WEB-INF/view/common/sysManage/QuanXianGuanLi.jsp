<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jspf" %>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include> 
  <div class="main-container" id="main-container"> 
   <script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script> 
   <div class="main-container-inner"> 
    <a class="menu-toggler" id="menu-toggler" href="#"> <span class="menu-text"></span> </a> 
    <div class="sidebar" id="sidebar"> 
     <script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
	 </script>
	  <div class="sidebar-shortcuts" id="sidebar-shortcuts"> 
       <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large"> 
        <button class="btn btn-success" onclick="goPage('home.html')"><i class="icon-signal"></i></button> 
        <button class="btn btn-info" onclick="goPage('home.html')"> <i class="icon-pencil"></i></button> 
        <button class="btn btn-warning" onclick="goPage('home.html')"> <i class="icon-group"></i></button> 
        <button class="btn btn-danger" onclick="goPage('home.html')"> <i class="icon-cogs"></i></button> 
       </div><!--.sidebar-shortcuts-large  -->
       <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
           <span class="btn btn-success"></span>
           <span class="btn btn-info"></span>
           <span class="btn btn-warning"></span>
           <span class="btn btn-danger"></span>
      </div>
     </div><!--sidebar-shortcuts  -->
     <!-- 导航条 --> 
     <jsp:include page="/WEB-INF/view/nav.jsp"></jsp:include> 
     <div class="sidebar-collapse" id="sidebar-collapse"> 
      <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i> 
     </div> <!--.sidebar-collapse  -->
     <script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script> 
    </div> <!--.sidebar  -->
    <div class="main-content"> 
     <div class="breadcrumbs" id="breadcrumbs"> 
      <script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script> 
      <ul class="breadcrumb"> 
       <li><i class="icon-home home-icon"></i> <a href="home.html">首页</a></li> 
       <li><a href="admin/quanxianguanli.html">权限管理</a></li> 
      </ul> 
      <!-- .breadcrumb -->
     </div> 
     <div class="page-content"> 
      <div class="row"> 
       <div class="col-xs-12">
       <div class="space-6"></div>
         <div class="row">
         </div><!--.row  -->
       </div> <!-- .col-xs-12 -->
      </div> <!-- /.row --> 
     </div> <!-- /.page-content --> 
    </div> <!-- /.main-content --> 
    <script type="text/javascript">
    </script> 
    <!-- 工具导入 --> 
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include>
    <!-- /#ace-settings-container --> 
   </div><!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>
 </body>
</html>
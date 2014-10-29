<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
       <button class="btn btn-success"> <i class="icon-signal"></i> </button> 
       <button class="btn btn-info"> <i class="icon-pencil"></i> </button> 
       <button class="btn btn-warning"> <i class="icon-group"></i> </button> 
       <button class="btn btn-danger"> <i class="icon-cogs"></i> </button> 
      </div> 
      <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini"> 
       <span class="btn btn-success"></span> 
       <span class="btn btn-info"></span> 
       <span class="btn btn-warning"></span> 
       <span class="btn btn-danger"></span> 
      </div> 
     </div> 
     <!-- #sidebar-shortcuts --> 
     <!-- 导航条 --> 
     <jsp:include page="/WEB-INF/view/nav.jsp"></jsp:include> 
     <div class="sidebar-collapse" id="sidebar-collapse"> 
      <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i> 
     </div> 
     <script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script> 
    </div> 
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
       <li><a href="coop/kehuguanli.html">客户信息管理</a></li> 
      </ul> 
      <!-- .breadcrumb -->
     </div> 
     <div class="page-content"> 
      <div class="row"> 
       <div class="col-xs-12"> 
        <h3 class="header smaller lighter blue"> 
          <button id="bt-add-dialog" class="btn btn-success" data-toggle="modal"  data-target="#add-dialog-message"><i class="icon-plus-sign align-top bigger-125"></i>添加 </button> 
          <jsp:include page="KeHuGuanLi_add.jsp"></jsp:include>
          <button id="bt-edit-dialog" class="btn btn-primary" data-toggle="modal"  data-target="#edit-dialog-message"><i class="icon-edit align-top bigger-125"></i>修改</button>
          <jsp:include page="KeHuGuanLi_edit.jsp"></jsp:include> 
          <button id="bt-delete-dialog" class="btn btn-danger" data-toggle="modal"  data-target="#delete-dialog-message"><i class="icon-trash align-top bigger-125"></i>删除 </button> 
         <jsp:include page="KeHuGuanLi_delete.jsp"></jsp:include> </h3> 
        <div class="table-header">
          所有信息 
        </div> 
        <div class="table-responsive"> 
         <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
            <div class="row" >
            <div class="col-sm-6"><div id="pager"  ><label style="color:rgb(66, 139, 202)">显示 <select size="1" onchange="javascript:gotoPage(1)" id="p_pageSizeSelect">
              <option value="10" selected="selected" >10</option>
              <option value="25" >25</option>
              <option value="50" >50</option>
              <option value="100" >100</option></select>记录</label></div ><!--#page  -->
            </div>
            <div id="pages"></div>
           </div><!--.row  -->
          <form action="coop/pageOfCustomers" id="queryform" method="get">
            <!-- 显示列表数据 --> 
            <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info"> 
             <thead> 
              <tr role="row"> 
               <th role="columnheader" rowspan="1" colspan="1" style="width: 57px;" aria-label=""> <label> <input type="checkbox" class="ace" /> <span class="lbl"></span> </label> </th> 
               <th  role="columnheader"  rowspan="1" colspan="1" style="width: 20px;" >序号</th>
               <th  role="columnheader"  rowspan="1" colspan="1" style="width: 153px;" >名称</th> 
               <th role="columnheader"  rowspan="1" colspan="1" style="width: 133px;" >地址</th> 
               <th role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" > <i class="icon-time bigger-110 hidden-480"></i> 邮箱地址 </th> 
               <th  role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" >联系电话 </th> 
               <th  role="columnheader" rowspan="1" colspan="1" style="width: 156px;" aria-label="">操作</th> 
              </tr> 
             </thead> 
             <tbody role="alert" aria-live="polite" aria-relevant="all"  id="tb">
             </tbody> 
            </table>
           </form>
           <div class="row" ><div class="col-sm-6"  id="other"></div></div><!--.row  -->
         </div>
        </div> 
       </div> 
       <!-- /.col --> 
      </div> 
      <!-- /.row --> 
     </div> 
     <!-- /.page-content --> 
    </div> 
    <!-- /.main-content --> 
    <script type="text/javascript">
	jQuery(function($) {
		/* 获取数据 */
		gotoPage(1);
		/* 复选框操作 */
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
	});
</script> 
    <!-- 工具导入 --> 
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include> 
    <!-- /#ace-settings-container --> 
   </div> 
   <!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>  
 </body>
</html>
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
       <li><a href="coop/kehuguanli.html/1/10">客户信息管理</a></li> 
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
           <div class="row">
            <tags:pager pagerRange="6"  totalElement="${allCustomerInfo.totalElement }" pageSize="${allCustomerInfo.pageSize}"  totalPage="${allCustomerInfo.totalPage}" currentPage="${allCustomerInfo.currentPage}" formId="queryForm"></tags:pager>
          </div><!--.row  -->
          <form action="coop/kehuguanli.html" id="queryform" method="get">
            <!-- 显示列表数据 --> 
            <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info"> 
             <thead> 
              <tr role="row"> 
               <th role="columnheader" rowspan="1" colspan="1" style="width: 57px;" aria-label=""> <label> <input type="checkbox" class="ace" /> <span class="lbl"></span> </label> </th> 
               <th  role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 57px;" >序号</th>
               <th  role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 122px;" >名称</th> 
               <th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 133px;" >地址</th> 
               <th role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 193px;" > <i class="icon-time bigger-110 hidden-480"></i> 邮箱地址 </th> 
               <th  role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" style="width: 170px;" >联系电话 </th> 
               <th  role="columnheader" rowspan="1" colspan="1" style="width: 156px;" aria-label=""></th> 
              </tr> 
             </thead> 
             <tbody role="alert" aria-live="polite" aria-relevant="all">
               <c:forEach items="${allCustomerInfo.content}" var="list" varStatus="status">
                 <tr> 
                 <td ><label> <input type="checkbox" class="ace" /> <span class="lbl"></span> </label></td> 
                 <td >${ status.index + 1}</td> 
                 <td >${list.name }</td> 
                 <td >${list.address }</td> 
                 <td >${list.email}</td> 
                 <td ><span class="label label-sm label-success">${list.telephone }</span></td> 
                 <td > 
                  <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons"> 
                   <a class="blue" href="#"> <i class="icon-zoom-in bigger-130"></i> </a> 
                   <a class="green" href="#"> <i class="icon-pencil bigger-130"></i> </a> 
                   <a class="red" href="#"> <i class="icon-trash bigger-130"></i> </a> 
                  </div> 
                  <div class="visible-xs visible-sm hidden-md hidden-lg"> 
                   <div class="inline position-relative"> 
                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button> 
                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close"> 
                     <li><a href="#" class="tooltip-info" data-rel="tooltip" title="" data-original-title="View"> <span class="blue"> <i class="icon-zoom-in bigger-120"></i> </span> </a></li> 
                     <li><a href="#" class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a></li> 
                     <li><a href="#" class="tooltip-error" data-rel="tooltip" title="" data-original-title="Delete"> <span class="red"> <i class="icon-trash bigger-120"></i> </span> </a></li> 
                    </ul> 
                   </div> 
                  </div> </td> 
                </tr> 
               </c:forEach>
             </tbody> 
            </table>
           </form>
           <div class="row">
            <tags:pager pagerRange="6"  totalElement="${allCustomerInfo.totalElement }" pageSize="${allCustomerInfo.pageSize}"  totalPage="${allCustomerInfo.totalPage}" currentPage="${allCustomerInfo.currentPage}" formId="queryForm"></tags:pager>
          </div><!--.row  -->
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
		
		var oTable1 = $('#sample-table-2').dataTable( {
		"aoColumns": [
	      { "bSortable": false },
	      null, null,null, null, null,
		  { "bSortable": false }
		] } );
		
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
		
		$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
			var off2 = $source.offset();
			var w2 = $source.width();
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		}
		
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
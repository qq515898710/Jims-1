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
       <li><a href="coop/shangpinchaxun.html">商品查询</a></li> 
      </ul> 
      <!-- .breadcrumb -->
     </div> 
     <div class="page-content">
     <div class="page-header fixed-div">
        <p><lable>商品名称或简称：</lable><input type="text" id="name"/></p>
        <p>
          <lable>录入时间：</lable>
          <input type="text" id="beginTime" class="date-picker" data-date-format="yyyy-mm-dd" />
          &nbsp;到&nbsp;
          <input type="text" id="endTime" class="date-picker" data-date-format="yyyy-mm-dd"/>
        </p>
        <p>
          <button class="btn btn-primary btn-sm" id="search"><i class="icon-search align-top bigger-125"></i>查询</button>
          <button class="btn btn-success btn-sm" id="search-all"><i class="icon-search align-top bigger-125"></i>查询全部</button>
        </p>
      </div><!--.page-header  -->
      <div class="row"> 
       <div class="col-xs-12">
       <div class="space-6"></div>
       <div id="alert"></div>
         <div id="table-result">
           <div class="table-header">所有信息 </div>
           <div class="table-responsive">
             <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
               <div class="row">
                 <div class="col-sm-6">
                   <div id="pager">
                     <label>显示 
                       <select size="1" onchange="javascript:gotoPage(1,'name=&beginTime=&endTime=')" id="p_pageSizeSelect">
                         <option value="10" selected="selected">10</option>
                         <option value="25">25</option>
                         <option value="50">50</option>
                         <option value="100">100</option>
                       </select>记录
                     </label>
                   </div><!--#page  -->
                 </div><!--.col-sm-6  -->
                 <div id="pages"></div>
               </div><!--.row  -->
               <!-- 显示列表数据 -->
               <table id="table" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
                 <thead>
                   <tr role="row">
                     <th role="columnheader" rowspan="1" colspan="1" style="width: 57px;" aria-label=""> <label> <input type="checkbox" class="ace"  id="checkall"/> <span class="lbl"></span> </label> </th> 
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 50px;" >序号</th>
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 153px;" >名称</th> 
                     <th role="columnheader"  rowspan="1" colspan="1" style="width: 133px;" >产地</th> 
                     <th role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" > <i class="icon-time bigger-110 hidden-480"></i>录入时间</th> 
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" >包装 </th> 
                     <th  role="columnheader" rowspan="1" colspan="1" style="width: 156px;" aria-label="">操作</th>
                   </tr>
                 </thead>
                 <tbody role="alert" aria-live="polite" aria-relevant="all"  id="tb">
               </table><!--#table  -->
               <div class="row" ><div class="col-sm-6"  id="other"></div></div><!--.row  -->
             </div><!--.dataTables_wrapper  -->
           </div><!--.table-responsive  -->
         </div><!--.table-result  -->
       </div> <!-- .col-xs-12 -->
      </div> <!-- /.row --> 
     </div> <!-- /.page-content --> 
    </div> <!-- /.main-content --> 
    <script type="text/javascript">
    jQuery(function($) {

	    $("#search").click(function () {
           var searchName=$("#name").val();
           var beginTime=$("#beginTime").val();
           var endTime=$("#endTime").val();
           gotoPage(1,"name="+searchName+"&beginTime="+beginTime+"&endTime="+endTime);
	    });
	    
	    $("#search-all").click(function () {
	    	gotoPage(1,'name=&beginTime=&endTime=');
	    });
	    
        gotoPage(1,'name=&beginTime=&endTime=');
		
	    $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){   
	    });
		   
		/* 复选框操作 */
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
		
		$(document).keydown(function(event){
			if(event.keyCode==13){//enter键
			    $("#search").click();
			}
		});
	});

    //分页显示工具
	function gotoPage(pageIndex, cond) {
		var pagerRange = 6;//
		var pageSize =  $("#p_pageSizeSelect").val(); //获取每一页显示多少记录
		var loc="<div class='col-sm-6'><div class='dataTables_paginate paging_bootstrap'><ul class='pagination'>";
		$('#tb').html("");
		//TODO 测试用
		//alert("page=" + pageIndex + "&size=" + pageSize+"&"+cond);
		$.ajax({
					url : "coop/pageOfGoodsByCriteria",
					type : 'get',
					data : "page=" + pageIndex + "&size=" + pageSize+"&"+cond,
					aysnc : false,
					beforeSend:function(XMLHttpRequest){
						  //TODO 测试用
			              //alert('远程调用开始...');
			              $("#table-result").showLoading();
			         },
					success : function(msg) {
						if(msg.totalElement == 0){
							$('#tb').append("<tr><td colspan=7><div class='alert alert-block alert-danger'><div class='danger bold-center'>没结果</div><div></td></tr>");
							$('#pages').html("");
							$("#other").html("");
						}else{
							$.each(msg.content, function(i, item) {
					              $('#tb').append( "<tr>"
					            		  +"<td><label> <input type='checkbox' class='ace' name='checkbox' value='"+item.id+"' /><span class='lbl'></span> </label></td>"
					            		  +"<td >"+(++i)+"</td> "
					            		  +"<td >"+item.name+"</td> "
					            		  +"<td >"+item.origin+"</td> "
					            		  +"<td >"+getFormatDateByLong(item.time,"yyyy-MM-dd")+"</td> "
					            		  +"<td >"+item.pack+"</td> "
					            		  +"<td >"+"<div class='visible-md visible-lg hidden-sm hidden-xs action-buttons' id='buttontools'>"
					            		  				+"<a class='blue' href='javascript:show(\""+item.id+"\")'> <i class='icon-zoom-in bigger-130'></i>"
					            		  				+"<a class='green' href='javascript:edit(\""+item.id+"\")' > <i class='icon-pencil bigger-130'></i> </a>"
					            		  				+"<a class='red' href='javascript:delete(\""+item.id+"\")' > <i class='icon-trash bigger-130'></i> </a>"
					            		  				+"</td> "+"</tr>");
					            });
								var begin = Math.max(1, msg.currentPage - pagerRange/2 );
								var end = Math.min(begin + (pagerRange - 1), msg.totalPage);
								if(msg.currentPage !=1){
									loc+="<li class='prev '><a href='javascript:gotoPage(1,\""+cond+"\")'><i class=' icon-double-angle-left '></i></a></li><li class='prev '><a href='javascript:gotoPage("+(msg.currentPage - 1)+",\""+cond+"\")'><i class=' icon-angle-left '></i></a></li>";
								}else{
									loc+="<li class='prev disabled'><a href='javascript:void(0)'><i class=' icon-double-angle-left '></i></a></li><li class='prev disabled'><a href='javascript:void(0)'><i class=' icon-angle-left '></i></a></li>";
								}
								for(var i = begin; i <= end; i++){
									if(msg.currentPage == i){
										loc+="<li class='active'><a href='javascript:void(0)'>"+i+"</a></li>"
									}else{
										loc+="<li><a href='javascript:gotoPage("+i +",\""+cond+"\")' >"+i+"</a></li>"
									}
								}
								if(msg.currentPage!=msg.totalPage){
									loc+="<li class='next'><a href='javascript:gotoPage("+(msg.currentPage + 1)+",\""+cond+"\")'><i class='icon-angle-right '></i></a></li><li class='next '><a href='javascript:gotoPage("+msg.totalPage+",\""+cond+"\")'><i class='icon-double-angle-right '></i></a></li>";
								}else{
									loc+="<li class='next disabled'><a href='javascript:void(0)'><i class='icon-angle-right '></i></a></li><li class='next disabled'><a href='javascript:void(0)'><i class='icon-double-angle-right '></i></a></li>";
								}
								loc+="</ul></div></div>";
								$('#pages').html(loc);
								$("#other").html('<a href="javascript:gotoPage(1,\'name=&beginTime=&endTime=\')" ><i class="icon-refresh"></i></a>&nbsp;|&nbsp;<label >共 '+msg.totalElement+' 记录&nbsp;|&nbsp;共 '+msg.totalPage +' 页</label>');
						}
						$("#table-result").hideLoading();
					},
					complete:function(XMLHttpRequest,textStatus){
						  //TODO 测试用
			              // alert('远程调用成功，状态文本值：'+textStatus);
						$("#table-result").hideLoading();
			         },
			         error:function(XMLHttpRequest,textStatus,errorThrown){
			              alert('error...状态文本值：'+textStatus+" 异常信息："+errorThrown);
			              $("#table-result").hideLoading();
			          }
				});
	}

	function show(id){
		var searchId=id;
		$.ajax({
		    type: "POST", 
		    url: "coop/searchGoodById", 
		    data: "searchId=" + searchId, 
		    dataType: "json",
			beforeSend:function(XMLHttpRequest){
				  //TODO 测试用
	            //alert('远程调用开始...');
	            $("#table-result").showLoading();
	        },
		    success: function (data){
		    	if(data.name != null && data.name != ''){
		    		$("#detailed-name").html(data.name);
		    	}else{
		    		$("#detailed-name").html('未知');
		    	}
		    	if(data.abbreviation != null && data.abbreviation != ''){
		    		$("#detailed-abbreviation").html(data.abbreviation);
		    	}else{
		    		$("#detailed-abbreviation").html('未知');
		    	}
		    	if(data.origin != null && data.origin != ''){
		    		$("#detailed-origin").html(data.origin);
		    	}else{
		    		$("#detailed-origin").html('未知');
		    	}
		    	if(data.units!=null && data.units!=''){
		    		$("#detailed-units").html(data.units);
		    	}else{
		    		$("#detailed-units" ).html('未知');
		    	}
		    	if(data.pack!=null && data.pack!=''){
		    		$("#detailed-pack").html(data.pack);
		    	}else{
		    		$("#detailed-pack").html('未知');
		    	}
		    	if(data.approvalNum!=null && data.approvalNum!=''){
		    		$("#detailed-approvalNum").html(data.approvalNum);
		    	}else{
		    		$("#detailed-approvalNum").html('未知');
		    	}
		    	if(data.batchNum!=null && data.batchNum!=''){
		    		$("#detailed-batchNum").html(data.batchNum);
		    	}else{
		    		$("#detailed-batchNum").html('未知');
		    	}
		    	if(data.memo!=null && data.memo!=''){
		    		$("#detailed-memo").html(data.memo);
		    	}else{
		    		$("#detailed-memo").html('未知');
		    	}
		    	$("#table-result").hideLoading();
		    },
			complete:function(XMLHttpRequest,textStatus){
				  //TODO 测试用
	            // alert('远程调用成功，状态文本值：'+textStatus);
				$("#table-result").hideLoading();
	       },
	       error:function(XMLHttpRequest,textStatus,errorThrown){
	            alert('error...状态文本值：'+textStatus+" 异常信息："+errorThrown);
	            $("#table-result").hideLoading();
	        }
		});
		$('#detailed-dialog-message').modal('show');
	}
    </script>
    <jsp:include page="/WEB-INF/view/coop/baseManage/ShangPinGuanLi_detailed.jsp"></jsp:include>
    <!-- 工具导入 --> 
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include>
    <!-- /#ace-settings-container --> 
   </div><!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>
 </body>
</html>
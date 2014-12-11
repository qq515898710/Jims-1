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
       <li><a href="coop/rukutuihuochaxun.html">进货退货查询</a></li> 
      </ul> 
      <!-- .breadcrumb -->
     </div> 
     <div class="page-content">
      <div class="page-header fixed-div">
        <p>
          <lable>供应商名称：</lable><input type="text" id="providername"/>
          <lable>商品名称：</lable><input type="text" id="goodname"/>
          <lable>操作员：</lable><input type="text" id="username"/>
        </p>
        <p>
          <lable>录入时间：</lable>
          <input type="text" id="beginTime" class="date-picker" data-date-format="yyyy-mm-dd" />
          &nbsp;到&nbsp;
          <input type="text" id="endTime" class="date-picker" data-date-format="yyyy-mm-dd"/>
        </p>
        <p>
          <button class="btn btn-primary btn-sm" id="search"><i class="icon-search align-top bigger-125"></i>查询</button>
          <button class="btn btn-success btn-sm" id="search-all"><i class="icon-search align-top bigger-125"></i>查询全部</button>
          <button class="btn btn-success btn-sm" ><i class="icon-undo align-top bigger-125"></i>重置</button>
          <button class="btn btn-success btn-sm" ><i class="icon-print align-top bigger-125"></i>打印</button>
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
                       <select size="1" onchange="javascript:gotoPage(1,'goodname=&providername=&username=&beginTime=&endTime=')" id="p_pageSizeSelect">
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
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 153px;" >供应商名称</th> 
                     <th role="columnheader"  rowspan="1" colspan="1" style="width: 133px;" >商品名称</th> 
                     <th role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" > <i class="icon-time bigger-110 hidden-480"></i>录入时间</th> 
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 100px;" >数量 </th>
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 100px;" >总价(元) </th>
                     <th  role="columnheader"  rowspan="1" colspan="1" style="width: 100px;" >状态 </th>
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
           var goodName=$("#goodname").val();
           var providerName=$("#providername").val();
           var userName=$("#username").val();
           var beginTime=$("#beginTime").val();
           var endTime=$("#endTime").val();
           gotoPage(1,"goodname="+goodName+"&providername="+providerName+"&username="+userName+"&beginTime="+beginTime+"&endTime="+endTime);
	    });
	    
	    $("#search-all").click(function () {
	    	gotoPage(1,'goodname=&providername=&username=&beginTime=&endTime=');
	    });
	    
        gotoPage(1,'goodname=&providername=&username=&beginTime=&endTime=');
		
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
					url : "coop/pageOfStockReturn",
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
							$('#tb').append("<tr><td colspan=9><div class='alert alert-block alert-danger'><div class='danger bold-center'>没结果</div><div></td></tr>");
							$('#pages').html("");
							$("#other").html("");
						}else{
							$.each(msg.content, function(i, item) {
								 var state;
								 if(item.approval == "NOPASS"){
									 state = "<span class='label label-sm label-warning'>未通过</span>";
								 }else if(item.approval == "PASS"){
									 state = "<span class='label label-sm label-success'>通过</span>";
								 }
					              $('#tb').append( "<tr>"
					            		  +"<td><label> <input type='checkbox' class='ace' name='checkbox' value='"+item.id+"' /><span class='lbl'></span> </label></td>"
					            		  +"<td >"+(++i)+"</td> "
					            		  +"<td >"+item.providerInfo.name+"</td> "
					            		  +"<td >"+item.goodInfo.name+"</td> "
					            		  +"<td >"+getFormatDateByLong(item.time,"yyyy-MM-dd")+"</td> "
					            		  +"<td >"+item.amount+"</td> "
					            		  +"<td >"+item.sum+"</td> "
					            		  +"<td >"+state+"</td> "
					            		  +"<td >"+"<div class='visible-md visible-lg hidden-sm hidden-xs action-buttons' id='buttontools'>"
					            		  				+"<a class='blue' href='javascript:show(\""+item.id+"\")'> <i class='icon-zoom-in bigger-130'></i>"
					            		  				+"<a class='green' href='javascript:edit(\""+item.id+"\")' > <i class='icon-pencil bigger-130'></i> </a>"
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
								$("#other").html('<a href="javascript:gotoPage(1,\'goodname=&providername=&username=&beginTime=&endTime=\')" ><i class="icon-refresh"></i></a>&nbsp;|&nbsp;<label >共 '+msg.totalElement+' 记录&nbsp;|&nbsp;共 '+msg.totalPage +' 页</label>');
						}
						$("#table-result").hideLoading();
					},
					complete:function(XMLHttpRequest,textStatus){
						  //TODO 测试用
			              // alert('远程调用成功，状态文本值：'+textStatus);
						$("#table-result").hideLoading();
			         },
			         error:function(XMLHttpRequest,textStatus,errorThrown){
			              alert('error...状态文本值：'+XMLHttpRequest+" 异常信息："+textStatus);
			              $("#table-result").hideLoading();
			          }
				});
	}

	function show(id){
		var searchId=id;
		$.ajax({
		    type: "POST", 
		    url: "coop/searchstockreturnbyid", 
		    data: "searchId=" + searchId, 
		    dataType: "json",
			beforeSend:function(XMLHttpRequest){
				  //TODO 测试用
	            //alert('远程调用开始...');
	            $("#table-result").showLoading();
	        },
		    success: function (data){
			    console.info(data);
				 var state;
				 if(data.approval == "NOPASS"){
					 state = "未通过";
				 }else if(data.approval == "PASS"){
					 state = "通过";
				 }
			    console.info(data.providerInfo.name);
		    	$("#detailed-providername").html(data.providerInfo.name);
		    	$("#detailed-goodname").html(data.goodInfo.name);
		    	$("#detailed-unitCost").html(data.unitCost);
		    	$("#detailed-amount").html(data.amount);
		    	$("#detailed-sum").html(data.sum);
		    	$("#detailed-state").html(state);
		    	$("#detailed-checkConclusion").html(data.checkConclusion);
		    	$("#detailed-time").html(getFormatDateByLong(data.time,"yyyy-MM-dd"));
		    	$("#detailed-clearingForm").html(data.clearingForm);
		    	$("#detailed-handler").html(data.handler);
		    	$("#detailed-username").html(data.user.username);
		    },
			complete:function(XMLHttpRequest,textStatus){
				  //TODO 测试用
	            // alert('远程调用成功，状态文本值：'+textStatus);
				$("#table-result").hideLoading();
	       },
	       error:function(XMLHttpRequest,textStatus,errorThrown){
	            alert('error...状态文本值：'+XMLHttpRequest+" 异常信息："+errorThrown);
	            $("#table-result").hideLoading();
	        }
		});
		$('#detailed-dialog-message').modal('show');
	}

	function edit(id) {
		var searchId=id;
		$("#alert").html("");
		$.ajax({
		    type: "POST", 
		    url: "coop/searchstockreturnbyid", 
		    data: "searchId=" + searchId, 
		    dataType: "json", 
		    success: function (data){
				 $("#edit-id").attr("value",data.id);
				 $("#edit-goodname").attr("value",data.goodInfo.name);
				 $("#edit-unitCost").attr("value",data.unitCost);
				 $("#edit-amount").attr("value",data.amount);
				 $("#edit-sum").attr("value",data.sum);
				 var state;
				 if(data.approval == "NOPASS"){
					 state = "<div class=\"radio\">"+
					     "<label><input name=\"form-field-radio\" type=\"radio\" class=\"ace\" value=\"1\" checked />"+
					     "<span class=\"lbl\">未通过</span></label></div>"+
					     "<div class=\"radio\">"+
					     "<label><input name=\"form-field-radio\" type=\"radio\" class=\"ace\" value=\"0\" />"+
					     "<span class=\"lbl\">通过</span></label></div>";
				 }else if(data.approval == "PASS"){
					 $("#edit-ok").addClass("disabled");
					 state = "<label><input name=\"form-field-radio\" type=\"radio\" class=\"ace\" value=\"0\" checked />"+
				     "<span class=\"lbl\">通过</span></label></div>";
				 }
				 $("#field-div").html(state);
			}
		 });
		$("#alert").html("");
		$('#edit-dialog-message').modal('show');
	}
    </script> 
    <!-- 工具导入 --> 
    <jsp:include page="RuKuTuiHuoChaXun_detail.jsp"></jsp:include>
    <jsp:include page="RuKuTuiHuoChaXun_edit.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include>
    <!-- /#ace-settings-container --> 
   </div><!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>
 </body>
</html>
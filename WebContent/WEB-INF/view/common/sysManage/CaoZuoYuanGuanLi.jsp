<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
       <li><a href="admin/caozuoyuanguanli.html">操作员管理</a></li> 
      </ul> 
      <!-- .breadcrumb --> 
      <!-- 可添加div--> 
     </div> 
     <div class="page-content"> 
      <div class="row"> 
       <div class="col-xs-12"> 
        <div class="page-header fixed-div">
          <p>
            <label>帐号：</label><input type="text" id="search-account">&nbsp;
            <label>姓名：</label><input type="text" id="search-username">
          </p>
          <button id="search" class="btn hide-option btn-sm" data-toggle="modal"  data-target="#search-dialog-message" title="查找"><i class="icon-search align-top bigger-125"></i>查找 </button>
          <button id="bt-add-dialog" class="btn btn-success hide-option btn-sm" data-toggle="modal"  data-target="#add-dialog-message" title="添加"><i class="icon-plus-sign align-top bigger-125"></i>添加 </button>
          <tags:caozuoyuan_add></tags:caozuoyuan_add>
          <button id="bt-edit-dialog" class="btn btn-primary btn-sm" title="修改"><i class="icon-edit align-top bigger-125"></i>修改密码</button>
          <jsp:include page="CaoZuoYuanGuanLi_edit.jsp"></jsp:include>
          <jsp:include page="CaoZuoYuanGuanLi_alter.jsp"></jsp:include>
          <jsp:include page="CaoZuoYuanGuanLi_detailed.jsp"></jsp:include>
          <jsp:include page="CaoZuoYuanGuanLi_delete.jsp"></jsp:include>
          <button id="bt-delete-dialog" class="btn btn-danger btn-sm" title="删除"><i class="icon-trash align-top bigger-125"></i>删除 </button>
          <button id="bt-import-dialog" class="btn btn-purple btn-sm" title="模版execl表格导入,点&lt;更多&gt;下载 " ><i class=" icon-cloud-upload align-top bigger-125"></i>导入 </button>  
          <button id="bt-outport-dialog" class="btn btn-grey btn-sm" title="导出"><i class="icon-cloud-download align-top bigger-125"></i>导出 </button>  
          <div class="btn-group"> 
            <button data-toggle="dropdown" class="btn btn-pink dropdown-toggle btn-sm2 "><i class="icon-stackexchange" ></i> 更多<i class="icon-angle-down icon-on-right"></i></button> 
              <ul class="dropdown-menu"> 
                <li> <a href="#"><i class="icon-print"></i> 打印</a> </li> 
                <li class="divider"></li> 
                <li> <a href="#"><i class="icon-long-arrow-down"></i> 模版表格下载</a> </li> 
              </ul> 
           </div>
       </div> <!--.page-header fixed-div  -->
       <div id="c-alert"></div>
         <div id="table-result">
          <div class="table-header">
            所有信息 
          </div> 
          <div class="table-responsive"> 
           <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
              <div class="row" >
              <div class="col-sm-6"><div id="pager"  ><label >显示 <select size="1" onchange="javascript:gotoPage(1,'account=&username=')" id="p_pageSizeSelect">
                <option value="10" selected="selected" >10</option>
                <option value="25" >25</option>
                <option value="50" >50</option>
                <option value="100" >100</option></select>记录</label></div ><!--#page  -->
              </div>
              <div id="pages"></div>
             </div><!--.row  -->
            <form>
              <!-- 显示列表数据 --> 
              <table id="table" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info"> 
               <thead> 
                <tr role="row"> 
                 <th role="columnheader" rowspan="1" colspan="1" style="width: 57px;" aria-label=""> <label> <input type="checkbox" class="ace" id="checkall"/> <span class="lbl"></span> </label> </th> 
                 <th  role="columnheader"  rowspan="1" colspan="1" style="width: 50px;" >序号</th>
                 <th  role="columnheader"  rowspan="1" colspan="1" style="width: 153px;" >帐号</th> 
                 <th role="columnheader"  rowspan="1" colspan="1" style="width: 133px;" >姓名</th> 
                 <th role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" > <i class="icon-time bigger-110 hidden-480"></i>录入时间</th> 
                 <th  role="columnheader"  rowspan="1" colspan="1" style="width: 130px;" >角色 </th> 
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
       </div> <!-- .col-xs-12 -->
       <!-- /.col --> 
      </div> 
      <!-- /.row --> 
     </div> 
     <!-- /.page-content --> 
    </div> 
    <!-- /.main-content --> 
    <script type="text/javascript">
    
    var rolealterarray;
    
	jQuery(function($) {
		
		$("#search").click(function () {
           var account = $("#search-account").val();
           var username = $("#search-username").val();
           gotoPage(1,"account="+account+"&username="+username);
        });
		
		/* 获取数据 */
		gotoPage(1,"account=&username=");
		
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

	function edit(id){
		var searchId=id;
		$.ajax({
		    type: "POST", 
		    url: "admin/searchuserbyid", 
		    data:"searchId=" + searchId, 
		    dataType: "json", 
		    success: function (data){
				$("#alter-account").attr("value",data.account);
				$("#alter-username").attr("value",data.username);
				console.info(data.role);
				rolealterarray = data.role;
				console.info("rolealterarray"+rolealterarray);
				$.get("admin/rolelist", function(result){
					var str="";
					if(rolealterarray.length == 0){
						for(var i = result.length - 1 ; i > 0; i--){
							str += "<div class='inline'>"+
							  "<input type='checkbox' id='alter-role' name='alter-role' class='ace' value="+result[i].name+" />"+
							  "<span class='lbl'>"+result[i].description+"</span></div>";
						}
						str += "<div class='inline'>"+
						  "<input type='checkbox' id='alter-role' name='alter-role' class='ace' value="+result[0].name+" />"+
						  "<span class='lbl'>"+result[0].description+"</span></div>";
						$("#alterrole").html(str);
					}else{
						for(var i = result.length - 1 ; i > 0; i--){
							var innerstr="";
							for(var j = rolealterarray.length - 1; j >= 0; j--){
								console.info("进入"+innerstr);
								if(result[i].description == rolealterarray[j].description){
									innerstr = "<div class='inline'>"+
									  "<input type='checkbox' id='alter-role' name='alter-role' class='ace' value="+result[i].name+" checked />"+
									  "<span class='lbl'>"+result[i].description+"</span></div>";
									console.info("if"+innerstr);
									break;
								}else{
									innerstr = "<div class='inline'>"+
									  "<input type='checkbox' id='alter-role' name='alter-role' class='ace' value="+result[i].name+" />"+
									  "<span class='lbl'>"+result[i].description+"</span></div>";
									console.info("else"+innerstr);
								}
							}
							str += innerstr;
						}
						innerstr="";
						for(var j = rolealterarray.length - 1; j >= 0; j --){
							if(result[0].description == rolealterarray[j].description){
								innerstr = "<div class='inline'>"+
								  "<input type='checkbox' onclick='ckalterfunction(this)' id='alter-role-all' name='alter-role' class='ace' value="+result[0].name+" checked />"+
								  "<span class='lbl'>"+result[0].description+"</span></div>";
								console.info("if"+innerstr);
								break;
							}else{
								innerstr = "<div class='inline'>"+
								  "<input type='checkbox' onclick='ckalterfunction(this)' id='alter-role-all' name='alter-role' class='ace' value="+result[0].name+" />"+
								  "<span class='lbl'>"+result[0].description+"</span></div>";
								console.info("else"+innerstr);
							}
						}
						str += innerstr;
						$("#alterrole").html(str);
					}
			 	});
			}
		 });
		$("#alert").html("");
	    $('#alter-dialog-message').modal('show');
	}
	
	//分页显示工具
	function gotoPage(pageIndex, cond) {
		var action = 'admin/pageofuserlist';
		var pagerRange = 6;//
		var pageSize =  $("#p_pageSizeSelect").val(); //获取每一页显示多少记录
		var loc="<div class='col-sm-6'><div class='dataTables_paginate paging_bootstrap'><ul class='pagination'>";
		$('#tb').html("");
		//TODO 测试用
		$.ajax({
			url : action,
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
						  var array = new Array();
						  //console.info(item.role);
					      for(var j = item.role.length - 1; j >= 0; j--){
						      //TODO  测试
					    	  array.push(item.role[j].description);
						  }
			              $('#tb').append( "<tr>"
			            		  +"<td><label> <input type='checkbox' class='ace' name='checkbox' value='"+item.account+"' /><span class='lbl'></span> </label></td>"
			            		  +"<td >"+(++i)+"</td> "
			            		  +"<td >"+item.account+"</td> "
			            		  +"<td >"+item.username+"</td> "
			            		  +"<td >"+getFormatDateByLong(item.createDate,"yyyy-MM-dd")+"</td> "
			            		  +"<td >"+array.join(',')+"</td> "
			            		  +"<td >"+"<div class='visible-md visible-lg hidden-sm hidden-xs action-buttons' id='buttontools'>"
			            		  				+"<a class='blue' href='javascript:show(\""+item.account+"\")'> <i class='icon-zoom-in bigger-130'></i>"
			            		  				+"<a class='green' href='javascript:edit(\""+item.account+"\")' > <i class='icon-pencil bigger-130'></i> </a>"
			            		  				+"<a class='red' href='javascript:delete(\""+item.account+"\")' > <i class='icon-trash bigger-130'></i> </a></div>"
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
						$("#other").html('<a href="javascript:gotoPage(1,\'account=&username=\')" ><i class="icon-refresh"></i></a>&nbsp;|&nbsp;<label >共 '+msg.totalElement+' 记录&nbsp;|&nbsp;共 '+msg.totalPage +' 页</label>');
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
		    url: "admin/searchuserbyid", 
		    data:"searchId=" + searchId,
		    dataType: "json",
			beforeSend:function(XMLHttpRequest){
				  //TODO 测试用
	            //alert('远程调用开始...');
	            $("#table-result").showLoading();
	        },
	        success: function (data){
	        	console.info(data.account);
	        	console.info(data.username);
	        	console.info(data.createDate);
	        	console.info(data.latestDate);
				$("#detailed-account").html(data.account);
				$("#detailed-username").html(data.username);
				$("#detailed-createdate").html(getFormatDateByLong(data.createDate,"yyyy-MM-dd hh:mm:ss"));
				$("#detailed-latestdate").html(getFormatDateByLong(data.latestDate,"yyyy-MM-dd hh:mm:ss"));
			    var array = new Array();
		        for(var j = data.role.length - 1; j >= 0; j--){
		    	  array.push(data.role[j].description);
			    }
				$("#detailed-role").html(array.join(","));
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
    <!-- 工具导入 --> 
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include> 
    <!-- /#ace-settings-container --> 
   </div> 
   <!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>  
 </body>
</html>
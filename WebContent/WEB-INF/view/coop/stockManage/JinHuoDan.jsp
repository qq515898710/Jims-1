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
       <li><a href="coop/jinhuodan.html">进货单</a></li> 
      </ul> 
      <!-- .breadcrumb -->
     </div> 
     <div class="page-content"> 
      <div class="row"> 
       <div class="col-xs-12">
       <div class="space-6"></div>
       <div class="row">
         <div class="col-sm-10 col-sm-offset-1">
           <div class="widget-box transparent invoice-box">
             <div class="widget-header widget-header-large">
               <h3 class="grey lighter pull-left position-relative">
                 <i class="icon-leaf green"></i>进货单
               </h3>
               <div class="widget-toolbar no-border invoice-info">
                 <span class="invoice-info-label">时间:</span>
                 <span class="blue" id="time"></span>
<!--                  <br>
                 <span class="invoice-info-label">发票:</span>
                 <span class="red">#121212</span> -->
               </div>
               <div class="widget-toolbar hidden-480"><a href="javascript:void()"><i class="icon-print"></i></a></div><!--.widget-toolbar hidden-480  -->
             </div><!--.widget-header widget-header-large  -->
             <div class="widget-body">
               <div class="widget-main padding-24">
               <div class="row">
                 <div class="col-sm-6">
                   <div class="row">
                     <div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right"><b>供应商信息</b></div>
                   </div><!--.row  -->
                   <div class="row">
                     <ul class="list-unstyled spaced">
                       <li>
                         <i class="icon-caret-right blue"></i>
                         <label name="provider">供应商：</label>
                         <select id="providerName" class="chosen-select" data-placeholder="请选择一个供应商"></select>
                       </li>
                       <li>
                         <i class="icon-caret-right blue"></i>
                         <label name="address">地址：</label>
                         <span name="address" id="address">-</span>
                       </li>
                       <li>
                         <i class="icon-caret-right blue"></i>
                         <label name="contacts">联系人：</label>
                         <span name="contacts" id="contacts">-</span>
                       </li>
                       <li>
                         <i class="icon-caret-right blue"></i>
                         <label name="telephone">联系电话：</label>
                         <span name="telephone" id="telephone">http://127.0.0.1:8020/bootstrap%E5%90%8E%E5%8F%B0%E6%A8%A1%E7%89%88/invoice.html#</span>
                       </li>
                     </ul>
                   </div><!--.row  -->
                 </div><!--.col-sm-6  -->
                 <div class="col-sm-6">
                   <div class="row">
                     <div class="col-xs-11 label label-lg label-success arrowed-in arrowed-right"><b>商品信息</b></div>
                   </div><!--.row  -->
                   <div class="row">
                     <ul class="list-unstyled spaced">
                       <li>
                         <i class="icon-caret-right green"></i>
                         <label name="goodName">商品：</label>
                         <select id="goodName" class="chosen-select" data-placeholder="请选择一个商品"></select>
                       </li>
                       <li>
                         <i class="icon-caret-right green"></i>
                         <label name="origin">产地：</label>
                         <span name="origin" id="origin">-</span>
                       </li>
                       <li>
                         <i class="icon-caret-right green"></i>
                         <label name="pack">包装：</label>
                         <span name="pack" id="pack">-</span>
                       </li>
                       <li>
                         <i class="icon-caret-right green"></i>
                         <label name="approvalNum">批准文号：</label>
                         <span name="approvalNum" id="approvalNum">-</span>
                       </li>
                     </ul>
                   </div><!--.row  -->
                 </div><!--.col-sm-6  -->
               </div><!--.row  -->
               </div><!--.widget-main padding-24  -->
             </div><!--.widget-body  -->
           </div><!--.widget-box transparent invoice-box  -->
         </div><!--.col-sm-10 col-sm-offset-1  -->
       </div><!--.row  -->
       </div> <!-- .col-xs-12 -->
      </div> <!-- /.row --> 
     </div> <!-- /.page-content --> 
    </div> <!-- /.main-content --> 
    <script type="text/javascript">
	jQuery(function($) {
		$.get("coop/listProviderByName", function(msg){
			var result="<option value='0' select >&nbsp;</option>";
			for(var i = 0; i < msg.length;i++){
				result+="<option value=\""+msg[i]+"\">"+msg[i]+"</option>";
			}
			$("#providerName").html(result);
			//TODO
			// 好感人的界面
			$("#providerName").chosen();
			$("#providerName_chosen").css("width","160px");
	    });
	    
		systemTime();
		
		//selcet事件
	    $("#providerName").change(function(){
		    //TODO
			//alert($("#providerName").val());
		    $.get("coop/searchProviderByName",{name:$("#providerName").val()},function(msg){
			    $("#address").html(msg.address);
			    $("#contacts").html(msg.contacts);
			    $("#telephone").html(msg.telephone);
				$.get("coop/searchByProviderName",{name:$("#providerName").val()},function(msg){
					if(msg != null && msg != ""){
						var result="<option value='0' select >&nbsp;</option>";
						for(var i = 0; i < msg.length;i++){
							result+="<option value=\""+msg[i].name+"\">"+msg[i].name+"</option>";
						}
						$("#goodName").html(result);
						//TODO
						// 好感人的界面
						$("#goodName").chosen();
						$("#goodName_chosen").css("width","160px");
					}else{
						$("#goodName").html("<option value='0' select >&nbsp;</option>");
					}
				});
			});
		});
		
	});

	//获取系统时间，将时间以指定格式显示到页面。  
    function systemTime()  
    {  
        //获取系统时间。  
        var dateTime=new Date();  
        var hh=dateTime.getHours();  
        var mm=dateTime.getMinutes();  
        var ss=dateTime.getSeconds();  
        //分秒时间是一位数字，在数字前补0。  
        mm = extra(mm);  
        ss = extra(ss);  
        //将时间显示到ID为time的位置，时间格式形如：19:18:02  
        document.getElementById("time").innerHTML=hh+":"+mm+":"+ss;  
        //每隔1000ms执行方法systemTime()。  
        setTimeout("systemTime()",1000);  
    }  
    //补位函数。  
    function extra(x)  
    {  
        //如果传入数字小于10，数字前补一位0。  
        if(x < 10)  
        {  
            return "0" + x;  
        }  
        else  
        {  
            return x;  
        }  
    }
    </script> 
    <!-- 工具导入 --> 
    <jsp:include page="/WEB-INF/view/tool.jsp"></jsp:include>
    <!-- /#ace-settings-container --> 
   </div><!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>
 </body>
</html>
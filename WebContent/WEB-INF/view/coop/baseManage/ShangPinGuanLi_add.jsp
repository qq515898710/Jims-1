<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.UUID"%>
<%
	String token = UUID.randomUUID().toString().replaceAll("-", "");
	session.setAttribute("token", token);
%>
<div id="add-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span></button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-plus-sign"></i>&nbsp;添加商品信息 </h6> 
     </div>
     <div class="modal-body">
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font " for="name"> 商品名称： </label> 
        <div class="col-sm-9">
         <input type="text" id="name" class="col-xs-8" /><div id="name-tip"></div>
        </div> 
       </div> 
       <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right font" for="abbreviation"> 简称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="abbreviation" class="col-xs-8" /><div id="abbreviation-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="origin"> 产地： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="origin" class="col-xs-8" /><div id="origin-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="unitCost"> 单价： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="unitCost" class="col-xs-8" /><div id="unitCost-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="pack"> 包装： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="pack" class="col-xs-8" /><div id="pack-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="approvalNum"> 批准文号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="approvalNum" class="col-xs-8" /><div id="approvalNum-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="batchNum"> 批号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="batchNum" class="col-xs-8" /><div id="batchNum-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="memo"> 备忘录(简介)： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="memo" class="col-xs-8" /><div id="memo-tip"></div>
        </div> 
       </div>
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="providerName">选择供应商： </label> 
        <div class="col-sm-9">
         <select id="providerName" class="col-xs-8 chosen-select" data-placeholder="请选择一个供应商">
         </select>
        </div> 
       </div><!--.form-group-->
       <input type="hidden" name="formtoken"  value="<%=token%>"  id="formtoken">
       <!-- 警告框 -->
       <div id="warning-block"></div>
      </form> 
     </div> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" id="cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm"  id="ok" autocomplete="off"  data-loading-text="正在处理中..." ><i class="icon-ok bigger-110" ></i>确定</button> 
     </div> 
    </div> 
   </div> 
  </div>
  <script type="text/javascript">
  jQuery(function($) {
	  
		$.get("coop/listProviderByName", function(msg){
			var result="<option value='0' select >&nbsp;</option>";
			for(var i = 0; i < msg.length;i++){
				console.info(msg[i]);
				result+="<option value='"+msg[i]+"'>"+msg[i]+"</option>";
			}
			$(".chosen-select").html(result);
		    $(".chosen-select").chosen();
		    $("#providerName_chosen").css("width","260px");
	    });

 	    $('form :input').blur(function() {//表单验证
	        var $parent = $(this).parent();
	        $parent.find(".formtips").remove();
	        if ($(this).is('#name')) {
	            if (this.value == "") {
	                var errorMsg = '商品名称不能为空';
	                $("#name-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#abbreviation')) {
	            if (this.value == "") {
	                var errorMsg = '简称不能为空';
	                $("#abbreviation-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#unitCost')) {
	            if (this.value == "") {
	                var errorMsg = '单价不正确';
	                $("#unitCost-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#origin')) {
	            if (this.value == "") {
	                var errorMsg = '产地不能为空';
	                $("#origin-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#pack')) {
	            if (this.value == "") {
	                var errorMsg = '包装不能为空';
	                $("#pack-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#approvalNum')) {
	            if (this.value == "") {
	                var errorMsg = '批准文号不能为空';
	                $("#approvalNum-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#batchNum')) {
	            if (this.value == "") {
	                var errorMsg = '批号不能为空';
	                $("#batchNum-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
 	    });
 	    
 	   $("#ok").on('click',function() { //提交事件
 	 	   //TODO
//  		  var $btn = $(this).button('loading');
	        $.ajax({
	            type: "POST",
	            url: "admin/addGood",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
	            data: JSON.stringify({
	                'name': $("#name").val(),
	                'abbreviation': $("#abbreviation").val(),
	                'origin': $("#origin").val(),
	                'unitCost': $("#unitCost").val(),
	                'pack': $("#pack").val(),
	                'approvalNum': $("#approvalNum").val(),
	                'batchNum': $("#batchNum").val(),
	                'memo': $("#memo").val(),
	                'providerName':$(".chosen-select").val(),
	                'formtoken': $("#formtoken").val()
	            }),
	            async: true,
	            success: function(data) {
		            if(data.tip != null){
					    $("#warning-block").html('<div class="alert alert-block alert-danger">'+
			                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
			                    '<div class="danger bold-center">'+data.tip+'</div></div>');
			        }
		            else{
		            	if(data.success != null){
				            $("#warning-block").html('<div class="alert alert-block alert-success">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="success bold-center">添加成功,'+'<a href="admin/shangpinguanli.html" class="green">'+
				                    '<span id="mysecond" class="green">'+5+
				                    '</span>秒自动跳转</a><div></div>');
			            	 countDown(5, "admin/shangpinguanli.html");
				        }
				        else{
				            if(data.name != null){
				            	$("#name-tip").html('<span class="formtips onError" style="font-size:50%">' + data.name + '</span>');
					        }
					        if(data.abbreviation != null){
					        	$("#abbreviation-tip").html('<span class="formtips onError" style="font-size:50%">' + data.abbreviation + '</span>');
						    }
					        if(data.origin != null){
					        	$("#origin-tip").html('<span class="formtips onError" style="font-size:50%">' + data.origin + '</span>');
						    }
					        if(data.unitCost != null){
					        	$("#unitCost-tip").html('<span class="formtips onError" style="font-size:50%">' + data.unitCost + '</span>');
						    }
					        if(data.pack != null){
					        	$("#pack-tip").html('<span class="formtips onError" style="font-size:50%">' + data.pack + '</span>');
						    }
					        if(data.approvalNum != null){
					        	$("#approvalNum-tip").html('<span class="formtips onError" style="font-size:50%">' + data.approvalNum + '</span>');
						    }
					        if(data.batchNum != null){
					        	$("#batchNum-tip").html('<span class="formtips onError" style="font-size:50%">' + data.batchNum + '</span>');
						    }
						    $("#delete-tip").html('<div class="alert alert-block alert-danger">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="danger bold-center">添加失败</div></div>');
					    }
			        }
	            },
	            error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.status + "-" + XMLHttpRequest.readyState + "-" + textStatus);
	            }
	        });
	        //TODO
// 	        .always(function() {
// 	            $btn.button('reset');
// 	        }); //ajax
 	   });//提交事件

 	   $("#cancel").on("click",function(){//取消事件
 	 	   location.reload();
 	 	});
	 	
 	   $("#close").on("click",function(){//x事件
 		  location.reload();
  	 	});

	 	$("#bt-add-dialog").on("click",function(){//x事件
	 		$("#alert").html("");
  	 	});
	  });
  </script>
<!-- #add-dialog-message --> 
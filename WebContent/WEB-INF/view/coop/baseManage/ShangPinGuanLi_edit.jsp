<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.UUID"%>
<%
	String token = UUID.randomUUID().toString().replaceAll("-", "");
	session.setAttribute("GoodEidtToken", token);
%>
<div id="edit-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="edit-close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-edit align-top bigger-125"></i>&nbsp;修改商品信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form"> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-name"> 商品名称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-name" class="col-xs-8" readonly="readonly"/><div id="edit-name-tip"></div> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-abbreviation"> 简称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-abbreviation" class="col-xs-8" /><div id="edit-abbreviation-tip"></div> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-origin"> 产地： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-origin" class="col-xs-8" /> <div id="edit-origin-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-unitCost"> 单价： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-unitCost" class="col-xs-8" /> <div id="edit-unitCost-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-pack"> 包装： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-pack" class="col-xs-8" /> <div id="edit-pack-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-approvalNum"> 批准文号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-approvalNum" class="col-xs-8" /> <div id="edit-approvalNum-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-batchNum"> 批号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-batchNum" class="col-xs-8" /> <div id="edit-batchNum-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-memo"> 备忘录(简介)： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-memo" class="col-xs-8" /> <div id="edit-memo-tip"></div>
        </div> 
       </div> 
       <input type="hidden" name="formtoken"  value="<%=token%>"  id="edit-formtoken">
       <input type="hidden" name="id"  id="edit-id">
       <input type="hidden" name="time" id="edit-time">
       <input type="hidden" name="provider" id="edit-provider">
       <!-- 警告框 -->
       <div id="edit-alert"></div>
<!--        <div class="form-group">  -->
<!--         <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">选择商品： </label>  -->
<!--         <div class="col-sm-9">  -->
<!--          <select id="form-field-1" class="col-xs-8"> <option value="">&nbsp;</option> <option value="">&nbsp;</option> </select>  -->
<!--         </div>  -->
<!--        </div> -->
       <!--.form-group  --> 
      </form> 
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" id="edit-cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm" id="edit-ok"><i class="icon-ok bigger-110" autocomplete="off"  data-loading-text="正在处理中..." ></i>确定</button> 
     </div> 
     <!--.modal-footer  --> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
<!--.edit-dialog-message  -->
<script type="text/javascript">
$(document).ready(function() {

	$("#bt-edit-dialog").on('click',function(){//修改按钮
		var selectedItems2 = new Array();
		$("input[name='checkbox']:checked").each(function() {
			selectedItems2.push($(this).val());
		});
		if (selectedItems2 .length == 0) {
			$("#alert").html('<div class="alert alert-block alert-danger">'+
				'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
				'<div class="danger bold-center">没勾选任何记录</div> </div>');
		}else{
			$.ajax({
			    type: "POST", 
			    url: "coop/searchGoodById", 
			    data: "searchId=" + selectedItems2.join(','), 
			    dataType: "json", 
			    success: function (data){
					 $("#edit-id").attr("value",data.id);
					 $("#edit-name").attr("value",data.name);
					 $("#edit-abbreviation").attr("value",data.abbreviation);
					 $("#edit-origin").attr("value",data.origin);
					 $("#edit-unitCost").attr("value",data.unitCost);
					 $("#edit-pack").attr("value",data.pack);
					 $("#edit-approvalNum").attr("value",data.approvalNum);
					 $("#edit-batchNum").attr("value",data.batchNum);
					 $("#edit-memo").attr("value",data.memo);
					 $("#edit-time").attr("value",data.time);
					 $("#edit-provider").attr("value",data.providerInfo.id);
				}
			 });
			$("#alert").html("");
 			$('#edit-dialog-message').modal('show');
		}
	});
	
	$("#edit-ok").on('click',function() { //提交事件
// 		 var $btn = $(this).button('loading');
		 $.ajax({
	            type: "POST",
	            url: "admin/editGood",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
	            data: JSON.stringify({
		            'id':$("#edit-id").val(),
	                'name': $("#edit-name").val(),
	                'abbreviation': $("#edit-abbreviation").val(),
	                'origin': $("#edit-origin").val(),
	                'unitCost': $("#edit-unitCost").val(),
	                'pack': $("#edit-pack").val(),
	                'approvalNum': $("#edit-approvalNum").val(),
	                'batchNum': $("#edit-batchNum").val(),
	                'memo': $("#edit-memo").val(),
	                'time': $("#edit-time").val(),
	                'providerId': $("#edit-provider").val(),
	                'formtoken': $("#edit-formtoken").val()
	            }),
	            success: function(data) {
		            if(data.tip != null){
			            $("#edit-alert").html('<div class="alert alert-block alert-danger">'+
			                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
			                    '<div class="danger bold-center">'+data.tip+'</div></div>');
			        }
		            else{
		            	if(data.success != null){
				            $("#edit-alert").html('<div class="alert alert-block alert-success">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="success bold-center">修改成功,'+'<a href="admin/shangpinguanli.html" class="green">'+
				                    '<span id="mysecond" class="green">'+5+
				                    '</span>秒自动跳转</a><div></div>');
			            	 countDown(5, "admin/shangpinguanli.html");
				        }
				        else{
				            if(data.name != null){
				            	$("#edit-name-tip").html('<span class="formtips onError" style="font-size:50%">' + data.name + '</span>');
					        }
					        if(data.abbreviation != null){
					        	$("#edit-abbreviation-tip").html('<span class="formtips onError" style="font-size:50%">' + data.abbreviation + '</span>');
						    }
					        if(data.origin != null){
					        	$("#edit-origin-tip").html('<span class="formtips onError" style="font-size:50%">' + data.origin + '</span>');
						    }
					        if(data.unitCost != null){
					        	$("#edit-unitCost-tip").html('<span class="formtips onError" style="font-size:50%">' + data.unitCost + '</span>');
						    }
					        if(data.pack != null){
					        	$("#edit-pack-tip").html('<span class="formtips onError" style="font-size:50%">' + data.pack + '</span>');
						    }
					        if(data.approvalNum != null){
					        	$("#edit-approvalNum-tip").html('<span class="formtips onError" style="font-size:50%">' + data.approvalNum + '</span>');
						    }
					        if(data.batchNum != null){
					        	$("#edit-batchNum-tip").html('<span class="formtips onError" style="font-size:50%">' + data.batchNum + '</span>');
						    }
					        if(data.memo != null){
					        	$("#edit-memo-tip").html('<span class="formtips onError" style="font-size:50%">' + data.memo + '</span>');
						    }
				            $("#edit-alert").html('<div class="alert alert-block alert-danger">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="danger bold-center">修改失败</div></div>');
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
	   
	   $("#edit-cancel").on("click",function(){//取消事件
		   location.reload();
	 	});
	 	
	   $("#edit-close").on("click",function(){//x事件
		   location.reload();
	 	});
});
</script>
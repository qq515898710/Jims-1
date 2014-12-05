<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.UUID"%>
<%
	String token = UUID.randomUUID().toString().replaceAll("-", "");
	session.setAttribute("ProviderEidtToken", token);
%>
<div id="edit-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="edit-close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-edit align-top bigger-125"></i>&nbsp;修改供应商信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form"> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-name" > 供应商名称： </label> 
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
        <label class="col-sm-3 control-label no-padding-right font" for="edit-address"> 地址： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-address" class="col-xs-8" /> <div id="edit-address-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-postalCode">邮政编码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-postalCode" class="col-xs-8" /> <div id="edit-postalCode-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-phone"> 电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-phone" class="col-xs-8" /> <div id="edit-phone-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-fax"> 传真： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-fax" class="col-xs-8" /> <div id="edit-fax-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-contacts"> 联系人： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-contacts" class="col-xs-8" /> <div id="edit-contacts-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-telephone">联系人电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-telephone" class="col-xs-8" /> <div id="edit-telephone-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-email"> 电子邮箱： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-email" class="col-xs-8" /> <div id="edit-email-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-depositBank">开户行： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-depositBank" class="col-xs-8 " /> <div id="edit-depositBank-tip"></div>
        </div> 
       </div>
       <input type="hidden" name="formtoken"  value="<%=token%>"  id="edit-formtoken">
       <input type="hidden" name="id"  id="edit-id">
       <input type="hidden" name="time" id="edit-time">
       <!-- 警告框 -->
       <div id="edit-alert"></div>
<!--        <div class="form-group">  -->
<!--         <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">选择供应商： </label>  -->
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
			    url: "coop/searchProviderById", 
			    data: "searchId=" + selectedItems2.join(','), 
			    dataType: "json", 
			    success: function (data){
					 $("#edit-id").attr("value",data.id);
					 $("#edit-name").attr("value",data.name);
					 $("#edit-abbreviation").attr("value",data.abbreviation);
					 $("#edit-address").attr("value",data.address);
					 $("#edit-postalCode").attr("value",data.postalCode);
					 $("#edit-phone").attr("value",data.phone);
					 $("#edit-fax").attr("value",data.fax);
					 $("#edit-contacts").attr("value",data.contacts);
					 $("#edit-telephone").attr("value",data.telephone);
					 $("#edit-email").attr("value",data.email);
					 $("#edit-depositBank").attr("value",data.depositBank);
					 $("#edit-time").attr("value",data.time);
				}
			 });
			$("#alert").html("");
 			$('#edit-dialog-message').modal('show');
		}
	});
	
	$("#edit-ok").on('click',function() { //提交事件
		//TODO
// 		 var $btn = $(this).button('loading');
		 $.ajax({
	            type: "POST",
	            url: "admin/editProvider",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
	            data: JSON.stringify({
		            'id':$("#edit-id").val(),
	                'name': $("#edit-name").val(),
	                'abbreviation': $("#edit-abbreviation").val(),
	                'address': $("#edit-address").val(),
	                'postalCode': $("#edit-postalCode").val(),
	                'phone': $("#edit-phone").val(),
	                'fax': $("#edit-fax").val(),
	                'contacts': $("#edit-contacts").val(),
	                'telephone': $("#edit-telephone").val(),
	                'email': $("#edit-email").val(),
	                'depositBank': $("#edit-depositBank").val(),
	                'time': $("#edit-time").val(),
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
				                    '<div class="success bold-center">修改成功,'+'<a href="admin/gongyingshangguanli.html" class="green">'+
				                    '<span id="mysecond" class="green">'+5+
				                    '</span>秒自动跳转</a><div></div>');
			            	 countDown(5, "admin/gongyingshangguanli.html");
				        }
				        else{
				            if(data.name != null){
				            	$("#edit-name-tip").html('<span class="formtips onError" style="font-size:50%">' + data.name + '</span>');
					        }
					        if(data.abbreviation != null){
					        	$("#edit-abbreviation-tip").html('<span class="formtips onError" style="font-size:50%">' + data.abbreviation + '</span>');
						    }
					        if(data.address != null){
					        	$("#edit-address-tip").html('<span class="formtips onError" style="font-size:50%">' + data.address + '</span>');
						    }
					        if(data.postalCode != null){
					        	$("#edit-postalCode-tip").html('<span class="formtips onError" style="font-size:50%">' + data.postalCode + '</span>');
						    }
					        if(data.phone != null){
					        	$("#edit-phone-tip").html('<span class="formtips onError" style="font-size:50%">' + data.phone + '</span>');
						    }
					        if(data.fax != null){
					        	$("#edit-fax-tip").html('<span class="formtips onError" style="font-size:50%">' + data.fax + '</span>');
						    }
					        if(data.contacts != null){
					        	$("#edit-contacts-tip").html('<span class="formtips onError" style="font-size:50%">' + data.contacts + '</span>');
						    }
					        if(data.telephone != null){
					        	$("#edit-telephone-tip").html('<span class="formtips onError" style="font-size:50%">' + data.telephone + '</span>');
						    }
					        if(data.email != null){
					        	$("#edit-email-tip").html('<span class="formtips onError" style="font-size:50%">' + data.email + '</span>');
						    }
					        if(data.depositBank != null){
					        	$("#edit-depositBank-tip").html('<span class="formtips onError" style="font-size:50%">' + data.depositBank + '</span>');
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
	        // TODO
	        //.always(function() {
	        //    $btn.button('reset');
	        //}); //ajax
	   });//提交事件
	   
	   $("#edit-cancel").on("click",function(){//取消事件
		   location.reload();
	 	});
	 	
	   $("#edit-close").on("click",function(){//x事件
		   location.reload();
	 	});
});
</script>
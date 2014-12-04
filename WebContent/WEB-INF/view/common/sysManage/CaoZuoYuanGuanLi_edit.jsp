<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="edit-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="edit-close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-edit align-top bigger-125"></i>&nbsp;修改操作员信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 姓名： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-username" name="username" class="col-xs-8" readonly="readonly"/> <div id="edit-username-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 密码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-password" name="password" class="col-xs-8" /> <div id="edit-password-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 重复密码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-repassword" name="password" class="col-xs-8" /> <div id="edit-repassword-tip"></div>
        </div> 
       </div> 
       <input type="hidden" id="edit-account"/>
       <div id="edit-alert"></div> 
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
	
	var selectedItems2 = new Array();
	$("#bt-edit-dialog").on('click',function(){//修改按钮
		$("input[name='checkbox']:checked").each(function() {
			selectedItems2.push($(this).val());
		});
		
		if (selectedItems2.length == 0) {
			$("#c-alert").html('<div class="alert alert-block alert-danger">'+
				'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
				'<div class="danger bold-center">没勾选任何记录</div> </div>');
		}else{
			$("#c-alert").html("");
			$.ajax({
			    type: "POST", 
			    url: "admin/searchuserbyid", 
			    data:"searchId=" + selectedItems2.join(','), 
			    dataType: "json", 
			    success: function (data){
					$("#edit-account").attr("value",data.account);
					$("#edit-username").attr("value",data.username);
				}
			 });
			$("#alert").html("");
 			$('#edit-dialog-message').modal('show');
		}
	});

	$("#edit-ok").on('click',function() { //提交事件
		$.ajax({
            type: "POST",
            url: "admin/edituserinfo",
            contentType: "application/json",
            // 必须有
            dataType: "json",
            // 表示返回值类型，不必须
		    data: JSON.stringify({
                'account': $("#edit-account").val(),
                'username': $("#edit-username").val(),
                'password': $("#edit-password").val(),
                'repassword': $("#edit-repassword").val(),
            }),
            success: function(data) {
			    if(!data.success){
					$("#edit-alert").html('<div class="alert alert-block alert-danger">'+
							'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
							'<div class="danger bold-center">'+data.message+'</div> </div>');
				}else{
		            $("#edit-alert").html('<div class="alert alert-block alert-success">'+
		                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
		                    '<div class="success bold-center">修改成功,'+'<a href="admin/caozuoyuanguanli.html" class="green">'+
		                    '<span id="mysecond" class="green">'+5+
		                    '</span>秒自动跳转</a><div></div>');
	            	 countDown(5, "admin/caozuoyuanguanli.html");
				}
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status + "-" + XMLHttpRequest.readyState + "-" + textStatus);
            }
        });
	});//提交事件
	   
   $("#edit-cancel").on("click",function(){//取消事件
	   location.reload();
 	});
 	
   $("#edit-close").on("click",function(){//x事件
	   location.reload();
 	});
});
</script>
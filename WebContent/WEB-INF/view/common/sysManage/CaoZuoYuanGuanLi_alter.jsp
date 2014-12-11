<%@ page language="java" contentType="text/html; charedit=UTF-8" pageEncoding="UTF-8"%>
<div id="alter-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="alter-close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-alter align-top bigger-125"></i>&nbsp;修改操作员信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 姓名： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="alter-username" name="username" class="col-xs-8" readonly="readonly" /> <div id="alter-username-tip"></div>
        </div> 
       </div>
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 角色： </label> 
        <div class="col-sm-9" id="alterrole">
        </div> <!--.col-sm-9  -->
       </div><!--.form-group  -->
       <input type="hidden" id="alter-account"/>
       <div id="alter-alert"></div> 
      </form> 
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" id="alter-cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm" id="alter-ok"><i class="icon-ok bigger-110" autocomplete="off"  data-loading-text="正在处理中..." ></i>确定</button> 
     </div> 
     <!--.modal-footer  --> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
<!--.alter-dialog-message  -->
<script type="text/javascript">
function ckalterfunction(obj){
	   var that = obj.checked;
	   $("input[name=alter-role]").each(function(){
		   $("input[name=alter-role]").attr("checked", that);
	   });
}

$(document).ready(function() {

	$("#alter-ok").on('click',function() { //提交事件
		var selectedItems = new Array();
		$("input[name='alter-role']:checked").each(function() {
			selectedItems.push($(this).val());
		});
		if (selectedItems.length == 0) {
			$("#alter-alert").html('<div class="alert alert-block alert-danger">'+
				'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
				'<div class="danger bold-center">没勾选角色</div> </div>');
		}else{
			$.ajax({
	            type: "POST",
	            url: "admin/alteruserinfo",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
			    data: JSON.stringify({
	                'account': $("#alter-account").val(),
	                'username': $("#alter-username").val(),
	                'roleName': selectedItems.join(','),
	            }),
	            success: function(data) {
				    if(!data.success){
						$("#alter-alert").html('<div class="alert alert-block alert-danger">'+
								'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
								'<div class="danger bold-center">'+data.message+'</div> </div>');
					}else{
			            $("#alter-alert").html('<div class="alert alert-block alert-success">'+
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
		}
	   });//提交事件
	   
	   $("#alter-cancel").on("click",function(){//取消事件
		   location.reload();
	 	});
	 	
	   $("#alter-close").on("click",function(){//x事件
		   location.reload();
	 	});
});
</script>
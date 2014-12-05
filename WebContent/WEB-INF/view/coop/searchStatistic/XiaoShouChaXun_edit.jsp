<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.UUID"%>
<%
	String token = UUID.randomUUID().toString().replaceAll("-", "");
	session.setAttribute("rukuEidtToken", token);
%>
<div id="edit-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" id="edit-close"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-edit align-top bigger-125"></i>&nbsp;修改销售单信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form"> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-goodname"> 商品名称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-goodname" class="col-xs-8" readonly="readonly"/><div id="edit-goodname-tip"></div> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-unitCost"> 单价(元)： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-unitCost" class="col-xs-8" /><div id="edit-unitCost-tip"></div> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-amount"> 数量： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="edit-amount" class="col-xs-8" /> <div id="edit-amount-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="edit-state"> 状态： </label> 
        <div class="col-sm-9">
         <span id="field-div"></span>
        </div> 
       </div> 
       <input type="hidden" goodname="formtoken"  value="<%=token%>"  id="edit-formtoken">
       <input type="hidden" goodname="id"  id="edit-id">
       <!-- 警告框 -->
       <div id="edit-alert"></div>
      </form> 
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" id="edit-cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm" id="edit-ok"><i class="icon-ok bigger-110" autocomplete="off"  data-loading-text="正在处理中..." ></i>确定</button> 
      <button type="button" class="btn btn-danger btn-sm" id="edit-delete"><i class="icon-trash bigger-110" autocomplete="off"  data-loading-text="正在处理中..." ></i>删除</button> 
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
	
	$('#id-button-borders').attr('checked' , 'checked').on('click', function(){
		$('#default-buttons .btn').toggleClass('no-border');
    });

	$("#edit-ok").on('click',function() { //提交事件
		//TODO
// 		 var $btn = $(this).button('loading');
		 $.ajax({
	            type: "POST",
	            url: "admin/editsell",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
	            data: JSON.stringify({
		            'id':$("#edit-id").val(),
	                'goodName': $("#edit-goodname").val(),
	                'unitCost': $("#edit-unitCost").val(),
	                'amount': $("#edit-amount").val(),
	                'sum': ($("#edit-unitCost").val() * $("#edit-amount").val()),
	                'approval': $("input[name='form-field-radio']:checked").val(),
	                'formtoken': $("#edit-formtoken").val()
	            }),
	            success: function(data) {
		            if(data.success){
			            $("#edit-alert").html('<div class="alert alert-block alert-success">'+
			                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
			                    '<div class="success bold-center">修改成功,'+'<a href="coop/xiaoshouchaxun.html" class="green">'+
			                    '<span id="mysecond" class="green">'+5+
			                    '</span>秒自动跳转</a><div></div>');
		            	 countDown(5, "coop/xiaoshouchaxun.html");
			        }else{
			            $("#edit-alert").html('<div class="alert alert-block alert-danger">'+
			                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
			                    '<div class="danger bold-center">'+data.message+'</div></div>');
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
<%@ tag language="java" pageEncoding="UTF-8"%>
<div id="add-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-plus-sign"></i>&nbsp;添加操作员信息 </h6> 
     </div> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 姓名： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="add-username" name="username" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 密码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="add-password" name="password" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 角色： </label> 
        <div class="col-sm-9" id="add-setrole">
        </div> <!--.col-sm-9  -->
       </div><!--.form-group  -->
       <div id="alert"></div> 
      </form> 
     </div>
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" id="cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm" id="ok"><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div> 
   </div>
   <script type="text/javascript">
   
   //1.  var array = new Array();
   //2. 往数组添加数据：
   //array.push($(this).val());
   //3.数组以“,”分隔输出：
   //alert(array.join(','));
   
   jQuery(function($) {

		$.get("admin/rolelist", function(result){
			var str = "";
			for(var i = result.length - 1 ; i > 0; i--){
				str +="<div class='inline'>"+
					  "<input type='checkbox' id='add-role' name='add-role' class='ace' value="+result[i].name+" />"+
					  "<span class='lbl'> "+result[i].description+" </span></div>";
			}
			str +="<div class='inline'>"+
			  " <input type='checkbox' onclick='ckfunction(this)' id='add-role-all' name='add-role' class='ace' value="+result[0].name+" />"+
			  "<span class='lbl'> "+result[0].description+" </span></div>";
			$("#add-setrole").html(str);
	 	});
	 	

 	   $("#ok").on("click",function(){//取消事件
			var selectedItems = new Array();
			$("input[name='add-role']:checked").each(function() {
				selectedItems.push($(this).val());
			});
			if (selectedItems.length == 0) {
				$("#alert").html('<div class="alert alert-block alert-danger">'+
					'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
					'<div class="danger bold-center">没勾选角色</div> </div>');
			}else{
				$("#alert").html();
				//TODO
				console.info($("#add-username").val()+"-"+$("#add-password").val()+"-"+selectedItems.join(','))
				$.ajax({
		            type: "POST",
		            url: "admin/adduser",
		            contentType: "application/json",
		            // 必须有
		            dataType: "json",
		            // 表示返回值类型，不必须
		            data: JSON.stringify({
		                'username': $("#add-username").val(),
		                'password': $("#add-password").val(),
		                'roleName': selectedItems.join(',')
		            }),
		            success: function(data) {
			            if(data.success){
				            $("#alert").html('<div class="alert alert-block alert-success">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="success bold-center">添加成功,'+'<a href="admin/caozuoyuanguanli.html" class="green">'+
				                    '<span id="mysecond" class="green">'+5+
				                    '</span>秒自动跳转</a><div></div>');
			            	 countDown(5, "admin/caozuoyuanguanli.html");
				        }else{
				            $("#alert").html('<div class="alert alert-block alert-danger">'+
				                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
				                    '<div class="danger bold-center">添加失败</div></div>');
					    }
		            },
		            error: function(XMLHttpRequest, textStatus, errorThrown) {
		                alert(XMLHttpRequest.status + "-" + XMLHttpRequest.readyState + "-" + textStatus);
		            }
	            });
			}
 	 	});
	 	
 	   $("#cancel").on("click",function(){//取消事件
 	 	   location.reload();
 	 	});
	 	
 	   $("#close").on("click",function(){//x事件
 		  location.reload();
  	 	});
   });

   function ckfunction(obj){
	   var that = obj.checked;
	   $("input[name=add-role]").each(function(){
		   $("input[name=add-role]").attr("checked", that);
	   });
   }
   </script>
  </div> 
<!-- #add-dialog-message --> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="delete-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"> <i class="icon-trash align-top bigger-125"></i>&nbsp;删除商品信息 </h6> 
     </div>
     <!--.modal-header  --> 
     <div class="modal-body">
      <div class="alert alert-block alert-danger"><div id="delete-content" class="danger bold-center"></div></div>
      <div id="delete-tip"></div>
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"  id="delete-cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm"  id="delete-ok" autocomplete="off"  data-loading-text="正在处理中..." ><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
  <!-- .delete-dialog-message -->
  <script type="text/javascript">
  var deleteIds="";
  var len;
  
  jQuery(function($) {
	  
  $('#delete-cancel').on('click',function(){
  	 location.reload();
  });
	  
  $("#bt-delete-dialog").on('click',function(){//删除按钮
		var selectedItems2 = new Array();
		$("input[name='checkbox']:checked").each(function() {
			selectedItems2.push($(this).val());
		});
		
		if (selectedItems2 .length == 0) {
			$("#alert").html('<div class="alert alert-block alert-danger">'+
					'<button type="button" class="close" data-dismiss="alert" id="close"> <i class="icon-remove"></i> </button>'+
					'<div class="danger bold-center">没勾选任何记录</div> </div>');
		}else{
			deleteIds=selectedItems2.join(',');
			len=selectedItems2.length;
			$("#alert").html("");
			if(len > 0){
				$("#delete-content").html("确定删除选中的"+len+"行记录?");
			}else{
				$("#delete-content").html("确定删除选中的记录?");
			}
			$("#delete-dialog-message").modal('show');
		}
	});

  $("#delete-ok").on('click',function() { //提交事件
// 		var $btn = $(this).button('loading');
		$.ajax({ 
		    type: "post", 
		    url: "admin/deleteGood", 
		    data: "deleteId=" + deleteIds,
		    dataType: "json", 
		    success: function (data) {
			    if(data.success){
		            $("#delete-tip").html('<div class="alert alert-block alert-success">'+
		                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
		                    '<div class="success bold-center">'+data.message+','+'<a href="admin/shangpinguanli.html" class="green">'+
		                    '<span id="mysecond" class="green">'+5+
		                    '</span>秒自动跳转</a><div></div>');
			        countDown(5, "admin/shangpinguanli.html");
				 }else{
				    $("#delete-tip").html('<div class="alert alert-block alert-danger">'+
		                    '<button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>'+
		                    '<div class="danger bold-center">'+data.message+'</div></div>');
				}
		      },
		    error: function(request,error){ 
		        alert('Error deleting item(s), try again later.'); 
		      } 
// 		    }).always(function() {
// 	            $btn.button('reset');
	        }); //ajax;
	});
  });
  </script>
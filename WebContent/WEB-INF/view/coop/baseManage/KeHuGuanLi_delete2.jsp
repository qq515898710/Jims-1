<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="delete-dialog-message-2" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"> <i class="icon-trash align-top bigger-125"></i>&nbsp;删除客户信息 </h6> 
     </div>
     <!--.modal-header  --> 
     <div class="modal-body">
      <div class="font" style="text-align: center; color: red;"> 确定删除?</div>
      <div id="delete-tip2" class="font"  style="text-align: center;"></div>
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"  id="delete-cancel2"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm"  id="delete-ok2" autocomplete="off"  data-loading-text="正在处理中..." ><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
  <!-- .delete-dialog-message -->
  <script type="text/javascript">
  
  jQuery(function($) {
	  
	  $('#delete-cancel2').on('click',function(){
		  $("#delete-tip2").html("");
		  gotoPage(1);
	  });
	  
	  $("#delete-ok2").on('click',function() { //提交事件
			var $btn = $(this).button('loading');
			//这样获取a标签name
// 			var $deleteId= $("#buttontools .red").attr("name");
 			alert($("#buttontools .red").attr("name"));
			$.ajax({ 
			    type: "post", 
			    url: "admin/deleteCustomer", 
			    data: "deleteId=" + $deleteId, 
			    dataType: "json", 
			    success: function (data) {
				    if(data.success){
				    	$("#delete-tip2").html('<hr>'+data.message+', '+'<a href="coop/kehuguanli.html" style="color:green;"><span id="mysecond">'+3+'</span>秒自动跳转</a>');
				    	$("#delete-tip2").css('color','green');
				        countDown(3, "coop/kehuguanli.html");
					 }else{
					    $("#delete-tip2").html('<hr>'+data.message);
					    $("#delete-tip2").css('color','red');
					}
			      }, 
			    error: function(request,error){ 
			        alert('Error deleting item(s), try again later.'); 
			      } 
			    }).always(function() {
		            $btn.button('reset');
		        }); //ajax;
		});
  });
  </script>
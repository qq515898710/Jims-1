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
      <h6 class="modal-title" id="myModalLabel"> <i class="icon-plus-sign"></i>&nbsp;添加客户信息 </h6> 
     </div>
     <div class="modal-body">
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font " for="name"> 客户名称： </label> 
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
        <label class="col-sm-3 control-label no-padding-right font" for="address">地址： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="address" class="col-xs-8" /><div id="address-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="postalCode"> 邮政编码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="postalCode" class="col-xs-8" /><div id="postalCode-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="phone"> 电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="phone" class="col-xs-8" /><div id="phone-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="fax"> 传真： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="fax" class="col-xs-8" /><div id="fax-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="contacts"> 联系人： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="contacts" class="col-xs-8" /><div id="contacts-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="telephone">联系人电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="telephone" class="col-xs-8" /><div id="telephone-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="email">电子邮箱： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="email" class="col-xs-8 " /><div id="email-tip"></div>
        </div> 
       </div>
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="depositBank"> 开户行： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="depositBank" class="col-xs-8" /><div id="depositBank-tip"></div>
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="accountBank"> 开户帐号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="accountBank" class="col-xs-8" /><div id="accountBank-tip"></div>
        </div> 
       </div>
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
  <script>
  	 $(document).ready(function() {
 	    $('form :input').blur(function() {//表单验证
	        var $parent = $(this).parent();
	        $parent.find(".formtips").remove();
	        if ($(this).is('#name')) {
	            if (this.value == "") {
	                var errorMsg = '客户名称不能为空';
	                $("#name-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#postalCode')) {
	            if (!(/[1-9]\d{5}(?!\d)/.test(this.value))) {
	                var errorMsg = '邮政编码不正确';
	                $("#postalCode-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#address')) {
	            if (this.value == "") {
	                var errorMsg = '地址不能为空';
	                $("#address-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#phone')) {
	            if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(this.value))) {
	                var errorMsg = '手机格式不正确(13000000000)';
	                $("#phone-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#fax')) {
	            if (!(/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/.test(this.value))) {
	                var errorMsg = '传真格式不正确';
	                $("#fax-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#contacts')) {
	            if (this.value == "") {
	                var errorMsg = '联系人不能为空';
	                $("#contacts-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#telephone')) {
	            if (!(/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/.test(this.value))) {
	                var errorMsg = '座机格式不正确(XXXX-XXXXXXX)';
	                $("#telephone-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#email')) {
	            if (!(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(this.value))) {
	                var errorMsg = '邮箱格式不正确';
	                $("#email-tip").html('<span class="formtips onError" style="font-size:50%">' + errorMsg + '</span>');
	            }
	        }
 	    });
 	    
 	   $("#ok").on('click',function() { //提交事件
 	 	   //TODO
//  		  var $btn = $(this).button('loading');
	        $.ajax({
	            type: "POST",
	            url: "admin/addCustomer",
	            contentType: "application/json",
	            // 必须有
	            dataType: "json",
	            // 表示返回值类型，不必须
	            data: JSON.stringify({
	                'name': $("#name").val(),
	                'abbreviation': $("#abbreviation").val(),
	                'address': $("#address").val(),
	                'postalCode': $("#postalCode").val(),
	                'phone': $("#phone").val(),
	                'fax': $("#fax").val(),
	                'contacts': $("#contacts").val(),
	                'telephone': $("#telephone").val(),
	                'email': $("#email").val(),
	                'depositBank': $("#depositBank").val(),
	                'accountBank': $("#accountBank").val(),
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
				                    '<div class="success bold-center">添加成功,'+'<a href="admin/kehuguanli.html" class="green">'+
				                    '<span id="mysecond" class="green">'+5+
				                    '</span>秒自动跳转</a><div></div>');
			            	 countDown(5, "admin/kehuguanli.html");
				        }
				        else{
				            if(data.name != null){
				            	$("#name-tip").html('<span class="formtips onError" style="font-size:50%">' + data.name + '</span>');
					        }
					        if(data.abbreviation != null){
					        	$("#abbreviation-tip").html('<span class="formtips onError" style="font-size:50%">' + data.abbreviation + '</span>');
						    }
					        if(data.address != null){
					        	$("#address-tip").html('<span class="formtips onError" style="font-size:50%">' + data.address + '</span>');
						    }
					        if(data.postalCode != null){
					        	$("#postalCode-tip").html('<span class="formtips onError" style="font-size:50%">' + data.postalCode + '</span>');
						    }
					        if(data.phone != null){
					        	$("#phone-tip").html('<span class="formtips onError" style="font-size:50%">' + data.phone + '</span>');
						    }
					        if(data.fax != null){
					        	$("#fax-tip").html('<span class="formtips onError" style="font-size:50%">' + data.fax + '</span>');
						    }
					        if(data.contacts != null){
					        	$("#contacts-tip").html('<span class="formtips onError" style="font-size:50%">' + data.contacts + '</span>');
						    }
					        if(data.telephone != null){
					        	$("#telephone-tip").html('<span class="formtips onError" style="font-size:50%">' + data.telephone + '</span>');
						    }
					        if(data.email != null){
					        	$("#email-tip").html('<span class="formtips onError" style="font-size:50%">' + data.email + '</span>');
						    }
					        if(data.depositBank != null){
					        	$("#depositBank-tip").html('<span class="formtips onError" style="font-size:50%">' + data.depositBank + '</span>');
						    }
					        if(data.accountBank != null){
					        	$("#accountBank-tip").html('<span class="formtips onError" style="font-size:50%">' + data.accountBank + '</span>');
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
	        //.always(function() {
	       //     $btn.button('reset');
	       // }); //ajax
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
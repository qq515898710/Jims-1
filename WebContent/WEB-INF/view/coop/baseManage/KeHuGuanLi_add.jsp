<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="add-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h4 class="modal-title" id="myModalLabel"> <i class="icon-plus-sign"></i>&nbsp;添加客户信息 </h4> 
     </div>
     <div class="modal-body">
      <form id="add-form-dialog" class="form-horizontal" role="form">
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 供应商全称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="name" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 简称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="abbreviation" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 邮政编码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="postalCode" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">地址： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="address" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="phone" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 传真： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="fax" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 联系人： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="contacts" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">联系人电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="telephone" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 开户帐号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="accountBank" class="col-xs-8" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">电子邮箱： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="email" class="col-xs-8 " /> 
        </div> 
       </div>
       <!-- 警告框 -->
       <div class="hide" id="warning-block" style="background-color:#fcf8e3;color: #a94442">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        	Best check yo self, you're not...
        <span class="sr-only">Close</span>
       </div>
      </form> 
     </div> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary" id="ok"><i class="icon-ok bigger-110"></i>确定</button> 
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
	                var errorMsg = '请输入名称.';
	                $parent.append('<span class="formtips onError" style="font-size:30%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#postalCode')) {
	            if (this.value == "") {
	                var errorMsg = '请输入邮政编码.';
	                $parent.append('<span class="formtips onError" style="font-size:30%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#address')) {
	            if (this.value == "") {
	                var errorMsg = '请输入地址.';
	                $parent.append('<span class="formtips onError" style="font-size:30%">' + errorMsg + '</span>');
	            }
	        }
	        if ($(this).is('#phone')) {
	            if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(this.value))) {
	                var errorMsg = '手机为11位数,13开头';
	                $parent.append('<span class="formtips onError" style="font-size:30%">' + errorMsg + '</span>');
	            }
	        }
 	    });
 	   $("#ok").on('click',function() { //提交事件
 	 	   //先移除吧
 		  $("#warning-block").removeClass("hide");
 	   });
	  });
  </script>
<!-- #add-dialog-message --> 
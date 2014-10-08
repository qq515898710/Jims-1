<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="edit-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h4 class="modal-title" id="myModalLabel"> <i class="icon-edit align-top bigger-125"></i>&nbsp;修改客户信息 </h4> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form"> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 供应商全称： </label> 
        <div class="col-sm-9"> 
         <input readonly="" type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 简称： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 邮政编码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">地址： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 传真： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 联系人： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">联系人电话： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 开户帐号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">电子邮箱： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="form-field-1" class="col-xs-10 " /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">选择供应商： </label> 
        <div class="col-sm-9"> 
         <select id="form-field-1" class="col-xs-10"> <option value="">&nbsp;</option> <option value="">&nbsp;</option> </select> 
        </div> 
       </div>
       <!--.form-group  --> 
      </form> 
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary"><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
     <!--.modal-footer  --> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
<!--.edit-dialog-message  -->
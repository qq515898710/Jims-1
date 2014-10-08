<%@ tag language="java" pageEncoding="UTF-8"%>
<div id="add-dialog-message" class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h4 class="modal-title" id="myModalLabel"> <i class="icon-plus-sign"></i>&nbsp;添加操作员信息 </h4> 
     </div> 
     <div class="modal-body"> 
      <form id="add-form-dialog" class="form-horizontal" role="form"> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 工号： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="name" name="name" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 姓名： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="username" name="username" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1"> 密码： </label> 
        <div class="col-sm-9"> 
         <input type="text" id="password" name="password" class="col-xs-10" /> 
        </div> 
       </div> 
       <div class="form-group"> 
        <label class="col-sm-3 control-label no-padding-right font" for="form-field-1">用户类型： </label> 
        <div class="col-sm-9"> 
         <select id="form-field-1" class="col-xs-10"> <option value="">&nbsp;</option> <option value="">&nbsp;</option> </select> 
        </div> 
       </div>
      </form> 
     </div>
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary"><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div> 
   </div> 
  </div> 
<!-- #add-dialog-message --> 
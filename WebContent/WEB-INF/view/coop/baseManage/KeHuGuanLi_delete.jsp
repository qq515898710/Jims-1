<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="delete-dialog-message" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h4 class="modal-title" id="mySmallModalLabel"> <i class="icon-trash align-top bigger-125"></i>&nbsp;删除客户信息 </h4> 
     </div>
     <!--.modal-header  --> 
     <div class="modal-body">
      <div class="font" style="text-align: center;">
       确定删除?
      </div>
     </div>
     <!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary"><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div>
    <!--.modal-content  --> 
   </div>
   <!--.modal-dialog  --> 
  </div>
  <!-- .delete-dialog-message -->

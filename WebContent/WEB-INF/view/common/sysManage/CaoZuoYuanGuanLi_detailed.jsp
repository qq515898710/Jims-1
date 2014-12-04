<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="detailed-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"><i class="icon-zoom-in align-top bigger-125"></i>&nbsp;详细用户信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body" style="font-size: 15px;">
        <div class="profile-user-info profile-user-info-striped"> 
         <div class="profile-info-row"> 
          <div class="profile-info-name"> 帐号 </div> 
          <div class="profile-info-value"> <span class="editable editable-click" id="detailed-account">-</span></div> 
         </div>
         <div class="profile-info-row"> 
          <div class="profile-info-name"> 姓名 </div> 
          <div class="profile-info-value"> <span class="editable editable-click" id="detailed-username">-</span></div> 
         </div>
         <div class="profile-info-row"> 
          <div class="profile-info-name"> 角色 </div> 
          <div class="profile-info-value"> <span class="editable editable-click" id="detailed-role">-</span> </div> 
         </div> 
         <div class="profile-info-row"> 
          <div class="profile-info-name"> 创建时间 </div> 
          <div class="profile-info-value"> <span class="editable editable-click" id="detailed-createdate">-</span> </div> 
         </div> 
         <div class="profile-info-row"> 
          <div class="profile-info-name"> 最后登录时间</div> 
          <div class="profile-info-value"> <span class="editable editable-click" id="detailed-latestdate">-</span> </div> 
         </div> 
        </div> 
     </div> <!--.modal-body  --> 
    </div> <!--.modal-content  --> 
   </div> <!--.modal-dialog  --> 
  </div> <!-- .search-dialog-message -->
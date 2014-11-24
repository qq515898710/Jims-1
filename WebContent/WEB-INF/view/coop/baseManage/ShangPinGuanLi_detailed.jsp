<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="detailed-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"><i class="icon-zoom-in align-top bigger-125"></i>&nbsp;详细商品信息 </h6> 
     </div> 
     <!--.modal-header  --> 
     <div class="modal-body" style="font-size: 15px;"> 
      <div class="">
       <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4"> 
        <li class="active"> <a data-toggle="tab" href="#home4">基础信息</a> </li> 
        <li class=""> <a data-toggle="tab" href="#dropdown14">更多</a> </li> 
       </ul> 
       <div class="tab-content"> 
        <div id="home4" class="tab-pane active"> 
         <div class="profile-user-info profile-user-info-striped"> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 商品名称 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-name">-</span></div> 
          </div>
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 简称 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-abbreviation">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 产地 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-origin">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 单位 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-units">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 包装</div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-pack">-</span> </div> 
          </div> 
         </div> 
        </div> 
        <div id="dropdown14" class="tab-pane">
          <div class="profile-user-info profile-user-info-striped"> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 批准文号</div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-approvalNum">-</span> </div> 
          </div>
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 批号</div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-batchNum">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 备忘录(简介)</div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-memo">-</span> </div> 
          </div> 
         </div> 
        </div> 
       </div> 
      </div> 
     </div> 
     <!--.modal-body  --> 
    </div> 
    <!--.modal-content  --> 
   </div> 
   <!--.modal-dialog  --> 
  </div> 
  <!-- .search-dialog-message -->
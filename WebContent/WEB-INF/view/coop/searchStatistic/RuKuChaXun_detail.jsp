<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="detailed-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"><i class="icon-zoom-in align-top bigger-125"></i>&nbsp;详细进货单信息 </h6> 
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
           <div class="profile-info-name"> 供应商名称 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-providername">-</span></div> 
          </div>
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 商品名称 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-goodname">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 单价(元) </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-unitCost">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 数量 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-amount">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 总价(元) </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-sum">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 状态 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-state">-</span> </div> 
          </div> 
         </div> 
        </div> 
        <div id="dropdown14" class="tab-pane">
          <div class="profile-user-info profile-user-info-striped"> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 进货理由</div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-checkConclusion">-</span> </div> 
          </div>
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 进货时间 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-time">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 结算方式 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-clearingForm">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 经手人 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-handler">-</span> </div> 
          </div> 
          <div class="profile-info-row"> 
           <div class="profile-info-name"> 操作员 </div> 
           <div class="profile-info-value"> <span class="editable editable-click" id="detailed-username">-</span> </div> 
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
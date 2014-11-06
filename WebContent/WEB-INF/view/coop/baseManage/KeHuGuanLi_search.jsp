<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"><i class="icon-search align-top bigger-125"></i>&nbsp;查询客户信息 </h6> 
     </div>
     <!--.modal-header  --> 
     <div class="modal-body">
       <form class="form-horizontal" role="form">
          <div class="form-group"> 
             <label class="col-sm-3 control-label no-padding-right font " for="name"> 客户名称或简称： </label> 
             <div class="col-sm-9">
                <input type="text" id="search-name" class="col-xs-8" /><div id="search-name-tip"></div>
             </div> 
          </div>
       </form>
     </div><!--.modal-body  --> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"  id="search-cancel"><i class="icon-remove bigger-110"></i>取消</button> 
      <button type="button" class="btn btn-primary btn-sm"  id="search-ok" autocomplete="off"  data-loading-text="正在处理中..." ><i class="icon-ok bigger-110"></i>确定</button> 
     </div> 
    </div><!--.modal-content  --> 
   </div><!--.modal-dialog  --> 
  </div><!-- .search-dialog-message -->
  <script type="text/javascript">
   var searchName="";
   jQuery(function($) {
	   
	  $("#search-ok").on("click",function(){
		  searchName=$("#search-name").val();
		  gotoPage(1,'name='+searchName);
	  });
	  
	  $("#search-cancel").on("click",function(){
		  gotoPage(1,'name=');
	  });
	  
   });
  </script>
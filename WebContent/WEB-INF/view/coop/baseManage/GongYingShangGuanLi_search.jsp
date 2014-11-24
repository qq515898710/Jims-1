<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search-dialog-message" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> 
   <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span><span class="sr-only">x</span> </button> 
      <h6 class="modal-title" id="mySmallModalLabel"><i class="icon-search align-top bigger-125"></i>&nbsp;查询供应商信息 </h6> 
     </div>
     <!--.modal-header  --> 
     <div class="modal-body">
       <form class="form-horizontal" role="form">
          <div class="form-group"> 
             <label class="col-sm-5 control-label no-padding-right font " for="search-name"> 供应商名称或简称： </label> 
             <div class="col-sm-6">
                <input type="text" id="search-name" class="col-xs-6" /><div id="search-name-tip"></div>
             </div>
          </div>
          <div class="form-group">
            <label class="col-sm-5 control-label no-padding-right font " for="id-date-picker-1"> 录入时间(起)： </label> 
            <div class="col-sm-6">
              <input class="col-xs-6 date-picker" data-date-format="yyyy-mm-dd" id="id-date-picker-1" type="text" />
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-5 control-label no-padding-right font " for="id-date-picker-2"> 录入时间(末)： </label> 
            <div class="col-sm-6">
              <input class="col-xs-6 date-picker" data-date-format="yyyy-mm-dd" id="id-date-picker-2" type="text" />
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

   $("#bt-search-dialog").on("click",function(){//x事件
      $("#alert").html("");
   });
 	
   $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){   
      $(this).prev().focus();
   });
   //2个的适合才有用,暂时影响我界面交互,不用
   $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
      $(this).next().focus();
   });
   
   var searchName="";
   jQuery(function($) {
	   
	  $("#search-ok").on("click",function(){
		  searchName=$("#search-name").val();
		  var beginTime=$("#id-date-picker-1").val();
		  var endTime=$("#id-date-picker-2").val();
		  //alert(beginTime+"--"+endTime);
		  gotoGongYingShangPage(1,"name="+searchName+"&beginTime="+beginTime+"&endTime="+endTime);
	  });
	  
	  $("#search-cancel").on("click",function(){
		  location.reload();
	  });
	  
   });
  </script>
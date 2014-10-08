<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
<div class="main-container" id="main-container"> 
   <script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script> 
   <div class="main-container-inner"> 
   </div> 
   <div class="page-content"> 
    <div class="row"> 
     <div class="col-xs-12"> 
      <!-- PAGE CONTENT BEGINS --> 
      <div class="error-container"> 
       <div class="well"> 
        <h1 class="grey lighter smaller"> <span class="blue bigger-125"> <i class="icon-random"></i> 500 </span> 发生了一些错误 </h1> 
        <hr /> 
        <h3 class="lighter smaller"> 我们正在修理<i class="icon-wrench icon-animated-wrench bigger-125"></i> on 它! </h3> 
        <div class="space"></div> 
        <div> 
         <h4 class="lighter smaller">与此同时,试试下面的其中之一吧:</h4> 
         <ul class="list-unstyled spaced inline bigger-110 margin-15"> 
          <li><i class="icon-hand-right blue"></i> 阅读常见问题</li> 
          <li><i class="icon-hand-right blue"></i> 给我们更多的信息关于这个特定的错误发生!</li> 
         </ul> 
        </div> 
        <hr /> 
        <div class="space"></div> 
        <div class="center"> 
         <a href="javascript:void();" class="btn btn-grey"> <i class="icon-arrow-left"></i> 返回 </a> 
         <a href="home.html" class="btn btn-primary"> <i class="icon-dashboard"></i> 主页 </a> 
        </div> 
       </div> 
      </div> 
      <!-- PAGE CONTENT ENDS --> 
     </div> 
     <!-- /.col --> 
    </div> 
    <!-- /.row --> 
   </div> 
   <!-- /.page-content --> 
  </div> 
  <!-- /.main-content -->  
  <!-- /.main-container-inner -->   
 </body>
</html>
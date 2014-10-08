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
    <div class="page-content"> 
     <div class="row"> 
      <div class="col-xs-12"> 
       <!-- PAGE CONTENT BEGINS --> 
       <div class="error-container"> 
        <div class="well"> 
         <h1 class="grey lighter smaller"> <span class="blue bigger-125"> <i class="icon-sitemap"></i> 404 </span> 页面未找到 </h1> 
         <hr /> 
         <h3 class="lighter smaller">我们到处找不到它!</h3> 
         <div> 
          <form class="form-search"> 
           <span class="input-icon align-middle"> <i class="icon-search"></i> <input type="text" class="search-query" placeholder="查询内容" /> </span> 
           <button class="btn btn-sm" onclick="return false;">查询!</button> 
          </form> 
          <div class="space"></div> 
          <h4 class="smaller">尝试下列之一:</h4> 
          <ul class="list-unstyled spaced inline bigger-110 margin-15"> 
           <li><i class="icon-hand-right blue"></i> 逐字逐句的url输入错误</li> 
           <li><i class="icon-hand-right blue"></i> 阅读常见问题</li> 
           <li><i class="icon-hand-right blue"></i> 通知管理员 </li> 
          </ul> 
         </div> 
         <hr /> 
         <div class="space"></div> 
         <div class="center"> 
          <a href="#" class="btn btn-grey"> <i class="icon-arrow-left"></i>返回 </a> 
          <a href="home.html" class="btn btn-primary"> <i class="icon-dashboard"></i> 主页 </a> 
         </div> 
        </div> 
       </div> 
       <!-- PAGE CONTENT ENDS --> 
      </div> 
      <!-- /.col --> 
     </div> 
    </div> 
    <!-- /.page-content --> 
   </div> 
   <!-- /.main-content --> 
  </div> 
  <!-- /.main-container-inner -->   
 </body>
</html>
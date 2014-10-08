<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.PropertyResourceBundle"%>
<!DOCTYPE HTML >
<html lang="zh-cn">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	PropertyResourceBundle configBundle = (PropertyResourceBundle)PropertyResourceBundle.getBundle("configs/scm");
%>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title><%=configBundle.getString("title") %></title>
<!-- basic styles -->
<link rel="icon" type="image/png" href="assets/images/favicon.ico" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<!-- 自定义css -->
<link rel="stylesheet" href="assets/css/scm.css" />
<script src="assets/js/ace-extra.min.js"></script>
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script src="assets/js/bootbox.min.js"></script>
<script src="assets/js/jquery.lazyload.js"></script>
<!-- 二维码js -->
<script type="text/javascript" src="assets/js/jquery.qrcode.js"></script>
<!-- 自定义js -->
<script type="text/javascript" src="assets/js/scm.js"></script>
</head>
<body>
  <div class="navbar navbar-default" id="navbar"> 
   <script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script> 
   <div class="navbar-container" id="navbar-container"> 
    <div class="navbar-header pull-left"> 
     <a href="javascript:void();" class="navbar-brand"> <small> <i class="icon-leaf"></i> <%=configBundle.getString("title") %> </small> </a> 
     <!-- /.brand --> 
    </div> 
    <!-- /.navbar-header --> 
    <div class="navbar-header pull-right" role="navigation"> 
     <ul class="nav ace-nav">
      <li class="light-blue"><a data-toggle="dropdown" href="#" class="dropdown-toggle"> <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" /> <span class="user-info"> <small><%=configBundle.getString("weclome") %><%=configBundle.getString("presence") %>,</small> moziqi </span> <i class="icon-caret-down"></i> </a> 
       <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close"> 
        <li><a href="#"> <i class="icon-cog"></i> <%=configBundle.getString("setting") %> </a></li> 
        <li><a href="#"> <i class="icon-user"></i><%=configBundle.getString("profile") %></a></li> 
        <li class="divider"></li> 
        <li><a href="#"> <i class="icon-off"></i><%=configBundle.getString("off") %> </a></li> 
       </ul></li> 
     </ul> 
     <!-- /.ace-nav --> 
    </div> 
    <!-- /.navbar-header --> 
   </div> 
   <!-- /.container --> 
  </div>
  <!--.navbar  navbar-default-->
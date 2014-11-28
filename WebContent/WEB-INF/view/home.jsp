<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.PropertyResourceBundle"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%PropertyResourceBundle configBundle = (PropertyResourceBundle)PropertyResourceBundle.getBundle("configs/scm"); %>
<jsp:include page="header.jsp"></jsp:include>
<div class="main-container" id="main-container"> 
   <script type="text/javascript">
    try {
      ace.settings.check('main-container', 'fixed')
    } catch (e) {
    }
  </script> 
   <div class="main-container-inner"> 
    <a class="menu-toggler" id="menu-toggler" href="#"> <span class="menu-text"></span> </a> 
    <div class="sidebar" id="sidebar"> 
     <script type="text/javascript">
        try {
          ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
  </script> 
     <div class="sidebar-shortcuts" id="sidebar-shortcuts"> 
       <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large"> 
        <button class="btn btn-success" onclick="goPage('home.html')"><i class="icon-signal"></i></button> 
        <button class="btn btn-info" onclick="goPage('coop/jinhuodan.html')"> <i class="icon-pencil"></i></button> 
        <button class="btn btn-warning" onclick="goPage('home.html')"> <i class="icon-group"></i></button> 
        <button class="btn btn-danger" onclick="goPage('home.html')"> <i class="icon-cogs"></i></button> 
       </div><!--.sidebar-shortcuts-large  -->
       <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
           <span class="btn btn-success"></span>
           <span class="btn btn-info"></span>
           <span class="btn btn-warning"></span>
           <span class="btn btn-danger"></span>
      </div><!--.sidebar-shortcuts-mini  -->
     </div><!--sidebar-shortcuts  -->
     <!-- 导航条 -->
     <jsp:include page="nav.jsp"></jsp:include>
     <div class="sidebar-collapse" id="sidebar-collapse"> 
      <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i> 
     </div> 
     <script type="text/javascript">
        try {
          ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
      </script> 
    </div> 
    <div class="main-content"> 
     <div class="breadcrumbs" id="breadcrumbs"> 
      <script type="text/javascript">
          try {
            ace.settings.check('breadcrumbs', 'fixed')
          } catch (e) {
          }
        </script> 
      <ul class="breadcrumb"> 
       <li><i class="icon-home home-icon"></i> <a href="home.html"><%=configBundle.getString("index") %></a></li> 
       <li> 控制台</li> 
      </ul> 
      <!-- .breadcrumb --> 
      <div class="nav-search" id="nav-search"> 
       <form class="form-search"> 
        <span class="input-icon"> <input type="text" placeholder="请输入查询的内容" class="nav-search-input" id="nav-search-input" autocomplete="off" /> <i class="icon-search nav-search-icon"></i> </span> 
       </form> 
      </div> 
      <!-- #nav-search --> 
     </div> 
     <div class="page-content"> 
      <div class="page-header"> 
       <h1>控制台<i class="icon-double-angle-right"></i><small> 登录成功 </small> </h1> 
      </div> <!-- /.page-header --> 
      <div class="row"> 
       <div class="col-xs-12"> 
        <!-- PAGE CONTENT BEGINS --> 
        <div class="alert alert-block alert-success"> 
         <button type="button" class="close" data-dismiss="alert"> <i class="icon-remove"></i> </button> 
         <i class="icon-ok green"></i><%=configBundle.getString("weclome") %><%=configBundle.getString("use") %>
         <strong class="green"><%=configBundle.getString("title") %><small><%=configBundle.getString("version") %></small> </strong> 
        </div><!--.alert alert-block alert-success  -->
       <div class="row">
         <div class="space-6"></div>
         <div class="col-sm-7 infobox-container">
             <div class="infobox infobox-green">
               <div class="infobox-icon"> <i class="icon-list-alt"></i> </div> 
               <div class="infobox-data"> 
                 <span class="infobox-data-number" id="home-count-inventory-day"></span> 
                 <div class="infobox-content">库存</div> 
              </div>
              <div class="stat stat-success" id="home-percent-inventory-day"></div> 
            </div><!--.infobox infobox-green  -->
            <div class="infobox infobox-blue">
              <div class="infobox-icon"><i class="icon-shopping-cart"></i> </div> 
              <div class="infobox-data"> 
                <span class="infobox-data-number">1</span> 
                <div class="infobox-content">进货</div> 
             </div> 
             <div class="stat stat-important">4%</div> 
           </div><!--.infobox infobox-blue  -->
            <div class="infobox infobox-blue">
              <div class="infobox-icon"><i class="icon-shopping-cart"></i> </div> 
              <div class="infobox-data"> 
                <span class="infobox-data-number">2</span> 
                <div class="infobox-content">进货退货</div> 
             </div> 
             <div class="stat stat-important">4%</div> 
           </div><!--.infobox infobox-blue  -->
           <div class="infobox infobox-pink">
              <div class="infobox-icon"><i class="icon-shopping-cart"></i> </div> 
              <div class="infobox-data"> 
                <span class="infobox-data-number">3</span> 
                <div class="infobox-content">销售</div> 
              </div> 
              <div class="stat stat-important">4%</div> 
           </div><!--.infobox infobox-pink  -->
           <div class="infobox infobox-pink">
              <div class="infobox-icon"><i class="icon-shopping-cart"></i> </div> 
              <div class="infobox-data"> 
                <span class="infobox-data-number">4</span> 
                <div class="infobox-content">销售退货</div> 
              </div> 
              <div class="stat stat-important">4%</div> 
           </div><!--.infobox infobox-pink  -->
           <div class="infobox infobox-red">
              <div class="infobox-icon"><i class="icon-beaker"></i> </div> 
              <div class="infobox-data"> 
                <span class="infobox-data-number">4</span> 
                <div class="infobox-content">其他</div> 
              </div> 
           </div><!--.infobox infobox-red  -->
          </div><!--.col-sm-7 infobox-container  -->
          <div class="vspace-sm"></div>
          <div class="col-sm-5">
            <div class="widget-box">
              <div class="widget-header widget-header-flat widget-header-small">
                <h5><i class="icon-signal"></i>访问来源</h5>
                <div class="widget-toolbar no-border">
                  <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
                                                          本周<i class="icon-angle-down icon-on-right bigger-110"></i>
                  </button>
                  <ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
                    <li class="active"><a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a></li>
                    <li ><a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>上周</a></li>
                    <li ><a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本月</a></li>
                    <li ><a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>上月</a></li>
                  </ul>
                </div><!--.widget-toolbar no-border  -->
              </div><!--.widget-header widget-header-flat widget-header-small  -->
              <div class="widget-body">
                <div class="widget-main">
                  <div id="piechart-placeholder"></div>
                  <div class="hr hr8 hr-double"></div>
                </div>
              </div><!--widget-body  -->
            </div><!--widget-box  -->
          </div><!--.col-sm-5 -->
       </div><!--.row  -->
       <div class="hr hr32 hr-dotted"></div>
          <div class="row">
            <div class="col-sm-5">
              <div class="widget-box transparent">
                <div class="widget-header widget-header-flat">
                  <h4 class="lighter"><i class="icon-star orange"></i>热门销售</h4>
                  <div class="widget-toolbar"><a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a></div>
                </div><!--.widget-header widget-header-flat  -->
                <div class="widget-body">
                  <div class="widget-body-inner" style="display: block;">
                    <div class="widget-main no-padding">
                      <table class="table table-bordered table-striped">
                        <thead class="thin-border-bottom">
                          <tr>
                            <th><i class="icon-caret-right blue"></i>名称</th>
                            <th><i class="icon-caret-right blue"></i>价格</th>
                            <th><i class="icon-caret-right blue"></i>状态</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>卫生巾</td>
                            <td>$100</td>
                            <td><span class="label label-info arrowed-right arrowed-in">销售中</span></td>
                          </tr>
                        </tbody>
                      </table>
                    </div><!--.widget-main no-padding  -->
                  </div><!--.widget-body-inner  -->
                </div><!--.widget-body  -->
              </div><!--.widget-box transparent  -->
            </div><!--.col-sm-5  -->
            <div class="col-sm-7">
              <div id="recent-box" class="widget-box transparent">
                <div class="widget-header">
                  <h4 class="lighter smaller"><i class="icon-rss orange"></i>最近</h4>
                  <div class="widget-toolbar no-border">
                    <ul id="recent-tab" class="nav nav-tabs">
                      <li class="active"><a href="#task-sell" data-toggle="tab">销售</a></li>
                      <li ><a href="#task-stock" data-toggle="tab">进货</a></li>
                      <li ><a href="#task-user" data-toggle="tab">工作人员</a></li>
                    </ul>
                  </div><!--widget-toolbar no-border  -->
                </div><!--.widget-header  -->
                <div class="widget-body">
                  <div class="widget-main padding-4">
                    <div class="tab-content padding-8 overflow-visible">
                      <div id="task-sell" class="tab-pane active">
                        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 300px;">
                          <div class="comments" style="overflow: hidden; width: auto; height: 300px;">
                            <div class="itemdiv commentdiv">
                              <div class="user"><img alt="商品" src="assets/images/goods.jpg"> </div>
                              <div class="body">
                                <div class="name">我的商品</div>
                                <div class="time"><i class="icon-time"></i><span class="green">本月</span></div>
                                <div class="text"><i class="icon-quote-left"></i>总结,大概列出一些信息出来</div>
                              </div>
                            </div>
                          </div><!--comments  -->
                        </div><!--.slimScrollDiv  -->
                      </div><!--#task-sell  -->
                      <div id="task-stock" class="tab-pane">我是进货</div>
                      <div id="task-user" class="tab-pane">我是工作人员</div>
                    </div><!--.tab-content padding-8 overflow-visible  -->
                  </div><!--.widget-main padding-4  -->
                </div><!--.widget-body  -->
              </div><!--#recent-box  -->
            </div><!--.col-sm-6  -->
       </div><!--.row  -->
       <div id="qzcode" class="hide"></div>
       <div class="hide"><img alt="条形码" src="barcode?msg=9787302337416" height="50px" width=130px/> </div>
       <script type="text/javascript">
       
       var content = toUtf8("欢迎使用jscm,  本系统由莫梓奇开发");
       
       jQuery(function(){
           
		 $.get("coop/showCountInventoryInfoInToday", function(result){
			$("#home-count-inventory-day").html(result);
    	 });
    	 
		 $.get("coop/showInventoryInfoPercentageofDayOnThisMonth", function(result){
			 if(result >= 0){
				 $("#home-percent-inventory-day").html(result);
				 $("#home-percent-inventory-day").removeClass("stat-important").addClass("stat-success");
			 }else{
				 $("#home-percent-inventory-day").html(result);
				 $("#home-percent-inventory-day").removeClass("stat-success").addClass("stat-important");
			 }
    	 });

		 var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
		  var data = [
			{ label: "进货单",  data: 38.7, color: "#68BC31"},
			{ label: "库存盘点",  data: 24.5, color: "#2091CF"},
			{ label: "进货退货单",  data: 8.2, color: "#AF4E96"},
			{ label: "销售单",  data: 18.6, color: "#DA5430"},
			{ label: "修改密码",  data: 10, color: "#FEE074"}
		  ]
		  function drawPieChart(placeholder, data, position) {
		 	  $.plot(placeholder, data, {
				series: {
					pie: {
						show: true,
						tilt:0.8,
						highlight: {
							opacity: 0.25
						},
						stroke: {
							color: '#fff',
							width: 2
						},
						startAngle: 2
					}
				},
				legend: {
					show: true,
					position: position || "ne", 
					labelBoxBorderColor: null,
					margin:[-30,15]
				}
				,
				grid: {
					hoverable: true,
					clickable: true
				}
			 })
		 }
		 drawPieChart(placeholder, data);
		
		 /**
		 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
		 so that's not needed actually.
		 */
		 placeholder.data('chart', data);
		 placeholder.data('draw', drawPieChart);

		  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
		  var previousPoint = null;
		
		  placeholder.on('plothover', function (event, pos, item) {
			if(item) {
				if (previousPoint != item.seriesIndex) {
					previousPoint = item.seriesIndex;
					var tip = item.series['label'] + " : " + item.series['percent']+'%';
					$tooltip.show().children(0).text(tip);
				}
				$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
			} else {
				$tooltip.hide();
				previousPoint = null;
			}
			
		 });
			 
         $("#qzcode").qrcode({ 
            render: "table", //table方式 
            width: 300, //宽度 
            height:300, //高度 
            text: content//任意内容 
        }); 
      })
       </script>
       </div><!-- /.col-xs-12 -->
      </div> <!-- /.row --> 
     </div> <!-- /.page-content --> 
    </div> <!-- /.main-content --> 
    <!-- 工具导入 -->
    <jsp:include page="tool.jsp"></jsp:include>
    <!-- /#ace-settings-container --> 
   </div> 
   <!-- /.main-container-inner --> 
   <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="icon-double-angle-up icon-only bigger-110"></i> </a> 
  </div>  
 </body>
</html>
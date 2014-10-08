<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="currentPage" type="java.lang.Long" required="true"%>
<%@ attribute name="pageSize" type="java.lang.Long" required="true"%>
<%@ attribute name="pagerRange" type="java.lang.Long" required="true"%>
<%@ attribute name="totalPage" type="java.lang.Long" required="true"%>
<%@ attribute name="totalElement" type="java.lang.Long" required="true"%>
<%@ attribute name="formId" type="java.lang.String" required="true"%>
<%
	// http://blog.csdn.net/tomatozq/article/details/8215946
	long begin = Math.max(1, currentPage - pagerRange / 2);//循环显示分页
	long end = Math.min(begin + (pagerRange - 1), totalPage);//循环显示分页
	request.setAttribute("pageBegin", begin);
	request.setAttribute("pageEnd", end);
%>
<div class="col-sm-6">
<div id="pager" >
	<label>显示 
		<select size="1" onchange="javascript:gotoPage(<%=currentPage%>)" id="p_pageSizeSelect">
			<option value="10"  <c:if test="${pageSize==10}">selected</c:if>>10</option>
			<option value="25"  <c:if test="${pageSize==25}">selected</c:if>>25</option>
			<option value="50"  <c:if test="${pageSize==50}">selected</c:if>>50</option>
			<option value="100" <c:if test="${pageSize==100}">selected</c:if>>100</option>
		</select> 
	记录</label>
	|&nbsp;<label>共 ${totalElement} 记录&nbsp;|&nbsp;共${totalPage }页</label>
	</div ><!--#page  -->
</div>
<div class="col-sm-6">
	<div class="dataTables_paginate paging_bootstrap">
		<ul class="pagination">
			<%if (currentPage != 1){ %>
				<li class="prev "><a href="javascript:gotoPage(1)"><i class=" icon-double-angle-left "></i></a></li>
				<li class="prev "><a href="javascript:gotoPage(<%=currentPage - 1%>)"><i class=" icon-angle-left "></i></a></li>
			<%}else{ %>
				<li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-double-angle-left "></i></a></li>
				<li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-angle-left "></i></a></li>
			<%} %>
			<c:forEach var="i"  begin="${pageBegin }" end="${pageEnd }">
				<c:choose>
					<c:when test="${i == currentPage }">
						<li class="active"><a href="javascript:void(0)">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:gotoPage(${i })" >${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%if (currentPage != totalPage){ %>
				<li class="next"><a href="javascript:gotoPage(<%=currentPage + 1%>)"><i class="icon-angle-right "></i></a></li>
				<li class="next "><a href="javascript:gotoPage(<%=totalPage%>)"><i class="icon-double-angle-right "></i></a></li>
			<%}else{ %>
				<li class="next disabled"><a href="javascript:void(0)"><i class="icon-angle-right "></i></a></li>
				<li class="next disabled"><a href="javascript:void(0)"><i class="icon-double-angle-right "></i></a></li>
			<%} %>
		</ul>
	</div><!-- dataTables_paginate paging_bootstrap -->
</div><!-- col-sm-6 -->
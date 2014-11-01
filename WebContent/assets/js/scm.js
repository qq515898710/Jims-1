//定时跳转
function countDown(time,url){
    $("#mysecond").text(time);//<span>中显示的内容值
     if(url==''){
             url="/";
     }
     if(--time>0){
            setTimeout("countDown("+time+",'"+url+"')",1000);//设定超时时间
     }
     else{
         location.href=url;//跳转页面
     }
}

/** 二维码* */
function toUtf8(str) {
	var out, i, len, c;
	out = "";
	len = str.length;
	for (i = 0; i < len; i++) {
		c = str.charCodeAt(i);
		if ((c >= 0x0001) && (c <= 0x007F)) {
			out += str.charAt(i);
		} else if (c > 0x07FF) {
			out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
			out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
			out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
		} else {
			out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
			out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
		}
	}
	return out;
}

//分页显示工具
function gotoPage(pageIndex) {
	var action = $('#queryform').attr('action');
	var pagerRange = 6;//
	var pageSize =  $("#p_pageSizeSelect").val(); //获取每一页显示多少记录
	var loc='<div class="col-sm-6"><div class="dataTables_paginate paging_bootstrap"><ul class="pagination">';
	$('#tb').html("");
	$.ajax({
				url : action,
				type : 'get',
				data : "page=" + pageIndex + "&size=" + pageSize,
				aysnc : false,
				success : function(msg) {
					$.each(msg.content, function(i, item) {
			              $('#tb').append( '<tr>'
			            		  +'<td><label> <input type="checkbox" class="ace" id="'+item.id+'" /><span class="lbl"></span> </label></td>'
			            		  +'<td >'+(++i)+'</td> '
			            		  +'<td >'+item.name+'</td> '
			            		  +'<td >'+item.address+'</td> '
			            		  +'<td >'+item.email+'</td> '
			            		  +'<td >'+item.phone+'</td> '
			            		  +'<td >'+'<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
			            		  				+'<a class="blue" href="#"> <i class="icon-zoom-in bigger-130"></i>'
			            		  				+'<a class="green" href="#"> <i class="icon-pencil bigger-130"></i> </a>'
			            		  				+'<a class="red" href="#" id="'+item.id+'" data-toggle="modal"  data-target="#delete-dialog-message"> <i class="icon-trash bigger-130"></i> </a>'+'</td> '+'</tr>');
			            });
						var begin = Math.max(1, msg.currentPage - pagerRange/2 );
						var end = Math.min(begin + (pagerRange - 1), msg.totalPage);
						if(msg.currentPage !=1){
							loc+='<li class="prev "><a href="javascript:gotoPage(1)"><i class=" icon-double-angle-left "></i></a></li><li class="prev "><a href="javascript:gotoPage('+(msg.currentPage - 1)+')"><i class=" icon-angle-left "></i></a></li>';
						}else{
							loc+='<li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-double-angle-left "></i></a></li><li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-angle-left "></i></a></li>';
						}
						for(var i = begin; i <= end; i++){
							if(msg.currentPage == i){
								loc+='<li class="active"><a href="javascript:void(0)">'+i+'</a></li>'
							}else{
								loc+='<li><a href="javascript:gotoPage('+i +')" >'+i+'</a></li>'
							}
						}
						if(msg.currentPage!=msg.totalPage){
							loc+='<li class="next"><a href="javascript:gotoPage('+(msg.currentPage + 1)+')"><i class="icon-angle-right "></i></a></li><li class="next "><a href="javascript:gotoPage('+msg.totalPage+')"><i class="icon-double-angle-right "></i></a></li>';
						}else{
							loc+='<li class="next disabled"><a href="javascript:void(0)"><i class="icon-angle-right "></i></a></li><li class="next disabled"><a href="javascript:void(0)"><i class="icon-double-angle-right "></i></a></li>';
						}
						loc+='</ul></div></div>';
						$('#pages').html(loc);
						$("#other").html('<label >共 '+msg.totalElement+' 记录&nbsp;|&nbsp;共 '+msg.totalPage +' 页</label>');
				}
			});
}

//function deleteCustomer() {
//	$("#mytable tr").each(function(i) {
//		var chk = $(this).find("input[type='checkbox']:checked");
//		if (chk.attr("id") != "checkall") {// 不能删除标题行
//			if (chk.attr("checked")) {
//				$(this).remove();
//			}
//		}
//	});
//}

// 将一个表单的数据返回成JSON对象
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
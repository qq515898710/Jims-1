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
// 分页caozuoyuanguanli.jsp
function gotoPage(pageIndex) {
	var action = $('#queryform').attr('action');
	var pageSize = $("#p_pageSizeSelect").val();
	$.ajax({
				url : action,
				type : 'get',
				data : "page=" + pageIndex + "&size=" + pageSize,
				aysnc : false,
				success : function(msg) {
					alert(msg.success);
//					$.each(data.data.content, function(i, item) {  
//			              $('#tb').append( '<tr>'
//			            		  +'<td><label> <input type="checkbox" class="ace" /><span class="lbl"></span> </label></td>'
//			            		  +'<td >'+item.id+'</td> '+'</tr>');
//			            });
				}
			});
	// var action = $('#queryform').attr('action');
	// var pageSize = $("#p_pageSizeSelect").val();
	// action += "/" + pageIndex + "/" + pageSize;
	// // alert(action);
	// $("#queryform").attr("action", action);
	// $("#queryform").submit();
}

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
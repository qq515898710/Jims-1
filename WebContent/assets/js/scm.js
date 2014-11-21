function goPage(url) {
	location.href = url;// 跳转页面
}
// 定时跳转
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
function gotoPage(pageIndex, cond) {
	var action = 'coop/pageOfCustomersByName';
	var pagerRange = 6;//
	var pageSize =  $("#p_pageSizeSelect").val(); //获取每一页显示多少记录
	var loc='<div class="col-sm-6"><div class="dataTables_paginate paging_bootstrap"><ul class="pagination">';
	$('#tb').html("");
	//TODO 测试用
	//alert("page=" + pageIndex + "&size=" + pageSize+"&"+cond);
	$.ajax({
				url : action,
				type : 'get',
				data : "page=" + pageIndex + "&size=" + pageSize+"&"+cond,
				aysnc : false,
				beforeSend:function(XMLHttpRequest){
					  //TODO 测试用
		              //alert('远程调用开始...');
		              $("#table-result").showLoading();
		         },
				success : function(msg) {
					$.each(msg.content, function(i, item) {
			              $('#tb').append( '<tr>'
			            		  +'<td><label> <input type="checkbox" class="ace" name="checkbox" value="'+item.id+'" /><span class="lbl"></span> </label></td>'
			            		  +'<td >'+(++i)+'</td> '
			            		  +'<td >'+item.name+'</td> '
			            		  +'<td >'+item.address+'</td> '
			            		  +'<td >'+getFormatDateByLong(item.time,'yyyy-MM-dd')+'</td> '
			            		  +'<td >'+item.phone+'</td> '
			            		  +'<td >'+'<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons" id="buttontools">'
			            		  				+'<a class="blue" href="javascript:showCustomer(\''+item.id+'\')"> <i class="icon-zoom-in bigger-130"></i>'
			            		  				+'<a class="green" href="javascript:editCustomer(\''+item.id+'\')" > <i class="icon-pencil bigger-130"></i> </a>'
			            		  				+'<a class="red" href="javascript:deleteCustomer(\''+item.id+'\')" > <i class="icon-trash bigger-130"></i> </a>'+'</td> '+'</tr>');
			            });
						var begin = Math.max(1, msg.currentPage - pagerRange/2 );
						var end = Math.min(begin + (pagerRange - 1), msg.totalPage);
						if(msg.currentPage !=1){
							loc+='<li class="prev "><a href="javascript:gotoPage(1,\''+cond+'\')"><i class=" icon-double-angle-left "></i></a></li><li class="prev "><a href="javascript:gotoPage('+(msg.currentPage - 1)+',\''+cond+'\')"><i class=" icon-angle-left "></i></a></li>';
						}else{
							loc+='<li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-double-angle-left "></i></a></li><li class="prev disabled"><a href="javascript:void(0)"><i class=" icon-angle-left "></i></a></li>';
						}
						for(var i = begin; i <= end; i++){
							if(msg.currentPage == i){
								loc+='<li class="active"><a href="javascript:void(0)">'+i+'</a></li>'
							}else{
								loc+='<li><a href="javascript:gotoPage('+i +',\''+cond+'\')" >'+i+'</a></li>'
							}
						}
						if(msg.currentPage!=msg.totalPage){
							loc+='<li class="next"><a href="javascript:gotoPage('+(msg.currentPage + 1)+',\''+cond+'\')"><i class="icon-angle-right "></i></a></li><li class="next "><a href="javascript:gotoPage('+msg.totalPage+',\''+cond+'\')"><i class="icon-double-angle-right "></i></a></li>';
						}else{
							loc+='<li class="next disabled"><a href="javascript:void(0)"><i class="icon-angle-right "></i></a></li><li class="next disabled"><a href="javascript:void(0)"><i class="icon-double-angle-right "></i></a></li>';
						}
						loc+='</ul></div></div>';
						$('#pages').html(loc);
						$("#other").html('<a href="javascript:gotoPage(1,\'name=&beginTime=&endTime=\')" ><i class="icon-refresh"></i></a>&nbsp;|&nbsp;<label >共 '+msg.totalElement+' 记录&nbsp;|&nbsp;共 '+msg.totalPage +' 页</label>');
						$("#table-result").hideLoading();
				},
				complete:function(XMLHttpRequest,textStatus){
					  //TODO 测试用
		              // alert('远程调用成功，状态文本值：'+textStatus);
					$("#table-result").hideLoading();
		         },
		         error:function(XMLHttpRequest,textStatus,errorThrown){
		              alert('error...状态文本值：'+textStatus+" 异常信息："+errorThrown);
		              $("#table-result").hideLoading();
		          }
			});
}

function showCustomer(id){
	var searchId=id;
	$.ajax({
	    type: "POST", 
	    url: "coop/searchCustomerById", 
	    data: "searchId=" + searchId, 
	    dataType: "json",
		beforeSend:function(XMLHttpRequest){
			  //TODO 测试用
            //alert('远程调用开始...');
            $("#table-result").showLoading();
        },
	    success: function (data){
	    	if(data.name != null && data.name != ''){
	    		$("#detailed-name").html(data.name);
	    	}else{
	    		$("#detailed-name").html('未知');
	    	}
	    	if(data.abbreviation != null && data.abbreviation != ''){
	    		$("#detailed-abbreviation").html(data.abbreviation);
	    	}else{
	    		$("#detailed-abbreviation").html('未知');
	    	}
	    	if(data.address != null && data.address != ''){
	    		$("#detailed-address").html(data.address);
	    	}else{
	    		$("#detailed-address").html('未知');
	    	}
	    	if(data.postalCode!=null && data.postalCode!=''){
	    		$("#detailed-postalCode").html(data.postalCode);
	    	}else{
	    		$("#detailed-postalCode" ).html('未知');
	    	}
	    	if(data.phone!=null && data.phone!=''){
	    		$("#detailed-phone").html(data.phone);
	    	}else{
	    		$("#detailed-phone").html('未知');
	    	}
	    	if(data.fax!=null && data.fax!=''){
	    		$("#detailed-fax").html(data.fax);
	    	}else{
	    		$("#detailed-fax").html('未知');
	    	}
	    	if(data.contacts!=null && data.contacts!=''){
	    		$("#detailed-contacts").html(data.contacts);
	    	}else{
	    		$("#detailed-contacts").html('未知');
	    	}
	    	if(data.telephone!=null && data.name!=''){
	    		$("#detailed-telephone").html(data.telephone);
	    	}else{
	    		$("#detailed-telephone").html('未知');
	    	}
	    	if(data.email!=null && data.email!=''){
	    		$("#detailed-email").html(data.email);
	    	}else{
	    		$("#detailed-email").html('未知');
	    	}
	    	if(data.depositBank!=null && data.depositBank!=''){
	    		$("#detailed-depositBank").html(data.depositBank);
	    	}else{
	    		$("#detailed-depositBank").html('未知');
	    	}
	    	if(data.accountBank!=null && data.accountBank!=''){
	    		$("#detailed-accountBank").html(data.accountBank);
	    	}else{
	    		$("#detailed-accountBank").html('未知');
	    	}
	    	$("#table-result").hideLoading();
	    },
		complete:function(XMLHttpRequest,textStatus){
			  //TODO 测试用
            // alert('远程调用成功，状态文本值：'+textStatus);
			$("#table-result").hideLoading();
       },
       error:function(XMLHttpRequest,textStatus,errorThrown){
            alert('error...状态文本值：'+textStatus+" 异常信息："+errorThrown);
            $("#table-result").hideLoading();
        }
	});
	$('#detailed-dialog-message').modal('show');
}

function deleteCustomer(id){
	deleteIds = id;
	$("#delete-content").html("确定删除选中的记录?");
	$("#alert").html("");
	$('#delete-dialog-message').modal('show');
}

function editCustomer(id) {
	var searchId=id;
	$("#alert").html("");
	$.ajax({
	    type: "POST", 
	    url: "coop/searchCustomerById", 
	    data: "searchId=" + searchId, 
	    dataType: "json", 
	    success: function (data){
			 $("#edit-id").attr("value",data.id);
			 $("#edit-name").attr("value",data.name);
			 $("#edit-abbreviation").attr("value",data.abbreviation);
			 $("#edit-address").attr("value",data.address);
			 $("#edit-postalCode").attr("value",data.postalCode);
			 $("#edit-phone").attr("value",data.phone);
			 $("#edit-fax").attr("value",data.fax);
			 $("#edit-contacts").attr("value",data.contacts);
			 $("#edit-telephone").attr("value",data.telephone);
			 $("#edit-email").attr("value",data.email);
			 $("#edit-depositBank").attr("value",data.depositBank);
			 $("#edit-accountBank").attr("value",data.accountBank);
			 $("#edit-time").attr("value",data.time);
		}
	 });
	$("#alert").html("");
	$('#edit-dialog-message').modal('show');
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
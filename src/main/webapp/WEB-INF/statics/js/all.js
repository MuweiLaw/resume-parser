
function initObjectData(obj) {
	if(!obj) {
		return '';
	}
	return obj;
}

//paraName 等找参数的名称
function getUrlParam(paraName) {
	var url = document.location.toString();
	var arrObj = url.split("?");
	if(arrObj.length > 1) {
		var arrPara = arrObj[1].split("&");
		var arr;
		for(var i = 0; i < arrPara.length; i++) {
			arr = arrPara[i].split("=");
			if(arr != null && arr[0] == paraName) {
				return arr[1];
			}
		}
		return "";
	} else {
		return "";
	}
}
//将html转换成text
/**
 * 去掉空格
 *  </p> => \n
 * @param html
 * @returns {string}
 */
function html2text(html) {
	return html.replace(/&nbsp;/g, '').replace(/<p>/g, '').replace(/<\/p>/g, '\n');
}

function text2html(text) {
	var textArr = text.split('\n');
	var html = '';

	$.each(textArr, function (i, item) {
		html += '<p>'+item+'</p>';
	});

	return html;
}

//获取等级比例
function getLevelPersent(name) {
	if(name == 'EXCELLENT') {
		return 100;
	} else if(name == 'SKILLED') {
		return 75;
	} else if(name == 'GOOD') {
		return 50;
	} else if(name == 'NORMAL') {
		return 25;
	}
	return 0;
}
//求职反馈类型
function getFeedBackOrder(name){
	if(name == '邀请面试') {
		return 1;
	} else if(name == '暂不合适') {
		return 3;
	} else if(name == '有意向') {
		return 1;
	} else if(name == '已查看') {
		return 2;
	}
	return 2;
}

//校验手机号
function isPhoneNo(phoneNo) {
	var regex = /^[1][3456789][0-9]{9}$/;
	return regex.test(phoneNo);
}

//校验邮箱
function isEmail(val_) {
	var regex = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
	return regex.test(val_);
}

//校验用户名
function isUserName(val_) {
	var regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/;
	return regex.test(val_);
}

//密码强度验证
function isPwd(val_) {
	//var regex = /(?!^(\d+|[a-zA-Z]+|[~!@#$%^&*?]+)$)^[\w~!@#$%^&*?]{12,16}$/;
	var regex = /((?=.*[a-z])(?=.*\d)|(?=[a-z])(?=.*[#@!~%^&*])|(?=.*\d)(?=.*[#@!~%^&*]))[a-z\d#@!~%^&*]{6,16}/gi;
	return regex.test(val_);
}

//弱中强
function checkPwd(msg) { //判断含有数字字母特殊符号
	var lvl = 0;      
	if(msg.match(/[0-9]/)) {
		lvl++;
	}

	if(msg.match(/[a-zA-Z]/)) {
		lvl++;
	}

	if(msg.match(/[^0-9a-zA-Z]/)) {
		lvl++;
	}   
	if(msg.length < 10 && msg.length >= 6) {        
		lvl--;      
	}      
	return lvl;    
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for(var i = 0; i < ca.length; i++) {
		var c = $.trim(ca[i]);
		if(c.indexOf(name) == 0) return c.substring(name.length, c.length);
	}
	return "";
}

function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	var domain = window.location.hostname;
	if (/localhost|127.0.0.1/g.test(domain)) {
		document.cookie = cname + "=" + cvalue + "; " + expires+'; path=/;';
	} else {
		document.cookie = cname + "=" + cvalue + "; " + expires+'; path=/;domain=.decheng1024.com';
	}

}
function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	document.cookie= name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/;domain=.decheng1024.com";
	var domain = window.location.hostname;
	if (/localhost|127.0.0.1/g.test(domain)) {
		document.cookie= name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/;";
	} else {
		document.cookie= name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/;domain=.decheng1024.com";
	}
}

//ajax
function ajaxAll(ajax_) {
	jQuery.support.cors=true;
	$.ajax({
		type: ajax_.type || "POST",
		url: host + (ajax_.url || ''),
		data: ajax_.data || {},
		headers: {
			'token': getCookie('company_token')
		},
		dataType: ajax_.dataType || "text",
		crossDomain: true,
		beforeSend: ajax_.beforeSend || function(xhr) {},
		success: ajax_.success || function (res) {},
		error: function(result) {
			ajax_.error && ajax_.error(result);
			try {
				var res = JSON.parse(result.responseText);
				if (res.message == '700:login') {
					delCookie("company_token");
					delCookie("company_user");
                    delCookie("enterprise_state");
					window.parent.location.href = '../signin/signin.html';
				}
			} catch (e) {}
		}
	});
}

/**
 *
 * @param currentPage
 * @param pageCount
 * @param total
 * @returns {string} 返回分页字符串
 */
function createPagination(currentPage, pageSize, total){

	var appendStr = '';
	var prevClass = 'pageItem';
	var nextClass = 'pageItem';
	var pageClass = 'pageItem';
	var prevPage = parseInt(currentPage) - 1;
	var nextPage = parseInt(currentPage) + 1;
	var minshowPageNumber = 1;
	var maxShowPageCount=5;
	var pageCount = Math.ceil(total / pageSize);

	if(currentPage - parseInt(maxShowPageCount/2) > 0 && currentPage + parseInt(maxShowPageCount/2) <= pageCount){
		minshowPageNumber = currentPage - parseInt(maxShowPageCount/2);
	}else if(currentPage - parseInt(maxShowPageCount/2) > 0 && currentPage + parseInt(maxShowPageCount/2) > pageCount){
		minshowPageNumber = pageCount - parseInt(maxShowPageCount-1);
		if(minshowPageNumber <= 0){
			minshowPageNumber = 1;
		}
	}

	if(prevPage <= 0){
		prevClass = 'pageItemDisable';
	}
	if(nextPage > pageCount){
		nextClass = 'pageItemDisable';
	}
	/*appendStr +='<li class="allPage">一共<span>'+total+'</span>条数据</li>';*/
	appendStr +='<li class="allPage">共<span>'+currentPage + '/'+pageCount+'</span>页</li>';

	if (pageCount <= 1) {
		return appendStr;
	}

	appendStr += '<li class="'+prevClass+'" data-page="1" data-rel="firstpage">首页</li>';
	appendStr += '<li class="'+prevClass+'" data-page="'+prevPage+'" data-rel="prevpage"><span class="prev-icon"></span></li>';

	var $length = pageCount < maxShowPageCount ? pageCount : maxShowPageCount;
	var pageNumber;

	for(var i = 0;i < $length;i++){
		pageNumber = minshowPageNumber++;
		if(pageNumber == currentPage){
			pageClass = 'pageItem active';
		} else {
			pageClass = 'pageItem';
		}
		appendStr += '<li class="'+pageClass+'" data-page="'+pageNumber+'" data-rel="itempage">'+pageNumber+'</li>';
	}

	appendStr += '<li class="'+nextClass+'" data-page="'+nextPage+'" data-rel="nextpage"><span class="next-icon"></span></li>';
	appendStr += '<li class="'+nextClass+'" data-page="'+pageCount+'" data-rel="lastpage">尾页</li>';

	return appendStr;

}


$(document).ready(function() {
	$('.logout').on('click', function () { //企业版退出登录
		ajaxAll({
			url: "/token/user/logout",
			success: function(result) {
				var res = JSON.parse(result);

				if(res.code == 'success') {
					//清除缓存

					delCookie("company_user");
					delCookie("company_token");
					delCookie("enterprise_state");
					window.parent.location.href = '../signin/signin.html';
				} else {
					alert('退出失败!');
				}
			},
			error:function(err){
				console.log(err)
			}
		})
	});

	if ($('.wrapper .header').length > 0 && getCookie('company_token')) { ///token/company/unreadMessage 企业版头部信息
		ajaxAll({
			dataType: 'json',
			url: '/token/company/unreadMessage',
			success: function (resData) {
				if (resData.code == 'success' && resData.data) {
					$('.wrapper .header .company-name').html(resData.data.abbreviation);
					resData.data.logo && $('.wrapper .header .head-company-logo').attr('src', resData.data.logo);
					$('.wrapper .header .hr-desc').html(resData.data.realName+'&nbsp;&nbsp;' + resData.data.jobName);

					if (resData.data.number > 0) {
						$('.wrapper .header .notify-num').html(resData.data.number).show();
					}
					localStorage.setItem('company_info', JSON.stringify(resData.data));
				}
				$('.wrapper .header .logo').css('opacity', 1);
			},
			error: function () {
				$('.wrapper .header .logo').css('opacity', 1);
			}
		});
	}

});

var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?12905615085e3c5992568b3ed4704cc3";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
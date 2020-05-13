/*
 * max 总长度
 * cpg 当前页数
 * num  显示个数
 * showPageLen  分页显示个数
 * func 再调用数据
 * cls 类名
 */
function pageShow(max, cpg, num, showPageLen, func, cls) {
//	debugger
	var pageNum = Math.ceil(max / num),
		html = '',
		arr = [],
		n = '',
		falg = false,
		len = '';
	arr.length = pageNum < showPageLen ? pageNum : showPageLen;
	cpg = Number(cpg) == 0 ? cpg = 1 : Number(cpg);
	html += '<ul class="pageUl">';
	html += '<p class="page-text">总条数' + max + '条</p>';
	html += '<p class="page-text">总页数' + pageNum + '页</p>';
	if(cpg > 1) {
		html += '<li class="homePage" data-num="1">首页</li>';
		html += '<li class="prevPage page-text" data-num="' + (cpg - 1) + '">上一页</li>';
	};
	n = Math.ceil(showPageLen / 2);

	for(var i = 0; i < showPageLen; i++) {
		if(i < pageNum) {
			if(cpg <= n && cpg < showPageLen) {
				arr[i] = i + 1;
			} else if(cpg > pageNum - n + 1) {
				if(pageNum - (showPageLen - i - 1) == 0) {
					falg = true; //标识是否为0
				};
				arr[i] = falg ? pageNum + 1 - (showPageLen - i - 1) : pageNum - (showPageLen - i - 1);
			} else {
				arr[i] = cpg - (n - 1 - i);
			};
		};
	};

	len = arr.length;
	for(var i = 0; i < len; i++) {
		var active = cpg == arr[i] ? 'active' : '';
		html += '<li class="curpage ' + active + '" data-num="' + arr[i] + '">' + arr[i] + '</li>';
	};
	if(cpg < pageNum) {
		html += '<li class="nextPage page-text" data-num="' + (cpg + 1) + '">下一页</li>';
		html += '<li class="endPage page-text" data-num="' + pageNum + '">末页</li>';
	};
	html += '<input type="text" name="feedNum" value="" />';
	html += '<span class="feed">跳页</span>';
	html += '</ul>';

	cls = typeof cls == "undefined" ? '.pagination' : cls;
	$(cls).html($(html));
	clickpage(pageNum, func);
}

function clickpage(maxNum, func) {
	var feedNum = '';
	$('.pageUl').on('click', 'li', function() {
		feedNum = $(this).attr('data-num');
		var str = parseInt(feedNum);
		func(str);

	});
	$('.pageUl').on('click', '.feed', function() {
		var reg = /^[\d]{0,}$/g;
		var dom = $(this);
		feedNum = dom.siblings('input[name="feedNum"]').val();
		if($.isArray(feedNum.match(reg))) {
			feedNum = feedNum.match(reg)[0];
			if(feedNum > maxNum || feedNum <= 0) return false;
			var str = parseInt(feedNum);
			func(str);
		};
	});
};

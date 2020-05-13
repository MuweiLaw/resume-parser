$(document).ready(function() {

    /*设置页面内容部分的最小高度*/
    var windowH = $(window).height();
    $('#main').css('min-height', windowH - 300);

    $('.footer-two>.page-1080 a ').attr('href','http://beian.miit.gov.cn/')


    $('body').on('click','.tab-nav-click ',function(){
        var URL=$(this).attr('data-url')
        if(URL) {
            window.location.href = URL;
        }
    })

    //退出
    $('body').on('click','#go-out', function () { //个人版退出登录
        ajaxAll({
            url: "/token/user/logout",
            success: function(result) {
                var res = JSON.parse(result);

                if(res.code == 'success') {
                    //清除缓存

                    delCookie("company_user");
                    delCookie("company_token");
                    delCookie("enterprise_state");
                    window.location.href = '../../project/signin/signin.html';
                } else {
                    alert('退出失败!');
                }
            },
            error:function(err){
                console.log(err)
            }
        })
    });

    //去登录
    $('body').on('click','#go-login-btn',function(){
        window.location.href = '../signin/signin.html';
    })
    //去注册
    $('body').on('click','#go-register-btn',function(){
        window.location.href = '../signin/signin.html?type=register';
    })

    //点击logo跳到首页
    $('body').on('click','#logo-img',function(){
        window.location.href = '../index/index.html';
    })
    //去企业
    $('body').on('click','#go-enterprise',function(){
        /*console.log(getCookie('enterprise_state'))
        var enterprise_state=getCookie('enterprise_state')
        switch (enterprise_state) {
            case 'INIT':
            case 'UNREGISTERED':
                redirectUrl = 'https://enterprise.decheng1024.com/authen/authen.html';
                break;
            case 'SUBAUTH_COMPANY':
            case 'SUBAUTH_MANAGEMENT':
            case 'AUTHREJECT_DATA':
            case 'AUTHREJECT_MANAGEMENT':
                redirectUrl = 'https://enterprise.decheng1024.com/examine/examine.html';
                break;
            case 'NORMOAL':
                redirectUrl = 'https://enterprise.decheng1024.com/index/index.html';
                break;
        }
        window.open('redirectUrl')*/
        var token=getCookie('company_token')
        if(token){
            window.open('https://enterprise.decheng1024.com')
        }else{
            window.open('https://enterprise.decheng1024.com/signin/signin.html')
        }


    })

    //banner图修改
    $('body').on('click','#banner-click>div',function(){
       var url=$(this).attr('data-url')
        window.open(url)

    })

    //了解得程
    $('body').on('click','.know-de-cheng',function(){
        window.open('../knowPage/knowPage.html')
    })
    //用户协议
    $('body').on('click','.user-protocol',function(){
        window.open('../protocolPage/protocolPage.html')
    })
    //得程APP
    $('body').on('click','.app-de-cheng',function(){
        window.open('../appPage/appPage.html')
    })
    //使用帮助
    $('body').on('click','.use-help',function(){
        window.open('../helpPage/helpPage.html')
    })
    //意见反馈feedback-opinion
    $('body').on('click','.feedback-opinion',function(){
        window.open('../feedbackPage/feedbackPage.html')
    })

    //点击显示图片
    $('body').on('click','.download-attention>div',function(){
        $('.download-attention>div').removeClass('active');
        $(this).addClass('active')
        var type=$(this).attr('data-type')
        if(type == 'one'){
            $('.img-one').show()
            $('.img-two').hide()
            $('.img-three').hide()
        }else if(type == 'two'){
            $('.img-one').hide()
            $('.img-two').show()
            $('.img-three').hide()
        }else{
            $('.img-one').hide()
            $('.img-two').hide()
            $('.img-three').show()
        }
    })

    // 计算字符串长度(英文占1个字符，中文汉字占2个字符)
    String.prototype.gblen = function() {
        var len = 0;
        for(var i = 0; i < this.length; i++) {
            if(this.charCodeAt(i) > 127 || this.charCodeAt(i) == 94) {
                len ++;
            } else {
                len++;
            }
        }
        return len;
    }
    /*
     * 截取指定字节长度的字符串
     * 注：半角长度为1，全角长度为2
     * str:字符串
     * len:截取长度
     * return: 截取后的字符串及是否截取的标记（扩展用）code=1 字符串截断   code=0  字符串未截断
     */
    window.cutStrByte = cutStrByte = function(str, len) {
        //校验参数
        if(!str || !len) {
            return {
                "cutStr": "",
                "code": 0
            };
        }
        var code = "1", // 默认返回code值，已截断
            strLen = str.length, // 原字符串长度
            cutStr;
        //如果字符串长度小于截取长度的一半,则返回全部字符串
        if(strLen <= len / 2) {
            cutStr = str;
            code = "0";
        } else {
            //遍历字符串
            var strByteCount = 0;
            for(var i = 0; i < strLen; i++) {
                //中文字符字节加2  否则加1
                strByteCount += getByteLen(str.charAt(i));
                //i从0开始 截断时大于len 只截断到第i个
                if(strByteCount > len) {
                    cutStr = str.substring(0, i);
                    break;
                } else if(strByteCount == len) {
                    cutStr = str.substring(0, i + 1);
                    break;
                }
            }
        }
        //cutstr为空，没有截断字符串
        if(!cutStr) {
            cutStr = str;
            code = "0";
        }
        return {
            "cutStr": cutStr,
            "code": code
        };
    }

    /**
     * 获取字节长度，全角字符两个单位长度，半角字符1个单位长度
     */
    window.getByteLen = getByteLen = function(val) {
        var len = 0;
        if(!val) {
            return len;
        }
        for(var i = 0; i < val.length; i++) {
            if(!val[i]) {
                continue;
            }
            // 全角
            if(val[i].match(/[^\x00-\xff]/ig) != null) {
                len += 2;
            } else {
                len += 1;
            }
        }
        return len;
    };

    var user = getCookie('company_user');
    if (user) {
        ajaxAll({
            // url: "/token/company/personUnreadMessage",
            url: "/token/company/queryPersonUnreadMessage",
            data: {},
            success: function(result) {
                var res=JSON.parse(result)
                var number=res.data.number
                if(parseInt(number)>0){
                    $('.about-tab>div:first-child').addClass('activeType')
                }
            },
            error:function(err){
                layer.alert('系统异常，请稍后重试', {icon: 5});
            }
        });
    }
});
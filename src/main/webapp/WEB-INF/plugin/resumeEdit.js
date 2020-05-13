var page = {
    searchTimer: null,
    /*数据处理*/
    data: {
        submitFlag:true,
        resume:{
            resumePreviewBasicInfoDTO: {},//基础信息
            socialContactList: [],//社交主页
            userEducationExperience: [],//教育经历
            userIntroduceDTO: {},//自我描述
            userJobIntentionDTO: {},//求职意向
            userProjectExperience: [],//项目经历
            workExperience: []//工作经历
        },
        baseData:window.ldsResumeDic
    },
    //倒计时
    countdown: function() {
        var that = this;
        var all_time = 60;
        timer = setInterval(function() {
            $('#sendCode').text(all_time + 's');
            all_time -= 1;
            $('#sendCode').css('pointer-events','none')
            if(all_time == -1) {
                clearInterval(timer);
                $('#sendCode').text('重发');
                $('#sendCode').css('pointer-events','')
                return true;
            }
        }, 1000);
    },
    /*样式处理*/
    styleDeal: function() {
        var that = this;
        var user = getCookie('company_user');
        var token=getCookie('company_token');

        if (user) {
            $('.no-login').hide()
            $('.have-login').show()
            $('.msg-resume-delivery').show()
            $('.userName').html(user)

        }else{
            $('.no-login').show()
            $('.have-login').hide()
            $('.msg-resume-delivery').hide()
        }
    },
    /*事件监听处理*/
    evenListen: function() {
        var that = this;
        var url=$(window.parent.document.getElementById("iframe")).attr('src')
        var urlArr=url.split('=')
        var resumeId=urlArr[1]
        console.log(resumeId);
        $('#onlineResumeId').val(resumeId)
        that.getResumeDetail(resumeId)

        // 选择热门城市
        $('body').on('click','#city-left .left-list-one',function(){
            var dom = $(this).parents('.select-lists-one');
            var index = $(this).index();
            $('#city-left .left-list-one').removeClass('active')
            $(this).addClass('active')
            dom.find('.select-lists-right').children('.right-list-one').hide();
            dom.find('.select-lists-right').children('.right-list-one').eq(index).show();
        });
        $('body').on('click','#city-right .list-val-one',function(){
            $('#city').val($(this).html())
            $('#city').attr('city-val',$(this).attr('data-val'))
        });

        //一级选择
        $('body').on('click','.select-val',function () {
            var dom=$(this).parent('.content-select')
            dom.find('.content-select-one').toggle()

        });
        $('body').on('click','.content-select-val',function(){
            var dom = $(this).parents('.content-select');
            var dataVal=$(this).attr('data-val');
            var dataHtml=$(this).html();
            dom.find('.select-val').val(dataHtml)
            dom.find('.select-val').attr('data-val',dataVal)
            $('.content-select-one').hide()
        });
        //二级选择
        $('body').on('click','.content-drop-value',function () {
            var dom=$(this).parent('.content-drop-down')
            dom.find('.drop-down-list-one').toggle()

        });
        $('body').on('click','.drop-down-left-val',function(){
            var dom = $(this).parents('.drop-down-list-one');
            var index = $(this).index();
            $('.drop-down-left-val').removeClass('active')
            $(this).addClass('active')
            dom.find('.drop-down-right').children('.drop-down-right-one').hide();
            dom.find('.drop-down-right').children('.drop-down-right-one').eq(index).show();
        });
        $('body').on('click','.drop-down-right-val',function(){
            var dom = $(this).parents('.content-drop-down');
            var dataVal=$(this).attr('data-val');
            var dataHtml=$(this).html();

            dom.find('.content-drop-value').val(dataHtml)
            dom.find('.content-drop-value').attr('data-val',dataVal)
            $('.drop-down-list-one').hide()
        });

        // 三级
        $('body').on('click','.drop-left-val',function(){
            var dom = $(this).parents('.drop-down-list-one');

            $('.drop-left-val').removeClass('active')
            $(this).addClass('active')
            var index = $(this).index();
            dom.find('.drop-middle').children('.drop-middle-one').hide();
            dom.find('.drop-middle').children('.drop-middle-one').eq(index).show();
            dom.find('.drop-right').children('.drop-right-one').hide()
            dom.find('.drop-right').children('.drop-right-one').eq(index).show()
            dom.find('.drop-right').children('.drop-right-one').eq(index).children('.drop-right-one-one').hide()
            dom.find('.drop-right').children('.drop-right-one').eq(index).children('.drop-right-one-one').eq(0).show()
        });
        $('body').on('click','.drop-middle-val',function(){
            var dom = $(this).parents('.drop-down-list-one');
            var index = $(this).index();
            var indexOne = $('.drop-left-val.active').index();
            dom.find('.drop-right').children('.drop-right-one').hide();
            dom.find('.drop-right').children('.drop-right-one').eq(indexOne).show();
            dom.find('.drop-right').children('.drop-right-one').eq(indexOne).children('.drop-right-one-one').hide()
            dom.find('.drop-right').children('.drop-right-one').eq(indexOne).children('.drop-right-one-one').eq(index).show()
            // dom.find('.drop-right').children('.drop-right-one-one').eq(index).show();
        });
        $('body').on('click','.drop-right-val',function(){
            var dom = $(this).parents('.content-drop-down');
            var dataVal=$(this).attr('data-val');
            var dataHtml=$(this).html();
            dom.find('.content-drop-value').val(dataHtml)
            dom.find('.content-drop-value').attr('data-val',dataVal)
            $('.drop-down-list-one').hide()
        });
        //选择性别
        $('body').on('click','#sex>span',function(){
            $('#sex span').removeClass('active')
            $(this).addClass('active')
            $("input[name='sex']").val($(this).attr('data-val'))
        });

        //修改头像
        $('body').on('click', '.change-person-icon', function() {
            $("input[name='files']").click();
            //监听上传文件
            $("input[name='files']").bind("change",function(){
                var fileType = $(this).val().substring($(this).val().lastIndexOf(".") + 1);
                if(this.files[0].size.toFixed(1) > 2 * 1024 *1024){
                    layer.alert('请选择小于2M的文件', {icon: 6});
                    $("input[name='files']").val('')
                    return;
                }
                if(fileType != "jpg" && fileType != "jpeg" && fileType != "png" && fileType != "gif" && fileType != "bmp" && fileType != "svg"){
                    layer.alert('只能上传图片文件类型：png、jpg、gif、bmp', {icon: 6});
                    $("input[name='files']").val('')
                    return;
                }
                that.updateUeadPortraitUrl();
            });
        });
        $('body').on('click','input[name="files"]',function(e){
            e.stopPropagation();
        });


        //选择搜索到的公司
        $('body').on('click','.company-lists .company-list-one',function(){
            var html=$(this).html();
            var companyId=$(this).attr('data-id')
            var dataType=$(this).attr('data-type')
            $('.company-lists').hide()
            $('.company-lists').html('')
            $('.modal-one .no-yes-shield').show()

            $('#companyName').val(html)
            $('.no-yes-shield').attr('company-id',companyId)
            $('.no-yes-shield').attr('data-type',dataType)
            if(dataType == 'noShield'){
                $('.no-yes-shield').addClass('no-shield')
                $('.no-yes-shield').removeClass('yes-shield')
                $('.no-yes-shield').html('屏蔽该公司')
            }else{
                $('.no-yes-shield').removeClass('no-shield')
                $('.no-yes-shield').addClass('yes-shield')
                $('.no-yes-shield').html('取消屏蔽该公司')
            }
        })
        //屏蔽或取消屏蔽公司
        $('body').on('click','.no-yes-shield',function(){
            var companyId=$(this).attr('company-id');

            var dataType=$(this).attr('data-type');
            if(dataType == 'noShield'){
                // 屏蔽公司-屏蔽公司
                that.userShieldCompany(companyId)
            }else{
                //屏蔽公司-取消屏蔽公司
                that.userCancelShieldCompany(companyId)
            }
        })    
        //点击编辑---个人信息
        $('body').on('click', '.edit-btn-personal', function() {
            var html=''
            layer.open({
                type: 1, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                skin: 'layer-modal-one', //样式类名
                title: "基本信息",
                area: ['850px', '500px'],
                closeBtn: 1, //不显示关闭按钮
                // anim: 2,
                shadeClose: true, //开启遮罩关闭
                content:that.personalModal(),
                success: function(layero) {

                    laydate.render({
                        elem: '#timeOne', //指定元素
                    });
                    laydate.render({
                        elem: '#time-two', //指定元素
                    });
                    var allCity = that.data.baseData.allCity;
                    console.log(allCity)
                    var htmlOne=''
                    var htmlTwo=''
                    for(var i=0;i<allCity.length;i++){
                        if(i==0){
                            htmlOne+='<div class="left-list-one active">'+allCity[i].name+'</div>'
                        }else{
                            htmlOne+='<div class="left-list-one">'+allCity[i].name+'</div>'
                        }

                        htmlTwo+='<div  class="right-list-one">'
                        var children=allCity[i].childNodeList;
                        for(var j=0;j<children.length;j++){
                            htmlTwo+='<span class="list-val-one ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                        }
                        htmlTwo+='</div>'
                    }
                    $('#city-left').html(htmlOne)
                    $('#city-right').html(htmlTwo)


                    //实时监听input的变化
                    $('#username').on('input propertychange', function() {
                        $('.name-actual-length').html($('#username').val().length)
                    });
                    $("input[name='email']").on('input propertychange', function() {
                        $('.email-actual-length').html($("input[name='email']").val().length)
                    });

                    that.initEditResumeBasicModal();
                }
            })
        });
        //点击编辑---自我介绍
        $('body').on('click', '.edit-btn-self', function() {
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1,
                    skin: 'layer-modal-two',
                    title: "自我描述",
                    area: ['796px', '554px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.selfDescriptionModal(),
                    success: function(layero) {
                        $('#selfDescription').on("keyup",function(){
                            var value = $('#selfDescription').val();
                            value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                            $('.self-description-actual').html(value.length)
                            if(value.length>200){
                                $('.self-description-actual').css('color','red')
                            }else{
                                $('.self-description-actual').css('color','#999999')
                            }
                        })

                        that.initSelfDescriptionModal();
                    }
                })
            }

        });
        //点击编辑---求职意向///es/saveJobIntention
        $('body').on('click', '.edit-job-intention', function() {
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1, //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    skin: 'layer-modal-six', //样式类名
                    title: "设置求职意愿",
                    area: ['850px', '500px'],
                    closeBtn: 1, //不显示关闭按钮
                    shadeClose: true, //开启遮罩关闭
                    content:that.jobIntentionModal(),
                    success: function(layero) {
                        //期望职位
                        var theFunction = that.data.baseData.theFunction;
                        var theFunctionOne=''
                        var theFunctionTwo=''
                        for(var i=0;i<theFunction.length;i++){
                            if(i==0){
                                theFunctionOne+='<div class="drop-down-left-val active">'+theFunction[i].name+'</div>'
                            }else{
                                theFunctionOne+='<div class="drop-down-left-val">'+theFunction[i].name+'</div>'
                            }

                            theFunctionTwo+='<div  class="drop-down-right-one">'
                            var children=theFunction[i].childNodeList;
                            for(var j=0;j<children.length;j++){
                                theFunctionTwo+='<span class="drop-down-right-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                            }
                            theFunctionTwo+='</div>'
                        }
                        $('.position-left').html(theFunctionOne)
                        $('.position-right').html(theFunctionTwo)

                        //行业
                        var industries = that.data.baseData.industries;

                        var htmlOne=''
                        var htmlTwo=''
                        for(var i=0;i<industries.length;i++){
                            if(i==0){
                                htmlOne+='<div class="drop-down-left-val active">'+industries[i].name+'</div>'
                            }else{
                                htmlOne+='<div class="drop-down-left-val">'+industries[i].name+'</div>'
                            }

                            htmlTwo+='<div  class="drop-down-right-one">'
                            var children=industries[i].childNodeList;
                            for(var j=0;j<children.length;j++){
                                htmlTwo+='<span class="drop-down-right-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                            }
                            htmlTwo+='</div>'
                        }
                        $('.industry-left').html(htmlOne)
                        $('.industry-right').html(htmlTwo)

                        //城市
                        var allCity = that.data.baseData.allCity;
                        var allCityOne=''
                        var allCityTwo=''
                        for(var i=0;i<allCity.length;i++){
                            if(i==0){
                                allCityOne+='<div class="drop-down-left-val active">'+allCity[i].name+'</div>'
                            }else{
                                allCityOne+='<div class="drop-down-left-val">'+allCity[i].name+'</div>'
                            }

                            allCityTwo+='<div  class="drop-down-right-one">'
                            var children=allCity[i].childNodeList;
                            for(var j=0;j<children.length;j++){
                                allCityTwo+='<span class="drop-down-right-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                            }
                            allCityTwo+='</div>'
                        }
                        $('.address-left').html(allCityOne)
                        $('.address-right').html(allCityTwo)

                        //期望薪资
                        var salaryLevel = that.data.baseData.salaryLevel;
                        var htmlFive=''
                        for(var i=0;i<salaryLevel.length;i++){
                            htmlFive+='<div class="content-select-val" data-val="'+salaryLevel[i].value+'">'+salaryLevel[i].name+'</div>'
                        }
                        $('.salary-level').html(htmlFive)

                        //求职状态
                        var jobStatus = that.data.baseData.jobStatus;
                        var jobStatusHtml=''
                        for(var i=0;i<jobStatus.length;i++){
                            jobStatusHtml+='<div class="content-select-val" data-val="'+jobStatus[i].value+'">'+jobStatus[i].name+'</div>'
                        }
                        $('.job-status').html(jobStatusHtml)

                        that.initEditJobIntentionModal();
                    }
                })
            }

        });

        /*-----------------------------------------------------添加和编辑相关模块-------------------------------------------*/
        //添加---工作经验
        $('body').on('click', '.add-work-experience-btn,.edit-work-experience-btn', function() {
            var type=$(this).attr('data-type');
            var title=''
            var workExpId='empty'
            if(type == "add"){
                var length = $('.work-experience-lists .work-experience-one').length;
                if(length == 10){
                    layer.alert('最多只能添加10个工作经历', {icon: 5});
                    return
                }
                title='添加工作经历'
            }else{
                title='编辑工作经历'
                workExpId=$(this).attr('work-id')
            }
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1,
                    skin: 'layer-modal-three',
                    title: title,
                    area: ['850px', '500px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.workExperienceModal(),
                    success: function(layero) {
                        laydate.render({
                            elem: '#beginDate',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date(value).getTime();
                                var endTime = new Date($('#endDate').val()).getTime();
                                if (endTime < startDate) {
                                    layer.msg('离职时间不能小于入职时间');
                                }
                            }
                        });
                        laydate.render({
                            elem: '#endDate',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date($('#beginDate').val()).getTime();
                                var endTime = new Date(value).getTime();
                                if (endTime < startDate) {
                                    layer.msg('离职时间不能小于入职时间');
                                }
                            }
                        });
                        $('#workDescription').on("keyup",function(){
                            var value = $('#workDescription').val();
                            value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                            $('.work-description-actual').html(value.length)
                            if(value.length>1000){
                                $('.work-description-actual').css('color','red')
                            }else{
                                $('.work-description-actual').css('color','#999999')
                            }
                        })

                        var industries = that.data.baseData.industries;

                        var htmlOne=''
                        var htmlTwo=''
                        for(var i=0;i<industries.length;i++){
                            if(i==0){
                                htmlOne+='<div class="drop-down-left-val active">'+industries[i].name+'</div>'
                            }else{
                                htmlOne+='<div class="drop-down-left-val">'+industries[i].name+'</div>'
                            }

                            htmlTwo+='<div  class="drop-down-right-one">'
                            var children=industries[i].childNodeList;
                            for(var j=0;j<children.length;j++){
                                htmlTwo+='<span class="drop-down-right-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                            }
                            htmlTwo+='</div>'
                        }
                        $('.industry-left').html(htmlOne)
                        $('.industry-right').html(htmlTwo)

                        var theFunction = that.data.baseData.theFunction;

                        var htmlThree=''
                        var htmlFour=''
                        for(var i=0;i<theFunction.length;i++){
                            if(i==0){
                                htmlThree+='<div class="drop-down-left-val active">'+theFunction[i].name+'</div>'
                            }else{
                                htmlThree+='<div class="drop-down-left-val">'+theFunction[i].name+'</div>'
                            }

                            htmlFour+='<div  class="drop-down-right-one">'
                            var children=theFunction[i].childNodeList;
                            for(var j=0;j<children.length;j++){
                                htmlFour+='<span class="drop-down-right-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</span>'
                            }
                            htmlFour+='</div>'
                        }
                        $('.function-left').html(htmlThree)
                        $('.function-right').html(htmlFour)

                        var salaryLevel = that.data.baseData.salaryLevel;
                        var htmlFive=''
                        for(var i=0;i<salaryLevel.length;i++){
                            htmlFive+='<div class="content-select-val" data-val="'+salaryLevel[i].value+'">'+salaryLevel[i].name+'</div>'
                        }
                        $('.salary-level').html(htmlFive)
                        $("input[name='companyName']").on('input propertychange', function() {
                            $('.company-actual-length').html($("input[name='companyName']").val().length)

                            // 延迟搜索
                            clearTimeout(page.searchTimer);
                            page.searchTimer = setTimeout(function () {
                                var companyName=$.trim($("input[name='companyName']").val());
                               // that.userShieldCompanySearchList(companyName)
                            }, 800);

                        });
                        /*$(".content-company").mouseout(function(){
                            $(".company-lists").hide()
                        });*/
                        $("input[name='position']").on('input propertychange', function() {
                            $('.position-actual-length').html($("input[name='position']").val().length)

                        });
                        $('.company-lists').html('')
                        $('.company-lists').hide()

                        that.initWorkExperienceModal(type,workExpId);
                    }
                })
            }

        });
        //添加---项目经验
        $('body').on('click', '.add-project-experience-btn,.edit-project-experience-btn', function() {
            var type=$(this).attr('data-type');
            var title=''
            var projectExpId='empty'
            if(type == "add"){
                var length = $('.project-experience-lists .project-experience-one').length;
                if(length == 10){
                    layer.alert('最多只能添加10个项目经历', {icon: 5});
                    return
                }
                title='添加项目经历'
            }else{
                title='编辑项目经历'
                projectExpId=$(this).attr('project-id')
            }
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1,
                    skin: 'layer-modal-four',
                    title: title,
                    area: ['850px', '500px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.projectExperienceModal(),
                    success: function(layero) {
                        laydate.render({
                            elem: '#beginDateOne',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date(value).getTime();
                                var endTime = new Date($('#endDateOne').val()).getTime();
                                if (endTime < startDate) {
                                    layer.msg('项目开始时间不能小于项目结束时间');
                                }
                            }
                        });
                        laydate.render({
                            elem: '#endDateOne',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date($('#beginDateOne').val()).getTime();
                                var endTime = new Date(value).getTime();
                                if (endTime < startDate) {
                                    layer.msg('项目开始时间不能小于项目结束时间');
                                }
                            }
                        });
                        $('#projectDescription').on("keyup",function(){
                            var value = $('#projectDescription').val();
                            value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                            $('.project-description-actual').html(value.length)
                            if(value.length>1000){
                                $('.project-description-actual').css('color','red')
                            }else{
                                $('.project-description-actual').css('color','#999999')
                            }
                        })


                        var workExperience = that.data.resume.workExperience;
                        var htmlSix='<div class="content-select-val" data-val="empty">不关联公司</div>'

                        if(workExperience.length != 0){
                            for(var i=0;i<workExperience.length;i++){
                                htmlSix+='<div class="content-select-val" data-val="empty">'+workExperience[i].companyName+'</div>'
                            }
                        }
                        $('.associate-company').html(htmlSix)

                        $("input[name='projectName']").on('input propertychange', function() {
                            $('.project-actual-length').html($("input[name='projectName']").val().length)
                        });

                        that.initProjectExperienceModal(type,projectExpId);
                    }
                })
            }

        });
        //添加--教育经历
        $('body').on('click', '.add-educational-experience-btn,.edit-educational-experience-btn', function() {
            var type=$(this).attr('data-type');
            var title=''
            var educationExpId='empty'
            if(type == "add"){
                var length = $('.educational-experience-lists .educational-experience-one').length;
                if(length == 10){
                    layer.alert('最多只能添加10个教育经历', {icon: 5});
                    return
                }
                title='添加教育经历'
            }else{
                title='编辑教育经历'
                educationExpId=$(this).attr('educational-id')
            }
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1,
                    skin: 'layer-modal-five',
                    title: title,
                    area: ['870px', '500px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.educationalExperienceModal(),
                    success: function(layero) {
                        laydate.render({
                            elem: '#beginDateTwo',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date(value).getTime();
                                var endTime = new Date($('#endDateTwo').val()).getTime();
                                if (endTime < startDate) {
                                    layer.msg('入校时间不能小于毕业时间');
                                }
                            }
                        });
                        laydate.render({
                            elem: '#endDateTwo',
                            format: 'yyyy-MM-dd',
                            done: function (value, date, endDate) {
                                var startDate = new Date($('#beginDateTwo').val()).getTime();
                                var endTime = new Date(value).getTime();
                                if (endTime < startDate) {
                                    layer.msg('入校时间不能小于毕业时间');
                                }
                            }
                        });
                        $('#educationalDescription').on("keyup",function(){
                            var value = $('#educationalDescription').val();
                            value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                            $('.educational-description-actual').html(value.length)
                            if(value.length>1000){
                                $('.educational-description-actual').css('color','red')
                            }else{
                                $('.educational-description-actual').css('color','#999999')
                            }
                        })

                        var educationLevel = that.data.baseData.educationLevel;

                        var htmlSeven=''
                        for(var i=0;i<educationLevel.length;i++){
                            htmlSeven+='<div class="content-select-val" data-val="'+educationLevel[i].value+'">'+educationLevel[i].name+'</div>'
                        }
                        $('.education-level').html(htmlSeven)

                        var professionDivison = that.data.baseData.professionDivison;

                        var pDHtmlOne=''
                        var pDHtmlTwo=''
                        var pDHtmlThree=''
                        for(var i=0;i<professionDivison.length;i++){
                            if(i==0){
                                pDHtmlOne+='<div class="drop-left-val active">'+professionDivison[i].name+'</div>'
                            }else{
                                pDHtmlOne+='<div class="drop-left-val">'+professionDivison[i].name+'</div>'
                            }

                            pDHtmlTwo+='<div  class="drop-middle-one">'
                            var children=professionDivison[i].childNodeList;
                            pDHtmlThree+='<div  class="drop-right-one">'
                            for(var j=0;j<children.length;j++){
                                pDHtmlTwo+='<div class="drop-middle-val ellipsis" data-val="'+children[j].value+'">'+children[j].name+'</div>'
                                var childrenOne=children[j].childNodeList;
                                pDHtmlThree+='<div  class="drop-right-one-one">'
                                for(var m=0;m<childrenOne.length;m++){
                                    pDHtmlThree+='<div class="drop-right-val ellipsis" data-val="'+childrenOne[m].value+'">'+childrenOne[m].name+'</div>'
                                }
                                pDHtmlThree+='</div>'
                            }
                            pDHtmlThree+='</div>'
                            pDHtmlTwo+='</div>'
                        }
                        $('.educational-left').html(pDHtmlOne)
                        $('.educational-middle').html(pDHtmlTwo)
                        $('.educational-right').html(pDHtmlThree)

                        $("input[name='schoolName']").on('input propertychange', function() {
                            $('.school-actual-length').html($("input[name='schoolName']").val().length)
                        });

                        that.initEducationalExperienceModal(type,educationExpId);
                    }
                })
            }

        });

        //添加--社交主页
        $('body').on('click', '.add-social-homepage-btn,.edit-social-homepage-btn', function() {
            var type=$(this).attr('data-type');
            var title=''
            var socialId='empty'
            var socialText='empty'
            if(type == "add"){
                var length = $('.social-homepage-lists .social-homepage-one').length;
                if(length == 10){
                    layer.alert('最多只能添加10个社交主页', {icon: 5});
                    return
                }
                title='添加社交主页'
            }else{
                title='编辑社交主页'
                socialId=$(this).attr('social-id')
                var dom=$(this).parents('.social-homepage-one')
                socialText=dom.find('a').html()
            }
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('请先编辑个人信息', {icon: 5});
            }else{
                var html=''
                layer.open({
                    type: 1,
                    skin: 'layer-modal-five',
                    title: title,
                    area: ['850px', '200px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.socialHomepageModal(),
                    success: function(layero) {
                        laydate.render({
                            elem: '#beginDateTwo',
                        });
                        laydate.render({
                            elem: '#endDateTwo',
                        });

                        $("input[name='socialWebsite']").on('input propertychange', function() {
                            $('.social-actual-length').html($("input[name='socialWebsite']").val().length)
                        });
                        that.initSocialHomepageModal(type,socialId,socialText);
                    }
                })
            }

        });

        //添加附件简历
        $('body').on('click', '.upload-resume-attachment-btn', function() {
            var onlineResumeId=$('#onlineResumeId').val();
            if(onlineResumeId == 'empty'){
                layer.alert('您需完善在线简历的<自我描述><个人信息><教育经历><求职意向>部分才能上传附件简历!', {icon: 5});
            }else{
                if(!that.data.resume.userIntroduceDTO || that.data.resume.userEducationExperience.length==0 ||!that.data.resume.userJobIntentionDTO){
                    var msg=''
                    if(!that.data.resume.userIntroduceDTO){
                        msg+='<自我描述>'
                    }
                    if(that.data.resume.userEducationExperience.length==0){
                        msg+='<教育经历>'
                    }
                    if(!that.data.resume.userJobIntentionDTO){
                        msg+='<求职意向>'
                    }

                    layer.alert('您需完善在线简历的'+msg+'部分才能上传附件简历!', {icon: 5});
                    return
                }

                /*if(!that.data.resume.userIntroduceDTO && that.data.resume.userEducationExperience.length==0 &&!that.data.resume.userJobIntentionDTO){
                    layer.alert('您需完善在线简历的<自我描述><教育经历><求职意向>部分才能上传附件简历!', {icon: 5});
                    return
                }else if(that.data.resume.userEducationExperience.length==0 &&!that.data.resume.userJobIntentionDTO){
                    layer.alert('您需完善在线简历的<教育经历><求职意向>部分才能上传附件简历!', {icon: 5});
                    return
                }else if(!that.data.resume.userJobIntentionDTO){
                    layer.alert('您需完善在线简历的<求职意向>部分才能上传附件简历!', {icon: 5});
                    return
                }*/
                var num=parseInt($('.annex-resume-num').html());
                if(num >= 5){
                    layer.alert("最多只能添加5份附件简历哟！！", {icon: 6});
                    return
                }
                layer.open({
                    type: 1,
                    skin: 'layer-modal-attachment',
                    title: '添加附件简历',
                    area: ['810px', '400px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content:that.resumeAttachmentModal(),
                    success: function(layero) {
                        //$('#uploadResumeAttachmentForm').html('<input id="fileName" type="file" name="file" style="opacity: 0;" />')
                    }
                })
            }


        });
        $('body').on('click', '.upload-resume-attachment', function() {

            var $fileInput;
            $fileInput =$(this).find('#fileName');
            $fileInput.click();
        });

       $('body').on('change', '#fileName', function () {
            var fileType = $(this).val().substring($(this).val().lastIndexOf(".") + 1);
            if(this.files[0].size.toFixed(1) > 2 * 1024 *1024){
                layer.alert('请选择小于2M的文件', {icon: 6});
                $('#fileName').val('')
                return false;
            }
            if(fileType != "docx" && fileType != "doc" && fileType != "pdf" && fileType != "txt" && fileType != "ppt" && fileType != "pptx" && fileType != "wps"){
                layer.alert('只能上传docx、doc、word、pdf、ppt、txt、pptx、wps格式文件', {icon: 6});
                $('#fileName').val('')
                return;
            }

            that.uploadResumeAttachment();
        });

        $('body').on('click','input[name="file"]',function(e){
            e.stopPropagation();

        });


        /*-----------------------------------------------------保存编辑的信息-----------------------------------------*/
        //保存---个人信息
        $('body').on('click','#userBasicInfoFormSubmit',function(){
            that.savePersonalInformation()
        })
        //保存---自我描述
        $('body').on('click','#selfDescriptionSubmit',function(){
            that.saveSelfDescription()
        })
        //保存---工作经验
        $('body').on('click','#workExperienceSubmit',function(){
            that.saveWorkExperience()
        })
        //保存---项目经历
        $('body').on('click','#projectExperienceSubmit',function(){
            that.saveProjectExperience()
        })
        //保存---教育经历
        $('body').on('click','#educationalExperienceSubmit',function(){
            that.saveEducationalExperience()
        })
        //保存---社交主页
        $('body').on('click','#socialHomepageSubmit',function(){
            that.saveSocialHomepage()
        })
        //保存---求职意向
        $('body').on('click','#jobIntentionSubmit',function(){
            that.saveJobIntention()
        })
        //保---存简历名renameSubmit
        $('body').on('click','#renameSubmit',function(){
            var attachmentId=$(this).attr('data-id');
            that.saveAttachment(attachmentId)
        })

        /*-----------------------------------------------------删除相关信息-------------------------------------------*/
        //删除---附件简历
        $('body').on('click','.del-annex-resume',function(){
            var attachmentId=$(this).attr('data-id');
            layer.confirm('确定删除附件简历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteAttachment(attachmentId)
            });
        })
        //删除---工作经历
        $('body').on('click','.delete-work-experience-btn',function(){
            var workExpId=$(this).attr('work-id');
            var dom=$(this).parents('.work-experience-one')
            layer.confirm('确定删除工作经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteWorkExperience(workExpId,dom)
            });
        });
        $('body').on('click','.delete-work-experience',function(){
            var workExpId=$(this).attr('work-id');
            var dom='delete'
            layer.confirm('确定删除工作经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteWorkExperience(workExpId,dom)
            });
        });
        //删除---项目经历
        $('body').on('click','.delete-project-experience-btn',function(){
            var projectExpId=$(this).attr('project-id');
            var dom=$(this).parents('.project-experience-one')
            layer.confirm('确定删除项目经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteProjectExperience(projectExpId,dom)
            });
        });
        $('body').on('click','.delete-project-experience',function(){
            var projectExpId=$(this).attr('project-id');
            var dom='delete'
            layer.confirm('确定删除项目经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteProjectExperience(projectExpId,dom)
            });
        });
        //删除---教育经历
        $('body').on('click','.delete-educational-experience-btn',function(){
            var eduExpId=$(this).attr('educational-id');
            var dom=$(this).parents('.educational-experience-one')
            layer.confirm('确定删除教育经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteEducationalExperience(eduExpId,dom)
            });
        })
        $('body').on('click','.delete-educational-experience',function(){
            var eduExpId=$(this).attr('educational-id');
            var dom='delete'
            layer.confirm('确定删除教育经历吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteEducationalExperience(eduExpId,dom)
            });
        });
        //删除---社交主页
        $('body').on('click','.delete-social-homepage-btn',function(){
            var socialId=$(this).attr('social-id');
            var dom=$(this).parents('.social-homepage-one')
            layer.confirm('确定删除社交主页吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteSocialHomepage(socialId,dom)
            });
        })

        $('body').on('click','.delete-social-homepage',function(){
            var socialId=$(this).attr('social-id');
            var dom='delete'
            layer.confirm('确定删除社交主页吗？', {icon: 3, title:'提示'}, function(index){
                that.deleteSocialHomepage(socialId,dom)
            });
        })

        //工作经历展开或显示
        $('body').on('click','.show-work-experience',function(){
            var type=$(this).attr('data-type');
            if(type == 'hide'){
                $('.work-experience-lists .work-experience-one').removeClass('work-experience-hide')
                $(this).attr('data-type','show');
                $('.show-work-experience').html('隐藏部分工作经历')
            }else{
                $(this).attr('data-type','hide');
                $('.show-work-experience').html('展开'+$('.work-experience-lists .work-experience-one').length+'个工作经历')
                $('.work-experience-lists .work-experience-one').each(function(index){
                    if(index > 1){
                        $(this).addClass('work-experience-hide')
                    }
                })
            }
        })

        //项目经历展开或显示
        $('body').on('click','.show-project-experience',function(){
            var type=$(this).attr('data-type');
            if(type == 'hide'){
                $('.project-experience-lists .project-experience-one').removeClass('project-experience-hide')
                $(this).attr('data-type','show');
                $('.show-project-experience').html('隐藏部分项目经历')
            }else{
                $(this).attr('data-type','hide');
                $('.show-project-experience').html('展开'+$('.project-experience-lists .project-experience-one').length+'个项目经历')
                $('.project-experience-lists .project-experience-one').each(function(index){
                    if(index > 1){
                        $(this).addClass('project-experience-hide')
                    }
                })
            }
        })

    },


    //编辑简历头像
    updateUeadPortraitUrl:function(){
        var that = this;
        var url = host + "/es/saveHeadUrl";
        $("#headPortraitUrlFileForm").attr("action", url);

        var token = getCookie('company_token');
        $("#headPortraitTokenId").val(token);
        var onlineResumeId=$('#onlineResumeId').val();
        $('#headPortraitResumeId').val(onlineResumeId)
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;

        var formData = new FormData(document.getElementById('headPortraitUrlFileForm'));
        $.ajax({
            url: url,
            type: "post",
            data: formData,
            processData: false,
            contentType: false,
            dataType:"text",
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function (result) {
                that.data.submitFlag = true;
                var res = result;
                if(res.code == 'success'){
                    $(".personal-logo>img").attr("src", res.data);
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        })

    },
    // 个人在线简历概览
    getResumeDetail:function(resumeId){
        var that = this;
        if(resumeId == ''){
            return;
        }
        $.ajax({
            url: "/es/previewResume",
            type:'POST',
            data:{"resumeId": resumeId},
            success: function(result) {
                var res = result;
                if (res.code == "success"){
                    that.data.resume=res.data;
                    that.initEditResumeBasicHtml(res.data.resumePreviewBasicInfoDTO)//基本信息
                    that.initSelfDescriptionHtml(res.data.userIntroduceDTO)//自我描述
                    that.initWorkExperienceHtml(res.data.workExperience)//工作经历
                    that.initProjectExperienceHtml(res.data.userProjectExperience)//项目经历
                    that.initEducationExperienceHtml(res.data.userEducationExperience)//教育经历
                    that.initJobIntentionHtml(res.data.userJobIntentionDTO)//求职意向

                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error:function(err){
                layer.alert(err.msg, {icon: 5});
            }
        })
    },
    //获取搜索的公司
    userShieldCompanySearchList:function(companyName){
        var that=this
        $.ajax({
            url: "/es/userShieldCompanySearchList",
            type:'POST',
            data: {
                'companyName':companyName
            },
            success: function(result) {
                var res=result
                if (res.code == "success") {
                    var data=res.data.data;
                    if(data.length != 0){
                        $('.modal-one .company-lists').show()
                        var html=''
                        for(var i=0;i<data.length;i++){
                            html+='<div class="company-list-one" data-id="'+data[i].companyId+'" data-type="'+(data[i].checkShield == 'N'?'noShield':'yesShield')+'">'+data[i].companyName+'</div>';
                        }
                        $('.modal-one .company-lists').html(html)
                    }else{
                        $('.modal-one .company-lists').hide()
                    }
                    /*
                    var data=res.data.data;
                    for(var i=0;i<data.length;i++){
                        html+='<div class="result-one">'+
                            '<span class="company-name ellipsis">'+(data[i].companyName?data[i].companyName:'')+'</span>'+
                            '<span data-id="'+data[i].companyId+'" data-type="'+(data[i].checkShield == 'N'?'noShield':'yesShield')+'" class="cancel-shield '+(data[i].checkShield == 'N'?'bag':'')+'">'+(data[i].checkShield == 'N'?'屏蔽':'取消屏蔽')+'</span>'+
                            '</div>';
                    }
                    $('.result-lists').html(html || '<div class="data-empty">没有相关搜索结果</div>')*/
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error:function(err){
                layer.alert('系统异常，请稍后重试', {icon: 5});
            }
        });
    },

    //屏蔽公司
    userShieldCompany:function(companyId){
        var that=this
        $.ajax({
            url: "/es/userShieldCompany",
            type:'POST',
            data: {
                'companyId':companyId
            },
            type:'GET',
            success: function(result) {
                var res=result
                if (res.code == "success") {
                    $('.no-yes-shield').attr('data-type','yesShield')
                    $('.no-yes-shield').removeClass('no-shield')
                    $('.no-yes-shield').addClass('yes-shield')
                    $('.no-yes-shield').html('取消屏蔽该公司')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error:function(err){
                layer.alert('系统异常，请稍后重试', {icon: 5});
            }
        });
    },
    //取消屏蔽公司
    userCancelShieldCompany:function(companyId){
        var that=this
        $.ajax({
            url: "/es/userCancelShieldCompany",
            type:"POST",
            data: {
                'companyId':companyId
            },
            type:'GET',
            success: function(result) {
                var res=result
                if (res.code == "success") {
                    $('.no-yes-shield').attr('data-type','noShield')
                    $('.no-yes-shield').addClass('no-shield')
                    $('.no-yes-shield').removeClass('yes-shield')
                    $('.no-yes-shield').html('屏蔽该公司')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error:function(err){
                layer.alert('系统异常，请稍后重试', {icon: 5});
            }
        });
    },

    /*---------------------------------------------------------------生成相关页面-------------------------------------*/
    initEditResumeBasicHtml:function(data){

        if(data != null){
            //用户名
            var sexVal=data.gender;
            var sexHtml=''
            if(sexVal == 'female'){
                sexHtml='<img src="../../common/img/female.png" alt="">'
            }else{
                sexHtml='<img src="../../common/img/male.png" alt="">'
            }
            $('.personal-name').html(data.username + sexHtml)
            //用户基本信息
            var html=(data.workYear == 0?'<span>无工作经验</span>':'<span>'+data.workYear+'年工作经验</span>')+
                (data.age?'<span>'+data.age+'岁</span>':'')+
                (data.educationLevel?'<span>'+data.educationLevel+'</span>':'');
            $('.personal-tag').html(html)
            //邮箱,手机号码
            var htmlOne=(data.phoneNo?'<span class="personal-phone">'+data.phoneNo+'</span>':'')+
                (data.email?'<span class="personal-email">'+data.email+'</span>':'');
            $('.personal-email-phone').html(htmlOne);
            //用户头相
            $('.personal-logo').html(data.headurl?'<img class="headerImg" src="'+data.headurl+'" alt="">':'<img class="headerImg" src="../../common/img/img-4.png" alt="">')
            var htmlTwo='<div class="change-person-icon">\n' +
                '                                        <form id="headPortraitUrlFileForm" enctype="multipart/form-data" method="post" action="">\n' +
                '                                            <input type="file" name="files" style="display:none">\n' +
                '                                            <input type="hidden" name="token" id="headPortraitTokenId">\n' +
                '                                            <input type="hidden" name="resumeId" id="headPortraitResumeId">' +
                '                                        </form>\n' +
                '                                    </div>';
            $('.personal-logo').append(htmlTwo);

        }

    },
    initSelfDescriptionHtml:function(data){
        $('.self-description').html(data?text2html(data.selfDescription):'')
    },
    initWorkExperienceHtml:function(data){
        $('.show-work-experience').html('展开'+data.length+'个工作经历')
        if(data.length != 0){
            var html=''
            for(var i=0;i<data.length;i++){
                var skillHtml=''
                var skill = data[i].skill
                if(skill.length != 0){
                    for(var j=0;j<skill.length;j++){
                        skillHtml+='<span>'+skill[i]+'</span>'
                    }
                }
                html+='<div class="list-one work-experience-one '+(i>1?'work-experience-hide':'')+'">' +
                            '<div class="edit-delete-btn">' +
                                '<span class="edit-list-btn edit-work-experience-btn" data-type="edit" work-id="'+data[i].workExpId+'">编辑</span>' +
                                '<span class="delete-list-btn delete-work-experience-btn" work-id="'+data[i].workExpId+'">删除</span>' +
                            '</div>' +
                            '<div class="company-name-salary-time">' +
                                (data[i].companyName?'<span class="company-name ellipsis">'+data[i].companyName+'</span>':'')+
                                (data[i].monthlySalaryName?'<span class="company-salary">在职薪资:'+data[i].monthlySalaryName+'</span>':'')+
                                '<span class="company-time">'+(data[i].beginDate.split('-').join('.'))+'-'+(data[i].endDate.split('-').join('.'))+'</span>'+
                            '</div>' +
                            '<div class="position-tag">' +
                                (data[i].position?'<span>'+data[i].position+'</span>':'')+
                                (data[i].department?'<span>'+data[i].department+'</span>':'')+
                            '</div>' +
                            '<div class="made-project">' +skillHtml+'</div>' +
                            '<div class="work-experience-description">'+(data[i].jobDescription?text2html(data[i].jobDescription):'')+'</div>'+
                        '</div>'
            }
            $('.work-experience-lists').html(html)
            if(data.length>2){
                $('.show-work-experience').show()
                $('.show-work-experience').attr('data-type','hide')
            }else{
                $('.show-work-experience').hide()
            }

        }else {
            $('.show-work-experience').hide()
        }

    },
    initProjectExperienceHtml:function(data){
        $('.show-project-experience').html('展开'+data.length+'个项目经历')
        if(data.length != 0) {
            var html = ''
            for (var i = 0; i < data.length; i++) {
                var projectLink = data[i].projectLink
                var projectLinkHtml=''
                if(projectLink){
                    var arr=projectLink.split(':');
                    if(arr[0] == "http" || arr[0] == "https"){
                        projectLinkHtml+='<a class="ellipsis" target="_blank" title="'+data[i].projectLink+'" href="'+data[i].projectLink+'">'+data[i].projectLink+'</a>'
                    }else{
                        projectLinkHtml+='<a class="ellipsis" target="_blank" title="'+data[i].projectLink+'" href="http://'+data[i].projectLink+'">'+data[i].projectLink+'</a>'
                    }
                }
                html+='<div class="list-one project-experience-one '+(i>1?'project-experience-hide':'')+'">' +
                            '<div class="edit-delete-btn">' +
                                '<span class="edit-list-btn edit-project-experience-btn" data-type="edit" project-id="'+data[i].projectExpId+'">编辑</span>' +
                                '<span class="delete-list-btn delete-project-experience-btn" project-id="'+data[i].projectExpId+'">删除</span>' +
                            '</div>' +
                            '<div class="project-name-time">' +
                                (data[i].projectName?'<span class="project-name ellipsis">'+data[i].projectName+'</span>':'')+
                                '<span class="project-time">'+(data[i].beginDate.split('-').join('.'))+'-'+(data[i].endDate.split('-').join('.'))+'</span>'+
                            '</div>' +
                            '<div class="project-tag">' +
                                (data[i].companyName?'<span class="ellipsis">'+data[i].companyName+'</span>':'')+
                                (data[i].projectRole?'<span>'+data[i].projectRole+'</span>':'')+
                            '</div>' +
                            '<div class="project-url">'+projectLinkHtml+'</div>' +
                            '<div class="project-experience-description">' +(data[i].projectDescription?text2html(data[i].projectDescription):'')+'</div>' +
                        '</div>'
            }
            $('.project-experience-lists').html(html)
            $('.show-project-experience').show()
            if(data.length>2){
                $('.show-project-experience').show()
                $('.show-project-experience').attr('data-type','hide')
            }else{
                $('.show-project-experience').hide()
            }
        }else{
            $('.show-project-experience').hide()
        }
    },
    initEducationExperienceHtml:function(data){

        if(data.length != 0) {
            var html = ''
            for (var i = 0; i < data.length; i++) {
                html+='<div class="list-one educational-experience-one">' +
                            '<div class="edit-delete-btn">' +
                                '<span class="edit-list-btn edit-educational-experience-btn" data-type="edit" educational-id="'+data[i].educationExpId+'">编辑</span>' +
                                '<span class="delete-list-btn delete-educational-experience-btn" educational-id="'+data[i].educationExpId+'">删除</span>' +
                            '</div>' +
                            '<div class="educational-name-time">' +
                                (data[i].schoolName?'<span class="educational-name ellipsis">'+data[i].schoolName+'</span>':'')+
                                '<span class="educational-time">'+(data[i].beginDate.split('-').join('.'))+'-'+(data[i].endDate.split('-').join('.'))+'</span>'+
                            '</div>' +
                            '<div class="educational-tag">' +
                                (data[i].educationLevelName?'<span>'+data[i].educationLevelName+'</span>':'')+
                                (data[i].specialtyName?'<span class="ellipsis">'+data[i].specialtyName+'</span>':'')+
                            '</div>' +
                        '</div>'
            }
            $('.educational-experience-lists').html(html)
        }
    },
    initSocialHomepageHtml:function(data){

        if(data.length != 0) {
            var html = ''
            for (var i = 0; i < data.length; i++) {
                var socialWebsite = data[i].socialWebsite
                var socialWebsiteHtml=''
                if(socialWebsite){
                    var arr=socialWebsite.split(':');
                    if(arr[0] == "http" || arr[0] == "https"){
                        socialWebsiteHtml+='<a target="_blank" class="ellipsis" title="'+data[i].socialWebsite+'" href="'+data[i].socialWebsite+'">'+data[i].socialWebsite+'</a>'
                    }else{
                        socialWebsiteHtml+='<a target="_blank" class="ellipsis" title="'+data[i].socialWebsite+'" href="http://'+data[i].socialWebsite+'">'+data[i].socialWebsite+'</a>'
                    }
                }
                html+='<div class="list-one social-homepage-one">' +
                            '<div class="edit-delete-btn">' +
                                '<span class="edit-list-btn edit-social-homepage-btn" data-type="edit" social-id="'+data[i].socialId+'">编辑</span>' +
                                '<span class="delete-list-btn delete-social-homepage-btn" social-id="'+data[i].socialId+'">删除</span>' +
                            '</div>' +socialWebsiteHtml+
                        '</div>'
            }
            $('.social-homepage-lists').html(html)
        }
    },
    initJobIntentionHtml:function(data){

        if(data != null){
            var html = (data.workPositionName?'<div class="position-name ellipsis">'+data.workPositionName+'</div>':'')+
                (data.industryName?'<div class="position-industry ellipsis">'+data.industryName+'</div>':'')+
                (data.expectSalaryName?'<div class="position-salary ellipsis">'+data.expectSalaryName+'</div>':'')+
                (data.workAddressName?'<div class="position-address ellipsis">'+data.workAddressName+'</div>':'')+
                (data.jobStatusName?'<div class="position-status ellipsis">'+data.jobStatusName+'</div>':'')
            $('.career-objective-content').html(html)
        }

    },

    /*----------------------------------------------------编辑--------------------------------------------------------*/
    //获取--个人编辑信息
    initEditResumeBasicModal:function(){
    	
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId != 'empty'){
            $.ajax({
                url: "/es/queryPersonalInformation",
                type:"POST",
                data: {
                    'resumeId':onlineResumeId
                },
                success: function(result) {
                    var res=result
                    if(res.code=='success'){
                        var data=res.data;
                        $("input[name='username']").val(data.realName)
                        $('.name-actual-length').html(data.realName.length)
                        $("input[name='birthday']").val(data.birthday)
                        if(data.sex == "女"){
                            $('#female').addClass('active')
                            $("input[name='sex']").val('female')
                        }else{
                            $('#male').addClass('active')
                            $("input[name='sex']").val('male')
                        }

                        $("input[name='phone']").val(data.phoneNo)

                        $("input[name='email']").val(data.email)
                        $('.email-actual-length').html(data.email.length)
                        $("input[name='cityName']").val(data.cityName)
                        $("input[name='cityName']").attr('city-val',(data.city?data.city:'empty'))


                        $("input[name='beginWorkDate']").val(data.beginWorkDate)
                    }else{
                        layer.alert(res.msg, {icon: 5});
                    }
                },
                error: function (result) {
                    layer.alert('服务器请求失败', {icon: 5});
                }
            });
        }else{
            $("input[name='phone']").val($('#phone').val());
        }
    },
    //获取--自我描述编辑
    initSelfDescriptionModal:function(){
        var that=this
        var userIntroduceDTO=that.data.resume.userIntroduceDTO
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId != 'empty'){
            $('#selfDescription').val(userIntroduceDTO?userIntroduceDTO.selfDescription:'')
            var value = $('#selfDescription').val();
            value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
            $('.self-description-actual').html(value.length)
        }else{
            alert('暂无自我介绍信息')
        }
    },
    //获取--求职意向编辑
    initEditJobIntentionModal:function(){
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId != 'empty'){
            $.ajax({
                url: "/es/queryJobIntentiotention",
                type:"POST",
                data: {
                    'resumeId':onlineResumeId
                },
                success: function(result) {
                    var res=result
                    if(res.code=='success'){
                        var data=res.data;
                        if(data != null){
                            $("input[name='workPosition']").val(data.workPositionName)
                            $("input[name='workPosition']").attr('data-val',(data.workPosition?data.workPosition:'empty'))

                            $("input[name='industryOne']").val(data.industryName)
                            $("input[name='industryOne']").attr('data-val',(data.industry?data.industry:'empty'))

                            $("input[name='expectSalary']").val(data.expectSalaryName)
                            $("input[name='expectSalary']").attr('data-val',(data.expectSalary?data.expectSalary:'empty'))

                            $("input[name='workAddress']").val(data.workAddressName)
                            $("input[name='workAddress']").attr('data-val',(data.workAddress?data.workAddress:'empty'))

                            $("input[name='jobStatus']").val(data.jobStatusName)
                            $("input[name='jobStatus']").attr('data-val',(data.jobStatus?data.jobStatus:'empty'))
                        }


                    }else{
                        layer.alert(res.msg, {icon: 5});
                    }
                },
                error: function (result) {
                    layer.alert('服务器请求失败', {icon: 5});
                }
            });
        }else{

        }
    },
    //获取--工作经历编辑
    initWorkExperienceModal:function(type,workExpId){

        var that=this
        var onlineResumeId=$('#onlineResumeId').val();
        if(type != 'add'){
            $('.company-lists').html('')
            $('#workExperienceSubmit').attr('data-id',workExpId)
            $.ajax({
                url: "/es/queryWorkExperience",
                type:"POST",
                data:{"workExpId": workExpId},
                success: function(result) {
                    var res = result;
                    if (res.code == "success"){

                        $('.company-lists').html('')
                        $('.company-lists').hide()
                        var data=res.data;
                        $("input[name='companyName']").val(data.companyName)
                        $('.company-actual-length').html(data.companyName.length)

                        $("input[name='industry']").val(data.industryName)
                        $("input[name='industry']").attr('data-val',data.industry)

                        $("input[name='beginDate']").val(data.beginDate)
                        $("input[name='endDate']").val(data.endDate)

                        $("input[name='monthlySalary']").val(data.monthlySalaryName)
                        $("input[name='monthlySalary']").attr('data-val',data.monthlySalary)

                        $("input[name='functionOne']").val(data.functionName)
                        $("input[name='functionOne']").attr('data-val',data.function)

                        $("input[name='position']").val(data.position)
                        $('.position-actual-length').html(data.position.length)

                        $("input[name='department']").val(data.department)

                        $('#workDescription').val(data.jobDescription?data.jobDescription:'')
                        var value = $('#workDescription').val();
                        value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                        $('.work-description-actual').html(value.length)

                        $('#workExperienceDelete').css('display','inline-block')
                        $('#workExperienceDelete').attr('work-id',data.workExpId)



                        //workExpId
                    }else{
                        layer.alert(res.msg, {icon: 5});
                    }

                },
                error:function(err){
                    layer.alert('服务器请求失败', {icon: 5});
                }
            })
        }
    },
    //获取--项目经历编辑
    initProjectExperienceModal:function(type,projectExpId){

        var that=this
        var onlineResumeId=$('#onlineResumeId').val();
        if(type != 'add'){
            $('#projectExperienceSubmit').attr('data-id',projectExpId)
            $.ajax({
                url: "/es/queryProjectExperience",
                type:"POST",
                data:{"projectExpId": projectExpId},
                success: function(result) {
                    var res = result;
                    if (res.code == "success"){

                        var data=res.data;
                        $("input[name='projectName']").val(data.projectName)
                        $('.project-actual-length').html(data.projectName.length)

                        $("input[name='companyName']").val(data.companyName)

                        $("input[name='beginDateOne']").val(data.beginDate)
                        $("input[name='endDateOne']").val(data.endDate)

                        $("input[name='projectRole']").val(data.projectRole)

                        $("input[name='projectLink']").val(data.projectLink)

                        $('#projectDescription').val(data.projectDescription?data.projectDescription:'')
                        var value = $('#projectDescription').val();
                        value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                        $('.project-description-actual').html(value.length)

                        $('#projectExperienceDelete').css('display','inline-block')
                        $('#projectExperienceDelete').attr('project-id',data.projectExpId)
                    }else{
                        layer.alert(res.msg, {icon: 5});
                    }

                },
                error:function(err){
                    layer.alert('服务器请求失败！', {icon: 5});
                }
            })
        }else{
            $('.summer-note-three.panel-body').html('')
        }
    },
    //获取--教育经历编辑
    initEducationalExperienceModal:function(type,educationExpId){

        var that=this
        var onlineResumeId=$('#onlineResumeId').val();
        if(type != 'add'){
            $('#educationalExperienceSubmit').attr('data-id',educationExpId)
            $.ajax({
                url: "/es/queryEducationExperience",
                type:"POST",
                data:{"educationExpId": educationExpId},
                success: function(result) {
                    var res = result;
                    if (res.code == "success"){

                        var data=res.data;
                        $("input[name='schoolName']").val(data.schoolName)
                        $('.school-actual-length').html(data.schoolName.length)

                        $("input[name='beginDateTwo']").val(data.beginDate)
                        $("input[name='endDateTwo']").val(data.endDate)

                        $("input[name='specialty']").val(data.specialtyName)
                        $("input[name='specialty']").attr('data-val',data.specialty)

                        $("input[name='educationLevel']").val(data.educationLevelName)
                        $("input[name='educationLevel']").attr('data-val',data.educationLevel)

                        $("input[name='graduationCertNO']").val(data.graduationCertNO)

                        $('#educationalDescription').val(data.specialtyDescription?data.specialtyDescription:'')
                        var value = $('#educationalDescription').val();
                        value = value.replace(/\n|\r/gi,"").replace(/\s/g,"");
                        $('.educational-description-actual').html(value.length)


                        $('#educationalExperienceDelete').css('display','inline-block')
                        $('#educationalExperienceDelete').attr('educational-id',data.educationExpId)
                    }else{
                        layer.alert(res.msg, {icon: 5});
                    }

                },
                error:function(err){
                    layer.alert('服务器请求失败！', {icon: 5});
                }
            })
        }else{
            $('.summer-note-four.panel-body').html('')
        }
    },
    //获取--社交编辑
    initSocialHomepageModal:function(type,socialId,socialText){

        var that=this
        var onlineResumeId=$('#onlineResumeId').val();
        if(type != 'add'){
            $('#socialHomepageSubmit').attr('data-id',socialId)
            $("input[name='socialWebsite']").val(socialText)
            $('.social-actual-length').html(socialText.length)
            $('#socialHomepageDelete').css('display','inline-block')
            $('#socialHomepageDelete').attr('social-id',socialId)
        }else{
            $('.summer-note-four.panel-body').html('')
        }
    },

    /*----------------------------------------------------点击保存----------------------------------------------------*/
    savePersonalInformation:function(){
        var that=this;
        var resumeId=''
        var personalInformationDTO={};

        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            resumeId=$('#shortResumeId').val()
        }else{
            resumeId=onlineResumeId
        }
        //用户名
        var realName=$.trim($('#username').val())
        if(realName == ''){
            layer.alert("请填写用户名", {icon: 6});
            return;
        }else{
            personalInformationDTO.realName=realName
        }
        //出生日期
        var birthday = $("input[name='birthday']").val();
        if(birthday == ''){
            layer.alert("请选择出生日期", {icon: 6});
            return;
        }else {
            personalInformationDTO.birthday=birthday
        }

        //性别
        var sex = $("input[name='sex']").val();
        if(sex == ''){
            layer.alert("请选择性别", {icon: 6});
            return;
        }else {
            personalInformationDTO.sex=sex
        }
        //手机号码
        var phoneNo = $("input[name='phone']").val();
        if(phoneNo == ''){
            layer.alert("请填写手机号", {icon: 6});
            return;
        }
        personalInformationDTO.phoneNo=phoneNo

       /* if(phoneNo == ''){
            layer.alert("请填写手机号", {icon: 6});
            return;
        }else if(!isPhoneNo(phone)) {
            layer.alert("请输入正确的手机号", {icon: 6});
            return;
        }else {
            personalInformationDTO.phoneNo=phoneNo
        }*/

        //邮箱
        var email = $("input[name='email']").val();
        if(email == ''){
            layer.alert("请填写邮箱",{icon: 6});
            return;
        }else if(!isEmail(email)) {
            layer.alert("请输入正确的邮箱", {icon: 6});
            return;
        }else {
            personalInformationDTO.email=email
        }

        //所在城市
        var cityName = $("input[name='cityName']").val();
        var city = $("input[name='cityName']").attr('city-val');
        if(cityName == ''){
            layer.alert("请选择所在城市", {icon: 6});
            return;
        }else {
            personalInformationDTO.cityName=cityName
            personalInformationDTO.city=$("input[name='cityName']").attr('city-val')
        }

        //工作时间
        var beginWorkDate=$("input[name='beginWorkDate']").val();
        if(beginWorkDate == ''){
            layer.alert("请选择工作时间", {icon: 6});
            return;
        }else {
            personalInformationDTO.beginWorkDate=beginWorkDate
        }
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/savePersonalInformation",
            type:"POST",
            data: {
                "resumeId": resumeId,
                "beginWorkDate": beginWorkDate,
                "birthday": birthday,
                "city": city,
                "cityName": cityName,
                "email": email,
                "phoneNo": phoneNo,
                "realName": realName,
                "sex": sex
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    window.location.reload()
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败！', {icon: 5});
            }
        });
    },
    saveSelfDescription:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();

        if(onlineResumeId == "empty"){
            layer.alert("请先编辑个人信息", {icon: 6});
            return;
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId
        var selfDescription=$.trim($('#selfDescription').val())
        if(selfDescription){
            var length=parseInt($('.self-description-actual').html());
            if(length > 200){
                layer.alert("自我描述字数不能超过200！！", {icon: 6});
                return;
            }else{
                options.selfDescription=selfDescription
            }
        }else{
            layer.alert("自我描述不能为空", {icon: 6});
            return;
        }
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveUserIntroduce",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    layer.msg('保存成功');
                    that.data.resume.userIntroduceDTO=res.data;
                    that.initSelfDescriptionHtml(that.data.resume.userIntroduceDTO)
                    layer.closeAll();
           //         that.completenessResume($('#onlineResumeId').val())
                    $('.two').removeClass('edit-2')
                    $('.two').addClass('complete-1')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });

    },
    saveWorkExperience:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            layer.alert("请先编辑个人信息", {icon: 6});
            return;
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId
        var workExpId=$('#workExperienceSubmit').attr('data-id')
        if(workExpId != "empty"){
            options.workExpId=workExpId
        }

        //公司名
        var companyName = $.trim($("input[name='companyName']").val())
        if(companyName == ''){
            layer.alert("请填写公司名", {icon: 6});
            return;
        }else {
            options.companyName=companyName
        }
        var industry=$("input[name='industry']").attr('data-val')
        if(industry == 'empty'){
            layer.alert("请选择公司行业", {icon: 6});
            return;
        }else {
            options.industry=industry
        }
        //入职时间
        var beginDate = $.trim($("input[name='beginDate']").val())
        if(beginDate == ''){
            layer.alert("请选择入职时间", {icon: 6});
            return;
        }else {
            options.beginDate=beginDate
        }
        //离职时间
        var endDate = $.trim($("input[name='endDate']").val())
        if(endDate == ''){
            layer.alert("请选择离职时间", {icon: 6});
            return;
        }else {
            options.endDate=endDate
        }
        var startDate = new Date($('#beginDate').val()).getTime();
        var endTime = new Date($('#endDate').val()).getTime();
        if (endTime < startDate) {
            layer.msg('离职时间不能小于入职时间');
            return
        }

        //在职薪资
        var monthlySalary=$("input[name='monthlySalary']").attr('data-val')
        if(industry != 'empty'){
            options.monthlySalary=monthlySalary
        }

        //职位类别
        var functionOne =$("input[name='functionOne']").attr('data-val')
        if(functionOne  == 'empty'){
            layer.alert("请选择职位类别", {icon: 6});
            return;
        }else {
            options.function =functionOne
        }
        //职位名称
        var position = $.trim($("input[name='position']").val())
        if(position == ''){
            layer.alert("请选择职位名称！！", {icon: 6});
            return;
        }else {
            options.position=position
        }
        //所属部门
        var department = $.trim($("input[name='department']").val())
        if(department == ''){
            layer.alert("请选择所属部门", {icon: 6});
            return;
        }else {
            options.department=department
        }
        //工作内容
        var jobDescription=$.trim($('#workDescription').val())
        if(jobDescription){
            var length=parseInt($('.work-description-actual').html());
            if(length > 1000){
                layer.alert("工作内容字数不能超过1000！！", {icon: 6});
                return;
            }else{
                options.jobDescription=jobDescription
            }
        }else{
            layer.alert("请编写工作内容！！！", {icon: 6});
            return;
        }
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveWorkExperience",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code == "success"){
                    that.data.resume.workExperience=res.data;
                    that.initWorkExperienceHtml(that.data.resume.workExperience)
                    layer.closeAll();
                 //   that.completenessResume($('#onlineResumeId').val())
                    $('.three').removeClass('edit-3')
                    $('.three').addClass('complete-1')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });

    },
    saveProjectExperience:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            layer.alert("请先编辑个人信息", {icon: 6});
            return;
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId

        //项目ID
        var projectExpId=$('#projectExperienceSubmit').attr('data-id')
        if(projectExpId != "empty"){
            options.projectExpId=projectExpId
        }
        //项目名称
        var projectName = $.trim($("input[name='projectName']").val())
        if(projectName == ''){
            layer.alert("请填写项目名称", {icon: 6});
            return;
        }else {
            options.projectName=projectName
        }
        //关联公司
        var companyName = $.trim($("input[name='companyName']").val())
        if(companyName != ''){
            options.companyName=companyName
        }
        //项目开始时间
        var beginDateOne = $.trim($("input[name='beginDateOne']").val())
        if(beginDateOne == ''){
            layer.alert("请选择项目开始时间", {icon: 6});
            return;
        }else {
            options.beginDate=beginDateOne
        }
        //项目结束时间
        var endDateOne = $.trim($("input[name='endDateOne']").val())
        if(endDateOne == ''){
            layer.alert("请选择项目结束时间", {icon: 6});
            return;
        }else {
            options.endDate=endDateOne
        }
        var startDate = new Date($('#beginDateOne').val()).getTime();
        var endTime = new Date($('#endDateOne').val()).getTime();
        if (endTime < startDate) {
            layer.msg('项目开始时间不能小于项目结束时间');
            return
        }
        //担任角色
        var projectRole = $.trim($("input[name='projectRole']").val())
        if(projectRole == ''){
            layer.alert("请填写担任的角色", {icon: 6});
            return;
        }else {
            options.projectRole=projectRole
        }
        //项目连接
        var projectLink = $.trim($("input[name='projectLink']").val())
        if(projectLink != ''){
            options.projectLink=projectLink
        }
        //项目描述
        var projectDescription = $.trim($('#projectDescription').val());
        if(projectDescription){
            var length=parseInt($('.project-description-actual').html());
            if(length > 1000){
                layer.alert("项目描述字数不能超过1000！！", {icon: 6});
                return;
            }else{
                options.projectDescription=projectDescription
            }
        }else{
            layer.alert("请编辑项目描述", {icon: 6});
            return;
        }

        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveProjectExperience",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code == "success"){
                    that.data.resume.userProjectExperience=res.data;
                    that.initProjectExperienceHtml(that.data.resume.userProjectExperience)
                    layer.closeAll();
               //     that.completenessResume($('#onlineResumeId').val())
                    $('.four').removeClass('edit-4')
                    $('.four').addClass('complete-1')

                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    saveEducationalExperience:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            layer.alert("请先编辑个人信息", {icon: 6});
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId

        //教育经历ID
        var educationExpId=$('#educationalExperienceSubmit').attr('data-id')
        if(educationExpId != "empty"){
            options.educationExpId=educationExpId
        }
        //学校名称
        var schoolName = $.trim($("input[name='schoolName']").val())
        if(schoolName == ''){
            layer.alert("请填写学校名称", {icon: 6});
            return;
        }else {
            options.schoolName=schoolName
        }
        //入校时间
        var beginDateTwo = $.trim($("input[name='beginDateTwo']").val())
        if(beginDateTwo == ''){
            layer.alert("请选择入校时间", {icon: 6});
            return;
        }else {
            options.beginDate=beginDateTwo
        }
        //毕业时间
        var endDateTwo = $.trim($("input[name='endDateTwo']").val())
        if(endDateTwo == ''){
            layer.alert("请选择毕业时间", {icon: 6});
            return;
        }else {
            options.endDate=endDateTwo
        }
        var startDate = new Date($('#beginDateTwo').val()).getTime();
        var endTime = new Date($('#endDateTwo').val()).getTime();
        if (endTime < startDate) {
            layer.msg('入校时间不能小于毕业时间');
            return
        }
        //专业名称
        var specialty=$("input[name='specialty']").attr('data-val')
        if(specialty == 'empty'){
            layer.alert("请选择专业名称", {icon: 6});
            return;
        }else{
            options.specialty=specialty
        }

        //学历
        var educationLevel=$("input[name='educationLevel']").attr('data-val')
        if(educationLevel == 'empty'){
            layer.alert("请选择学历", {icon: 6});
            return;
        }else{
            options.educationLevel=educationLevel
        }

        //证件
        var graduationCertNO = $.trim($("input[name='graduationCertNO']").val())
        if(graduationCertNO != ''){
            options.graduationCertNO=graduationCertNO
        }

        //项目描述
        var specialtyDescription = $.trim($('#educationalDescription').val());
        if(specialtyDescription){
            var length=parseInt($('.educational-description-actual').html());
            if(length > 1000){
                layer.alert("在校经历字数不能超过1000！！", {icon: 6});
                return;
            }else{
                options.specialtyDescription=specialtyDescription
            }
        }

        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveEducationExperience",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code == "success"){
                    that.data.resume.userEducationExperience=res.data;
                    that.initEducationExperienceHtml(that.data.resume.userEducationExperience)
                    layer.closeAll();
              //      that.completenessResume($('#onlineResumeId').val())
                    $('.five').removeClass('edit-5')
                    $('.five').addClass('complete-1')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    saveSocialHomepage:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            layer.alert("请先编辑个人信息", {icon: 6});
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId

        //社交主页ID
        var socialId=$('#socialHomepageSubmit').attr('data-id')
        if(socialId != "empty"){
            options.socialId=socialId
        }
        //社交主页
        var socialWebsite = $.trim($("input[name='socialWebsite']").val())
        if(socialWebsite == ''){
            layer.alert("请填写社交主页连接", {icon: 6});
            return;
        }else {
            options.socialWebsite=socialWebsite
        }

        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveSocialHomepage",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code == "success"){

                    that.data.resume.socialContactList=res.data;
                    that.initSocialHomepageHtml(that.data.resume.socialContactList)
                    layer.closeAll();
                //    that.completenessResume($('#onlineResumeId').val())
                    $('.six').removeClass('edit-6')
                    $('.six').addClass('complete-1')
                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    saveJobIntention:function(){
        var that=this;
        var options={}
        var resumeId=''
        var onlineResumeId=$('#onlineResumeId').val();
        if(onlineResumeId == "empty"){
            layer.alert('请先编辑个人信息', {icon: 5});
            return;
        }else{
            resumeId=onlineResumeId
        }
        options.resumeId=resumeId
        //期望职位
        var workPosition =$("input[name='workPosition']").attr('data-val')
        if(workPosition  == 'empty'){
            layer.alert("请选择期望职位", {icon: 6});
            return;
        }else {
            options.workPosition =workPosition
        }

        //期望行业
        var industry =$("input[name='industryOne']").attr('data-val')
        if(industry  == 'empty'){
            layer.alert("请选择期望行业", {icon: 6});
            return;
        }else {
            options.industry =industry
        }
        //期望薪资
        var expectSalary =$("input[name='expectSalary']").attr('data-val')
        if(expectSalary  == 'empty'){
            layer.alert("请选择期望薪资", {icon: 6});
            return;
        }else {
            options.expectSalary =expectSalary
        }
        //期望城市
        var workAddress =$("input[name='workAddress']").attr('data-val')
        if(workAddress  == 'empty'){
            layer.alert("请选择期望城市", {icon: 6});
            return;
        }else {
            options.workAddress =workAddress
        }
        //求职状态
        var jobStatus =$("input[name='jobStatus']").attr('data-val')
        if(jobStatus  == 'empty'){
            layer.alert("请选择求职状态", {icon: 6});
            return;
        }else {
            options.jobStatus =jobStatus
        }


        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/saveJobIntention",
            type:"POST",
            data: options,
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    window.location.reload()
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    uploadResumeAttachment:function(){

        var that = this;
        var url = host + "/es/uploadResumeAttachment?token="+getCookie('company_token');
        $("#uploadResumeAttachmentForm").attr("action", url);

        var token = getCookie('company_token');

        /*$("#headPortraitTokenId").val(getCookie('company_token'));*/

        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;

        var formData = new FormData(document.getElementById('uploadResumeAttachmentForm'));
        $.ajax({
            url: url,
            type: "post",
            data: formData,
            processData: false,
            contentType: false,
            dataType:"text",
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            beforeSend:function(){
                $('.upload-resume-attachment>span').html('上传中......')
            },
            success: function (result) {
                $('#fileName').val('')
                $('.upload-resume-attachment>span').html('上传简历')
                that.data.submitFlag = true;
                var res = result;

                if(res.code == 'success'){
                    that.queryResumeAttachmentList();
                    layer.closeAll();

                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                $('#fileName').val('')
                $('.upload-resume-attachment>span').html('上传简历')
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        })
    },
    saveAttachment:function(attachmentId){
        var that=this
        var newName = $.trim($("input[name='newName']").val())
        if(newName == ''){
            layer.alert("附件名不能为空", {icon: 6});
            return;
        }
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/renameResumeAttachment",
            type:"POST",
            data: {
                'attachmentId':attachmentId,
                'newName':newName
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code == "success"){
                    that.queryResumeAttachmentList()
                    layer.closeAll();
                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });

    },


    /*----------------------------------------------------删除相关信息------------------------------------------------*/
    deleteAttachment:function(attachmentId){
        var that = this;
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/deleteResumeAttachment",
            type:"POST",
            data: {
                "attachmentId": attachmentId,
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    that.queryResumeAttachmentList();
                    layer.closeAll();
                    // that.completenessResume($('#onlineResumeId').val())
                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    deleteWorkExperience:function(workExpId,dom){
    	var onlineResumeId=$('#onlineResumeId').val();
        var that = this;
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/deleteWorkExperience",
            data: {
                "workExpId": workExpId,
                "resumeId":onlineResumeId
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    if(dom == 'delete'){
                        window.location.reload()
                    }else{
                        dom.remove()
                        layer.closeAll();
                 //       that.completenessResume($('#onlineResumeId').val())
                        $('.show-work-experience').html('展开'+$('.work-experience-lists>div').length+'个工作经历')
                        if($('.work-experience-lists>div').length == 0){
                            $('.three').addClass('edit-3')
                            $('.three').removeClass('complete-1')
                            $('.show-work-experience').hide()
                        }else{
                            if($('.work-experience-lists>div').length >2 ){
                                $('.show-work-experience').show()
                            }else{
                                $('.show-work-experience').hide()
                            }

                        }
                    }

                }else{
                    layer.alert(res.msg, {icon: 5});
                }
            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    deleteProjectExperience:function(projectExpId,dom){
    	var onlineResumeId=$('#onlineResumeId').val();
        var that = this;
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/deleteProjectExperience",
            type:"POST",
            data: {
                "projectExpId": projectExpId,
                "resumeId":onlineResumeId
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    if(dom == 'delete'){
                        window.location.reload()
                    }else{
                        dom.remove()
                        layer.closeAll();
                //        that.completenessResume($('#onlineResumeId').val())
                        $('.show-project-experience').html('展开'+$('.project-experience-lists>div').length+'个项目经历')
                        if($('.project-experience-lists>div').length == 0){
                            $('.four').addClass('edit-4')
                            $('.four').removeClass('complete-1')
                            $('.show-project-experience').hide()
                        }else{
                            if($('.project-experience-lists>div').length >2 ){
                                $('.show-project-experience').show()
                            }else{
                                $('.show-project-experience').hide()
                            }
                        }
                    }

                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    deleteEducationalExperience:function(eduExpId,dom){
        var that = this;
        //防重复提交控制
        var onlineResumeId=$('#onlineResumeId').val();
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/deleteEducationExperience",
            type:"POST",
            data: {
                "eduExpId": eduExpId,
                "resumeId":onlineResumeId
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    if(dom == 'delete'){
                        window.location.reload()
                    }else{
                        dom.remove()
                        // that.queryResumeAttachmentList();
                        layer.closeAll();
            //            that.completenessResume($('#onlineResumeId').val())
                        if($('.educational-experience-lists>div').length == 0){
                            $('.five').addClass('edit-5')
                            $('.five').removeClass('complete-1')
                        }
                    }

                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },
    deleteSocialHomepage:function(socialId,dom){
        var that = this;
        //防重复提交控制
        if(!that.data.submitFlag){
            return;
        }
        that.data.submitFlag = false;
        $.ajax({
            url: "/es/deleteSocialHomepage",
            type:"POST",
            data: {
                "socialId": socialId,
            },
            success: function(result) {
                that.data.submitFlag = true;
                var res=result
                if(res.code=="success"){
                    if(dom == 'delete'){
                        window.location.reload()
                    }else{
                        dom.remove()
                        // that.queryResumeAttachmentList();
                        layer.closeAll();
                    //    that.completenessResume($('#onlineResumeId').val())
                        if($('.social-homepage-lists>div').length == 0){
                            $('.six').addClass('edit-6')
                            $('.six').removeClass('complete-1')
                        }
                    }

                }else{
                    layer.alert(res.msg, {icon: 5});
                }

            },
            error: function (result) {
                that.data.submitFlag = true;
                layer.alert('服务器请求失败', {icon: 5});
            }
        });
    },



    /*----------------------------------------------------弹出框页面--------------------------------------------------*/
    personalModal: function() {
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">姓名</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="username" id="username" placeholder="输入姓名" maxlength="10" type="text">' +
                                '<div class="text-length-one"><span class="name-actual-length">0</span>/<span>10</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">出生年月</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" readonly name="birthday" id="timeOne" placeholder="选择出生年月日" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">性别</div>' +
                            '<input type="hidden" name="sex" id="sixVal" >'+
                            '<div class="content fl" id="sex">' +
                                '<span class="span-one" id="male" data-val="male">男</span><span class="span-one" id="female" data-val="female">女</span>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">手机号码</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="phone" readonly id="phoneNo" type="text">' +
                                '<div class="change-phone">更换</div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">联系邮箱</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="email" placeholder="输入邮箱地址" type="text" maxlength="30">' +
                                '<div class="text-length-one"><span class="email-actual-length">0</span>/<span>30</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">所在城市</div>' +
                            '<div class="content fl">' +
                                '<div class="content-two">'+
                                    '<input class="input-one" name="cityName" id="city" city-val="empty" readonly placeholder="选择所在城市" type="text"><span class="triangle"></span>'+
                                    '<div class="select-lists-one clearfix">'+
                                        '<div class="fl select-lists-left" id="city-left">'+

                                        '</div>'+
                                        '<div class="fl select-lists-right" id="city-right">'+
                                            '<div  class="right-list-one">'+

                                            '</div>'+
                                        '</div>'+
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">工作时间</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="beginWorkDate" id="time-two" placeholder="选择工作时间" maxlength="10" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn"><span class="" id="userBasicInfoFormSubmit">确定</span></div>'+
                    '</div>';
        return html
    },
    selfDescriptionModal:function(){
        var that=this;
        html='<div class="selfDescriptionModal">'+
                '<textarea name="selfDescription" id="selfDescription" cols="80" rows="20"></textarea>'+
                '<div class="about-btn"><span class="" id="selfDescriptionSubmit">确定</span></div>'+
                '<div class="self-description-limit"><span class="self-description-actual">0</span> / <span>200</span></div>'+
            '</div>'
        return html;
    },
    workExperienceModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">公司名称</div>' +
                            '<div class="content content-company fl">' +
                                '<input class="input-one" name="companyName" id="companyName" placeholder="输入公司名称" maxlength="20" type="text">' +
                                '<div class="text-length-one"><span class="company-actual-length">0</span>/<span>20</span></div>' +
                                '<div class="company-lists">'+

                                '</div>'+
                                '<div class="no-yes-shield no-shield" data-type="" company-id="">屏蔽该公司</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">公司行业</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value"  readonly name="industry" data-val="empty" id="industry" placeholder="选择公司行业" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-down-left industry-left">' +
                                        /*行业一级*/
                                    '</div>'+
                                    '<div class="fl drop-down-right industry-right">'+
                                        /*行业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">在职时间</div>' +
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="beginDate" id="beginDate" placeholder="入职时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="endDate" id="endDate" placeholder="离职时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">在职薪资</div>' +
                            '<div class="content content-select fl">' +
                                '<input class="input-one select-val" readonly data-val="empty" name="monthlySalary" id="monthlySalary" placeholder="选择在职薪资（选填）" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="content-select-one salary-level">'+
                                    /*在职薪资*/
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">职位类型</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value" readonly name="functionOne" data-val="empty" id="function" placeholder="选择职位类型" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-down-left function-left">' +
                                    /*行业一级*/
                                    '</div>'+
                                    '<div class="fl drop-down-right function-right">'+
                                    /*行业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">职位名称</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="position" id="position" placeholder="如iOS开发工程师" maxlength="20" type="text">' +
                                '<div class="text-length-one"><span class="position-actual-length">0</span>/<span>20</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">所属部门</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="department" id="department" placeholder="输入所属部门" maxlength="20" type="text">' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">工作内容</div>' +
                            '<div class="content fl">' +
                                '<textarea name="workDescription" id="workDescription" cols="80" rows="14"></textarea>'+
                                '<div class="work-description-limit"><span class="work-description-actual">0</span> / <span>1000</span></div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn">'+
                            '<span class="delete-work-experience" work-id=""  id="workExperienceDelete" data-id="empty">删除本条工作经历</span>'+
                            '<span class="" id="workExperienceSubmit" data-id="empty">确定</span>'+
                        '</div>'+
                    '</div>';
        return html
    },
    projectExperienceModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">项目名称</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="projectName" id="projectName" placeholder="输入项目名称" maxlength="20" type="text">' +
                                '<div class="text-length-one"><span class="project-actual-length">0</span>/<span>20</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">关联公司</div>' +
                            '<div class="content content-select fl">' +
                                '<input class="input-one select-val" readonly data-val="empty" name="companyName" id="companyName" placeholder="选择关联公司" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="content-select-one associate-company">'+
                                /*在职薪资*/
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">项目周期</div>' +
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="beginDateOne" id="beginDateOne" placeholder="开始时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="endDateOne" id="endDateOne" placeholder="结束时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">担任角色</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="projectRole" maxlength="20" id="projectRole" placeholder="如：Java开发工程师" type="text">' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">项目连接</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="projectLink" maxlength="99" id="projectLink" placeholder="输入与本项目相关的链接（选填）" type="text">' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">项目描述</div>' +
                            '<div class="content fl">' +
                                '<textarea name="projectDescription" id="projectDescription" cols="80" rows="14"></textarea>'+
                                '<div class="project-description-limit"><span class="project-description-actual">0</span> / <span>1000</span></div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn">'+
                            '<span class="delete-project-experience" project-id=""  id="projectExperienceDelete" data-id="empty">删除本项目经历</span>'+
                            '<span class="" id="projectExperienceSubmit" data-id="empty">确定</span>'+
                        '</div>'+
                    '</div>';
        return html
    },
    educationalExperienceModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">学校名称</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="schoolName" id="schoolName" placeholder="输入学校名称" maxlength="20" type="text">' +
                                '<div class="text-length-one"><span class="school-actual-length">0</span>/<span>20</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">在校时间</div>' +
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="beginDateTwo" id="beginDateTwo" placeholder="入学时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                            '<div class="content-two fl">' +
                                '<input class="input-two" readonly name="endDateTwo" id="endDateTwo" placeholder="毕业时间" type="text">' +
                                '<span class="triangle"></span>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">专业名称</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value"  readonly name="specialty" data-val="empty" id="specialty" placeholder="选择专业名称" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-left educational-left">' +
                                    /*专业一级*/
                                    '</div>'+
                                    '<div class="fl drop-middle educational-middle">'+
                                    /*专业二级*/
                                    '</div>'+
                                    '<div class="fl drop-right educational-right">'+
                                    /*专业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">学历</div>' +
                            '<div class="content content-select fl">' +
                                '<input class="input-one select-val" readonly data-val="empty" name="educationLevel" id="educationLevel" placeholder="选择学历" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="content-select-one education-level">'+
                                /*在职薪资*/
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">证件编码</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="graduationCertNO" maxlength="50" id="graduationCertNO" placeholder="输入毕业证书编码（选填）" type="text">' +
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                        '<div class="title fl">在校经历</div>' +
                            '<div class="content fl">' +
                                '<textarea name="educationalDescription" id="educationalDescription" cols="80" rows="14"></textarea>'+
                                '<div class="educational-description-limit"><span class="educational-description-actual">0</span> / <span>1000</span></div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn">'+
                            '<span class="delete-educational-experience" educational-id=""  id="educationalExperienceDelete" data-id="empty">删除本条教育经历</span>'+
                            '<span class="" id="educationalExperienceSubmit" data-id="empty">确定</span>'+
                        '</div>'+
                 '</div>';
        return html
    },
    socialHomepageModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">社交主页</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="socialWebsite" id="socialWebsite" placeholder="输入可以展示能力的链接" maxlength="50" type="text">' +
                                '<div class="text-length-one"><span class="social-actual-length">0</span>/<span>50</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn">'+
                            '<span class="delete-social-homepage" social-id=""  id="socialHomepageDelete" data-id="empty">删除本条社交主页</span>'+
                            '<span class="" id="socialHomepageSubmit" data-id="empty">确定</span>'+
                        '</div>'+
                    '</div>';
        return html
    },
    jobIntentionModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">期望职位</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value"  readonly name="workPosition" data-val="empty" id="workPosition" placeholder="选择职位类型" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-down-left position-left">' +
                                    /*行业一级*/
                                    '</div>'+
                                    '<div class="fl drop-down-right position-right">'+
                                    /*行业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">期望行业</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value"  readonly name="industryOne" data-val="empty" id="industryOne" placeholder="选择行业" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-down-left industry-left">' +
                                    /*行业一级*/
                                    '</div>'+
                                    '<div class="fl drop-down-right industry-right">'+
                                    /*行业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">期望薪资</div>' +
                            '<div class="content content-select fl">' +
                                '<input class="input-one select-val" readonly data-val="empty" name="expectSalary" id="expectSalary" placeholder="选择薪资范围（选填）" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="content-select-one salary-level">'+
                                /*在职薪资*/
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">期望城市</div>' +
                            '<div class="content content-drop-down fl">' +
                                '<input class="input-one content-drop-value"  readonly name="workAddress" data-val="empty" id="workAddress" placeholder="期望城市" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="drop-down-list-one clearfix">'+
                                    '<div class="fl drop-down-left address-left">' +
                                    /*行业一级*/
                                    '</div>'+
                                    '<div class="fl drop-down-right address-right">'+
                                    /*行业二级*/
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">求职状态</div>' +
                            '<div class="content content-select fl">' +
                                '<input class="input-one select-val" readonly data-val="empty" name="jobStatus" id="jobStatus" placeholder="选择当前状态" type="text">' +
                                '<span class="triangle"></span>'+
                                '<div class="content-select-one job-status">'+
                                /*在职薪资*/
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn"><span class="" id="jobIntentionSubmit">确定</span></div>'+
                    '</div>';
        return html
    },
    resumeAttachmentModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="resume-attachment-img"></div>'+
                        '<div class="resume-attachment-tip">'+
                            '<p>支持docx、doc、word、pdf、ppt、txt、pptx、wps格式文件</p>'+
                            '<p>文件大小需小于2M</p>'+
                        '</div>'+
                        '<div class="upload-resume-attachment">' +
                            '<span>上传简历</span>'+
                            '<form id="uploadResumeAttachmentForm" enctype="multipart/form-data" method="post" action="">' +
                            '<input id="fileName" type="file" name="file" style="opacity: 0;" />' +
                            '</form>' +
                        '</div>'+
                    '</div>';
        return html
    },
    renameModal:function(){
        var that = this;
        var html = '<div class="personal-information-modal">' +
                        '<div class="modal-one clearfix">'+
                            '<div class="title fl">附件名称</div>' +
                            '<div class="content fl">' +
                                '<input class="input-one" name="newName" id="newName" placeholder="输入姓名" maxlength="20" type="text">' +
                                '<div class="text-length-one"><span class="name-actual-length">0</span>/<span>20</span></div>' +
                            '</div>'+
                        '</div>'+
                        '<div class="about-btn"><span class="" id="renameSubmit" data-name="" data-id="">确定</span></div>'+
                    '</div>';
        return html
    },



    // 基础数据
    getDictionaryList:function(){
        var that=this;
        that.data.baseData=window.ldsResumeDic

        /*$.ajax({
            url: host + "/resumeEditDict",
            data: {},
            type: "get",
            dataType:"json",
            async:false,
            xhrFields:{
                withCredentials:true
            },
            success: function(result){
                var obj = result;

                that.data.baseData=obj
            },
            error:function(err){


            }
        })*/
    },
    init: function() {
        var that = this;
        that.styleDeal();
        that.evenListen();
//        that.getResumeId();
//        that.getDictionaryList();

    }
}
$(document).ready(function() {
    page.init();
});
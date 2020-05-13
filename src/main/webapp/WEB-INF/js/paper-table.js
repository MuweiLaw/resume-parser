//paper表数据
function getTableList(obj) {
    layui.table.render({
        elem: '#companyListTable',
        defaultToolbar: false,
        url: '/eval/paper/query',
        toolbar: '#toolbarDemo',
        cols: [
            [{
                checkbox: true,
                fixed: true
            }, {
                field: 'zizeng',
                title: '序号',
                fixed: 'left',
                templet: '#zizeng'
            }, {
                field: 'idKey',
                title: '序号',
                hide: true
            }, {
                field: 'scenes',
                title: '测评场景'
            }, {
                field: 'clazz',
                title: '测评分类',
                templet: '#clazzbox'
            }, {
                field: 'questionNum',
                title: '题目数量'
            }, {
                field: 'evalTime',
                title: '所需时间'
            }, {
                field: 'examType',
                title: '试卷类型',
                templet: '#TestPaperTypeConversion'
            }, {
                field: 'createdDate',
                title: '更新时间'
            }, {
                field: 'ConfigureTestPaper',
                title: '配置试卷',
                toolbar: '#ConfigureTestPaper',
                fixed: 'right'
            }, {
                field: 'ConfigurationEvaluationConclusion',
                title: '配置测评结论',
                toolbar: '#ConfigurationEvaluationConclusion',
                fixed: 'right'
            }
            ]
        ],
        page: true,
        limits: [5, 10, 15, 20],
        limit: 20, //每页默认显示的数量
        where: obj,
        method: 'post',
        done: function (res, curr, count) {
        }
    });
}

//配置试卷表数据
function getQuestionTable(obj) {
    layui.table.render({
        elem: '#ConfigurePaper',
        id: 'idTest',
        url: '/eval/question/query?paperId=' + obj,
        type: 'post',
        defaultToolbar: false,
        //width:800,
        toolbar: '#shijuan',
        cols: [
            [ //表头
                {
                    checkbox: true,
                    fixed: true
                }, {
                field: 'idKey',
                title: 'id',
                hide: true
            }, {
                field: 'serialNum',
                title: '题号',
                sort: true,
                width: 80
            }, {
                field: 'question',
                title: '题目',
                edit: 'text',
                width: 400

            }, {
                field: 'items',
                title: '题目选项',
                templet: function (d) {
                    return d.items.replace(/[<>&'"]/g, function (c) {
                        switch (c) {
                            case '<':
                                return '&lt;';
                            case '>':
                                return '&gt;';
                            case '&':
                                return '&amp;';
                            case '\'':
                                return '&apos;';
                            case '"':
                                return '&quot;';
                        }
                    });
                },
                width: 200

            }, {
                field: 'ConfigureTestPaper',
                title: '配置选项',
                toolbar: '#addquert',
                width: 85
            }
            ]
        ],
        page: true,
        limits: [5, 10, 15, 20],
        method: 'get',
    });
}

//选项表格渲染方法
function getTableone(obj) {
    layui.table.render({
        elem: '#answareChooseListTableDemo',
        url: '/eval/question/findOne', //服务器路径
        where: obj, //获取查询参数
        method: 'post', //请求方法
        defaultToolbar: false,
        toolbar: '#shezhibox', //工具条
        page: false,
        width: 480,
        cols: [
            [ //表头
                {
                    checkbox: true,
                    fixed: true,
                }, {
                field: 'idKey',
                title: 'id',
                hide: true
            }, {
                field: 'option',
                title: '选项',
                width: 100
            }, {
                field: 'description',
                title: '描述',
                templet: function (d) {
                    return d.description.replace(/[<>&'"]/g, function (c) {
                        switch (c) {
                            case '<': return '&lt;';
                            case '>': return '&gt;';
                            case '&': return '&amp;';
                            case '\'': return '&apos;';
                            case '"': return '&quot;';
                        }
                    });
                },
                edit: 'text',
                width: 327
            }
            ]
        ],
        page: false,
        loading: false,
        done: function (res, curr, count) {
        }
    });
}

//选项分数表格渲染
function getTabletwo(obj) {
    layui.table.render({
        elem: '#answareChooseListTableDemo',
        url: '/eval/question/findOne', //服务器路径
        where: obj, //获取查询参数
        method: 'post', //请求方法
        defaultToolbar: false,
        toolbar: '#shezhibox', //工具条
        page: false,
        width: 480,
        cols: [
            [ //表头
                {
                    checkbox: true,
                    fixed: true
                }, {
                field: 'idKey',
                title: 'id',
                hide: true
            }, {
                field: 'option',
                title: '选项',
                width: 75
            }, {
                field: 'description',
                title: '描述',
                templet: function (d) {
                    return d.description.replace(/[<>&'"]/g, function (c) {
                        switch (c) {
                            case '<':
                                return '&lt;';
                            case '>':
                                return '&gt;';
                            case '&':
                                return '&amp;';
                            case '\'':
                                return '&apos;';
                            case '"':
                                return '&quot;';
                        }
                    });
                },
                edit: 'text',
                width: 250
            }, {
                field: 'score',
                title: '分数',
                width: 102,
                edit: 'text'
            }

            ]
        ],

    });
}

//试卷评论选项配置表
function getConclusionone(obj) {
    layui.table.render({
        elem: '#evalConclusionListTable',
        width: 800,
        page: true,
        limits: [5, 10, 15, 20],
        limit: 5, //每页默认显示的数量
        toolbar: '#pinlun', //工具条
        defaultToolbar: false,
        cellMinWidth: 100,
        url: '/eval/conclusion/query?paperId=' + obj,
        cols:
            [
                [ //表
                    {
                        checkbox: true,
                        fixed: true
                    }, {
                    field: 'idKey',
                    title: 'id',
                    sort: true,
                    hide: true
                }, {
                    field: 'zizeng',
                    title: '序号',
                    fixed: 'left',
                    templet: '#zizeng'
                }, {
                    field: 'answer',
                    title: '试卷选项',
                }, {
                    field: 'conclusion',
                    title: '测评结论',
                }, {
                    field: 'imgs',
                    title: '配图',
                    templet: '#imgss'
                }, {
                    field: 'updatedDate',
                    title: '更新时间',
                }
                ]
            ]
    }); //表渲染
}

//试卷评论分数配置表
function getConclusiontwo(obj) {
    layui.table.render({
        elem: '#evalConclusionListTable',
        width: 800,
        page: true,
        limits: [5, 10, 15, 20],
        limit: 5, //每页默认显示的数量
        toolbar: '#pinlun', //工具条
        defaultToolbar: false,
        cellMinWidth: 100,
        url: '/eval/conclusion/query?paperId=' + obj,
        cols:
            [
                [ //表
                    {
                        checkbox: true,
                        fixed: true
                    }, {
                    field: 'idKey',
                    title: 'id',
                    sort: true,
                    hide: true
                }, {
                    field: 'zizeng',
                    title: '序号',
                    fixed: 'left',
                    templet: '#zizeng'
                }, {
                    field: 'rangeStart',
                    title: '分数范围开始'
                }, {
                    field: 'rangeEnd',
                    title: '分数范围结束'
                }, {
                    field: 'conclusion',
                    title: '测评结论'
                }, {
                    field: 'imgs',
                    title: '配图',
                    templet: '#imgss'
                }, {
                    field: 'updatedDate',
                    title: '更新时间'
                }
                ]
            ]
    });
}


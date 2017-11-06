//初始化首页右侧内容
$(function(){
	ydz.loadDom('home'); 
})

var ydz={
		/**
		 * 数据表格加载
		 */
		loadDom:function(){
			ydz.showdiv();
			var arglen=arguments.length;
			url=arguments[0];
			//setTimeout(function(){
				$.ajax({
	             	url:"/ui/sys/" + url + ".html",
	             	cache:false,
	             	async:true,
	             	success:function(data){
	             	$("#content").html(data);
	             	ydz.initTable();//表格init
	             	ydz.hidediv();  //隐藏
	              },
	          }); 
			//},100); 
		},
		
		//数据表格初始化
		initTable:function(){
			//初始化表格
         	$('table.datatable').datatable({checkable: true, sortable: true,fixedHeaderOffset:42});
         	//初始化分页
         	var totalPage = 20;
        	var totalRecords = 390;
        	var pageNo = ydz.getParameter('pno');
        	if(!pageNo){
        		pageNo = 1;
        	}
        	//生成分页
        	//有些参数是可选的，比如lang，若不传有默认值
        	kkpager.generPageHtml({
        		pno : pageNo,
        		//总页码
        		total : totalPage,
        		//总数据条数
        		totalRecords : totalRecords,
        		mode : 'click',//默认值是link，可选link或者click
        		click : function(n){
        			// do something
        			//手动选中按钮
        			this.selectPage(n);
        			return false;
        		}
        		
        		,lang				: {
        			firstPageText			: '<i class="icon-step-backward" title="首页"></i>',
        			firstPageTipText	: '<i class="icon-step-backward" title="首页"></i>',
        			lastPageText			: '<i class="icon-step-forward" title="末页"></i>',
        			lastPageTipText			: '<i class="icon-step-forward" title="末页"></i>',
        			prePageText				: '<i class="icon-play icon-rotate-180" title="上一页"></i>',
        			prePageTipText			: '<i class="icon-play icon-rotate-180" title="上一页"></i>',
        			nextPageText			: '<i class="icon-play" title="下一页"></i>',
        			nextPageTipText			: '<i class="icon-play" title="下一页"></i>',
        			totalPageBeforeText		: '',
        			totalPageAfterText		: '',
        			currPageBeforeText		: '',
        			currPageAfterText		: '',
        			totalInfoSplitStr		: '/',
        			totalRecordsBeforeText	: '共',
        			totalRecordsAfterText	: '条数据',
        			gopageBeforeText		: ' 转到',
        			gopageButtonOkText		: '确定',
        			gopageAfterText			: '页',
        			buttonTipBeforeText		: '第',
        			buttonTipAfterText		: '页',
        		}
        	});
		},
		
		getParameter: function(name) { 
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
			var r = window.location.search.substr(1).match(reg); 
			if (r!=null) return unescape(r[2]); return null;
		},
		
		//显示遮罩层
		showdiv:function(){
			$("#loading").show();
			 document.getElementById("bg").style.display ="block";
		},
		//隐藏遮罩层
		hidediv:function(){
			$("#loading").hide();
			 document.getElementById("bg").style.display ='none';
		}

}
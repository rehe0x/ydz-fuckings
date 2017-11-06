ydz={
	
		//POST请求
		post:function(opt){
			var def = $.Deferred();
			opt = opt || {};
			var type = opt.type || 'POST';
		　 type = type.toUpperCase() || 'POST';
		　 var url = opt.url || '';
		　 var data = opt.data || null;
		　 var succ = opt.succ || function () {};
			$.ajax({
				type:type,
				url: url, 
				data:data,
				dataType:"json",
				beforeSend:function(){//请求之前调用的函数
				},
				success: function(data){//请求成功调用的函数
					succ(data);
					def.resolve();
				},
				error: function(xhr,statusText,error){ //请求出错处理
					
		         }      
			});
			return def.promise();
		},
		
		//表单验证
		validate:function(){
			$.AMUI.progress.start();

			var yn = true;
			$("[validator=validator]").each(function(a,b){
			//	alert($(this).attr("placeholder"));
				var vals = $.trim($(this).val());
				if(typeof($(this).attr("required"))!="undefined"&&(vals=="undefined"||vals.length==0)){
					$(this).css("border-color","#dd514c");
					$(this).nextAll("small").eq(0).css("color","#dd514c");
					$(this).focus(function(){
						$(this).removeAttr("style");
						$(this).nextAll("small").removeAttr("style");
					});
					$(this).nextAll("div").eq(0).children(".wangEditor-txt").focus(function(){
						$(this).parent().nextAll("small").removeAttr("style");
					});
					yn=false;
					return true;
				}
				
				if( typeof($(this).attr("regexp"))!="undefined"){
					regval = eval($(this).attr("regexp"));
					if(!(regval.test(vals))){
						$(this).css("border-color","#dd514c");
						$(this).nextAll("small").eq(0).css("color","#dd514c");
						$(this).focus(function(){
							$(this).removeAttr("style");
							$(this).nextAll("small").removeAttr("style");
						});
						$(this).nextAll("div").eq(0).children(".wangEditor-txt").focus(function(){
							$(this).parent().nextAll("small").removeAttr("style");
						});
						yn=false;
						return true;
					}
				}  
			});
			
			$("[validator=validator-img]").each(function(a,b){
			
					var vals = $(this).children('div').length;
					var vanum=$(this).attr("img-num");
					if(vals<vanum){
						$(this).nextAll("small").eq(0).css("color","#dd514c");
						$(this).nextAll("div").eq(0).children("button").focus(function(){
						$(this).parent().nextAll("small").removeAttr("style");
						});
						yn=false;
						return true;
					}
				});
			
			
			if(!yn){
				$.AMUI.progress.done(true);
			}
			return yn;
		},
		
		formDate:function(input){
			var d = new Date(input);
		    var year = d.getFullYear();
		    var month = d.getMonth() + 1;
		    var day = d.getDate() <10 ? '0' + d.getDate() : '' + d.getDate();
		    var hour = d.getHours();
		    var minutes = d.getMinutes();
		    var seconds = d.getSeconds();
		    return year+ '-' + month + '-' + day + ' ' + hour + ':' + minutes + ':' + seconds;
		},
	
		
		//弹窗提示
		modalMsg:function(type,msg,opt){},
		
		//弹窗提示
		modalAlert:function(type,msg,opt){},
		
		//弹窗提示input
		modalAlertText:function(type,msg,opt){},
		
		isNull:function(da){
			return (da == "" || da == undefined || da == null) ? false : true; 
		},
		

}
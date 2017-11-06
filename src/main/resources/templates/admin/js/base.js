ydz={
		banner:_banner,
		news:_news,
		product:_product,
		productclass:_productclass,
		sysmenu:_sysmenu,
		join:_join,
		order:_order,
		sysuser:_sysuser,
		

		/**
		 * 数据表格加载
		 */
		loadDom:function(){
			var def = $.Deferred();
			$.AMUI.progress.set(0.4);
			ydz.showdiv();
			var arglen=arguments.length;
			tempUrl=arguments[0];
			fcUrl = arguments[1];
			async = arguments[2];
			if(ydz.isNull(async)){
				async=true;
			}
			$.ajax({
             	url:"/admin/" + tempUrl + ".html",
             	cache:false,
             	async:async,
             	success:function(data){
	             	$.AMUI.progress.set(1.0); 
	             	$("#content").html(data);
	             	if(ydz.isNull(fcUrl)){
	             		eval(fcUrl+"()");
	             	}
	             	$.AMUI.progress.done(true);
	             	def.resolve();
	             	ydz.hidediv();
               },
          }); 
		 return def.promise();
		},
		
		
		
		
		
		
		
		
		//POST请求
		post:function(opt){
			var def = $.Deferred();
			$.AMUI.progress.set(0.4);
			ydz.showdiv();
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
					$.AMUI.progress.inc();
				},
				success: function(data){//请求成功调用的函数
					if(data.code==400){
						window.location.href=data.data;
						return;
					}
					$.AMUI.progress.inc();
					succ(data);
					def.resolve();
					ydz.hidediv();
					$.AMUI.progress.done(true);
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
		    return year+ '-' + month + '-' + day ;
		},
	
		//显示遮罩层
		showdiv:function(){
			$("#loading").show();
			// document.getElementById("bg").style.display ="block";
		},
		//隐藏遮罩层
		hidediv:function(){
			$("#loading").hide();
			// document.getElementById("bg").style.display ='none';
		},
		
		//弹窗提示
		modalMsg:function(type,msg,opt){
			if(opt!=null){
				var load = opt.load || function () {};
			}
			
			if(type=='success'){
				$('#your-modal').modal({
					dimmer:true,
				});
				$('#your-modal').on('closed.modal.amui', function(){
					load();
					$('#your-modal').off('closed.modal.amui');
				});
				
			}else if(type=='error'){
				if(ydz.isNull(msg)){
					$("#your-modal-error-text").text(msg);
				}
				$('#your-modal-error').modal();
			}
			
		},
		
		//弹窗提示
		modalAlert:function(type,msg,opt){
			
			if(opt!=null){
				var sure = opt.sure || function () {};
			}
//			$('#my-confirm-delete').modal({
//			        relatedTarget: this,
//			        onConfirm: function(options) {
//			        	sure();
//			        	 
//					},
//			        // closeOnConfirm: false,
//			        onCancel: function() {
//			        }
//			  });

			 var $confirm = $('#my-confirm-delete');
		        var confirm = $confirm.data('amui.modal');
		        var onConfirm = function() {
		        	sure();
		          };
		        var onCancel = function() {
		        	
		        }
		        
		        if (confirm) {
		          confirm.options.onConfirm =  onConfirm;
		          confirm.options.onCancel =  onCancel;
		          confirm.toggle(this);
		        } else {
		          $confirm.modal({
		            relatedElement: this,
		            onConfirm: onConfirm,
		            onCancel: onCancel
		          });
		        }
			
		},
		
		//弹窗提示input
		modalAlertText:function(type,msg,opt){
			
			if(opt!=null){
				var sure = opt.sure || function () {};
			}
//			$('#my-confirm-delete').modal({
//			        relatedTarget: this,
//			        onConfirm: function(options) {
//			        	sure();
//			        	 
//					},
//			        // closeOnConfirm: false,
//			        onCancel: function() {
//			        }
//			  });

			 var $confirm = $('#my-prompt');
		        var confirm = $confirm.data('amui.modal');
		        var onConfirm = function() {
		        	sure();
		          };
		        var onCancel = function() {
		        	
		        }
		        
		        if (confirm) {
		          confirm.options.onConfirm =  onConfirm;
		          confirm.options.onCancel =  onCancel;
		          confirm.toggle(this);
		        } else {
		          $confirm.modal({
		            relatedElement: this,
		            onConfirm: onConfirm,
		            onCancel: onCancel
		          });
		        }
			
		},
		
		isNull:function(da){
			return (da == "" || da == undefined || da == null) ? false : true; 
		},
		
		
		plupload:function(opt){
			var succ = opt.succ || function () {};
			var browse_button = opt.browse_button;
			var counts=opt.counts;
			var uploader = new plupload.Uploader({
				    runtimes : 'html5,flash,silverlight,html',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
					url : '/file/upload',//上传文件路径
				    max_file_size : '3gb',//100b, 10kb, 10mb, 1gb
				   // chunk_size : '1mb',//分块大小，小于这个大小的不分块
				    unique_names : true,//生成唯一文件名
				    browse_button : browse_button, 
				  /*   filters : [ {
				        title : 'Image files',
				        extensions : 'jpg,gif,png'
				    }, {
				        title : 'Zip files',
				        extensions : 'zip,7z,rar'
				    } ], */
				    
				});
				uploader.init();
				//绑定文件添加进队列事件
				uploader.bind('FilesAdded',function(uploader,files){
					uploader.start();
				});
				
				//var urls = [];
				//当队列中的某一个文件上传完成后触发
				uploader.bind('FileUploaded',function(uploader,file,responseObject){
					var obj = jQuery.parseJSON(responseObject.response);  
					//urls.push(obj.data.url);
					 succ(obj.data.url);
				//	$("#fileImgval").val(obj.data.url);
				//	$("#fileImg").append("<div class='tpl-form-file-img'><img src='"+obj.data.url+"' alt=''></div>");
				});
				
				 //当上传队列中所有文件都上传完成后触发
				uploader.bind('UploadComplete',function(uploader,files){
					//succ(urls);
				}); 
		},
		
		
		pluploadEditor:function(){
			   // this 即 editor 对象
	        var editor = this;
	        // 编辑器中，触发选择图片的按钮的id
	        var btnId = editor.customUploadBtnId;
	        // 编辑器中，触发选择图片的按钮的父元素的id
	        var containerId = editor.customUploadContainerId;
	        
			var uploader = new plupload.Uploader({
				    runtimes : 'html5,flash,silverlight,html',//设置运行环境，会按设置的顺序，可以选择的值有html5,gears,flash,silverlight,browserplus,html
					url : '/file/upload',//上传文件路径
					flash_swf_url: 'Moxie.swf',
			        sliverlight_xap_url: 'Moxie.xap',
				    max_file_size : '3gb',//100b, 10kb, 10mb, 1gb
				   // chunk_size : '1mb',//分块大小，小于这个大小的不分块
				    unique_names : true,//生成唯一文件名
				    browse_button : btnId, 
				  /*   filters : [ {
				        title : 'Image files',
				        extensions : 'jpg,gif,png'
				    }, {
				        title : 'Zip files',
				        extensions : 'zip,7z,rar'
				    } ], */
				    
				});
				//存储所有图片的url地址
	        	var urls = [];
	        	
				uploader.init();
				
				
				//绑定文件添加进队列事件
				uploader.bind('FilesAdded',function(uploader,files){
					uploader.start();
				});
				
				//当队列中的某一个文件上传完成后触发
				uploader.bind('FileUploaded',function(uploader,file,responseObject){
					var obj = jQuery.parseJSON(responseObject.response);  
					//先将url地址存储来，待所有图片都上传完了，再统一处理
		            urls.push(obj.data.url);
				});
				
				//当上传队列中所有文件都上传完成后触发
				uploader.bind('UploadComplete',function(uploader,files){
					 // 用 try catch 兼容IE低版本的异常情况
		            try {
		                //打印出所有图片的url地址
		                $.each(urls, function (key, value) {
		                    // 插入到编辑器中
		                    editor.command(null, 'insertHtml', '<img src="' + value + '" style="max-width:100%;"/>');
		                });
		            } catch (ex) {
		                // 此处可不写代码
		            } finally {
		                //清空url数组
		                urls = [];
		                // 隐藏进度条
		                editor.hideUploadProgress();
		            }
				}); 
				
				 // 上传进度条
		        uploader.bind('UploadProgress', function (uploader, file) {
		            // 显示进度条
		            editor.showUploadProgress(file.percent);
		        });
		}
		


}
var ydz={

		msg : function(){
			var mess=arguments[0];
			if(arguments[1]=="e"){
				var e="error";
			}else if(arguments[1]=="s"){
				var e="success";
			}
		
			setTimeout( function() {
				// 创建通知
				var notification = new NotificationFx({
					message : "<p>"+mess+"</p>",
					layout : 'growl',
					effect : 'slide',
					type : e, // notice, warning or error
				});
				//自动隐藏
				notification.show();
			}, 500 );//展开时间
		},

}
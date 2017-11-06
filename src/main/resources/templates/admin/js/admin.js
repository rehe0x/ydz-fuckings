var _banner={
		
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:10,
		            place:'',
					datas:[],
					options: [
						  { text: '查询全部', value: '0' },
					      { text: '首页顶部', value: '1' },
					      { text: '首页中部', value: '2' }
					    ]
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					this.$nextTick(function () {
						$('select').selected();
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
		                ydz.post({
		    				url:"/banner/findBanner",
		    				data:{
	    						pageNum:this.cur,
	    						pageSize:this.size
	    						},
		    				succ:function(data){
		    					self.datas=data.data.list;
		    					self.all=data.data.pages;
		    				}
		    			})
					})
				},
				beforeUpdate:function(){},
				created: function(){},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
	                deleteBanner:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({
				    				url:"/banner/delete",
				    				data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
					},
	                findPage:function(){
	                	var self = this;
	                	self.place = $("#place-selected").val();
						 ydz.post({
			    				url:"/banner/findBanner",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size,
			    						place:this.place
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
			
			// 位置过滤器
			Vue.filter('placeVal', function (value) {
				if(value=='1'){
					return "首页顶部";
				}else if(value=='2'){
					return "首页中部";
				}else{
					return "无";
				}
			})
			// 类型过滤器
			Vue.filter('typeVal', function (value) {
				if(value==null){return "无"};
			})
		},
		
		
		
		createBanner:function(id){
			var d = ydz.loadDom('template/createBanner'); 
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						datas:{},
						options: [
						      { text: '首页顶部', value: '1' },
						      { text: '首页中部', value: '2' }
						    ]
					},
					mounted:function(){
						//$('select').selected();
						this.$nextTick(function () {
							var self = this;
							
							//初始化图片组件
							ydz.plupload({
								browse_button:'browse',
								counts:false,
								succ:function(data){
									self.datas.img=data;
			    				}
							});
							// 代码保证 this.$el 在 document 中
							if(ydz.isNull(idval)){//修改初始化数据
								//初始化数据
				                ydz.post({
				    				url:"/banner/findOne",
				    				data:{id:idval},
				    				succ:function(data){
				    					self.datas=data.data;
				    				}
				    			})
							}else{//添加初始化数据
								self.datas={
										img:'',
										id:'',
										place:'1',
										url:'',
										title:''
								};
							}
						 })
					},
					beforeUpdate:function(){},
					created: function(){},
					methods:{
						//保存
						saveBanner:function(ev){  
							var that=this;
							var yes = ydz.validate();
							if(yes){
								var that=this;
							 	ydz.post({
									url:"/banner/insertBanner",
									data:{
										id:idval,
										title:that.datas.title,
										img:that.datas.img,
										url:that.datas.url,
										place:that.datas.place
									},
									succ:function(data){
										if(data.code==200){
											ydz.modalMsg("success",null,{
												load:function(){
													ydz.sysmenu.loadMenu('banner/findAll');
												}
											});
										}else{
											ydz.modalMsg("error");
										}
									}
								})
							} 
							
						}
					}
				}) 
			    
			})
		},
}


/**新闻*/
var _news={
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:10,
					datas:[]
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					
					this.$nextTick(function () {

						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
		                ydz.post({
		    				url:"/news/findNews",
		    				data:{
	    						pageNum:this.cur,
	    						pageSize:this.size
	    						},
		    				succ:function(data){
		    					self.datas=data.data.list;
		    					self.all=data.data.pages;
		    				}
		    			})
					})
				},
				beforeUpdate:function(){},
				created: function(){},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
					
	                deleteNews:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({url:"/news/delete",data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
	                },
	                findPage:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/news/findNews",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
		},
		
		
		
		createNews:function(id){
			
			var d = ydz.loadDom('template/createNews'); 
			
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						editorContent:'',
						datas:{}
					},
					mounted:function(){
						this.$nextTick(function () {
							//时间
							var self = this;
							$('#my-datepicker').datepicker({format: 'yyyy-mm-dd'}).
								on('changeDate.datepicker.amui', function(event) {
								   self.datas.create_date=$("#my-datepicker").val();
						   });

							// 创建编辑器
			                var editor = new wangEditor('textarea1');
			                editor.onchange = function () {
			                    // onchange 事件中更新数据
			                    self.editorContent = editor.$txt.html();
			                };
			                editor.config.customUpload = true;  // 配置自定义上传的开关
			                editor.config.customUploadInit = ydz.pluploadEditor;
			                editor.create();
							
							// 代码保证 this.$el 在 document 中
							if(ydz.isNull(idval)){//修改初始化数据
								//初始化数据
				                ydz.post({
				    				url:"/news/findOne",
				    				data:{id:idval},
				    				succ:function(data){
				    					self.datas=data.data;
				    					self.editorContent=data.data.news_content;
				    					editor.$txt.html(data.data.news_content);
				    				}
				    			})
							}else{//添加初始化数据
								self.datas={
										news_title:'',
										id:'',
										news_content:'',
										create_date:'',
										state:''
								};
							}
						 })
					},
					beforeUpdate:function(){},
					created: function(){},
					methods:{
						//保存
						saveNews:function(ev){  
							var that=this;
							var yes = ydz.validate();
							if(yes){
								var that=this;
							 	ydz.post({
									url:"/news/insertNews",
									data:{
										id:idval,
										newsTitle:that.datas.news_title,
										newsContent:that.editorContent,
										createDate:that.datas.create_date,
									},
									succ:function(data){
										if(data.code==200){
											ydz.modalMsg("success",null,{
												load:function(){
													ydz.sysmenu.loadMenu('news/findAll');
												}
											});
										}else{
											ydz.modalMsg("error");
										}
									}
								})
							} 
							
						}
					}
				}) 
			    
			})
		},

}



/**产品分类*/
var _productclass={
		findAll:function(){
		 app=  new Vue({
		        el: '#demo',
		        data: {
		            option: {
		                root: {
		                	class_name: '根节点',
		                    isParent: true,
		                    isOpen: true,
		                    openedIcon: 'fa fa-folder-open-o',
		                    closedIcon: 'fa fa-folder-o',
		                    id:'0',
		                    children: []
		                }
		            },
		            classText:'',
		            idx:'0'
		        },
		        components:{
					'vue-tree': Vue.VueTree
				},
		        created: function(){
		        	//var self = this;
		        	//self.findAll();	
		        },
		        mounted:function() {
		        	this.$nextTick(function () {
		        		var self = this;
						 ydz.post({
			    				url:"/classdom/findClassDom",
			    				data:{},
			    				succ:function(data){
			    					self.option.root.children=data.data;
			    				}
			    			})
					})
		        },
		        methods:{
					listen: function (info) {
						var self = this;
						self.classText=info.class_name;
						self.idx=info.id;
						if(info.type=='add'){
							self.classText='';
							
							ydz.modalAlertText(null,null,{
		                		sure:function(){
		                			self.addClassDom();
		                		}
		                	})

						}else if(info.type=='edit'){
							ydz.modalAlertText(null,null,{
		                		sure:function(){
		                			 self.updateClassDom();
		                		}
		                	})
						}else{
							ydz.modalAlert(null,null,{
		                		sure:function(){
		                			self.deleteClassDom();
		                		}
		                	})
							
						}
					},
				  addClassDom:function(){
					  	var self = this;
						 ydz.post({
			    				url:"/classdom/insertClassDom",
			    				data:{
			    					superId:self.idx,
			    					className:self.classText
			    				},
			    				succ:function(data){
			    					if(data.code==200){
			    						ydz.modalMsg("success",null,{
			    							load:function(){
			    								self.findAll();
			    							}
			    						});
									}else{
										ydz.modalMsg("error");
									}
			    				}
			    			})
	                },
	                updateClassDom:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/classdom/insertClassDom",
			    				data:{
			    					id:self.idx,
			    					className:self.classText
			    				},
			    				succ:function(data){
			    					if(data.code==200){
			    						ydz.modalMsg("success",null,{
			    							load:function(){
			    								self.findAll();
			    							}
			    						});
									}else{
										ydz.modalMsg("error");
									}
			    				}
			    			})
	                },
	                deleteClassDom:function(){
	                	var self = this;
	                	ydz.post({
		    				url:"/classdom/delete",
		    				data:{id:self.idx},
		    				succ:function(data){
		    					if(data.code==200){
		    						ydz.modalMsg("success",null,{
		    							load:function(){
		    								self.findAll();
		    							}
		    						});
								}else{
									ydz.modalMsg("error");
								}
		    				}
		    			})
	                },
				    findAll:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/classdom/findClassDom",
			    				data:{},
			    				succ:function(data){
			    					self.option.root.children=data.data;
			    				}
			    			})
	                }
		        },
		        destroyed: function () {  
		        	app.$destroy()//触发方式,在console里面打myVue.$destroy();其中myVue.$destroy(true)是删除DOM节点,会触发detached函数,但是实例仍然存在
                    //在实例被销毁之后调用。此时所有的绑定和实例的指令已经解绑，注意是解绑不是销毁,所有的子实例也已经被销毁。
                    console.log("已销毁");
                }
		    });
		}
}

/**产品*/
var _product={
		
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:3,
		            classType:'',
					datas:[],
					options: []
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					this.$nextTick(function () {
						$('select').selected();
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
		                ydz.post({
		    				url:"/product/selectProductAll",
		    				data:{
	    						pageNum:this.cur,
	    						pageSize:this.size
	    						},
		    				succ:function(data){
		    					self.datas=data.data.list;
		    					self.all=data.data.pages;
		    				}
		    			})
					})
				},
				beforeUpdate:function(){},
				created: function(){
					var self = this;
					// 代码保证 this.$el 在 document 中
					//初始化分类数据
					 ydz.post({
		    				url:"/classdom/findClassDom",
		    				data:{},
		    				succ:function(data){
		    					self.options=data.data;
		    				}
		    			})
				},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
	                deleteProduct:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({
				    				url:"/product/deleteByPrimaryKey",
				    				data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
					},
	                findPage:function(){
	                	var self = this;
	                	self.classType = $("#class-selected").val();
						 ydz.post({
			    				url:"/product/selectProductAll",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size,
			    						productClassId:this.classType
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
			
			 
			      
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			})    
			
			// 位置过滤器
			Vue.filter('placeVal', function (value) {
				if(value=='1'){
					return "首页顶部";
				}else if(value=='2'){
					return "首页中部";
				}else{
					return "无";
				}
			})
			// 类型过滤器
			Vue.filter('typeVal', function (value) {
				if(value==null){return "无"};
			})
		},
		
		
		
		createProduct:function(id){
			var d = ydz.loadDom('template/createProduct'); 
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						datas:{
							id:'',
							productName:'',
							productPrice:'',
							productClassId:'',
							img:'',
							imgs:[],
							productDesc:''
					},
						editorContent:'',
						options: []
					},
					mounted:function(){
						//$('select').selected();
						this.$nextTick(function () {
							var self = this;
							// 创建编辑器
			                var editor = new wangEditor('textarea1');
			                editor.onchange = function () {
			                    // onchange 事件中更新数据
			                    self.editorContent = editor.$txt.html();
			                };
			                editor.config.customUpload = true;  // 配置自定义上传的开关
			                editor.config.customUploadInit = ydz.pluploadEditor;
			                editor.create();
			                
							//初始化图片组件
							ydz.plupload({
								browse_button:'browse',
								counts:false,
								succ:function(data){
									self.datas.img=data;
			    				}
							});
							//初始化图片组件
							ydz.plupload({
								browse_button:'browses',
								counts:true,
								succ:function(data){
									self.datas.imgs.push(data);
			    				}
							});
							
							if(ydz.isNull(idval)){//修改初始化数据
								//初始化数据
				                ydz.post({
				    				url:"/product/selectByPrimaryKey",
				    				data:{id:idval},
				    				succ:function(data){
				    					self.datas=data.data;
				    					self.datas.imgs=self.datas.imgs.split(",");
				    					self.editorContent=data.data.productDesc;
				    					editor.$txt.html(data.data.productDesc);
				    				}
				    			})
				    			
							}
						 })
					},
					beforeUpdate:function(){},
					created: function(){
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化分类数据
						 ydz.post({
			    				url:"/classdom/findClassDom",
			    				data:{},
			    				succ:function(data){
			    					self.datas.productClassId=data.data[0].id;
			    					self.options=data.data;
			    				}
			    			})
					},
					methods:{
						//保存
						saveProduct:function(ev){  
							var that=this;
							var yes = ydz.validate();
							
							if(yes){
								var that=this;
							 	ydz.post({
									url:"/product/insertProduct",
									data:{
										id:idval,
										productName:that.datas.productName,
										productPrice:that.datas.productPrice,
										productClassId:that.datas.productClassId,
										img:that.datas.img,
										imgs:that.datas.imgs.toString(),
										productDesc:that.editorContent
									},
									succ:function(data){
										if(data.code==200){
											ydz.modalMsg("success",null,{
												load:function(){
													ydz.sysmenu.loadMenu('product/findAll');
												}
											});
										}else{
											ydz.modalMsg("error");
										}
									}
								})
							} 
							
						},
						deleteImgs:function(index){
							var that=this;
							that.datas.imgs.splice(index,1);
						}
						
					}
				}) 
			    
			})
		},
}


/**招商代理*/
var _join={
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:5,
					datas:[]
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					this.$nextTick(function () {
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
						self.findPage();
					})
				},
				beforeUpdate:function(){},
				created: function(){},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
					
	                deleteJoin:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({url:"/join/delete",data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
	                },
	                findPage:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/join/findJoin",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
			
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			}) 
		},
		
		
		
		showJoin:function(id){
			var d = ydz.loadDom('template/createJoin'); 
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						editorContent:'',
						datas:{}
					},
					mounted:function(){
						this.$nextTick(function () {
							var self = this;
							// 代码保证 this.$el 在 document 中
							//初始化数据
			                ydz.post({
			    				url:"/join/findOne",
			    				data:{id:idval},
			    				succ:function(data){
			    					self.datas=data.data;
			    				}
			    			})
							
						 })
					},
					beforeUpdate:function(){},
					created: function(){},
					methods:{
						//保存
						goBack:function(){
							ydz.sysmenu.loadMenu('join/findAll');
						}
					}
				}) 
			    
			})
			
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			}) 
		},

}



/**在线订单*/
var _order={
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:5,
					datas:[]
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					this.$nextTick(function () {
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
						self.findPage();
					})
				},
				beforeUpdate:function(){},
				created: function(){},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
					
	                deleteOrder:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({url:"/order/delete",data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
	                },
	                findPage:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/order/findOrder",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
			
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			}) 
		},
		
		
		
		showOrder:function(id){
			var d = ydz.loadDom('template/createOrder'); 
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						editorContent:'',
						datas:{}
					},
				  computed: {
					    // a computed getter
					    addrInfo: function () {
					      // `this` points to the vm instance
					      return this.datas.mergerName+","+this.datas.addr;
					    }
					  },
					mounted:function(){
						this.$nextTick(function () {
							var self = this;
							// 代码保证 this.$el 在 document 中
							//初始化数据
			                ydz.post({
			    				url:"/order/findOne",
			    				data:{id:idval},
			    				succ:function(data){
			    					self.datas=data.data;
			    				}
			    			})
							
						 })
					},
					beforeUpdate:function(){},
					created: function(){},
					methods:{
						//保存
						goBack:function(){
							ydz.sysmenu.loadMenu('order/findAll');
						}
					}
				}) 
			    
			})
			
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			}) 
		},

}


/**账号管理*/
var _sysuser={
		findAll:function(){
			var app = new Vue({
				el:'#content',
				data:{
					cur: 1,
		            all: 0,
		            size:5,
					datas:[]
				},
				components:{
					'vue-pagination': Vue.Pagination
				},
				mounted:function(){
					this.$nextTick(function () {
						var self = this;
						// 代码保证 this.$el 在 document 中
						//初始化数据
						self.findPage();
					})
				},
				beforeUpdate:function(){},
				created: function(){},
				methods:{
					listen: function (data) {
						var self = this;
						self.cur=data;
						self.findPage();
					},
					
	                deleteSysUser:function(id){
	                	var self = this;
	                	ydz.modalAlert(null,null,{
	                		sure:function(){
	                			ydz.post({url:"/sysuser/delete",data:{id:id},
				    				succ:function(data){
				    					if(data.code==200){
				    						self.cur=1;
				    						ydz.modalMsg("success",null,{
				    							load:function(){
				    								self.findPage();
				    							}
				    						});
										}else{
											ydz.modalMsg("error");
										}
				    				}
				    			})
	                		}
	                	})
	                },
	                findPage:function(){
	                	var self = this;
						 ydz.post({
			    				url:"/sysuser/findSysUser",
			    				data:{
			    						pageNum:this.cur,
			    						pageSize:this.size
			    						},
			    				succ:function(data){
			    					self.datas=data.data.list;
			    					self.all=data.data.pages;
			    				}
			    			})
	                }
				}
			}) 
			
			// 时间过滤器
			Vue.filter('formatDates', function (value) {
				return ydz.formDate(value);
			}) 
		},
		
		
		
		createSysUser:function(id){
			
			var d = ydz.loadDom('template/createSysUser'); 
			
			d.then(function(){
				var idval = id;
				var app = new Vue({
					el:'#content',
					data:{
						datas:{
							name:'',
							id:'',
							account:'',
							pwd:''
						}
					},
					mounted:function(){
						this.$nextTick(function () {
							var self=this;
							// 代码保证 this.$el 在 document 中
							if(ydz.isNull(idval)){//修改初始化数据
								//初始化数据
				                ydz.post({
				    				url:"/sysuser/findOne",
				    				data:{id:idval},
				    				succ:function(data){
				    					self.datas=data.data;
				    				}
				    			})
							}
						 })
					},
					beforeUpdate:function(){},
					created: function(){},
					methods:{
						//保存
						saveSysUser:function(ev){  
							var that=this;
							var yes = ydz.validate();
							if(yes){
								var that=this;
							 	ydz.post({
									url:"/sysuser/insertSysUser",
									data:{
										name:that.datas.name,
										account:that.datas.account,
										pwd:that.datas.pwd,
										id:that.datas.id
									},
									succ:function(data){
										if(data.code==200){
											ydz.modalMsg("success",null,{
												load:function(){
													ydz.sysmenu.loadMenu('sysuser/findAll');
												}
											});
										}else{
											ydz.modalMsg("error");
										}
									}
								})
							} 
							
						}
					}
				}) 
			    
			})
		},

}


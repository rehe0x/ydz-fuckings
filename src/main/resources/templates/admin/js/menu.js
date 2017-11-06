_sysmenu={
		loadMenu:function(url){
			switch (url) {
			case "banner/findAll":
				ydz.loadDom('/template/banner-list',"ydz.banner.findAll"); 
				break;
			case "/template/home-page":
				ydz.loadDom("/template/home-page");
				break;
			case "news/findAll":
				ydz.loadDom('/template/news-list',"ydz.news.findAll"); 
				break;
			case "productclass/findAll":
				ydz.loadDom('/template/product-class-list',"ydz.productclass.findAll"); 
				break;
			case "product/findAll":
				ydz.loadDom('/template/product-list',"ydz.product.findAll"); 
				break;
			case "join/findAll":
				ydz.loadDom('/template/join-list',"ydz.join.findAll"); 
				break;
			case "order/findAll":
				ydz.loadDom('/template/order-list',"ydz.order.findAll"); 
				break;
			case "sysuser/findAll":
				ydz.loadDom('/template/sysuser-list',"ydz.sysuser.findAll"); 
				break;
			default:
				ydz.modalMsg("error","菜单未注册！");
				break;
			}
		}
}
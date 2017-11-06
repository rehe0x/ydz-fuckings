package com.ydz.fuckings.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ydz.fuckings.business.mapper.BannerMapper;
import com.ydz.fuckings.business.mapper.LotteryClassMapper;
import com.ydz.fuckings.business.mapper.LotteryOrderMapper;
import com.ydz.fuckings.business.model.LotteryClass;
import com.ydz.fuckings.business.model.LotteryOrder;
import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.RandomUtil;
import com.ydz.fuckings.controller.base.BaseAction;
import com.ydz.fuckings.thirdparty.JisuApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 彩票接口
 * @author Administrator
 *
 */
@Api(description = "彩票相关接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/lotterys")  
@SuppressWarnings("unchecked")
public class LotteryAction extends BaseAction{
	
	/**彩票分类mapper*/
	@Autowired
	private LotteryClassMapper lcMapper;
	/**彩票订单*/
	@Autowired
	private LotteryOrderMapper loMapper;
	
	/**Banner*/
	@Autowired
	private BannerMapper bannerMapper;

	
	@ApiOperation(value="获取彩票列表", notes="获取彩票列表 无参数 ")
	@RequestMapping(value="/getLotteryClass", method=RequestMethod.POST)
	public JsonResult getLotteryClass(){
		Page<?> page= PageHelper.startPage(1, 10);
		
		List<LotteryClass> lcList = lcMapper.findAll();
		System.out.println(page.getTotal());
		return new JsonResult(lcList);
	} 
	
	
	@ApiOperation(value="获取彩票开奖结果", notes="获取彩票开奖结果 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="caipiaoids",value="彩票ID",required=true,dataType="Integer",paramType="query"),
		@ApiImplicitParam(name="issuenos",value="彩票期数  不传默认当天",required=false,dataType="String",paramType="query"),
	})
    @RequestMapping(value="/getLottery", method=RequestMethod.POST)
	public JsonResult getLottery(Integer caipiaoids,String issuenos){
		JSONObject json= JisuApi.getLottery(caipiaoids, issuenos);
		return new JsonResult(json);
	} 
	
	@ApiOperation(value="获取彩票历史开奖结果", notes="获取彩票历史开奖结果 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="caipiaoids",value="彩票ID",required=true,dataType="Integer",paramType="query"),
		@ApiImplicitParam(name="issuenos",value="彩票期数  不传默认当天起算",required=false,dataType="String",paramType="query"),
		@ApiImplicitParam(name="nums",value="返回期数  不传默认20期  最多不超过20",required=false,dataType="Integer",paramType="query"),
	})
    @RequestMapping(value="/getLotteryHistory", method=RequestMethod.POST)
	public JsonResult getLotteryHistory(Integer caipiaoids,String issuenos,Integer nums){
		JSONArray json= JisuApi.getLotteryHistory(caipiaoids, issuenos, nums);
		return new JsonResult(json);
	} 
	
	
	@ApiOperation(value="彩票下注", notes="彩票下注 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="caipiaoid",value="彩票ID",required=true,dataType="Integer",paramType="query"),
		@ApiImplicitParam(name="lotteryNbr",value="投注号码",required=true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="lotteryNum",value="投注注数 不传默认1注",required=false,dataType="Integer",paramType="query"),
		@ApiImplicitParam(name="userId",value="用户ID",required=true,dataType="Integer",paramType="query"),
		@ApiImplicitParam(name="carded",value="身份证号码 随意传",required=true,dataType="String",paramType="query"),
		@ApiImplicitParam(name="phone",value="手机号码 随意传",required=true,dataType="String",paramType="query"),
	})
    @RequestMapping(value="/buyLottery", method=RequestMethod.POST)
	public JsonResult buyLottery(Integer caipiaoid,String lotteryNbr,Integer lotteryNum,Integer userId,String carded,String phone){
		LotteryOrder loBean  = new LotteryOrder();
		loBean.setCaipiaoid(caipiaoid);
		loBean.setOrderNbr(RandomUtil.getRandomFileName());
		loBean.setCarded(carded);
		loBean.setCreateDate(new Date());
		loBean.setLotteryNbr(lotteryNbr);
		if(lotteryNum==null&&lotteryNum==0){
			lotteryNum=1;
		}
		loBean.setLotteryNum(lotteryNum);
		loBean.setOrderMoney(0.0);
		loBean.setPhone(phone);
		loBean.setUserId(userId);
		loMapper.save(loBean);
		return new JsonResult(loBean.getLotteryNbr());
	} 
	
	
	@ApiOperation(value="我的下注", notes="我的下注  ps 我的订单 ")
	@ApiImplicitParam(name="userId",value="用户ID",required=true,dataType="Integer",paramType="query")
    @RequestMapping(value="/myLotteryOrder", method=RequestMethod.POST)
	public JsonResult myLotteryOrder(Integer userId){
		List<Map> listlo = loMapper.findByUser(userId);
		return new JsonResult(listlo);
	} 
	
	@ApiOperation(value="首页公告", notes="首页公告 ")
	@ApiImplicitParam(name="count1",value="返回条数  不传则默认20条   可自定义 10 20",required=true,dataType="Integer",paramType="query")
    @RequestMapping(value="/getLotteryNotice", method=RequestMethod.POST)
	public JsonResult getLotteryNotice(Integer count1){
		JSONArray jsonArr = JisuApi.getLotteryNotice(count1);
		return new JsonResult(jsonArr);
	}  
	
	@ApiOperation(value="获取banner", notes="获取banner  访问路径 取img  http://ip:port/ydz/img")
	@ApiImplicitParam(name="place",value="banner位置 1首页  2个人中心  3其他",required=true,dataType="String",paramType="query")
    @RequestMapping(value="/getBanner", method=RequestMethod.POST)
	public JsonResult getBanner(String place){
		List<Map> listlo = null;
		try {
			listlo = bannerMapper.findBanner(place);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(listlo);
	} 
	
}

package com.ydz.fuckings.thirdparty;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ydz.fuckings.common.HttpUtil;

/**
 * 极速API
 * @author Administrator
 *
 */
public class JisuApi {
	public static final String APPKEY = "84e342a168892e32";// 你的appkey
	public static final int caipiaoid = 13;
	public static final String issueno = "";
	public static final Integer num=20;
	public static final Integer count=20;
    public static final String URL_QUERY = "http://api.jisuapi.com/caipiao/query";//查询彩票开奖结果
    public static final String URL_CLASS = "http://api.jisuapi.com/caipiao/class";//查询彩票分类
    public static final String URL_HISTORY = "http://api.jisuapi.com/caipiao/history";//历史开奖
    public static final String URL_IQA = "http://api.jisuapi.com/iqa/query";
    
    /**
     * 查询彩票开奖结果
     * @param caipiaoid 彩票ID
     * @param issueno    期数
     */
    public static JSONObject getLottery(Integer caipiaoids,String issuenos) {
    	
        String result = null;
        
        if(null==caipiaoids||0==caipiaoids){
        	caipiaoids=caipiaoid;
        }
        if(null==issuenos){
        	issuenos=issueno;
        }
       
        String url = URL_QUERY + "?appkey=" + APPKEY + "&caipiaoid=" + caipiaoids + "&issueno=" + issuenos;
        
        JSONObject resultarr = null;
        
        try {
            result = HttpUtil.get(url, null, "UTF-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
            	resultarr = json.getJSONObject("result");
               /* String caipiaoid = resultarr.getString("caipiaoid");
                String issueno = resultarr.getString("issueno");
                String number = resultarr.getString("number");
                String refernumber = resultarr.getString("refernumber");
                String opendate = resultarr.getString("opendate");
                String deadline = resultarr.getString("deadline");
                String saleamount = resultarr.getString("saleamount");
                System.out.println(caipiaoid + " " + issueno + " " + number + " " + refernumber + " " + opendate + " "
                        + deadline + " " + saleamount);*/
                if (resultarr.get("prize") != null) {
                    JSONArray prize = resultarr.getJSONArray("prize");
                    for (int i = 0; i < prize.size(); i++) {
                        JSONObject obj = (JSONObject) prize.get(i);
                        String prizename = obj.getString("prizename");
                        String require = obj.getString("require");
                        String num = obj.getString("num");
                        String singlebonus = obj.getString("singlebonus");
                        System.out.println(prizename + " " + require + " " + num + " " + singlebonus);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultarr;
    }
    
    
    /**
     * 查询彩票开奖历史
     * @param caipiaoid 彩票ID
     * @param issueno    期数
     */
    public static JSONArray getLotteryHistory(Integer caipiaoids,String issuenos,Integer nums) {
    	
        String result = null;
        
        if(null==caipiaoids||0==caipiaoids){
        	caipiaoids=caipiaoid;
        }
        if(null==issuenos){
        	issuenos=issueno;
        }
        if(null==caipiaoids||0==caipiaoids){
        	nums=num;
        }
        String url = URL_HISTORY + "?appkey=" + APPKEY + "&caipiaoid=" + caipiaoids + "&issueno=" + issuenos + "&num=" +nums ;
        
        JSONArray resultarrList = null;
        
        try {
            result = HttpUtil.get(url, null, "UTF-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
            	JSONObject resultarr = json.getJSONObject("result");
                String caipiaoid = resultarr.getString("caipiaoid");
                String num = resultarr.getString("num");
                System.out.println(caipiaoid + " " + num);
                if (resultarr.get("list") != null) {
                	 resultarrList = resultarr.getJSONArray("list");
                	// for (int i = 0; i < resultarrList.size(); i++) {
                	//	 JSONObject objl = (JSONObject) resultarrList.get(i);
                	/*	 String opendate = objl.getString("opendate");
                         String issueno = objl.getString("issueno");
                         String number = objl.getString("number");
                         String refernumber = objl.getString("refernumber");
                         String saleamount = objl.getString("saleamount");
                         String totalmoney = objl.getString("totalmoney");
                         System.out.println(opendate + " " + issueno + " " +number+ " " + refernumber + " " +refernumber+ " " + saleamount + " " +totalmoney);*/
                        /* if (objl.get("prize") != null) {
                        	 JSONArray prize = objl.getJSONArray("prize");
                             for (int i1 = 0; i1 < prize.size(); i1++) {
                                 JSONObject obj = (JSONObject) prize.get(i1);
                                 String prizename = obj.getString("prizename");
                                 String require = obj.getString("require");
                                 String num1 = obj.getString("num");
                                 String singlebonus = obj.getString("singlebonus");
                                 System.out.println(prizename + " " + require + " " + num1 + " " + singlebonus);
                             }
                         }*/
                	// }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultarrList;
    }
    
    
    /**
     * 查询彩票分类
     * @return
     */
    public static JSONArray getLotteryClass() {
    	
        String result = null;
        JSONArray resultarr = null;
        
        String url = URL_CLASS + "?appkey=" + APPKEY ;
 
        try {
        	result = HttpUtil.get(url, null, "UTF-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
            	if (json.get("result") != null) {
                	resultarr = json.getJSONArray("result");
                   /* for (int i = 0; i < resultarr.size(); i++) {
                        JSONObject obj = (JSONObject) resultarr.get(i);
                        Integer caipiaoid = obj.getInteger("caipiaoid");
                        String name = obj.getString("name");
                        String parentid = obj.getString("parentid");
                        System.out.println(caipiaoid + " " + name + " " + parentid );
                    }*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultarr;
    }
    
    
    /**
     * 查询彩票最近开奖结果
     * @param count1 10 返回十条   20 返回20条  最高不超100
     * @return
     */
    public static JSONArray getLotteryNotice(Integer count1){
    	
    	if(count1!=null&&count1!=0){
    		count1=count;
    	}
    	
    	JSONArray jsonArr = JisuApi.getLotteryClass();
    	JSONArray jsonArr1 = new JSONArray();
    	 for (int i = 0; i < jsonArr.size(); i++) {
             JSONObject obj = (JSONObject) jsonArr.get(i);
        
             String name = obj.getString("name");
             Integer caipiaoid = obj.getInteger("caipiaoid");
             String parentid = obj.getString("parentid");
          //   System.out.println(caipiaoid + " " + name + " " + parentid );
             
             JSONObject jsonObj =  JisuApi.getLottery(caipiaoid, null);
             if(jsonObj!=null){
            	 jsonObj.put("name", name);
            	 jsonObj.remove("prize");
            	 jsonObj.remove("refernumber");
            	 jsonObj.remove("opendate");
            	 jsonObj.remove("deadline");
            	 jsonObj.remove("saleamount");
            	 jsonObj.remove("totalmoney");
            	 
            	 jsonArr1.add(jsonObj);
             }
             if(jsonArr1.size()>count1)break;
           
         }
    	 return jsonArr1;
    }
    
    
    /**
     * 机器人在线回答
     * @param question
     * @return
     */
    public static JSONObject iqaQuery(String  question) {
    	
        String result = null;
        JSONObject resultarr = null;
        try {
        	String url = URL_IQA + "?appkey=" + APPKEY + "&question="+question;
        	result = HttpUtil.get(url, null, "UTF-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
            	resultarr = json.getJSONObject("result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultarr;
    }
    
    public static void main(String[] args) {
//    	JisuApi.getLotteryClass();
//    	JisuApi.getLottery(17, null);
//    	JSONArray ss = JisuApi.getLotteryNotice(20);
//    	System.out.println(ss.toJSONString());
//    	JisuApi.getLotteryHistory(4, null, 20);
//    	JSONObject jsonObj;
//			jsonObj = JisuApi.iqaQuery("d坚实的咖啡机都是");
//			System.out.println(jsonObj.toJSONString());	
//	System.out.println(HttpUtil.get("http://zxwap.caipiao.163.com/news", null, "UTF-8"));
    	Map param  =new HashMap();
    	
    	param.put("appKey", "10001694");
 		param.put("format", "json");
 		//param.put("partner_id", "qianmi-open-sdk-java-20170919");
	    param.put("access_token", "30dfc654bc574e6a81fd231e6156a631");
	    param.put("v", "1.1");
    	param.put("method", "bm.elife.recharge.mobile.payBill");
    	param.put("timestamp", "2017-10-27 14:16:48");
    	
    	//业务参数
    	param.put("rechargeAmount", "10");
    	param.put("mobileNo", "18680885064");
        param.put("outerTid", "BMZD0000171027143DUB");
        param.put("callback", "http://xiehs.free.ngrok.cc/wap_web/topup/isTopupCallback.shtml");
        param.put("itemId", "152799");
    	
//    	params.put("v", "1.1");
//    	params.put("access_token", "30dfc654bc574e6a81fd231e6156a631");
//    	params.put("method", "bm.elife.recharge.mobile.payBill");
//    	params.put("format", "json");
//    	
//    	params.put("mobileNo", "18680885064");
//    	params.put("rechargeAmount", "10");
//    	params.put("outerTid", "BMZD0000171027143DUB");
//    	params.put("callback", "http://xiehs.free.ngrok.cc/wap_web/topup/isTopupCallback.shtml");
//    	params.put("itemId", "152799");
//    	Date date = new Date(System.currentTimeMillis());
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        String strValue = format.format(date);
//        System.out.println(strValue+"ss");
//    	params.put("timestamp", "2017-10-27 14:16:48");
//    	
//    	try {
//    		String sgr = BmbmSignUtil.sign(params, "eVfGdblyEVV2HWAhWqfZuXF5xHPsSQVc");
//    		System.out.println(sgr);
//			params.put("sign", sgr);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    	
    	String s = HttpUtil.post("http://test.api.bm001.com/api", param);
    	System.out.println(s);

	}
}

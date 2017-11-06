package com.ydz.fuckings.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TestMain {
	  private String url = "https://www.doormaster.me:9099/";  
	    private String charset = "utf-8";  
	    private HttpClientUtil httpClientUtil = null;  
	      
	    public TestMain(){  
	        httpClientUtil = new HttpClientUtil();  
	    }  
	      
	    public void test(){  
	        String httpOrgCreateTest = url + "doormaster/server/devices"; 
	        String httpOrgCreateTest1 = url + "doormaster/server/employees"; 
	        String httpOrgCreateTest2 = url + "doormaster/server/areas"; 
	        String httpOrgCreateTest3 = url + "doormaster/server/acc_ekeys"; 
	        Map<String,Object> createMap = new HashMap<String,Object>();  
	        createMap.put("access_token", "8e31de57294c6bd732fe8816ef5907b45a1d6ae3d5705efLcb2152bf");
	        createMap.put("operation", "GET");
	        Map data = new HashMap();
/*	      data.put("emp_name", "测AA试啦");
	        data.put("app_account", "18588858821");
	        data.put("area_id",  838);*/
	       // data.put("ids", 1);
	        List list = new ArrayList();
	        list.add("0350268656");
	        data.put("dev_sns",list);
	        createMap.put("data", data);
	        System.out.println(JSON.toJSONString(createMap));
	        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest3,createMap,charset);  
	        System.out.println("result:"+httpOrgCreateTestRtn);  
	    }  
	      
	    public static void main(String[] args){  
	        TestMain main = new TestMain();  
	        main.test();  
	    } 
}

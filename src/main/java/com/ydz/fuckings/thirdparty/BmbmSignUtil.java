package com.ydz.fuckings.thirdparty;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class BmbmSignUtil {
	 public static String sha1(String str) throws IOException {
	        return byte2hex(getSHA1Digest(str));
	    }

	    private static byte[] getSHA1Digest(String data) throws IOException {
	        byte[] bytes;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	            bytes = md.digest(data.getBytes("utf-8"));
	        } catch (GeneralSecurityException gse) {
	            throw new IOException(gse);
	        }
	        return bytes;
	    }

	    private static String byte2hex(byte[] bytes) {
	        StringBuilder sign = new StringBuilder();
	        for (int i = 0; i < bytes.length; i++) {
	            String hex = Integer.toHexString(bytes[i] & 0xFF);
	            if (hex.length() == 1) {
	                sign.append("0");
	            }
	            sign.append(hex.toUpperCase());
	        }
	        return sign.toString();
	    }

	    public static String sign(Map<String, String> param, String secret) throws IOException {
	        if (param == null) {
	            return null;
	        }
	        StringBuilder sb = new StringBuilder();
	        List<String> paramNames = new ArrayList<>(param.size());
	        paramNames.addAll(param.keySet());
	        Collections.sort(paramNames);
	        sb.append(secret);
	        for (String paramName : paramNames) {
	            sb.append(paramName).append(param.get(paramName));
	        }
	        sb.append(secret);
	        return sha1(sb.toString());
	    }

//	    public static void main(String[] args) throws IOException {
//	    	Map<String, String> param = new HashMap<>();
//	           
//	    	//��������
//	    	//param.put("appKey", QianmiApi.appKey);
//	 		param.put("format", "json");
//	 		//param.put("partner_id", "qianmi-open-sdk-java-20170919");
//		    param.put("access_token", QianmiApi.acceessToken);
//		    param.put("v", "1.1");
//        	param.put("method", "bm.elife.recharge.mobile.payBill");
//        	param.put("timestamp", "2017-10-27 14:16:48");
//        	
//        	//ҵ�����
//        	param.put("rechargeAmount", "10");
//        	param.put("mobileNo", "18680885064");
//	        param.put("outerTid", "BMZD0000171027143DUB");
//	        param.put("callback", "http://xiehs.free.ngrok.cc/wap_web/topup/isTopupCallback.shtml");
//	        param.put("itemId", "152799");
//	        
//	        
//        	String Sign = BmbmSignUtil.sign(param, QianmiApi.appSecret);
//			System.out.println("ǩ����"+Sign);
//			
//			
//
//			
//			long l = Long.parseLong("1509085008554");
//			//new���ڶ���
//			
//			SimpleDateFormat fmat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			try {
//				Date date = new Date(l);
//				System.out.println(date.toString());
//				
//				 DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                 format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//                 String strValue = format.format(date);
//                 System.out.println(strValue+"ss");
//				//param.put("timestamp", date);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	
//				
//	    }
}

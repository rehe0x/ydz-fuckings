package com.ydz.fuckings.common;

import java.text.NumberFormat;

public class PadUtil {
	/**
	  * 取子字符串
	  * @param oriStr   原字符串
	  * @param beginIndex  取子串的起始位置
	  * @param len    取子串的长度
	  * @return  子字符串
	  */
	 public static String subString(String oriStr,int beginIndex,int len){
    String str = null;	 
	  int strlen = oriStr.length();
	  beginIndex = beginIndex -1;
	  if(strlen <= beginIndex){
	   System.out.println("out of " + oriStr + "'s length, please recheck!");
	  }else if(strlen <= beginIndex+len){
	   str = oriStr.substring(beginIndex);
	  }else{
	   str = oriStr.substring(beginIndex, beginIndex+len);
	  }
	  return str;
	 }
	  
	 /**
	  * 右补位，左对齐
	  * @param oriStr  原字符串
	  * @param len  目标字符串长度
	  * @param alexin  补位字符
	  * @return  目标字符串
	  */
	 public static String padRight(String oriStr,int len,char alexin){
		String str = null;	 
	  int strlen = oriStr.length();
	  if(strlen < len){
	   for(int i=0;i<len-strlen;i++){
	    str = str+alexin;
	   }
	  }
	  str = str + oriStr;
	  return str;
	 }
	  
	 /**
	  * 左补位，右对齐
	  * @param oriStr  原字符串
	  * @param len  目标字符串长度
	  * @param alexin  补位字符
	  * @return  目标字符串
	  */
	 public static String padLeft(String oriStr,int len,String alexin){
	 String str = null;	 
	  int strlen = oriStr.length();
	  if(strlen < len){
	   for(int i=0;i<len-strlen;i++){
	    str = str+alexin;
	   }
	  }
	  str = oriStr + str;
	  return str;
	 }
	 
	 
	 public static String  PrefixInteger(int num, int n) {
		  	int number = num;     
		    NumberFormat formatter = NumberFormat.getNumberInstance();     
		    formatter.setMinimumIntegerDigits(n);     
		    formatter.setGroupingUsed(false);     
		    String s = formatter.format(number);     
		    return s;
	 }
}

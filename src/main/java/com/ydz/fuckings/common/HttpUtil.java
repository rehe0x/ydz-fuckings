package com.ydz.fuckings.common;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;  

/** 
* Apache HttpUtil 4.X 工具包装类 
*  
*/ 
@SuppressWarnings("unchecked")
public class HttpUtil {
	private static final String CHARSET_UTF8 = "UTF-8";  
    private static final String CHARSET_GBK = "UTF-8";  
    private static final String SSL_DEFAULT_SCHEME = "https";  
    private static final int SSL_DEFAULT_PORT = 443;  
      
    /** 
     * 获取DefaultHttpClient实例 
     *  
     * @param charset 
     * 参数编码集, 可空 
     * @return DefaultHttpClient 对象 
     */  
    private static CloseableHttpClient  getDefaultHttpClient(){  
         CloseableHttpClient httpclient = HttpClients.custom()  
                .setRetryHandler(requestRetryHandler)  
                .build();  
  
        return httpclient;  
    }  
      
    // 异常自动恢复处理, 使用HttpRequestRetryHandler接口实现请求的异常恢复  
    private static HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {  
        // 自定义的恢复策略  
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {  
            // 设置恢复策略，在发生异常时候将自动重试3次  
            if (executionCount >= 3) {  
                // Do not retry if over max retry count  
                return false;  
            }  
            if (exception instanceof InterruptedIOException) {  
                // Timeout  
                return false;  
            }  
            if (exception instanceof UnknownHostException) {  
                // Unknown host  
                return false;  
            }  
            if (exception instanceof ConnectTimeoutException) {  
                // Connection refused  
                return false;  
            }  
            if (exception instanceof SSLException) {  
                // SSL handshake exception  
                return false;  
            }  
            HttpClientContext clientContext = HttpClientContext.adapt(context);  
            HttpRequest request = clientContext.getRequest();  
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);  
            if (idempotent) {  
                // Retry if the request is considered idempotent  
                return true;  
            }  
            return false;  
        }  
    };  
      
    // 使用ResponseHandler接口处理响应，HttpClient使用ResponseHandler会自动管理连接的释放，解决了对连接的释放管理  
    private static ResponseHandler responseHandler = new ResponseHandler() {  
        // 自定义响应处理  
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {  
            HttpEntity entity = response.getEntity();  
            if (entity != null) {  
                String charset = null;  
                ContentType contentType = ContentType.getOrDefault(entity);  
                Charset charsetObj = contentType.getCharset();  
                if(charsetObj != null) {  
                    charset = charsetObj.name();  
                }  
                charset = charset == null ? CHARSET_GBK : charset;  
                return new String(EntityUtils.toByteArray(entity), charset);  
            } else {  
                return null;  
            }  
        }  
    };  
      
    /** 
     * Get方式提交,URL中包含查询参数, 格式：http://www.g.cn?search=p&name=s..... 
     *  
     * @param url 
     * 提交地址 
     * @return 响应消息 
     */  
    public static String get(String url) {  
        return get(url, null, null);  
    }  
      
      
    /** 
     * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn 
     *  
     * @param url 
     * 提交地址 
     * @param params 
     * 查询参数集, 键/值对 
     * @return 响应消息 
     */  
    public static String get(String url, Map params) {  
        return get(url, params, null);  
    }  
      
      
    /** 
     * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn 
     *  
     * @param url 
     * 提交地址 
     * @param params 
     * 查询参数集, 键/值对 
     * @param charset 
     * 参数提交编码集 
     * @return 响应消息 
     */  
    public static String get(String url, Map params, String charset) {  
        if (url == null || StringUtils.isEmpty(url)) {  
            return null;  
        }  
        List qparams = getParamsList(params);  
        if (qparams != null && qparams.size() > 0) {  
            charset = (charset == null ? CHARSET_GBK : charset);  
            String formatParams = URLEncodedUtils.format(qparams, charset);  
            url = (url.indexOf("?")) < 0 ? (url + "?" + formatParams) : (url  
                    .substring(0, url.indexOf("?") + 1) + formatParams);  
        }  
        CloseableHttpClient httpclient = getDefaultHttpClient();  
        HttpGet hg = new HttpGet(url);  
        // 发送请求，得到响应  
        String responseStr = null;  
        try {  
            responseStr = (String) httpclient.execute(hg, responseHandler);  
        } catch (ClientProtocolException e) {  
            throw new RuntimeException("客户端连接协议错误", e);  
        } catch (IOException e) {  
            throw new RuntimeException("IO操作异常", e);  
        } finally {  
            abortConnection(hg, httpclient);  
        }  
        return responseStr;  
    }  
      
      
    /** 
     * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn 
     *  
     * @param url 
     * 提交地址 
     * @param params 
     * 提交参数集, 键/值对 
     * @return 响应消息 
     */  
    public static String post(String url, Map params) {  
        return post(url, params, null);  
    }  
      
      
    /** 
     * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn 
     *  
     * @param url 
     * 提交地址 
     * @param params 
     * 提交参数集, 键/值对 
     * @param charset 
     * 参数提交编码集 
     * @return 响应消息 
     */  
    public static String post(String url, Map params, String charset) {  
        if (url == null || StringUtils.isEmpty(url)) {  
            return null;  
        }  
        // 创建HttpClient实例  
        CloseableHttpClient httpclient = getDefaultHttpClient();  
        UrlEncodedFormEntity formEntity = null;  
        try {  
            if (charset == null || StringUtils.isEmpty(charset)) {  
                formEntity = new UrlEncodedFormEntity(getParamsList(params));  
            } else {  
                formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);  
            }  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("不支持的编码集", e);  
        }  
        HttpPost hp = new HttpPost(url);   
        hp.setEntity(formEntity);  
        // 发送请求，得到响应  
        String responseStr = null;  
        try {  
            responseStr = (String) httpclient.execute(hp, responseHandler);  
        } catch (ClientProtocolException e) {  
            throw new RuntimeException("客户端连接协议错误", e);  
        } catch (IOException e) {  
            throw new RuntimeException("IO操作异常", e);  
        } finally {  
            abortConnection(hp, httpclient);  
        }         
        return responseStr;  
    }  
      
      
      
    /** 
     * 释放HttpClient连接 
     *  
     * @param hrb 
     * 请求对象 
     * @param httpclient 
     *           client对象 
     */  
    private static void abortConnection(final HttpRequestBase hrb, final CloseableHttpClient httpclient){  
        if (hrb != null) {  
            hrb.abort();  
        }  
        if (httpclient != null) {  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                throw new RuntimeException("释放httpclient发生IO操作异常", e);  
            }  
        }  
    }  
      
    /** 
     * 将传入的键/值对参数转换为NameValuePair参数集 
     * @param paramsMap 
     * 参数集, 键/值对 
     * @return NameValuePair参数集 
     */  
    private static List getParamsList(Map paramsMap) {  
        if (paramsMap == null || paramsMap.size() == 0) {  
            return null;  
        }  
        List params = new ArrayList();  
        Iterator<Map.Entry<String, Object>> it = paramsMap.entrySet().iterator();  
        while (it.hasNext()) {  
           Map.Entry<String, Object> entry = it.next();  
           System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
           params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));  
        }  
        return params;  
    }  

    public static void main(String[] args) {
    	String url="https://www.doormaster.me:9099/doormaster/server/video_devices";
    	Map map = new HashMap();
    	map.put("access_token", "8e31de57294c6bd732fe8816ef5907b45a1d6ae3d5705efLcb2152bf");
    	String src = HttpUtil.get(url, map);
    	System.out.println(src);
    }
}

package com.ydz.fuckings.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ydz.fuckings.common.JsonResult;
import com.ydz.fuckings.common.date.DateStyle;
import com.ydz.fuckings.common.date.DateUtil;
import com.ydz.fuckings.controller.base.BaseController;

import springfox.documentation.annotations.ApiIgnore;
/**
 * 文件上传
* @ClassName: FileAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年5月16日 下午4:16:01 
*
 */
@RestController
@RequestMapping(value="/file")  
public class FileAction extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(FileAction.class);
    
   @Value("${web.upload-path}")
    private String path;
   
	/**
	 *  文件上传
	 * @param file
	 * @return
	 */
    @ApiIgnore
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public JsonResult upload(@RequestParam("file") MultipartFile file){
    
         // 获取文件名
         String fileName = file.getOriginalFilename();
         logger.info("上传的文件名为：" + fileName);
         // 获取文件的后缀名
         String suffixName = fileName.substring(fileName.lastIndexOf("."));
         logger.info("上传的后缀名为：" + suffixName);
         // 文件上传后的路径
         //String filePath = this.getRequest().getSession().getServletContext().getRealPath("/upload/image/");
         String filePath = this.getRequest().getServletContext().getRealPath(path);
         // 解决中文问题，liunx下中文路径，图片显示问题
        //  fileName = UUID.randomUUID() + suffixName;
         fileName =DateUtil.DateToString(new Date(), DateStyle.YYYYMMDDHHMMSS)+new Random().nextInt(999999)+ suffixName;
         System.out.println(filePath + fileName);
         File dest = new File(filePath + fileName);
        
         // 检测是否存在目录
         if (!dest.getParentFile().exists()) {
             dest.getParentFile().mkdirs();
         }
         try {
             file.transferTo(dest);
          } catch (IllegalStateException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         Map map = new HashMap();
         map.put("url",path+fileName);
         map.put("name", fileName);
        return new JsonResult(map);
		
	}

}

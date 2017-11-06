package com.ydz.fuckings.business.service;

import com.ydz.fuckings.business.model.About;
import com.ydz.fuckings.common.MyException;

/**
 * 关于service
 * @author Administrator
 *
 */
public interface IAboutService {
	
	public Integer saveAbout(About info)throws Exception;

}

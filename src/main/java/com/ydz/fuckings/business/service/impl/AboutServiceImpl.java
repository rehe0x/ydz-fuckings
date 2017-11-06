package com.ydz.fuckings.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydz.fuckings.business.mapper.AboutMapper;
import com.ydz.fuckings.business.model.About;
import com.ydz.fuckings.business.service.IAboutService;
import com.ydz.fuckings.common.MyException;

@Service
public class AboutServiceImpl implements IAboutService{
	/**关于mapper*/
	@Autowired
	private AboutMapper aboutMapper;
	
	@Override
	public Integer saveAbout(About info) throws MyException {
		aboutMapper.delete(null);
		return aboutMapper.save(info);
	}

}

package com.young.services.common.impl;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.young.daos.BaseDAO;
import com.young.services.common.ICommService;

@Service(value="commService")
public class CommServiceImpl   implements ICommService {

	protected Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	protected BaseDAO baseDAO;

	@Override
	public <T> T getEntity(String id, Class<T> cls) throws Exception {
		// TODO Auto-generated method stub
		T t=baseDAO.findById(Long.parseLong(id), cls);
		return t;
	}
}

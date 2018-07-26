package com.learn.pattern.AbstractFactory;

import com.learn.pattern.Bean.BaiWei;
import com.learn.pattern.Bean.Bear;
import com.learn.pattern.Bean.ChunSheng;
import com.learn.pattern.Bean.QingDao;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 11:06
 **/
public class FactoryImp extends AbstractFactory {

	@Override
	public Bear createQingDao() {
		return new QingDao();
	}

	@Override
	public Bear createChunSheng() {
		return new ChunSheng();
	}

	@Override
	public Bear createBaiWei() {
		return new BaiWei();
	}
}

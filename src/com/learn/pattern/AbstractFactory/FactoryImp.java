package com.learn.pattern.AbstractFactory;

import com.learn.pattern.Bean.Bear;
import com.learn.pattern.FactoryMethod.BaiWeiFactory;
import com.learn.pattern.FactoryMethod.ChunShengFactory;
import com.learn.pattern.FactoryMethod.QingDaoFactory;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 11:06
 **/
public class FactoryImp extends AbstractFactory {

	@Override
	public Bear createQingDao() {
		return new QingDaoFactory().createBear();
	}

	@Override
	public Bear createChunSheng() {
		return new ChunShengFactory().createBear();
	}

	@Override
	public Bear createBaiWei() {
		return new BaiWeiFactory().createBear();
	}
}

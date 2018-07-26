package com.learn.pattern.FactoryMethod;

import com.learn.pattern.Bean.Bear;
import com.learn.pattern.Bean.QingDao;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 10:58
 **/
public class QingDaoFactory implements Factory{

	@Override
	public Bear createBear() {
		return new QingDao();
	}
}

package com.learn.pattern.AbstractFactory;

import com.learn.pattern.Bean.Bear;
import com.learn.pattern.Bean.QingDao;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 11:03
 **/
public abstract class AbstractFactory {
	public abstract Bear createQingDao();

	public abstract Bear createChunSheng();

	public abstract Bear createBaiWei();
}

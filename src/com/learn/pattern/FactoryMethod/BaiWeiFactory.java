package com.learn.pattern.FactoryMethod;

import com.learn.pattern.Bean.BaiWei;
import com.learn.pattern.Bean.Bear;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 10:58
 **/
public class BaiWeiFactory implements Factory {
	@Override
	public Bear createBear() {
		return new BaiWei();
	}
}

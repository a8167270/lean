package com.learn.pattern.FactoryMethod;

import com.learn.pattern.Bean.Bear;
import com.learn.pattern.Bean.ChunSheng;

/**
 * @program: learn
 * @description:
 * @author: Feng.Jie
 * @create: 2018-07-26 10:59
 **/
public class ChunShengFactory implements Factory {
	@Override
	public Bear createBear() {
		return new ChunSheng();
	}
}

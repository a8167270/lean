package com.learn.pattern.SimpleFactory;

import com.learn.pattern.Bean.BaiWei;
import com.learn.pattern.Bean.Bear;
import com.learn.pattern.Bean.ChunSheng;
import com.learn.pattern.Bean.QingDao;

public class SimpleFactory implements Factory{

	@Override
	public Bear createBear(String name) {
		switch (name) {
			case "青岛":
				return new QingDao();
			case "百威":
				return new BaiWei();
			case "纯生":
				return new ChunSheng();
		}

		return null;
	}
}

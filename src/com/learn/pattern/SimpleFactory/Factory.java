package com.learn.pattern.SimpleFactory;

import com.learn.pattern.Bean.Bear;

public interface Factory {
	Bear createBear(String name);
}

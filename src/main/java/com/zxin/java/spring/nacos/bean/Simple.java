package com.zxin.java.spring.nacos.bean;

import org.springframework.stereotype.Component;

import com.alibaba.nacos.api.config.annotation.NacosValue;

@Component
public class Simple {

	@NacosValue(value="${name:zxin}", autoRefreshed = true)
	private String name;
	
	@NacosValue(value="${alive:false}", autoRefreshed = true)
	private boolean alive;
	
	@NacosValue(value="${num:12}", autoRefreshed = true)
	private int num;
	
	@NacosValue(value="${db:2.7}", autoRefreshed = true)
	private double db ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getDb() {
		return db;
	}

	public void setDb(double db) {
		this.db = db;
	}

	@Override
	public String toString() {
		return "Simple [name=" + name + ", alive=" + alive + ", num=" + num + ", db=" + db + "]";
	}
	
	
	
}

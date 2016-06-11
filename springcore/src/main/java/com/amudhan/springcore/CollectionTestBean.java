package com.amudhan.springcore;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Properties;

/*This class is created to demonstrate collection injection*/
public class CollectionTestBean {
	private List<String> list;
	private Set<Integer> set;
	private Map<Integer,String> map;
	private Properties properties;
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<Integer> getSet() {
		return set;
	}
	public void setSet(Set<Integer> set) {
		this.set = set;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "CollectionTestBean [list=" + list + ", set=" + set + ", map=" + map + ", properties=" + properties
				+ "]";
	}
	
}

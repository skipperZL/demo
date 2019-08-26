package com.zl.demo.cache.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisDemo {
	
	private void testPing() {
		 //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

	}
	
	private void testString() {
		 //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        
	}
	
	private void testList() {
		 //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }

	}
	
	private void testKey() {
		  //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
 
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }

	}
	
	private void testHash() {
		  //连接本地的 Redis 服务
      Jedis jedis = new Jedis("localhost");
      System.out.println("连接成功");
      Map<String, String> params = new HashMap<String, String>();
      params.put("22", "AAA");
      params.put("23", "BBB");
      params.put("24", "CCC");
      jedis.hmset("hashmap1", params);
      List<String> list = jedis.hmget("hashmap1", "23");
      for (String e : list) {
    	  System.out.println(e);
      }
	}
	
	private void testSet() {
		  //连接本地的 Redis 服务
    Jedis jedis = new Jedis("localhost");
    System.out.println("连接成功");
    jedis.sadd("setA", "apple1");
    jedis.sadd("setA", "apple2");
    jedis.sadd("setA", "apple3");
    jedis.sadd("setA", "apple4");
    Set<String> set = jedis.smembers("setA");
    for (String e : set) {
  	  System.out.println(e);
    }
	}
	
	private void testObject() {
	}

	public static void main(String[] args) {
		RedisDemo rd = new RedisDemo();
		rd.testPing();
		rd.testString();
		rd.testList();
		rd.testKey();
		rd.testHash();
		rd.testSet();
	}

}

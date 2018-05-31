package com.zl.demo.concurrent;

import java.sql.Connection;
import java.util.LinkedList;

import javafx.scene.shape.Line;
import sun.net.www.content.text.plain;

public class ConnectionPoolDemo {
	private LinkedList<Connection> pool = new LinkedList<>();
	
	public ConnectionPoolDemo(int initialSize) {
		if (initialSize > 0) {
			for (int i = 0; i < initialSize; i++) {
				pool.addLast(ConnectionDriverDemo.createConnection());
			}
		}
	}
	
	public void releaseConnection(Connection connection) {
		if (connection != null) {
			synchronized (pool) {
				pool.addLast(connection);
				pool.notifyAll();
				
			}
		}
	}
	
	public Connection fetchConnection(long mills) throws InterruptedException {
		synchronized (pool) {
			if (mills <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			} else {
				long end = System.currentTimeMillis() + mills;
				long remaining = mills;
				while (pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					remaining= end - System.currentTimeMillis();
				}
				Connection result = null;
				if (!pool.isEmpty()) {
					result = pool.removeFirst();
				}
				return result; 
			}
			
		}
	}
}

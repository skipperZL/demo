package com.zl.demo.designmodel.behavior.chain;

public class ChainDemo {
	
	public static void main(String[] args) {
		Request request1 = new Request("claim", 3000);
		Request request2 = new Request("claim", 200);
		Request request3 = new Request("claim", 888888);
		
		Employee libai = new TeamLeader("TeamLeader_LiBai");
		Employee potter = new HR("HR_Potter");
		Employee lucy = new Manager("Manager_Lucy");
		
		libai.successor = potter;
		potter.successor = lucy;
		
		libai.handle(request1);
		libai.handle(request2);
		libai.handle(request3);
		
		
	}
	
}

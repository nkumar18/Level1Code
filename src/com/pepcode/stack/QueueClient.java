package com.pepcode.stack;


public class QueueClient {
public static void main(String[] args) throws Exception {
	queue  myq=new queue();
	myq.push(100);
	myq.push(10);
	myq.push(90);
	myq.push(101);
	for(int i=0;i<myq.size();i++) {
		System.out.println(myq.front());
	}
	
}
}

package jadetest;

import jade.core.*;
/**
 * ���Գɹ�����
 * ��������Ϊ -gui hello:jadetest.HelloWorldAgent 
 * ð�ź��治���пո񣡣������пո񣡣������пո񣡣�
 * @author HB
 *
 */

public class HelloWorldAgent extends Agent {

	public void setup(){
	    System.out.println("Agent Started: Hello World2!");
	    System.out.println("-----About Me:-----");
	    System.out.println("My local name is:"+getLocalName());
	    System.out.println("My globally unique name is:"+getName() );
	    System.out.println("-----About Here:-----");
	    Location l = here();
	    System.out.println("I am running in a location called:"+l.getName());
	    System.out.println("Which is identified uniquely as:"+l.getID());
	    System.out.println("And is contactable at:"+l.getAddress());
	    System.out.println("Using the protocol:"+l.getProtocol());
	}
	
	

}


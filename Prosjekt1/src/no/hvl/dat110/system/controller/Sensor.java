package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp = 0;
		
		// implement marshalling, call and unmarshalling for read RPC method
		rpcclient.connect();
		
		byte[] sendt = RPCUtils.marshallInteger(RPCID, temp);
		byte[] motatt = rpcclient.call(sendt);
		
		temp = RPCUtils.unmarshallInteger(motatt);
		
		return temp;
	}
	
}

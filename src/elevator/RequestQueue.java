package elevator;

import java.util.LinkedList;

class RequestQueue {
	
	private LinkedList<Request> reqQueue = new LinkedList<Request>();
	
	public void addRequest(Request req) throws IncorrectTimeException{
		if(!reqQueue.isEmpty() && reqQueue.getLast().getTime()>=req.getTime()){
			//wrong!!
			//System.out.println("incorrect request time! Elevator will stop.");
			throw new IncorrectTimeException("incorrect request time! Elevator will stop.");
		}
		reqQueue.addLast(req);
		return;
	}
	
	public Request getRequest(){
		return reqQueue.pollFirst();
	}
	
	public boolean isEmpty(){
		return reqQueue.isEmpty();
	}
}

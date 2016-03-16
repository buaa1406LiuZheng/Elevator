package elevator;

import java.util.LinkedList;

class RequestQueue{
	
	private LinkedList<Request> reqQueue = new LinkedList<Request>();
		
	public void initialRequest(Request req) throws IncorrectTimeException{
		if(!reqQueue.isEmpty() && reqQueue.getLast().getTime()>req.getTime()){
			//wrong!!
			throw new IncorrectTimeException("incorrect request time! Elevator will stop.");
		}
		reqQueue.addLast(req);
		return;
	}
	
	public void addRequest(Request req){
		reqQueue.add(req);
	}
	
	public Request getFirstRequest(){
		/*get the first request and delete it*/
		return reqQueue.pollFirst();
	}
	
	public Request getRequest(int i){
		return reqQueue.get(i);
	}
	
	public RequestQueue RequestBetweenTime(double t1,double t2){
		/*return a list of requests whose time is between t1 and t2*/
		RequestQueue requests = new RequestQueue();
		
		for(Request q:reqQueue){
			if(q.getTime()<t1){
				continue;
			}
			else if(q.getTime()>t2){
				break;
			}
			else{
				requests.addRequest(q);
			}			
		}
		
		return requests;
	}
	
	public RequestQueue RequestBetweenTime(double t){
		/*return a list of requests whose time is exactly t*/
		return RequestBetweenTime(t,t);
	}
	
	public void clear(){
		/*clear all requests in the reqQueue*/
		reqQueue.clear();
	}
	
	public void removeAll(Request req){
		/*remove all the same request as req in the reqQueue*/
		while(reqQueue.remove(req));
		return;
	}
	
	public int lenth(){
		/*return the lenth(size) of the reqQueue*/
		return reqQueue.size();
	}
	
	public boolean isEmpty(){
		return reqQueue.isEmpty();
	}
}

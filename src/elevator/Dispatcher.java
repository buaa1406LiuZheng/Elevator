package elevator;

class Dispatcher {
	
	private Elevator elevt;
	private RequestQueue rq;
	
	public Dispatcher(Elevator e,RequestQueue r){
		elevt = e;
		rq = r;
	}
	
	public int Dispatch(){
		Request r;
		int validDispatch=0;
		
		while(!rq.isEmpty()){
			r = rq.getRequest();
			elevt.move(r);
			validDispatch++;
		}
		
		return validDispatch;
	}
	
}

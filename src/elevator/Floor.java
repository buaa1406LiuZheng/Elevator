package elevator;

class Floor {
	private RequestQueue[] floorRequest = new RequestQueue[10];
	
	public Floor(){
		for(int i=0;i<10;i++){
			floorRequest[i]=new RequestQueue();
		}
	}
	
	public boolean haveRequest(int i){
		/*if ith floor has request*/
		return !floorRequest[i-1].isEmpty();
	}
	
	public void addRequest(Request req){
		/*add a request to ith floor's request list*/
		int i = req.getFloor()-1;
		floorRequest[i].addRequest(req);
	}
	
	public boolean isEmpty(){
		for(int i=0;i<10;i++){
			if(!floorRequest[i].isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public Request getLatestRequest(){
		Request req,latestReq=null;
		double time = 99999999999999.0;
		boolean flag = true;
		for(RequestQueue rq : floorRequest){
			for(int i=0;i<rq.lenth();i++){
				if(flag){
					req = rq.getRequest(i);
					latestReq = req;
					time = req.getTime();
					flag = false;
				}
				else{
					req = rq.getRequest(i);
					if(time>req.getTime()){
						time = req.getTime();
						latestReq = req;
					}
				}
			}
		}
		floorRequest[latestReq.getFloor()-1].removeAll(latestReq);
		return latestReq;
	}
	
	public void clear(int i){
		floorRequest[i].clear();
	}
}

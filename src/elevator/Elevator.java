package elevator;

class Elevator implements ElevatorInterface {
	
	private int floor = 1;
	private double runtime = 0;
	private Direction direction = Direction.STEADY;
	private boolean running = false;
	private int destination = 0;
	
	public void run(Request r){
		/*run according to a request*/
		int rfloor = r.getFloor();
		int time = r.getTime();
		
		if(time>runtime){
			runtime = time;
		}
		
		if(rfloor>floor){
			direction = Direction.UP;
		}
		else if(rfloor<floor){
			direction = Direction.DOWN;
		}
		else{
			direction = Direction.STEADY;
		}
		
		destination = rfloor;
		running = true;
		
		return;
	}
	
	public void moveTo(int dfloor){
		/*move to the dfloor and renew runtime*/
		runtime += Math.abs(floor-dfloor)*0.5;
		floor = dfloor;
	}
	
	public void moveTo(){
		/*move to the destination and renew runtime*/
		runtime += Math.abs(floor-destination)*0.5;
		floor = destination;
	}
	
	public void goUP(){
		/*go up 1 floor*/
		floor++;
		runtime+=0.5;
		running = true;
	}
	
	public void goDOWN(){
		/*go DOWN 1 floor*/
		floor--;
		runtime+=0.5;
		running = true;
	}
	
	public void stop(){
		/*stop at a floor(open and close door)*/
		runtime++;
		running = false;
	}
	
	/*public void start() {
		running = true;
	}*/
	
	public boolean isArrive(){
		return floor == destination;
	}
	
	public void stopRunning(){
		destination = 0;
		running = false;
	}
		
	public int getFloor(){
		return floor;
	}
	
	public double getRuntime() {
		return runtime;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	@Override
	public String toString(){
		return "("+String.valueOf(floor)+","+direction.toString()+","+String.valueOf(runtime)+")";
	}
	
}

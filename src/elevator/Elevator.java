package elevator;

class Elevator {
	
	private Floor floor = new Floor(1);
	private double runtime = 0;
	
	public void move(Request r){
		Floor rfloor = r.getFloor();
		int time = r.getTime();
		
		if(time>runtime){
			runtime = time;
		}
		runtime += Floor.floorDiff(floor, rfloor)*0.5+1;
		
		Direction direction = floor.moveDirection(rfloor);
		
		floor=rfloor;
		
		System.out.println("("+floor.toString()+","+direction.toString()+","+String.valueOf(runtime-1)+")");
		return;
	}
}

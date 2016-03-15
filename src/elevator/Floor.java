package elevator;

class Floor {
	private int floor;
	
	public Floor(int f){
		floor = f;
		return;
	}
	
	public static int floorDiff(Floor F1,Floor F2){
		return Math.abs(F1.floor-F2.floor);
	}
	
	public boolean isCorrectFR(Direction direction){
		if((floor==1 && direction==Direction.DOWN)||(floor==10&&direction==Direction.UP)){
			return false;
		}
		else {
			return true;
		}
	}
	
	public Direction moveDirection(Floor F){
		if(F.floor>floor){
			return Direction.UP;
		}
		else if(F.floor<floor){
			return Direction.DOWN;
		}
		else{
			return Direction.STEADY;
		}
	}
	
	public String toString(){
		return String.valueOf(floor);
	}
}

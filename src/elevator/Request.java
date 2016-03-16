package elevator;

enum Type{FR,ER};
enum Direction{UP,DOWN,STEADY,UNKNOWN};

class Request {
		
	private final Type type;
	private final int floor;
	private final Direction direction;
	private final int time;
	
	public Request(String r) throws IncorrectInputFormatException{
		
		 r = r.replaceAll("\\s","");
		 String pattern = "(\\(FR,([1-9]|10),(UP|DOWN),[0-9]{1,8}\\))"
				 +"|(\\(ER,([1-9]|10),[0-9]{1,8}\\))";
		 if(!r.matches(pattern)){
			 //wrong!!
			 throw new IncorrectInputFormatException("wrong input format");
		 }
		 
		 String[] info = r.split("[(,)]");

		 floor = Integer.valueOf(info[2]);
		 /*if (floor<=0 || floor>10){
			 //wrong!!
			 System.out.println("floor out of range");
			 throw new IncorrectInputFormatException();
		 }*/
		 
		 type = Type.valueOf(info[1]);
		 if(type == Type.FR){
			 direction = Direction.valueOf(info[3]);
			 time = Integer.valueOf(info[4]);
		 }
		 else{
			 direction = Direction.UNKNOWN;
			 time = Integer.valueOf(info[3]);
		 }
		 
		 if( type == Type.FR && 
				 (floor==1 && direction==Direction.DOWN)||(floor==10&&direction==Direction.UP)){
			 //wrong!!
			 throw new IncorrectInputFormatException("direction invalid");
		 }
	}
	
	public int getTime(){
		return time;
	}
	
	public int getFloor() {
		return floor;	
	}
	
	public Type getType() {
		return type;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	@Override
	public String toString(){
		if(type==Type.FR){
			return "(FR,"+String.valueOf(floor)+","+direction+","+String.valueOf(time)+")";
		}
		else{
			return "(ER,"+String.valueOf(floor)+","+String.valueOf(time)+")";
		}
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Request){
			Request r = (Request)o;
			return (r.type==type && r.floor==floor && 
					r.direction==direction && r.time==time);
		}
		return false;
	}
}

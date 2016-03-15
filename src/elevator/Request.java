package elevator;

enum Type{FR,ER};
enum Direction{UP,DOWN,STEADY,UNKNOWN};

class Request {
		
	private Type type;
	private Floor floor;
	private Direction direction;
	private int time;
	
	public Request(String r) throws IncorrectInputFormatException{
		
		 r = r.replaceAll("\\s","");
		 String pattern = "(\\(FR,([1-9]|10),(UP|DOWN),[0-9]{1,8}\\))"
				 +"|(\\(ER,([1-9]|10),[0-9]{1,8}\\))";
		 if(!r.matches(pattern)){
			 //wrong!!
			 //System.out.println("wrong input format");
			 throw new IncorrectInputFormatException("wrong input format");
		 }
		 
		 String[] info = r.split("[(,)]");

		 floor = new Floor(Integer.valueOf(info[2]));
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
		 
		 if( type == Type.FR && !floor.isCorrectFR(direction)){
			 //wrong!!
			 //System.out.println("direction invalid");
			 throw new IncorrectInputFormatException("direction invalid");
		 }
	}
	
	public int getTime(){
		return time;
	}
	
	public Floor getFloor() {
		return floor;	
	}
}

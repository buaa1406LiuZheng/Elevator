package elevator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		RequestQueue rq = new RequestQueue();
		
		System.out.println("Please enter your request, Enter 'done' to finish:");
		Scanner in = new Scanner(System.in);	
		int count=0,valid=0;
		
		while(true){	
			try{
				String s = in.nextLine();
				if(s.equals("done")||count==100){
					break;
				}				
				count++;			
				rq.addRequest(new Request(s));
				valid++;
			}
			catch (IncorrectInputFormatException e){
				System.out.println(e.getMessage());
				System.out.println("NO."+String.valueOf(count)+" request will be ignored.");
				continue;
			}
			catch (IncorrectTimeException e) {
				System.out.println(e.getMessage());
				valid=0;
				break;
			}catch (Throwable t) {
				System.out.println("Other Exception");
				valid=0;
				break;
			}
			
		}
		in.close();
		
		int validDispatch = 0;
		if(valid==0){
			System.out.println("no valid request or wrong request time");
		}
		else{
			try{
				Elevator elevt = new Elevator();
				Dispatcher dispatcher = new Dispatcher(elevt, rq);
				validDispatch = dispatcher.Dispatch();
			}catch(Throwable t){
				System.out.println("Other Exception");
			}
		}
		System.out.println(String.valueOf(validDispatch)+" valid dispatch(es)");
		
		return;
	}

}

package elevator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		RequestQueue rq = new RequestQueue();
		
		System.out.println("Please enter your request, Enter 'done' to finish:");
		Scanner in = new Scanner(System.in);	
		int count=0,valid=0;
		
		while(true){	
			
			String s = in.nextLine();
			if(s.equals("done")||count==100){
				break;
			}		
			
			count++;	
			try{
				rq.initialRequest(new Request(s));
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
		
		if(valid==0){
			System.out.println("no valid request or wrong request time");
		}
		else{
			Elevator elevt = new Elevator();
			ALSDispatcher dispatcher = new ALSDispatcher(elevt, rq);
			dispatcher.Dispatch();
			/*try{
				dispatcher.Dispatch();
			}catch(Throwable t){
				System.out.println("Other Exception");
			}*/
		}
		System.out.println("Dispatch end");
		
		return;
	}

}

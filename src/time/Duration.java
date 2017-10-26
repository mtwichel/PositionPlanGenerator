package time;

import exeptions.TimeOutOfBoundsException;
import exeptions.TimesOutOfOrderException;

public class Duration {
	
	protected Time lower;
	protected Time higher;
	
	public Duration(Time lower, Time higher) throws TimeOutOfBoundsException {
		
		if(higher.getHours()<lower.getHours()){
			//throw execption
			try {
				throw new TimesOutOfOrderException();
			} catch (TimesOutOfOrderException e) {
				System.out.println("High Time: " + higher + " comes before Low Time: " + lower);
				throw new TimeOutOfBoundsException();
				
			}
		}
		if((higher.getHours() == lower.getHours()) && higher.getMinutes() < lower.getMinutes()){
			try {
				throw new TimesOutOfOrderException();
			} catch (TimesOutOfOrderException e) {
				System.out.println("High Time: " + higher + " comes before Low Time: " + lower);
				throw new TimeOutOfBoundsException();
				
			}
		}else{
//			acceptable times
			this.lower = lower;
			this.higher = higher;
		}
		
		
	}
	
	public Time getLower(){
		return lower;
	}
	
	public Time getHigher(){
		return higher;
	}
	
	public Time getElapsed() throws TimeOutOfBoundsException{
		int hoursA;
		int minutesA;
		int totalMinutes = 0;
		
		totalMinutes += 60-lower.getMinutes();
		totalMinutes += (higher.getHours() - (lower.getHours() +1)) * 60;
		totalMinutes += higher.getMinutes();
		
		hoursA = totalMinutes/60;
		minutesA = totalMinutes%60;
		
//		System.out.println(totalMinutes);
		
		return new Time(hoursA, minutesA);
	}
	public boolean isInDuration(Time time){
		if(time.getHours()<=higher.getHours() && time.getHours()>=lower.getHours()){
			if(time.getMinutes()<=higher.getMinutes() && time.getMinutes()>=lower.getMinutes()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int getElapsedInMinutes() throws TimeOutOfBoundsException{
		return this.getElapsed().getTimeInMinutes();
	}
	
	public static void main(String[] args) throws TimeOutOfBoundsException, TimesOutOfOrderException{
		Duration d = new Duration(new Time(5, 33), new Time(8, 51));
		System.out.println(d.getElapsed());
		
		System.out.println(d.isInDuration(new Time(4, 41)));
	}
	
	public String toString(){
		return this.getLower() + " - " + this.getHigher();
	}

}

package time;

import exeptions.TimeOutOfBoundsException;

public class Time {
	
	private int hours;
	private int minutes;
	
	public Time(int hours, int minutes) throws TimeOutOfBoundsException{
		if(!((hours<0 || hours>24) || (minutes<0 || minutes >59))){
//			acceptable range
			this.hours = hours;
			this.minutes = minutes;
		}else{
			try {
				throw new TimeOutOfBoundsException();
			} catch (TimeOutOfBoundsException e) {
				System.out.println("Time " + hours + ":" + minutes + " is out of bounds");
				throw new TimeOutOfBoundsException();
			}
		}
		
	}
	
	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}
	
	public int getTimeInMinutes(){
		return (this.hours * 60) + this.minutes;
	}
	
	public String toString(){
		return this.hours + ":" + this.minutes;
	}
	
	public static Time convertMinutesToTime(int minutes) throws TimeOutOfBoundsException{
		
		return new Time(minutes/60, minutes%60);
	}
	
	public static void main(String[] args) throws TimeOutOfBoundsException{
		Time t = new Time(4, 15);
		System.out.println(t);
		int tm = t.getTimeInMinutes();
		System.out.println(tm);
		Time tt = Time.convertMinutesToTime(tm);
		System.out.println(tt);
	}

}

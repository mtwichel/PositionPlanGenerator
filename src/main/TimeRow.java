package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exeptions.TimeOutOfBoundsException;
import time.Duration;

import time.Time;

public class TimeRow {
	
	private Time startTime;
	private Time endTime;
	private Duration duration;
	
	private Employee[] positions;
	
	public TimeRow(Employee[] employees) {
//		super();
//		this.startTime = null;
//		this.endTime = null;
//		try {
//			this.duration = new Duration(startTime, endTime);
//		} catch (TimeOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		this.positions = employees;
	}
	
	public static List<TimeRow> generatePermutations(List<Employee> employees, List<TimeRow> permutations, int k){
	      for(int i = k; i < employees.size(); i++){
	            java.util.Collections.swap(employees, i, k);
	            generatePermutations(employees, permutations, k+1);
	            java.util.Collections.swap(employees, k, i);
	        }
	        if (k == employees.size() -1){
	        		permutations.add(new TimeRow((Employee[]) employees.toArray()));
	        }
		
		return permutations;
	}
	
	@Override
	public String toString() {
		String ans = "";
		
		for(Employee e : positions) {
			ans += e.getName() + ", ";
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		List<TimeRow> ans = 
				TimeRow.generatePermutations(Arrays.asList(
				new Employee("Jake"), 
				new Employee("Ellen"), 
				new Employee("Marcus"),
				new Employee("Tess"),
				new Employee("Madi"),
				new Employee("Ellie"),
				new Employee("Cory")),
				new ArrayList<>(), 
				0);
		
		for(int i =0; i<ans.size(); i++) {
			System.out.println(i + ": " + ans.get(i));
		}
	}
	

	
}

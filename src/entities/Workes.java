package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Workes {
	
	private String name;
	private WorkerLevel workerLevel;
	private Double daseSalary ;

	private Department department; 
	private List<HourContract> contracts =  new ArrayList<>(); 
	// um empregado tem 1 departamento 
	// um empregado tem varios contratos porisso usar a list 
	
	public Workes(){}
	
	public Workes(String name, WorkerLevel workerLevel, Double daseSalary, Department department) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.daseSalary = daseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getDaseSalary() {
		return daseSalary;
	}

	public void setDaseSalary(Double daseSalary) {
		this.daseSalary = daseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	public void addContract( HourContract contract){
		contracts.add(contract);
	
	}
	public void removeContract( HourContract contract){
		contracts.remove(contract);
	
	}
	
	public double income(int year,int month){
		
		double sum = daseSalary;
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c : contracts){
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month){
				
				sum += c.totalValue();
			}
			
			
		}
		return sum;
		
	}
	
}

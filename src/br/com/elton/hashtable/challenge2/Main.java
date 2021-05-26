package br.com.elton.hashtable.challenge2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.elton.models.Employee;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));
        
        
        List<Employee> toRemove = new ArrayList<>();
        Map<Integer, Employee> hashMap = new HashMap<>();
        
        for(Employee e: employees) {
        	
        	if(hashMap.containsKey(e.getId())) {
        		toRemove.add(e);
        	} else {
        		hashMap.put(e.getId(), e);
        	}
        }
        
        for (Iterator<Employee> iterator = hashMap.values().iterator(); iterator.hasNext();) {
        	Employee next = iterator.next();
			System.out.println(next.getLastName());
		}

        for(Employee e : toRemove) {
        	employees.remove(e);
        }	
        
        System.out.println(employees);

//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}

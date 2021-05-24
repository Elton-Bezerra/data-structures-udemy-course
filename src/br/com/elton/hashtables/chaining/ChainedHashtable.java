package br.com.elton.hashtables.chaining;

import java.util.LinkedList;
import java.util.ListIterator;

import br.com.elton.models.Employee;

public class ChainedHashtable {

	private LinkedList<StoredEmployee>[] hashtable;
	
	
	
	
	@SuppressWarnings("unchecked")
	public ChainedHashtable() {
		this.hashtable = new LinkedList[10];
		for(int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
	}

	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredEmployee(key, employee));
	}

	public Employee get(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		
		StoredEmployee employee = null;
		
		while(iterator.hasNext()) {
			employee = iterator.next();
			
			if(employee.key.equals(key)) {
				return employee.employee;
			}
		}
		
		return null;
	}

	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		
		StoredEmployee employee = null;
		int index = 0;
		while(iterator.hasNext()) {
			employee = iterator.next();
			if(employee.key.equals(key)) {
				break;
			}
			index++;
		}
		
		if(employee == null) {
			return null;
		} else {
			hashtable[hashedKey].remove(index);
			return employee.employee;
		}
		
	}
	
	private int hashKey(String key) {
//		return key.length() % hashtable.length;
		return Math.abs(key.hashCode() % hashtable.length);
	}
	
	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if(hashtable[i].isEmpty()) {
				System.out.println(String.format("Position %s: Empty", i));
			} else {
				System.out.println(String.format("Position %s: ", i));
				ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
				
				while(iterator.hasNext()) {
					System.out.print(iterator.next().employee);
					System.out.print("->");
				}
				
				System.out.println(" null ");
				
			}
		}
	}
}

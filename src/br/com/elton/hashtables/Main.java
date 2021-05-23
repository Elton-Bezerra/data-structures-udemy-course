package br.com.elton.hashtables;

import br.com.elton.models.Employee;

public class Main {

	public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        
        SimpleHashtable ht = new SimpleHashtable();
        
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        
        System.out.println("Retrieve value for key 'Jones': " + ht.get("Jones"));

        System.out.println("Retrieve value for key 'Smith': " + ht.get("Smith"));
        
        ht.remove("Wilson");
        ht.remove("Jones");
        
        ht.printHashtable();
        
        System.out.println("Retrieve value for key 'Smith': " + ht.get("Smith"));

	}
}

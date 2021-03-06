package br.com.elton.hashtables.chaining;

import br.com.elton.models.Employee;

public class Main {

	public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        
        ChainedHashtable ht = new ChainedHashtable();
        
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        
        ht.printHashtable();

        System.out.println("Retrieve value for key 'Jones': " + ht.get("Jones"));

        ht.remove("Wilson");
        ht.remove("Jones");
        
        System.out.println("Retrieve value for key 'Jones': " + ht.get("Jones"));
        
        ht.printHashtable();

	}
}

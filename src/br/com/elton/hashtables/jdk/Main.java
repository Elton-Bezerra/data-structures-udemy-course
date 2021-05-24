package br.com.elton.hashtables.jdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.com.elton.models.Employee;

public class Main {
	
	public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        
        Map<String, Employee> hashMap = new HashMap<>();
        
        
        
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        
        /*
         * Ao adicionar uma entrada (k,v) que já existia antes, retorna o valor anterior
         */
        Employee doe = hashMap.put("Doe", mikeWilson);
        
        
        // se ao tentar adicionar uma chave já existente, retorna o valor que já existe e não adiciona o valor passado
        Employee doe2 = hashMap.putIfAbsent("Doe", mikeWilson);

        
//        System.out.println(hashMap.containsKey("Doe"));
//        System.out.println(hashMap.containsValue(marySmith));
        System.out.println(doe);
//        hashMap.put("Wilson", mikeWilson);
        
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        
//        while(iterator.hasNext()) {
//        	System.out.println(iterator.next());
//        }
        
        
        hashMap.forEach((k, v) -> {
        	System.out.println("Key = " + k + ", employee = " + v);
        });
        
        
        
        
	}
	
	

}

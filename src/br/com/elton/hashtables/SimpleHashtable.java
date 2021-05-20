package br.com.elton.hashtables;

import br.com.elton.models.Employee;

public class SimpleHashtable {

	private StoredEmployee[] hashtable;
	
	public SimpleHashtable() {
		hashtable = new StoredEmployee[10];
	}
	
	public void put (String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		if(occupied(hashedKey)) {
			int stopIndex = hashedKey;
			
			
			if(hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}
			
			while(occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
			
		}
		
		if(occupied(hashedKey)) {
			System.out.println("Position already taken by other employee [" + hashedKey + "].");
			return;
		} 
		
		hashtable[hashedKey] = new StoredEmployee(key, employee);
	}
	
	public Employee get(String key) {
		int hashedKey = findKey(key);
		
		if(hashedKey == -1) {
			return null;
		}
		
		return hashtable[hashedKey].employee;
	}
	
	public Employee remove(String key) {
		int hashedKey = findKey(key);
		
		if(hashedKey == -1) {
			return null;
		}
		
		Employee employee = hashtable[hashedKey].employee;
		hashtable[hashedKey] = null;
		
		return employee;
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public void printHashtable() {
		for(int i = 0; i < hashtable.length; i++) {
			if(hashtable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println("Position " + i + ": " + hashtable[i].employee);
			}
		}
	}
	
	private boolean occupied(int index) {
		return hashtable[index] != null;
	}
	
	private int findKey(String key) {
		int hashedKey = hashKey(key);
		
		//se a chave original est� gravada no primeiro endere�o encontrado para o hash dela, � s� retornar esse hash
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} 
		
		// Caso contr�rio, fazer linear probing at� achar o hash(index) com a chave original igual a chave do par�metro
		int stopIndex = hashedKey;
		
		
		if(hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}
		
		while(hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
			
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
		
	}
}

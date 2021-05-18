package br.com.elton.lists.challenge1;

import br.com.elton.models.Employee;

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    public String toString() {
        return employee.toString();
    }


}

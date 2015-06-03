/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmw.assigment;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author GeorgeLocal
 */
public class Manager extends AbstractEmployee{

    public Manager(String name, long salary) {
        super(name, salary);
        _subordinates = new ArrayList<AbstractEmployee>();        
    }

    @Override
    public long getSalaries() {
        long totalSalary = _salary;
        for(AbstractEmployee sub: _subordinates){
            totalSalary += sub.getSalaries();
        }
        return totalSalary;
    }

    @Override
    public String getNames() {        
        //We sort alphabetically before printing the employees
        Collections.sort(_subordinates);
        StringBuilder str = new StringBuilder(getName());
        str.append("\nEmployees of: " + getName());
        for(AbstractEmployee emp : _subordinates){
            str.append("\n" + emp.getNames());
        }        
        
        return str.toString();
    }

    @Override
    public void addEmployee(AbstractEmployee employee) throws UnsupportedOperationException {
        _subordinates.add(employee);
    }
    
}

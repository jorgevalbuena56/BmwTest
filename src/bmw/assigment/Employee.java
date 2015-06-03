/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmw.assigment;

/**
 *
 * @author George
 */
public class Employee extends AbstractEmployee{

    public Employee(String name, long salary) {
        super(name, salary);
    }

    @Override
    public long getSalaries() {
        return _salary;
    }

    @Override
    public String getNames() {
        return _name;
    }

    @Override
    public void addEmployee(AbstractEmployee employee) {

        // no need to do anything here since is assumed that an regular employee does not a subordinate
        
    }
    
}

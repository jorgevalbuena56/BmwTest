/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmw.assigment;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GeorgeLocal
 */
public class BMWAssigment {

    /**
     * For this reading I used GSON, a library made by google to parse JSON objects
     * In order for this to run propertly, a file employees.json must be in the path /resources/employees.json
     * 
     * @return JsonObject
     */
    public JsonObject readJsonFile(){
        
        JsonObject employeeRoot = null;
        
        try {
            InputStream str = BMWAssigment.class.getResourceAsStream("/resources/employees.json");
            JsonReader reader = new JsonReader(new InputStreamReader(str));
            JsonParser jsonParser = new JsonParser();
            employeeRoot = jsonParser.parse(reader).getAsJsonObject();
                                    
            reader.close();
            str.close();

            
        } catch (IOException ex) {
            Logger.getLogger(BMWAssigment.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return employeeRoot;
    }
    /**
     * Recursive method to populate the data extracted from the Json file
     * 
     * @param employee
     * @return 
     */
    public static AbstractEmployee populateSubordinate(JsonObject employee){
        
        AbstractEmployee emp = null;
        
        if(employee.has("_subordinates")){
            emp = new Manager(employee.get("_name").getAsString(), employee.get("_salary").getAsLong());
            JsonArray array = employee.getAsJsonArray("_subordinates");
            for(int i= 0; i< array.size(); i++){
                emp.addEmployee(populateSubordinate(array.get(i).getAsJsonObject()));   
            }            
        }else{
            emp = new Employee(employee.get("_name").getAsString(), employee.get("_salary").getAsLong());
        }
        
        return emp;
    }
    
}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Employee{
    private int id;
    private String name;
    private int age; 
    private double salary;
    private static int count;

    public Employee(){
        this.name = null;
        this.age = 0;
        this.salary = 0.0;
    }
    public Employee(String name, int age, double salary){
        this.id = ++count;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void setId(){
        this.id = id;
    }
    public void setName(){
        this.name = name;
    }
    public void setAge(){
        this.age = age;
    }
    public void setsalary(){
        this.salary = salary;
    }

    public int getId(){
        return id;
    }
     public String getName(){
        return name;
    }
     public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }
    public void removeEmployee(){
    }
}
class EmployeeManagment{
    private ArrayList<Employee> emp;

    public EmployeeManagment(){
        emp = new ArrayList<Employee>();
    }
    public void addEmployee(String name, int age, double salary){
        Employee e = new Employee(name, age, salary);
        emp.add(e);
    }
    public void removeEmployee(int id){
        for(Employee e : emp){
            if(e.getId() == id){
                emp.remove(e);
            }
        }
    }
    public void display(){
        for(Employee e : emp){
            System.out.println(e.getName()+" "+e.getAge()+" "+e.getSalary());
        }
    }
}
class Test{
    public static void main(String args[]){
        File file = new File("employee.txt");
        
        if(file.exists()){
            try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(new Employee("Pawn", 21, 12000));

            System.out.println("object has been seilazed");
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            FileInputStream fin = new FileInputStream("employee.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            while(true){
                try{
                    Employee emp = (Employee)in.readObject();
                    System.out.println(emp);
                }
                catch(Exception e){
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }}
        else {
            System.out.println("file not found");
            try{
            file.createNewFile();
        } 
        catch(Exception e){
            System.out.println(e);
        }
    }
    }
}



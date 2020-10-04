package Controller;

import Model.ModelEmployee;

import java.util.ArrayList;

public class ControllerManager {



    private ModelEmployee newEmployee = new ModelEmployee(0,"",0,"",0);
    private ArrayList<ModelEmployee> allEmployee = new ArrayList<>();

 //   public ControllerManager(ModelEmployee newEmployee, ArrayList<ModelEmployee> allEmployee) {
 //       this.newEmployee = newEmployee;
 //       this.allEmployee = allEmployee;
 //   }


    public ModelEmployee getNewEmployee() { return newEmployee; }
    public void setNewEmployee(ModelEmployee newEmployee) { this.newEmployee = newEmployee; }
    public ArrayList<ModelEmployee> getAllEmployee() { return allEmployee; }
    //public void setAllEmployee(ArrayList<ModelEmployee> allEmployee) { this.allEmployee =
           // allEmployee; }



    public void viewEmployeeList() {
        for (int i = 0; i < getAllEmployee().size(); i++) {
            System.out.println(getAllEmployee().get(i).toString());
        }
    }
    // Method register employee
    public void registerEmployee() {

        newEmployee.setUserId(idGenerator());
        System.out.println("Creating an Employee. Please type the Employee's: ");
        System.out.println("ID: " + newEmployee.getUserId());
        newEmployee.setName(Scan.readLine("Name:"));
        newEmployee.setBirthYear(Scan.readInt("Birth year: "));
        newEmployee.setAddress(Scan.readLine("Address:"));
        newEmployee.setGrossSalary(Scan.readDouble("Monthly gross salary:"));
        allEmployee.add(newEmployee);
        System.out.println("You have successfully added a new employee: \n" + newEmployee);

    }
    //Method for generating unique ID
    public int idGenerator() {// Hitta en ny Metod:
        int idleId = 1000;

        for (int i = 0; i < allEmployee.size(); i++) { //search through entire arraylist of userDatabase
            if (allEmployee.get(i).getUserId() == idleId) { //when idleId matches with already existing
                // user in userDatabase
                idleId++;
                i = 0; //start at i=0 with new id number
            } else {
                i++; //next index in arraylist
            }
        }
        return idleId;
    }

    //Method remove employee
    public void removeEmployee () {

        int idRemoval = Scan.readInt("Removing employee account \nEnter employee ID: ");

        boolean isTargetIdFound = false;

        for (int i = 0; i < allEmployee.size() && !isTargetIdFound; i++) { //search though arraylist for...
            if (allEmployee.get(i).getUserId() == idRemoval) { //...account with same userID as the one
                // given by user
                allEmployee.remove(i); // remove when found
                System.out.println("User with ID " + idRemoval + " successfully removed.");
                //... then its removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound){
            System.out.println("Employee with ID " + idRemoval + " not found");
        }
    }


    public void employeeNetSalary() {


        String name = Scan.readLine("Please type your employees name:");

        double hPerYear = Scan.readDouble("Please type hours worked in a year:"); // declare and store value from numbers, maybe decimal

        double hPayRate = Scan.readDouble("Please enter hourly pay rate SEK:");

        double grossPay = hPayRate * hPerYear;
        double netSalaryOver100 = (grossPay * (0.7));

        if (grossPay <= 100000) {
            System.out.println("Gross Pay is less than 100.000 SEK per year, therefore the Net Salary is: " + grossPay + " SEK");
        } else {
            System.out.println("Gross Pay is more than 100.000 SEK per year and the Net Salary is: " + (netSalaryOver100) + " SEK");
        }

    }

    public void employeeBonus() {

        double age = Scan.readInt("What is the employee's age?  "); // it will come directly from getAge method.
        int bonusPac1 = 4000;
        int bonusPac2 = 6000;
        int bonusPac3 = 7500;

        if (age < 22) {
            System.out.println("The employee's bonus salary is " + bonusPac1 + " SEK.");
        } else if (age >= 22 && age <= 30) {
            System.out.println("The employee's bonus salary is " + bonusPac2 + " SEK.");
        } else {
            System.out.println("The employee's bonus salary is " + bonusPac3 + " SEK.");
        }
    }


}

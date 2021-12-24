import java.util.Scanner;
import java.util.ArrayList;

public class employeeList {
    employeeList() {

    }

    private ArrayList<employee> eList = new ArrayList<employee>();
    private Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("Choose an option:");
        System.out.println("1) Add an employee");
        System.out.println("2) Remove an employee");
        System.out.println("3) Edit an employee");
        System.out.println("4) Print all employees");
        System.out.println("5) Finished");
        // get user input for menu option
        String userInput = scan.next();
        int actualInput = -1;
        // try-catch block ensures that int was entered
        try {
            // see if its integer type
            actualInput = Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            System.out.println("Input must be integer type");
            // change to an example input to get to final if statement
            actualInput = 6;
        }
        boolean keepGoing = true;
        if (actualInput == 1) {
            // call option 1 method
            System.out.println("You choose to add an employee");
            eList.add(this.addEmployee());
        } else if (actualInput == 2) {
            // call option 2 method
            System.out.println("You choose to remove an employee");
            this.removeEmployee();
        } else if (actualInput == 3) {
            // call option 3 method
            System.out.println("You choose to edit an employee");
            this.editEmployee();
        } else if (actualInput == 4) {
            // call option 4 method
            System.out.println("You choose to print all employees");
            this.printAllEmployees();
        } else if (actualInput == 5) {
            // end menu calls
            System.out.println("Goodbye");
            scan.close();
            keepGoing = false;
        } else {
            System.out.println("Enter an integer in 1-5 range");
        }
        if (keepGoing) {
            // User can pick another option
            this.menu();
        }
    }

    private employee addEmployee() {
        // Scanner scan = new Scanner(System.in);
        // Setting name
        String nextLineGet = scan.nextLine();
        // will hold all employee info
        employee nEmployee = new employee();
        System.out.println("Enter employee name");
        String eFullName = scan.nextLine();
        // check that name has only letters and spaces
        if (onlyAlphabet(eFullName)) {
            nEmployee.setName(eFullName);
        } else {
            // Invalid name
            while (!onlyAlphabet(eFullName)) {
                System.out.println("Name must contain only letters try again");
                eFullName = scan.nextLine();
            }
            nEmployee.setName(eFullName);
        }
        // End of setting name

        // Setting id,age, gender, position,salary
        System.out.println("Enter employee age");
        String eAge = scan.next();
        int actualAgeInput = -1;
        // check if input is int type
        if (eAge.matches("\\d+")) {
            actualAgeInput = Integer.parseInt(eAge);
        } else {
            while (!eAge.matches("\\d+")) {
                System.out.println("Input must be integer type");
                eAge = scan.next();
            }
            actualAgeInput = Integer.parseInt(eAge);
        }
        nEmployee.setAge(actualAgeInput);

        System.out.println("Enter employee id");
        // check if input is int type
        String eID = scan.next();
        int actualID = -1;
        if (eID.matches("\\d+")) {
            actualID = Integer.parseInt(eID);
        } else {
            while (!eID.matches("\\d+")) {
                System.out.println("Input must be integer type");
                eID = scan.next();
            }
            actualID = Integer.parseInt(eID);
        }
        nEmployee.setID(actualID);

        System.out.println("Enter employee gender");
        String eGender = scan.next();
        if (onlyAlphabet(eGender)) {
            nEmployee.setGender(eGender);
        } else {
            while (!onlyAlphabet(eGender)) {
                System.out.println("Gender must contain only letters");
                eGender = scan.next();
            }
            nEmployee.setGender(eGender);
        }

        System.out.println("Enter employee salary");
        String eSalary = scan.next();
        int actualSalary = -1;
        if (eSalary.matches("\\d+")) {
            actualSalary = Integer.parseInt(eSalary);
        } else {
            while (!eSalary.matches("\\d+")) {
                System.out.println("Input must be only integers");
                eSalary = scan.next();
            }
            actualSalary = Integer.parseInt(eSalary);
        }
        nEmployee.setSalary(actualSalary);

        System.out.println("Enter employee position in company");
        String ePosition = scan.nextLine();
        ePosition = scan.nextLine();
        if (onlyAlphabet(ePosition)) {
            nEmployee.setPosition(ePosition);
        } else {
            while (!onlyAlphabet(ePosition)) {
                System.out.println("Position must only contain letters and spaces try again");
                ePosition = scan.nextLine();
            }
            nEmployee.setPosition(ePosition);
        }

        return nEmployee;
    }

    private boolean removeEmployee() {
        this.printAllEmployees();
        System.out.println("\nChoose an employee to remove based on their number");
        String removeIndex = scan.next();
        int actualIndex = -1;
        if (removeIndex.matches("\\d+")) {
            actualIndex = Integer.parseInt(removeIndex);
        } else {
            while (!removeIndex.matches("\\d+")) {
                System.out.println("Input must be integer type and within range");
                removeIndex = scan.next();
            }
            actualIndex = Integer.parseInt(removeIndex);
        }
        if (actualIndex < eList.size() && actualIndex >= 0) {
            eList.remove(actualIndex);
        } else {
            while (true){
                System.out.println("Input must be in range try again");
                removeIndex=scan.next();
                while (!removeIndex.matches("\\d+")){
                    System.out.println("Input must be integer type and in range");
                    removeIndex=scan.next();
                }
                actualIndex=Integer.parseInt(removeIndex);
                if (actualIndex < eList.size() && actualIndex >=0){
                    eList.remove(actualIndex);
                    break;
                }
            }
        }
        return true;
    }

    private boolean editEmployee() {
        this.printAllEmployees();
        System.out.println("\nChoose an employee to edit based on their number");
        String editIndex = scan.next();
        int actualEditIndex = -1;
        if (editIndex.matches("\\d+")) {
            actualEditIndex = Integer.parseInt(editIndex);
        } else {
            while (!editIndex.matches("\\d+")) {
                System.out.println("Input must be integer type and in range");
                editIndex = scan.next();
            }
            actualEditIndex = Integer.parseInt(editIndex);
        }
        if (actualEditIndex < eList.size() && actualEditIndex >= 0) {

        } else {
            while (true) {
                System.out.println("Input must be in range try again");
                editIndex = scan.next();
                while (!editIndex.matches("\\d+")) {
                    System.out.println("Input must be integer type and in range");
                    editIndex = scan.next();
                }
                actualEditIndex = Integer.parseInt(editIndex);
                if (actualEditIndex < eList.size() && actualEditIndex >= 0) {
                    break;
                }
            }

        }
        // eEmployee now equals the employee at the desired index
        employee eEmployee = eList.get(actualEditIndex);
        // remove old employee
        eList.remove(actualEditIndex);
        // eddEmployee returns new employee object and it is
        // set to the employee
        eEmployee = this.addEmployee();
        // replaces old employee at index with new one
        eList.add(actualEditIndex, eEmployee);
        return true;
    }

    private boolean printAllEmployees() {
        // printing all employees in eList arrayList
        System.out.println("Employee info\n");
        for (int i = 0; i < eList.size(); i++) {
            System.out.println("Employee #" + i);
            System.out.println("Name: " + eList.get(i).getName());
            System.out.println("ID: " + eList.get(i).getID());
            System.out.println("Gender: " + eList.get(i).getGender());
            System.out.println("Age: " + eList.get(i).getAge());
            System.out.println("Position: " + eList.get(i).getPostion());
            System.out.println("Salary: " + eList.get(i).getSalary());
            System.out.println();
        }
        return true;
    }

    // Error checking method that makes sure that input is only letters
    public boolean onlyAlphabet(String str) {
        return ((!str.equals("")) && (str != null) && (str.matches("^[ A-Za-z]+$")));
    }
}

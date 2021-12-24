
public class employee {
    private String name;
    private int ID;
    private int age;
    private String gender;
    private String position;
    private int salary;

    public employee(){
        this.ID=-1;
        this.name="";
        this.age=-2;
        this.gender="";
        this.position="";
        this.salary=-3;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public int getID(){
        return this.ID;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public String getPostion(){
        return this.position;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public int getSalary(){
        return this.salary;
    }
}

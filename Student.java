public class Student{

        String name;
        int rollno;
        double gpa;

Student(String name,int r,double g){
this.name=name;
this.rollno=r;
this.gpa=g;
};
public void display(){
System.out.println("NAME:"+name);
System.out.println("ROLL NO:"+rollno);
System.out.println("GPA:"+gpa);
}
}
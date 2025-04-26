import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
    abstract String getType();
}

class ExamCourse extends CourseType{
    @Override
    public String getType(){
        return "Examination";
    }
}

class AssignmentBased extends CourseType{
    @Override
    public String getType(){
        return "Assignment";
    }
}

class ResearchCourse extends CourseType{
    @Override
    public String getType(){
        return "Research";
    }
}

class Course<T extends CourseType>{
    private T CourseType;
    private String courseName;
    private String Department;

    public Course(T courseType, String courseName, String department) {
        CourseType = courseType;
        this.courseName = courseName;
        Department = department;
    }

    public T getCourseType() {
        return CourseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return Department;
    }

    public String Display(){
        return "CourseType: "+CourseType.getType()+"Course Name: "+courseName+"Department: "+Department;
    }
}
public class CourseManagementSystem {
    public static void main(String[] args) {
        ExamCourse exam=new ExamCourse();
        AssignmentBased assignment=new AssignmentBased();
        ResearchCourse research=new ResearchCourse();

        Course<ExamCourse> c1=new Course<>(exam,"Maths","Engineering");
        Course<AssignmentBased> c2=new Course<>(assignment,"JAVA","CSE");
        Course<ResearchCourse> c3=new Course<>(research,"Physics","Medical");

        List<Course<? extends CourseType>> data=new ArrayList<>();
        data.add(c1);
        data.add(c2);
        data.add(c3);

        for(Course<? extends CourseType> course: data){
            System.out.println(course.Display());
        }
    }
}

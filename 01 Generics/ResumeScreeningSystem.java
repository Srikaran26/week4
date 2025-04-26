import java.util.ArrayList;
import java.util.List;

// Abstract class for job roles
abstract class JobRole {
    abstract String reqSkills();
}

// Concrete job roles
class SoftwareEngineer extends JobRole {
    @Override
    public String reqSkills() {
        return "Data Structures, Java";
    }
}

class DataScientist extends JobRole {
    @Override
    public String reqSkills() {
        return "SRM Student, PowerBI";
    }
}

class ProductManager extends JobRole {
    @Override
    public String reqSkills() {
        return "Management, Communication";
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String display() {
        return "Candidate: " + candidateName +
                "\nApplied For: " + jobRole.getClass().getSimpleName() +
                "\nSkills Required: " + jobRole.reqSkills();
    }
}

// Resume processing class
class ResumeScreeningSystem {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("----- Screening Resume -----");
            System.out.println(resume.display());
            System.out.println();
        }
    }
}

// Main class
class ResumeSystemDemo {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Charlie", new ProductManager());

        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(r1);
        resumes.add(r2);
        resumes.add(r3);

        ResumeScreeningSystem.processResumes(resumes);
    }
}

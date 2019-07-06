package beans;

public class Student {
    private String firstname,lastname,form,stream,dateOfBirth,gender;
    private int age ,admission;

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", form='" + form + '\'' +
                ", stream='" + stream + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", admission=" + admission +
                '}';
    }

    public Student(String firstname, String lastname, String form, String stream, String dateOfBirth, String gender, int admission, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.form = form;
        this.stream = stream;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.age = age;
        this.admission=admission;
    }
    public Student(){}
    public int getAdmission(){
        return admission;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getForm() {
        return form;
    }

    public String getStream() {
        return stream;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

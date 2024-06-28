package hr.algebra.studentprojectapiinteropability.domain;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String imagePath;

    public Student(){
    }

    public Student(Long id, String name, String email, String imagePath) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
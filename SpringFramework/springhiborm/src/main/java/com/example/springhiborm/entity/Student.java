package com.example.springhiborm.entity;





import jakarta.persistence.*;

@Entity
@Table(name="StudentData")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private String name;
    private String email;
    private String course;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
	
	
	public Student(String name, String email, String course) {
		super();
		
		this.name = name;
		this.email = email;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}


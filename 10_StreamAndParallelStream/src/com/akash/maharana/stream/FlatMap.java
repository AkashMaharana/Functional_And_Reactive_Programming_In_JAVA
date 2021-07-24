package com.akash.maharana.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	public static void main(String[] args) {
		Student s1 = new Student("Akash", Arrays.asList("Coding", "System Design"));
		Student s2 = new Student("Swati", Arrays.asList("Informatica", "Business Intelligence"));
		Student s3 = new Student("Richi", Arrays.asList("Mathematics", "Social Studies"));

		List<Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		studentList.stream().map(Student::getHobbies).flatMap(List::stream).collect(Collectors.toList())
				.forEach(System.out::println);

	}

}

class Student {

	public String studentName;
	public List<String> hobbies;

	public Student(String studentName, List<String> hobbies) {
		this.studentName = studentName;
		this.hobbies = hobbies;
	}

	public List<String> getHobbies() {
		return this.hobbies;
	}
}

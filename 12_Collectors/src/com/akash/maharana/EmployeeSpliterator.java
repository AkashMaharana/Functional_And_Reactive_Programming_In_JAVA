package com.akash.maharana;

import java.sql.Date;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee> {

	private String employeeId;
	private String name;
	private String gender;
	private Date dateOfBith;
	private String location;
	private String role;
	private Date dateOfJoing;
	private Double salary;
	private Spliterator<String> wordSpliterator;

	public EmployeeSpliterator(Spliterator<String> wordSpliterator) {
		super();
		this.wordSpliterator = wordSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Employee> action) {
		if (wordSpliterator.tryAdvance(employeeId -> this.employeeId = employeeId)
				&& wordSpliterator.tryAdvance(name -> this.name = name)
				&& wordSpliterator.tryAdvance(gender -> this.gender = gender)
				&& wordSpliterator.tryAdvance(dateOfBith -> this.dateOfBith = Date.valueOf(dateOfBith))
				&& wordSpliterator.tryAdvance(location -> this.location = location)
				&& wordSpliterator.tryAdvance(role -> this.role = role)
				&& wordSpliterator.tryAdvance(dateOfJoing -> this.dateOfJoing = Date.valueOf(dateOfJoing))
				&& wordSpliterator.tryAdvance(salary -> this.salary = Double.valueOf(salary))) {
			action.accept(new Employee(this.employeeId, this.name, this.gender, this.dateOfBith, this.location,
					this.role, this.dateOfJoing, this.salary));
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Employee> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return this.wordSpliterator.estimateSize()/8;
	}

	@Override
	public int characteristics() {
		return wordSpliterator.characteristics();
	}

}

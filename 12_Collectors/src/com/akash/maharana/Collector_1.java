package com.akash.maharana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Collector_1 {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\Administrator\\OneDrive\\Desktop\\Infrastructure_Codebase\\"
				+ "Functional And Reactive Programming In Java\\12_Collectors\\src\\com\\akash\\maharana\\EmployeeData.txt");
		try (Stream<String> lines = Files.lines(path)) {
			Stream<String> eachLine = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> spliterator = eachLine.spliterator();
			Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(spliterator);
			Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
			List<Employee> employeeList = employeeStream.collect(Collectors.toList());
			List<Employee> updatedEmployeeList = new ArrayList<>();
			for (Employee emp : employeeList) {
				updatedEmployeeList.add(emp);
			}
			// Unmodifiable collection
			List<String> employeeName = updatedEmployeeList.stream().map(Employee::getName)
					.collect(Collectors.toList());
			employeeName.forEach(System.out::println);

			System.out.println("------------");

			Set<String> roles = updatedEmployeeList.stream().map(Employee::getRole).collect(Collectors.toSet());
			roles.forEach(System.out::println);

			System.out.println("------------");

			TreeSet<String> sortedName = updatedEmployeeList.stream().map(Employee::getName)
					.collect(Collectors.toCollection(TreeSet::new));
			sortedName.forEach(System.out::println);

			System.out.println("------------");

			TreeSet<Employee> sortedEmployee = updatedEmployeeList.stream()
					.collect(Collectors.toCollection(TreeSet::new));
			sortedEmployee.forEach(System.out::println);

			System.out.println("------------");

			Map<String, String> employeeMapById = updatedEmployeeList.stream()
					.collect(Collectors.toMap(Employee::getEmployeeId, Employee::getName));
			employeeMapById.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				System.out.print(entry.getValue());
				System.out.println();
			});

			Map<Boolean, List<Employee>> employeeMapByGender = updatedEmployeeList.stream()
					.collect(Collectors.partitioningBy(employee -> employee.getGender().equals("M")));
			employeeMapByGender.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				System.out.print(entry.getValue().stream().map(Employee::getName).collect(Collectors.joining(",")));
				System.out.println();
			});

			System.out.println("------------");
			
			Map<String, List<Employee>> groupingByRole = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole));
			groupingByRole.entrySet().forEach(entry->{
				System.out.print(entry.getKey()+" : ");
				System.out.print(entry.getValue().stream().map(Employee::getName).collect(Collectors.joining(",")));
				System.out.println();
			});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.akash.maharana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CascadingCollectors {

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
			Map<String, List<Employee>> groupingByRole = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole));
			groupingByRole.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				System.out.print(entry.getValue().stream().map(Employee::getName).collect(Collectors.joining(",")));
				System.out.println();
			});

			System.out.println("--------------");

			Map<String, Long> groupingByNumberOfEmployeesInARole = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole, Collectors.counting()));
			groupingByNumberOfEmployeesInARole.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				System.out.print(entry.getValue());
				System.out.println();
			});

			System.out.println("--------------");

			Map<String, Double> totalSalaryTakenByEachRole = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole, Collectors.summingDouble(Employee::getSalary)));
			totalSalaryTakenByEachRole.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				System.out.print(entry.getValue());
				System.out.println();
			});

			System.out.println("--------------");

			Map<String, Optional<Employee>> maximumSalaryTakenByEachRole = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole,
							Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
			maximumSalaryTakenByEachRole.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				if (entry.getValue().isPresent()) {
					System.out.println(entry.getValue().get().getName());
				}
			});

			System.out.println("--------------");
			
			Map<String, Optional<Double>> maximumSalaryTakenByEachRole1 = updatedEmployeeList.stream()
					.collect(Collectors.groupingBy(Employee::getRole, Collectors.mapping(Employee::getSalary,
							Collectors.maxBy(Comparator.comparing(Function.identity())))));
			maximumSalaryTakenByEachRole1.entrySet().forEach(entry -> {
				System.out.print(entry.getKey() + " : ");
				if (entry.getValue().isPresent()) {
					System.out.println(entry.getValue().get());
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

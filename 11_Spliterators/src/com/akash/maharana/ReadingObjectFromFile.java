package com.akash.maharana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectFromFile {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\Administrator\\OneDrive\\Desktop\\Infrastructure_Codebase\\"
				+ "Functional And Reactive Programming In Java\\11_Spliterators\\src\\com\\akash\\maharana\\Books.txt");

		try (Stream<String> lines = Files.lines(path)) {
			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);
			Stream<Book> bookStream = StreamSupport.stream(bookSpliterator, false);
			bookStream.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

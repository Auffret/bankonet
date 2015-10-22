package com.bankonet.reader;
import java.util.Scanner;

public class ConsoleReader implements InputReader{
	
	private static ConsoleReader instance = new ConsoleReader();
	
	private Scanner scanner = new Scanner(System.in);
	
	public static ConsoleReader getInstance(){
		return instance;
	}

	private ConsoleReader(){
		super();
	}
	
	public String readline(String message){
		System.out.println(message);
		return scanner.next();
	}
	
	public Integer readInt(String message){
		System.out.println(message);
		return scanner.nextInt();
	}
	
	public void close(){
		scanner.close();
	}
}

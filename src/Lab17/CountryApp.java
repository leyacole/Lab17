package Lab17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountryApp {
    
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		int input;
		
		
		Path path = Paths.get("countries.txt");
		if(Files.notExists(path)) {
		  try {
			Files.createFile(path);
		  }catch (IOException e) {
			  System.out.println("IO Exception!!");
		  }
		}
		System.out.println("Welcome to the Countries Maintenance Application!");
		
	do {
		System.out.println("Choose options:");
		System.out.println();
		System.out.println("1. Display Countries\n2. Enter new Country\n3. Exit");
		System.out.println();
		System.out.println("Enter Menu Number: ");
		input = scnr.nextInt();
		scnr.nextLine();  //CLEAR SCANNER
		
		if( input == 1) {
			List<Country> countries = CountriesTextFile.readFile();
			for (Country c : countries) {
				System.out.println(c.getName()+ ":" + " population " + c.getPopulation());
			}
				
		 } else if (input == 2) {
			 
		 	System.out.print("Enter a Country name to add: ");
			String name = scnr.nextLine();
			System.out.print("Enter their population: ");
			long population = scnr.nextLong();
			Country newCountry = new Country(name, population);
			CountriesTextFile.appendToFile(newCountry);
		 } else {
			System.out.println("Good Bye!");
		}
	 }while(input != 3);	
		scnr.close();
	}
}

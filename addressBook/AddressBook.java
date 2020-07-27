package addressBook;
import addressBook.utils.Compare;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

	

public class AddressBook{
	private String addressBookName;
	private List<Person> entries=new ArrayList<>();

	public AddressBook(String addressBookName){
		this.addressBookName=addressBookName;
	}

	public AddressBook() {
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public List<Person> getEntries() {
		return entries;
	}

	public void setEntries(List<Person> entries) {
		this.entries = entries;
	}

	public void addPerson(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("============## Add Person ##============");
		System.out.println("Enter the Person's First Name: ");
		String firsName= sc.next();

		System.out.println("Enter the Person's Last Name: ");
		String lastName = sc.next();

		System.out.println("Enter the Person's Address: ");
		String address = sc.next();

		System.out.println("Enter the Person's City: ");
		String city = sc.next();

		System.out.println("Enter the Person's State: ");
		String state = sc.next();

		System.out.println("Enter the Zip Code: ");
		int zip = sc.nextInt();

		System.out.println("Enter the PhoneNumber: ");
		long phoneNumber = sc.nextLong();
		

		Person person = new Person(firsName,lastName,address,city,state,zip,phoneNumber);
		this.entries.add(person);
		System.out.println("Person added Successfully : \n" + person.getInformation());


	}

	private void editPerson(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("##  Edit Person  ##");
		System.out.println("Enter Phone Number of Person to be Edited :");

		long phoneNumber = sc.nextLong();
		Person person = findPerson(phoneNumber);
		
		if(person==null){
			System.out.println("Sorry Number Doesn't Exist");
			return;
		}

		System.out.println("## Information ##");    	
		System.out.println(person.getInformation());

		boolean flag=true;
		while(flag){
			System.out.println("What do you like to edit: \n1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. Zip\n7. Phone Number\n8. Exit");
			
			
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt){
				case 1:
							System.out.println("Enter the First Name");
							person.setFirstName(sc.next());
							break;

				case 2:
							System.out.println("Enter the Last Name");
							person.setLastName(sc.next());
							break;
				case 3:
							System.out.println("Enter the Address");
							person.setAddress(sc.next());
							break;
				case 4:
							System.out.println("Enter the City");
							person.setCity(sc.next());
							break;
				case 5:
							System.out.println("Enter the State");
							person.setState(sc.next());
							break;
				case 6:
							System.out.println("Enter the Zip");
							person.setZip(sc.nextInt());
							break;
				case 7:
							System.out.println("Enter the PhoneNumber");
							person.setPhoneNumber(sc.nextLong());
							break;
				case 8:
							flag=false;
							break;
				
				default:
							System.out.println("Invalid input.");
			}
		}
		System.out.println("## New Details ##");    	
		System.out.println(person.getInformation());
	}

	private void deletePerson(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("## Delete Person ##");
		while(true){

			System.out.println("Phone Number of the Person that has to  be deleted:");
			long phoneNumber = sc.nextLong();
			Person person = findPerson(phoneNumber);

			if(person==null){
				System.out.println("Number Doesn't Exist");
				continue;
			}

			try{
				entries.remove(person);
				System.out.println("Person Deleted Successfully");
				break;

			} catch(Exception ex){
				System.out.println("Exception"+ex);
				continue;
			}
		}
	}

	private Person findPerson(long phoneNumber){
		for (Person tempPerson : entries) {
			if (tempPerson.getPhoneNumber() == phoneNumber) {
				System.out.println(tempPerson.getInformation());
				return tempPerson;
			}
		}
		return null;

	}

	private Person findPerson(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Phone Number of the person that you want to find:");
		long phoneNumber = sc.nextLong();
		return findPerson(phoneNumber);
		

	}
	
	private void sortEntries(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("## Sort ##");

		System.out.println("Sort on basis of: \n1. First Name\n2. Zip");
		
		
		int opt = sc.nextInt();
		sc.nextLine();
		switch(opt){
			case 1:
						Collections.sort(entries, Compare.firstNameComparator);
						break;
			case 2:
						Collections.sort(entries, Compare.zipComparator);
						break;
			
			default:
						System.out.println("Invalid input.");
			}

		System.out.println("Sorted");    	
		this.displayEntries();
		

	}

	private void displayEntries(){
		System.out.println("## Entries ##");
		for (Person person : entries) {
			System.out.println(person.getInformation()+"\n");
		
		}

	}


	public static void showMenu(){
		System.out.println("\n");
		System.out.println("\t==========================================");
		System.out.println("\t=============== # Menu #==================");
		System.out.println("\t=\t 1.Add  a Person\t\t =");
		System.out.println("\t==\t 2.Edit  a Person\t\t==");
		System.out.println("\t=\t 3.Delete  a Person\t\t =");
		System.out.println("\t==\t 4.Find  a Person\t\t==");
		System.out.println("\t=\t 5.Sort Address Book \t\t =");
		System.out.println("\t==\t 6.View Address Book\t\t==");
		System.out.println("\t=\t 7.Quit\t\t\t\t =");
		System.out.println("\t==========================================");
	}

	public static void main(String args[]){
		System.out.println("\t##  ===  Welcome to Address Book  ===  ##");

		
		Scanner sc = new Scanner(System.in);
		
		AddressBook addressBook = new AddressBook();
		
		boolean choice=true;
		while(choice){
			showMenu();
			int task = sc.nextInt();
			sc.nextLine();
			
			switch(task){

				case 1:			addressBook.addPerson();
								break;

				case 2:			addressBook.editPerson();
								break;

				case 3:			addressBook.deletePerson();
								break;

				case 4:			addressBook.findPerson();
								break;
				
				case 5:			addressBook.sortEntries();
								break;

				case 6:			addressBook.displayEntries();
								break;

				case 7:         System.out.println("Quiting...");
                				System.exit(0);

				default:
								System.out.println("Error: Invalid Data!!, Try again");

			}

			

		}

				
	}
}
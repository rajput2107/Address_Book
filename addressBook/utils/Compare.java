  
package addressBook.utils;

import java.util.Comparator;
import addressBook.Person;


public class Compare{

	public static Comparator<Person> firstNameComparator = new 
Comparator<Person>() {

		public int compare(Person n1, Person n2) {
			String firstName1 = 
n1.getFirstName().toUpperCase();
			String firstName2 = 
n2.getFirstName().toUpperCase();
			return firstName1.compareTo(firstName2);
		}};

	public static Comparator<Person> zipComparator = new 
Comparator<Person>() {

		public int compare(Person n1, Person n2) {

			int zip1 = n1.getZip();
			int zip2 = n2.getZip();

			return zip1 - zip2;
		}
	};


	
}


public class Student 

{
	private String lastname;
	private String firstname;
	private int totalpoints;
	private static final int MAX_POINTS=1000;
	private static final int DEFAULT_POINTS=0;
	private static final String DEFAULT_NAME="zz_error";
	private static final int SORT_BY_FIRST = 88;
	private static final int SORT_BY_LAST = 98;
	private static final int SORT_BY_POINTS = 108;
	private static int sortKey = SORT_BY_LAST;
	
	
	Student(String lstnm, String fstnm, int total) {
		if (!setLastname(lstnm))
			this.lastname = DEFAULT_NAME;
		if (!setFirstname(fstnm))
			this.firstname = DEFAULT_NAME;
		if (!setTotalpoints(total))
			this.totalpoints = DEFAULT_POINTS;
	}
	
	public String getLastname() {
		return lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public int getTotalpoints() {
		return totalpoints;
	}
	
	public boolean setLastname(String lastname) {
		if ( validString(lastname) ) {
			this.lastname=lastname;
			return true;
		}
		return false;
	}
	public boolean setFirstname(String firstname) {
		if ( validString(firstname) ) {
			this.firstname = firstname;
			return true;
		}
		return false;
	}
	public boolean setTotalpoints(int total) {
		if ( validTotal(total) ) {
			this.totalpoints=total;
			return true;
		}
		return false;
	}
	static public boolean setSortKey (int key) {
		if (key == SORT_BY_FIRST || key == SORT_BY_LAST || key == SORT_BY_POINTS) {
			sortKey = key;
			return true;
		}
		return false;
	}
	
	public int getSortKey() {
		return sortKey;
	}	
	public boolean validString(String name) {
		if ( name != null && Character.isLetter(name.charAt(0)) )
			return true;
		return false;
	}
	public boolean validTotal(int total) {
		if (total > 0 && total<= MAX_POINTS)
			return true;
		return false;
	}
	
	public String toString() {
		return "	" + this.lastname + ", " + this.firstname + " total points: " + this.totalpoints;
	}
	
	public static int compareTwoStudents(Student stud1, Student stud2) {
		int result = 0;
		
		switch (sortKey) {
			case SORT_BY_FIRST: 
				result = stud1.firstname.compareToIgnoreCase(stud2.firstname);
			break;
			case SORT_BY_LAST:
				result = stud1.lastname.compareToIgnoreCase(stud2.lastname);
			break;
			case SORT_BY_POINTS:
				result = stud1.totalpoints == stud2.totalpoints ? 0: (stud1.totalpoints > stud2.totalpoints ? 1 : -1);
			break;
			default:
			break;
		}
		
		return result;
	}		
	public static double getMedianDestructive(Student[] array) {
		
		if (array.length == 0)
		return 0.0;
		
		if (array.length == 1)
		return array[0].totalpoints;
		
		if (array.length % 2 == 0)
			return (array[array.length/2].totalpoints + array[array.length/2 - 1].totalpoints)/2;
		else {
			return array[(array.length - 1) / 2].totalpoints;
		}
	}
	public static void sortArray(Student[] array) {
		for (int i = 0; i < array.length; i++)
		{
			for (int k = 0; k < array.length - 1; k++) {
				if (compareTwoStudents(array[k], array[k+1]) > 0) 
				{
					Student temp = array[k];
					array[k] = array[k+1];
					array[k+1] = temp;
				}
				
			}
		}
	}

		public static void main(String[] args) 

		{
			
		Student[] Class = { 
				
			new Student("Ben", "Taylor", 97),
			new Student("Rickie", "Martin", 41),
			new Student("Jhonson", "Esabell", 99),
			new Student("Kasper", "Sorensen", 68),
			new Student("Michael", "LU", 58),
			new Student("Black", "Thompson", 48),
			new Student("Potter", "Harry", 35),
			new Student("Wisli", "Ron", 75),
			new Student("Robson", "Addy", 54),
			
		};
		
		Student[] Class1 = { 
				
			new Student("Ben", "Taylor", 97),
			new Student("Rickie", "Martin", 41),
			new Student("Jhonson", "Esabell", 99),
			new Student("Kasper", "Sorensen", 68),
			new Student("Michael", "LU", 58),
			new Student("Black", "Thompson", 48),
			new Student("Potter", "Harry", 35),
			new Student("Wisli", "Ron", 75),
			new Student("Robson", "Addy", 54),
			
		};
		
		Student[] Class2 = { 
			new Student("Arnold", "Swann", 88)
		};
		
		Student[] Class3 = {};
		
		System.out.println("\n" + "before: "+"\n");		
		for (int i = 0; i < Class1.length; i++) 
		System.out.println(Class1[i].toString());
		
		System.out.println("\n" + "sorting by default: "+"\n");
		sortArray(Class1);
		for (int i = 0; i < Class1.length; i++) 
		System.out.println(Class1[i].toString());
		
		
		System.out.println("\n" + "Sorting by first name: "+"\n");
		setSortKey(SORT_BY_FIRST);
		sortArray(Class1);
		for (int i = 0; i < Class1.length; i++) 
		System.out.println(Class1[i].toString());
		
		System.out.println("\n" + "Sorting by total points: "+"\n");
		setSortKey(SORT_BY_POINTS);
		sortArray(Class1);
		for (int i = 0; i < Class1.length; i++) 
		System.out.println(Class1[i].toString());
		
		System.out.println("\n"+"Median of evenClass = " + getMedianDestructive(Class1));
		System.out.println("Median of oddClass = " + getMedianDestructive(Class));
		System.out.println("Median of smallClass = " + getMedianDestructive(Class2));
		System.out.println("Median of noClass = " + getMedianDestructive(Class3));
	}

}
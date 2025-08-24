package pack;


import java.util.Scanner;

public class StringHelper {

	//private static Map<String, String> memory = new HashMap<>();
	
	private static int getValidInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid number. Please enter digits only.");
        }
    }
	
	public static void run() {
		 Scanner sc = new Scanner(System.in);
		 
		System.out.print("Please enter intial string: ");
		String result = sc.nextLine();
	
		
		while(true) {
			System.out.print("Enter string operation (add , chop, contains, extract, store, recall, remove, exit):");
			String op = sc.nextLine().toLowerCase();
			
			if(op.equals("exit")) {
				System.out.println("Final String: "+ result);
				break;
			}
			else if (op.equals("add")) {
			    System.out.print("Enter string to add: ");
			    String s2 = sc.nextLine();

			    if (s2.isEmpty()) {
			        System.out.print("You entered an empty string. Do you still want to add it? (yes/no): ");
			        String choice = sc.nextLine();
			        if (choice.equalsIgnoreCase("yes")) {
			            result = StringOperations.addStrings(result, s2);
			        } else {
			            System.out.println("Skipped adding empty string.");
			        }
			    } else {
			        result = StringOperations.addStrings(result, s2);
			    }
			}
			
			else if (op.equals("chop")) {
                int count = getValidInt(sc, "Enter number of characters to chop: ");
                System.out.print("Enter position (start/end/middle): ");
                String pos = sc.nextLine();
                result = StringOperations.chop(result, count, pos);
			}
			else if(op.equals("contains")) {
				System.out.print("Enter substring to check: ");
				String sub = sc.nextLine();
				if (sub == null || sub.isEmpty()) {
				    System.out.println("Empty substring is not valid.");
				} else {
				    boolean found = StringOperations.containsSubstring(result, sub);
				    System.out.println("Contains: " + found);
				}
			}
			else if (op.equals("extract")) {
                int start = getValidInt(sc, "Enter start index: ");
                int end = getValidInt(sc, "Enter end index: ");
                String extracted = StringOperations.extractSubstring(result, start, end);
                if (extracted != null) {
                    System.out.println("Extracted: " + extracted);
                    result = extracted;
				}
			}
			else if(op.equals("store")) {
				System.out.print("Enter key name to store result: ");
				String key = sc.nextLine();
				StringOperations.store(key, result);
			}
			else if(op.equals("recall")) {
				System.out.print("Enter key name to recall: ");
				String key = sc.nextLine();
				String recalled = StringOperations.recall(key);
				if(recalled!= null) {
					result = recalled;
					System.out.println("recalled value: "+ result);
				}
			}
			else if(op.equals("remove")) {
				System.out.print("Enter key name to remove: ");
				String key = sc.nextLine();
				StringOperations.remove(key);
			}
			else {
				System.out.println("Invalid Operation");
			}
			System.out.println("Current String: "+ result);
		}
		sc.close();
	}
}

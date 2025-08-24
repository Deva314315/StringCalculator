package pack;
import java.util.HashMap;


public class StringOperations {
	private static HashMap<String, String> memory = new HashMap();
	
	public static String addStrings(String s1, String s2) {
		return s1+s2;
	}
	public static String chop(String str, int count, String position) {
		if(str == null|| str.length()==0||count<= 0){
			return str;
		}
		
		switch(position.toLowerCase()) {
		case "start":
			if(count >= str.length())
				return "";
				return str.substring(count);
		case "end":
			if(count >= str.length())
				return "";
			return str.substring(0, str.length() - count);
		case "middle":
			if(count>= str.length())
				return "";
			int mid = str.length()/2;
			int left = mid - (count/2);
			int right = mid + (count - count/2);
			return str.substring(0, left) + str.substring(right);
			default :
				System.out.println("Invalid postion");
				return str;
		}
	}
		public static boolean containsSubstring(String str, String sub) {
			if((str==null)||(sub== null))
				return false;
			return str.contains(sub);
		}
		public static String extractSubstring(String str, int start, int end) {
			if(str == null)
				return null;
			if(start <0 || end > str.length()|| start >= end) {
				System.out.println("Invalid range");
				return null;
			}
			return str.substring(start, end);
		}
		public static void store(String key, String value) {
			memory.put(key, value);
			
			System.out.println("Stored: " + value + "as a key: "+ key );
		}
		public static String recall(String key) {
			if(memory.containsKey(key)) {
				return memory.get(key);
				}
			else {
				System.out.println("No Value found");
				return null;
			}
		}
		public static void remove(String key) {
			if(memory.containsKey(key)) {
				memory.remove(key);
				System.out.println("Removed Key: "+ key);
			}else {
				System.out.println("No value found for key");
			}
		}
}

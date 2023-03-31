package API_Demo_Test;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName(){
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return("John"+generatedString);
	}
	
	public static String getJob(){
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return("Job"+generatedString);
	}
	
	public static void main(String[] args) {
		RestUtils abc = new RestUtils();
		String name = abc.getName();
		String job = abc.getJob();
		System.out.println(name);
		System.out.println(job);
		}

}

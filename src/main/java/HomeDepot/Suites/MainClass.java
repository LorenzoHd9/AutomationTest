package HomeDepot.Suites;


import java.util.List;
import org.testng.TestNG;
import com.beust.jcommander.internal.Lists;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");//Path to xml file, put at same level as jar file
        testng.setTestSuites(suites);
        testng.run();
        //Cambio fer
        //Cambio Dafne
        System.out.println("test");

		//Utilities.testSummary();

	}
}

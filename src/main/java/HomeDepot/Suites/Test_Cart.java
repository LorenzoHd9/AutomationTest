package HomeDepot.Suites;

//import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.annotations.Test;
import HomeDepot.Library.LibraryCart;


public class Test_Cart extends TestBase {
	
    @Test
	  public void search() {
    	
	        LibraryCart library= new LibraryCart(driver);
		  library.GotoHome();
		  library.search("Pintura");
		  library.close();
	  }
    
    @Test
	  public void search2() {
	        LibraryCart library= new LibraryCart(driver);
		  library.GotoHome();
		  library.search("Pintura");
		  library.close();
	  }
    
    @Test
	  public void search3() {
	        LibraryCart library= new LibraryCart(driver);
		  library.GotoHome();
		  library.search("Pintura");
		  library.close();
	  }
    
    @Test
	  public void search4() {
	        LibraryCart library= new LibraryCart(driver);
		  library.GotoHome();
		  library.search("Pintura");
		  library.close();
	  }
	  
	  
}

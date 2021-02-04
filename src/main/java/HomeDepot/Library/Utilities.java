package HomeDepot.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utilities {
	List<String> filesListInDir = new ArrayList<String>();
	
	public static void cleanFolder() throws IOException {
		//use next line if you're running in local 
		File directory = new File("C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output");
		//use this line if you generate .jar file
		//File directory = new File("./test-output");
		if (directory.exists()){
			FileUtils.cleanDirectory(directory);
		}
	}
	
	public static void SendMail() throws IOException{
		CreateZip();
		//List<Integer> summary = testSummary();
		final String username = "lorenzohd9@gmail.com";
		final String password = "4567899asdfg$";
		final String to = "lorenzo.hernandez@getecsa.co";
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
        		new javax.mail.Authenticator() {
        	       protected PasswordAuthentication getPasswordAuthentication() {
        	    	   return new PasswordAuthentication(username, password);
        	}
        });
       // SuiteConfiguration config = new SuiteConfiguration();
        //InetAddressip = InetAddress.getLocalHost();
		String hostName = InetAddress.getLocalHost().getHostName();
        try {
        	Message message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(username));
        	message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Testing Results, From: "+hostName);
           
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Resumen de la prueba:"+"\n"
            		/*+"- Total de pruebas ejecutadas: "+summary.get(0)+", Skipped: "+summary.get(1)+", Failed: "+summary.get(2)+", Passed: "+summary.get(3)+"\n"
            		+"- La URL de la pruebas es: "+config.getProperty("site.url")+"\n"*/
            		+"- Nombre actual de host: "+hostName);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            //String filename = "./test-output/test-output.zip"; // from .jar execution
            String filename = "C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output\\test-output.zip";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Mail sent to: "+ to);
        }
        
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
	
	private static void CreateZip() throws IOException {
		deleteFilesJS();
		File dir = new File("C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output");
		//File dir = new File("./test-output");
		//String zipDirName = "./test-output/test-output.zip";
		String zipDirName = "C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output\\test-output.zip"; 
		Utilities zipFiles = new Utilities();
		zipFiles.zipDirectory(dir, zipDirName);
	}
	
	private void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }

    private static void deleteFilesJS() throws IOException {
    	File file = new File("C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output");
    	//File file = new File("./test-output");
    	final String extencion = ".js";
    	File[] fileList = file.listFiles(new FilenameFilter() {
    		public boolean accept(File dir, String name) {
    			if(name.toLowerCase().endsWith(extencion))
    				return true;
    			else
    				return false;
    		}
    	});
    	for (File f: fileList) {
    		if (!f.delete()) 
    			throw new IOException("Not able to delete file: " + f.getAbsolutePath());
    	}
    }
    
    public static List<Integer> testSummary() {
    	List<Integer> result = new ArrayList<Integer>();
    	try {
    		File XmlFile = new File("C:\\Users\\Lorenzo\\git\\Ecommerce_TH\\HomeDepotEcommerce\\test-output.zip\\testng-results.xml");
    		//File XmlFile = new File("./test-output/testng-results.xml");
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlFile);        
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("testng-results");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            int skipped = Integer.parseInt(eElement.getAttribute("skipped"));
            int failed = Integer.parseInt(eElement.getAttribute("failed"));
            int passed = Integer.parseInt(eElement.getAttribute("passed"));
            int total = skipped+failed+passed;
            result.add(total);
            result.add(skipped);
            result.add(failed);
            result.add(passed);
    	}
    	catch (Exception e) {e.printStackTrace();}
    	return result;
    }
}

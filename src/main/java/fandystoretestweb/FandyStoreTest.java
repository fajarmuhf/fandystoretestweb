package fandystoretestweb;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;

public class FandyStoreTest {

	
		
	public static String main() {
		Thread t1 = new Thread(new Runnable() {

	        public void run() {
	            try {
	            	openFandyStore("3268fe3c","OPPO A95","24 - 1.0.2");	
	            }catch(Exception e) {
	            	
	            	
	            }
	        }
		});
		Thread t2 = new Thread(new Runnable() {

	        public void run() {
	            try {
	    			openFandyStore("d5346ea1","Xiaomi Mi 6","24 - 1.0.2");
	            }catch(Exception e) {
	            	
	            }
	        }
		});
		Thread t3 = new Thread(new Runnable() {

	        public void run() {
	            try {
	    			openFandyStore("emulator-5554","Nexus 5","24 - 1.0.2");
	            }catch(Exception e) {
	            	
	            }
	        }
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		return "Loading";
	}
	
	
	public static void openFandyStore(String udid,String tipe,String version) throws InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("udid",udid);
		cap.setCapability("platformName", "android");
		cap.setCapability("appPackage","com.fmfstudio.fandy_store");
		cap.setCapability("appActivity", "MainActivity");
		cap.setCapability("noReset", false);
		
	    // Step-1 Creating a PdfDocument object
	    
		
	    
		AppiumDriver driver;
		try {
			driver = new AppiumDriver(
				    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
				    new URL("https://6093-158-140-176-15.ap.ngrok.io/wd/hub"), cap
				);
			try {
				Files.createDirectories(Paths.get("/Users/fajarmuhf/Laporan Fandy Store Testing/"+tipe));
		    	// Creating a PdfDocument object   
		        String dest1 = "/Users/fajarmuhf/Laporan Fandy Store Testing/"+tipe+"/laporan test - "+version+".pdf";   
		        PdfWriter writer = new PdfWriter(dest1);       
		           
		        // Creating a PdfDocument object      
		        PdfDocument pdf = new PdfDocument(writer);                  
		        
		        // Creating a Document object       
		        Document doc = new Document(pdf);                       
		           
		        // Creating a table       
		        float [] pointColumnWidths = {150F, 150F, 150F};   
		        Table table = new Table(pointColumnWidths);    
		        
		        
		        // Adding cells to the table       
		        ArrayList<String> aktivitas = new ArrayList<String>();
		        ArrayList<String> fungsi = new ArrayList<String>();
		        ArrayList<String> bugs = new ArrayList<String>();

		        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
				String aktivitasTes = "Aplikasi dibuka";
		        System.out.println(aktivitasTes);
				aktivitas.add(aktivitasTes);
				try {
					String took = tipe;
					if(took=="OPPO A95" || took=="Nexus 5") {
					    try{
					    	WebElement pilihLokasi = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
					    	fungsi.add("valid");
					    	bugs.add("-");
					    	try {
					    		pilihLokasi.click();
					    	}catch(Exception e) {
								fungsi.add("tidak valid");
								bugs.add(e.toString());
					    	}
						    aktivitasTes = "Klik Lokasi Saat aplikasi digunakan";
					        System.out.println(aktivitasTes);
							aktivitas.add(aktivitasTes);
						}catch(Exception e) {
							fungsi.add("tidak valid");
							bugs.add(e.toString());
						    
						}
					   
					    driver.getPageSource();
					    try{
						    WebElement pilihMedia = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
						    fungsi.add("valid");
					    	bugs.add("-");
					    	try {
					    		pilihMedia.click();
					    	}catch(Exception e) {
								fungsi.add("tidak valid");
								bugs.add(e.toString());
					    	}
						    aktivitasTes = "Klik Izinkan Media";
						    System.out.println(aktivitasTes);
						    aktivitas.add(aktivitasTes);
					    }catch(Exception e) {
							fungsi.add("tidak valid");
							bugs.add(e.toString());
					    }
					    driver.getPageSource();
					}
					else if(took=="Xiaomi Mi 6"){
						try{
							WebElement pilihMedia = driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"));
							fungsi.add("valid");
					    	bugs.add("-");
					    	try {
					    		pilihMedia.click();
					    	}catch(Exception e) {
								fungsi.add("tidak valid");
								bugs.add(e.toString());
					    	}
						    aktivitasTes = "Klik Izinkan Media";
					        System.out.println(aktivitasTes);
							aktivitas.add(aktivitasTes);
						}catch(Exception e) {
							fungsi.add("tidak valid");
							bugs.add(e.toString());
						}
						driver.getPageSource();
						try {
						    WebElement pilihLokasi = driver.findElement(AppiumBy.id("com.android.packageinstaller:id/permission_allow_button"));
						    fungsi.add("valid");
					    	bugs.add("-");
					    	try {
					    		pilihLokasi.click();
					    	}catch(Exception e) {
								fungsi.add("tidak valid");
								bugs.add(e.toString());
					    	}
					    	aktivitasTes = "Klik Izinkan Lokasi";
					        System.out.println(aktivitasTes);
							aktivitas.add(aktivitasTes);
						}
						catch(Exception e) {
							fungsi.add("tidak valid");
							bugs.add(e.toString());
						}
						driver.getPageSource();
					    
					}
					try {
					    WebElement pilihLoginGoogle = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.Button"));
					    fungsi.add("valid");
				    	bugs.add("-");
				    	pilihLoginGoogle.click();
					    aktivitasTes = "Klik Login Google";
				        System.out.println(aktivitasTes);
						aktivitas.add(aktivitasTes);
					}catch(Exception e) {
						fungsi.add("tidak valid");
						bugs.add(e.toString());
					}
					driver.getPageSource();
				    boolean done = false;
				    int timeout = 0;
				    int maxtimeout = 5;
				    while(!done) {
					    try {
					    	WebElement pilihAkun = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.LinearLayout"));
					    	fungsi.add("valid");
					    	bugs.add("-");
					    	try {
					    		pilihAkun.click();
					    	}catch(Exception e) {
								fungsi.add("tidak valid");
								bugs.add(e.toString());
					    	}
					    	aktivitasTes = "Pilih Akun Google Ke-1";
					        System.out.println(aktivitasTes);
							aktivitas.add(aktivitasTes);
						    done=true;
						}
					    catch(Exception e) {
					    	Thread.sleep(1000);
					    	driver.getPageSource();
					    	timeout++;
					    	if(timeout==maxtimeout) {
					    		done = true;
					    	}
					    }
				    }
				    done = false;
				    boolean bug0 = false;
				    String bug0s="";
				    timeout = 0;
				    maxtimeout = 5;
				    WebElement judulLama = null;
				    while(!done) {
					    try {
						    WebElement tipingPencarian = (WebElement) driver.findElement(AppiumBy.id("com.fmfstudio.fandy_store:id/editText_pencarian"));
						    judulLama = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.TextView[1]"));
							fungsi.add("valid");
							bugs.add("-");
							try {
								tipingPencarian.sendKeys("m");
							}catch(Exception e) {
								bug0 = true;
								bug0s = e.toString();
							}
							aktivitasTes = "Tiping Pencarian di Dashboard";
					        System.out.println(aktivitasTes);
							aktivitas.add(aktivitasTes);
							
							done=true;
						}
					    catch(Exception e) {
					    	Thread.sleep(1000);
					    	driver.getPageSource();
					    	if(done == false) {
								bug0 = true;
					    		bug0s = e.toString();
					    	}
					    	timeout++;
					    	if(timeout==maxtimeout) {
					    		done = true;
					    	}
					    }
				    }
				    
				    boolean done2 = false;
					int timeout2 = 0;
					int maxtimeout2 = 2;
				    while(!done2) {
						try {
							WebElement judul = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.TextView[1]"));
							WebElement deskripsi = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.TextView[2]"));
							if(judul.getText() != judulLama.getText() && (judul.getText().indexOf('m') > -1 || deskripsi.getText().indexOf('m') > -1)) {
								bug0=false;
							}
							done2 = true;
						}catch(Exception e) {
							
					    	Thread.sleep(1000);
					    	driver.getPageSource();
					    	timeout2++;
					    	if(timeout2 == maxtimeout2) {
					    		done2=true;
					    	}
						}
				    }
				    
					if(bug0) {
						fungsi.add("tidak valid");
						bugs.add(bug0s);	
					}
					else {
						fungsi.add("valid");
						bugs.add("-");		
					}
				} catch(Exception e){
					fungsi.add("tidak valid");
					bugs.add(e.toString());
				} finally {
					Thread.sleep(10000);
				    driver.quit();
				}
				table.addHeaderCell(new Cell().add("Name Aktifitas"));       
				table.addHeaderCell(new Cell().add("Validasi Fungsi"));       
				table.addHeaderCell(new Cell().add("Bugs"));       
		        for(int i=0;i<aktivitas.size();i++) {
		        	table.addCell(new Cell().add(aktivitas.get(i).toString()));
		        	try {
		        	table.addCell(new Cell().add(fungsi.get(i).toString()));
		        	table.addCell(new Cell().add(bugs.get(i).toString()));
		        	}
		        	catch(Exception e) {
		        		
		        	}
			    }
		        // Adding Table to document        
		        doc.add(table);  

			    System.out.println("Table created successfully..");
		        doc.close();
		           
		    } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch(Exception e) {
			System.out.println(e);
		}
			
	}
}

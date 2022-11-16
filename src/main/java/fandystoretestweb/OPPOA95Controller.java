package fandystoretestweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

public class OPPOA95Controller {
	public static String restart() {
		String namaDevice = "3268fe3c";
		JadbConnection jadb = new JadbConnection();
		try {
			List<JadbDevice> devices = jadb.getDevices();
			for(int i=0;i<devices.size();i++) {
				if(devices.get(i).toString().equals("Android Device with serial "+namaDevice)) {
					devices.get(i).executeShell("reboot","");
					break;
				}
			}
			System.out.print(devices.get(2).toString());
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("udid",namaDevice);
			cap.setCapability("platformName", "android");
			cap.setCapability("appPackage","com.android.launcher");
			cap.setCapability("appActivity", "Launcher");
			cap.setCapability("noReset", true);
			
			boolean done = false;
		    int timeout = 0;
		    int maxtimeout = 3600;
		    while(!done) {
			    try {
					AppiumDriver driver = new AppiumDriver(
						    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
						    new URL("http://127.0.0.1:4723/wd/hub"), cap
						);
					boolean done2 = false;
				    int timeout2 = 0;
				    int maxtimeout2 = 3600;
				    while(!done) {
					    try {
					    	WebElement pilihAkun = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView"));
					    	
					    	try {
					    		pilihAkun.click();
					    	}catch(Exception e) {
					    	}
						    done2=true;
						    done=true;
						}
					    catch(Exception e) {
					    	try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    	driver.getPageSource();
					    	timeout2++;
					    	if(timeout2==maxtimeout2) {
					    		done2 = true;
					    	}
					    }
				    }
			    }catch(Exception e) {
			    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	timeout++;
			    	if(timeout==maxtimeout) {
			    		done = true;
			    	}
			    }
		    }
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JadbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessBuilder builder = new ProcessBuilder(
	            "adb.exe", "-s",namaDevice,"tcpip","5555");
        builder.redirectErrorStream(true);
        Process p;
		try {
			p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder = new ProcessBuilder(
	            "C:/Users/Fajar/Downloads/scrcpy/scrcpy.exe", "--tcpip=192.168.1.22:5555");
        builder.redirectErrorStream(true);
		try {
			p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        int timeout=0;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);

		    	timeout++;
		    	if(timeout ==5) {
		    		break;
		    	}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		return "reboot successfully";
	}
}

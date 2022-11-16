package fandystoretestweb;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

public class Nexus5Controller {
	public static String restart() {
		String namaDevice = "emulator-5554";
		JadbConnection jadb = new JadbConnection();
		try {
			List<JadbDevice> devices = jadb.getDevices();
			System.out.println(devices.size());
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
			cap.setCapability("appPackage","com.google.android.apps.nexuslauncher");
			cap.setCapability("appActivity", "NexusLauncherActivity");
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
					    	//WebElement pilihAkun = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView"));
					    	
					    	try {
					    		//pilihAkun.click();
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
		return "reboot successfully";
	}
}

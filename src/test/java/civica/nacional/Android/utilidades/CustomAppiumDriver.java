package civica.nacional.Android.utilidades;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import android.content.Context;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;



public class CustomAppiumDriver{

	BaseUtil base;
	public AppiumDriver<MobileElement> driver;
	private DesiredCapabilities dc;
	public static String deviceName = "";
	static AppiumDriver<MobileElement> driverAll;
	UtilidadesTCS utilidadesTCS;


	public CustomAppiumDriver() {
		iniciarAppiumDriverCivicaApp();
	}

	public void iniciarAppiumDriver() {
		dc = new DesiredCapabilities();
		dc.setCapability("bundleId", Credenciales.parametrosGenerales().getProperty("appium.bundleId"));
		dc.setCapability("noReset", Credenciales.parametrosGenerales().getProperty("appium.noReset"));
		dc.setCapability("skipUnlock", Credenciales.parametrosGenerales().getProperty("appium.skipUnlock"));
		dc.setCapability("showXcodelog", Credenciales.parametrosGenerales().getProperty("appium.showXcodelog"));
		dc.setCapability("autoAcceptAlerts", Credenciales.parametrosGenerales().getProperty("appium.autoAcceptAlerts"));
		dc.setCapability("newCommandTimeout",
				Credenciales.parametrosGenerales().getProperty("appium.newCommandTimeout"));
		dc.setCapability("automationName", Credenciales.parametrosGenerales().getProperty("appium.automationName"));

		//Devices
		dc.setCapability("deviceName", Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
		dc.setCapability("platformName", Credenciales.parametrosGenerales().getProperty("appium.device.platformName"));
		dc.setCapability("platformVersion",
				Credenciales.parametrosGenerales().getProperty("appium.device.platformVersion"));
		dc.setCapability("udid", Credenciales.parametrosGenerales().getProperty("appium.device.udid"));
		
		try {
			BaseUtil.driver = new AppiumDriver<MobileElement>(
					new URL(Credenciales.parametrosGenerales().getProperty("appium.server.url")), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciarAppiumDriver2() {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		dc.setCapability("automationName", "uiautomator2");

	    //APP CIVICA
		dc.setCapability("appPackage", "gov.metromedellin.appCivicanew.lab");
		dc.setCapability("appActivity", "co.com.civica.superapp.screens.intro.view.IntroActivity");

		dc.setCapability("noReset", true);
		dc.setCapability("skipUnlock", true);

	    //Huawei P40
//		dc.setCapability("deviceName", "WGSUT21128001900");
//		dc.setCapability("udid", "WGSUT21128001900");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("platformVersion", "10");
//	    deviceName = dc.getCapability("deviceName").toString();
		dc.setCapability("deviceName", Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
        System.out.println("deviceName: "+Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
        dc.setCapability("udid", Credenciales.parametrosGenerales().getProperty("appium.device.udid"));
        dc.setCapability("platformName", Credenciales.parametrosGenerales().getProperty("appium.device.platformName"));
        dc.setCapability("platformVersion", Credenciales.parametrosGenerales().getProperty("appium.device.platformVersion"));
        deviceName = dc.getCapability("deviceName").toString();

	    try {
	    	BaseUtil.driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
	
	public  void iniciarAppiumDriver3(){

		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		dc.setCapability("automationName", "uiautomator2");

	//  APP DAVIPLATA
//		dc.setCapability("appPackage", "com.davivienda.daviplataapp.lab");
//		dc.setCapability("appActivity", "com.davivienda.daviplataapp.presentation.SplashActivity");
//		dc.setCapability("noReset", true);
//		dc.setCapability("skipUnlock", true);
		
	//  APP CÍVICA
		dc.setCapability("appPackage", "gov.metromedellin.appCivicanew");
		dc.setCapability("appActivity", "co.com.civica.superapp.screens.intro.view.IntroActivity");
		dc.setCapability("noReset", true);
		dc.setCapability("skipUnlock", true);
		
	//Huawei P30
//		 dc.setCapability("deviceName", "X9F4C19C20003439");
//		 dc.setCapability("udid", "X9F4C19C20003439");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "9.0");
//		 deviceName = dc.getCapability("deviceName").toString();
		
	// Samsung S8:
//		dc.setCapability("platformVersion", "10.0");
//		dc.setCapability("deviceName", "ce0517150df1112e01");
//		dc.setCapability("udid", "ce0517150df1112e01");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("platformVersion", "9.0");
//		deviceName = dc.getCapability("deviceName").toString();
		
	//  Huawei P40
//		 dc.setCapability("deviceName", "WGSUT21128001900");
//		 dc.setCapability("udid", "WGSUT21128001900");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "10.0");
//		 deviceName = dc.getCapability("deviceName").toString();
		dc.setCapability("deviceName", Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
        System.out.println("deviceName: "+Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
        dc.setCapability("udid", Credenciales.parametrosGenerales().getProperty("appium.device.udid"));
        dc.setCapability("platformName", Credenciales.parametrosGenerales().getProperty("appium.device.platformName"));
        dc.setCapability("platformVersion", Credenciales.parametrosGenerales().getProperty("appium.device.platformVersion"));
        deviceName = dc.getCapability("deviceName").toString();
		
    //  Redmi 12C
//		 dc.setCapability("deviceName", "6tvkp74tgeqs4pkb");
//		 dc.setCapability("udid", "6tvkp74tgeqs4pkb");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "12");
//		 deviceName = dc.getCapability("deviceName").toString();
		
	//  Samsung A32
//		 dc.setCapability("deviceName", "R58R725HT5A");
// 		 dc.setCapability("udid", "R58R725HT5A");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "13");
//		 deviceName = dc.getCapability("deviceName").toString();
		 
		try {
			BaseUtil.driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			}
		}
	
//	public void iniciarAppiumDriverCivicaApp() {
//        // Set capabilities for Appium driver
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
//        dc.setCapability("automationName", "uiautomator2");
//        dc.setCapability("appPackage", "co.gov.metromedellin.appCivicanew.lab");
//        dc.setCapability("appActivity", "co.com.civica.superapp.screens.intro.view.IntroActivity");        
//        dc.setCapability("noReset", true);
//        dc.setCapability("skipUnlock", true);
//        dc.setCapability("platformVersion", "10.0");
//        dc.setCapability("deviceName", "WGSUT21128001900");
//        dc.setCapability("udid", "WGSUT21128001900");
//        dc.setCapability("platformName", "Android");
//        deviceName = dc.getCapability("deviceName").toString();
//
//        // Establish Bluetooth connection
//        try {
//            LocalDevice localDevice = LocalDevice.getLocalDevice();
//            DiscoveryAgent discoveryAgent = localDevice.getDiscoveryAgent();
//            RemoteDevice[] remoteDevices = discoveryAgent.retrieveDevices(DiscoveryAgent.CACHED);
//            RemoteDevice chosenDevice = remoteDevices[0]; // Choose the first device for connection
//
//            String url = "btspp://" + chosenDevice.getBluetoothAddress() + ":1;authenticate=false;encrypt=false;master=false";
//            StreamConnection streamConnection = (StreamConnection) Connector.open(url);
//            System.out.println("Bluetooth connection established.");
//
//            // Initialize Appium driver
//            driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//            System.out.println("Appium driver initialized successfully.");
//
//            // Close Bluetooth connection after initializing driver
//            streamConnection.close();
//            System.out.println("Bluetooth connection closed.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
	
	public  void iniciarAppiumDriverCivicaApp(){
		//Huawei P40
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("appPackage", "co.gov.metromedellin.appCivicanew.lab");
        dc.setCapability("appActivity", "co.com.civica.superapp.screens.intro.view.IntroActivity");        
        dc.setCapability("noReset", true);
        dc.setCapability("skipUnlock", true);
        dc.setCapability("deviceName", Credenciales.parametrosGenerales().getProperty("appium.device.deviceName"));
        dc.setCapability("udid", Credenciales.parametrosGenerales().getProperty("appium.device.udid"));
        dc.setCapability("platformName", Credenciales.parametrosGenerales().getProperty("appium.device.platformName"));
        dc.setCapability("platformVersion", Credenciales.parametrosGenerales().getProperty("appium.device.platformVersion"));
        deviceName = dc.getCapability("deviceName").toString();
        //Redmi 12C
//            dc.setCapability("deviceName", "6tvkp74tgeqs4pkb");
//            dc.setCapability("udid", "6tvkp74tgeqs4pkb");
//            dc.setCapability("platformName", "Android");
//            dc.setCapability("platformVersion", "12");
//            deviceName = dc.getCapability("deviceName").toString();
        //Samsung A32
//        dc.setCapability("deviceName", "R58R725HT5A");
//        dc.setCapability("udid", "R58R725HT5A");
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("platformVersion", "13");
//        deviceName = dc.getCapability("deviceName").toString();
         
        try {
			BaseUtil.driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
    }
	
	public AppiumDriver<MobileElement> getCustomDriver() {
		return BaseUtil.driver;
	}
	
}

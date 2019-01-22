package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("/Users/thuan.pham/Desktop/PrivateProjects/WebTestingWithReport");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\TestExportReport.html", true);
        }
        return extent;
    }
}

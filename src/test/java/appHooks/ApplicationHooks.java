package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.product.factory.BrowserFactory;
import com.product.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private PropertiesReader reader;
	private BrowserFactory browserFactory;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		reader = new PropertiesReader();
		prop = reader.init_prop();
	}

	@Before(order = 1)
	public void setUpBrowser() {

		String browserName = prop.getProperty("browser");
		browserFactory = new BrowserFactory();
		driver = browserFactory.init_Driver(browserName);
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", screenshotName);
		}

	}
}

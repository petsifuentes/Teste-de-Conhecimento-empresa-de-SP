package teste1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreencheDados {
	static WebDriver driver;
	WebElement contato, nome, email, telefone;
	
	@Before
	public void preCondicoes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Teste de Conhecimento empresa de SP\\Arquivos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://artit.com.br/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void preenchendoDados() throws IOException {
		contato = driver.findElement(By.linkText("Contato"));
		contato.click();
		nome = driver.findElement(By.name("fld_8768091"));
		nome.sendKeys("Petrônio Sifuentes Gomes Júnior");
		tiraScreenShot("teste1.jpg");
		email = driver.findElement(By.name("fld_6009157"));
		email.sendKeys("pet.sifuentesjr@gmail.com");
		tiraScreenShot("teste2.jpg");
		telefone = driver.findElement(By.name("fld_9033886"));
		telefone.sendKeys("37991337936");		
		tiraScreenShot("teste3.jpg");
	}
	
	public static void tiraScreenShot(String nomeDaImagem) throws IOException{
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File arquivoScreenShot = screenshot.getScreenshotAs(OutputType.FILE);

		// imageFileDir = System.getProperty("java.io.tmpdir"); 
		String imageFileDir = "C:\\Users\\USER\\Desktop\\Teste de Conhecimento empresa de SP\\Arquivos";
		FileUtils.copyFile(arquivoScreenShot, new File(imageFileDir, nomeDaImagem));

	}
	
	@After
	public void posCondicoes() {
		driver.quit();
	}
}

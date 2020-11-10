import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrame {
	 
	public WebDriver driver;
	public DSL dsl;	
	public  CampoTreinamentoPage page;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\willian.santos\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new  CampoTreinamentoPage(driver);
	}
	
	@Test
	public void testeTextField(){
		dsl.escrever("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void setNome() {
		page.setNome("Willian");
	
	}
	
	@Test
	public void clicaFrame() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
}

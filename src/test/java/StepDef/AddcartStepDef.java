package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddcartStepDef {
    WebDriver driver;
    @Given("I open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("I open elevania homepage")
    public void iOpenElevaniaHomepage(){
        driver.get("https://www.elevenia.co.id/");
    }

    @When("I close banner")
    public void iCloseBanner() {
        driver.findElement(By.className("closeBtnMainPromo")).isDisplayed();
        driver.findElement(By.className("closeBtnMainPromo")).click();
    }

    @When("I search {string}")
    public void iSeach(String searchValue) throws InterruptedException {
        driver.findElement(By.id("AKCKwd")).sendKeys(searchValue, Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.className("searchTxt")).isDisplayed();
    }

    @And("I choose first product in Produk terlaris tab")
    public void iClickProdukTerlaris() throws InterruptedException {
        driver.findElement(By.cssSelector("a[code='SS']")).click(); //click Produk terlaris tab
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"prod_28911164\"]/div/a[2]")).click(); //choose first product
        Thread.sleep(2000);
        driver.findElement(By.className("productInfoArea")).isDisplayed();
    }

    @And("I added to cart")
    public void iClickTambahKeCartButton() throws InterruptedException {
        driver.findElement(By.className("btnOrangeW")).click(); //add to cart
        Thread.sleep(1000);
        driver.findElement(By.id("mo_lay144")).isDisplayed();
        driver.findElement(By.className("btnRed")).click(); //click Ya in pop up confirmation
    }

    @And("I click Ubah Kurir button")
    public void iClickUbahKurirButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shoppingList")).isDisplayed();
        driver.findElement(By.name("deliveryChangePopup")).click();
    }

    @And("I click Batal in pop up confirmation")
    public void iClickBatalInPopUpConfirmation() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame("ifrLayer"); //switch frame
        driver.findElement(By.className("btnWGray")).click();
        driver.switchTo().parentFrame(); //switch to parent frame
    }

    @And("I removed an item from cart")
    public void iClickHapusButton(){
        driver.findElement(By.xpath("//*/tbody/tr/td[7]/a[2]")).click();
        driver.findElement(By.id("chkDelPopY")).click(); //click OK in pop up confirmation
    }

    @Then("Cart is empty")
    public void cartIsEmpty() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("dataNone")).isDisplayed();
        driver.close();
        driver.quit();
    }
}

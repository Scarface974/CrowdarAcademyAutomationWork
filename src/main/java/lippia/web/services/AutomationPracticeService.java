package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.driver.DriverManager;
import junit.framework.Assert;
import lippia.web.constants.AutomationConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.crowdar.core.actions.ActionManager.click;
import static com.crowdar.core.actions.ActionManager.setInput;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AutomationPracticeService {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void enterSearchCriteria(String text) {
        setInput(AutomationConstants.INPUT_SEARCH_XPATH, text);
    }

    public static void clickSearchButton() {click(AutomationConstants.SEARCH_BUTTON_NAME);
    }

    public static void clickBotonShop() {
        click(AutomationConstants.BUTTON_SHOP);}

   public static void clickBotonHome() {click(AutomationConstants.BUTTON_HOME);}

    public static void clickFirstSlider(){click(AutomationConstants.IMAGE_SLIDER1);}

    public static void clickProducto(){click(AutomationConstants.PRODUCTO_HOME);}

    public static void clickAddToBasket(){click(AutomationConstants.ADD_TO_BASKET);}

    public static void clickCarrito(){click(AutomationConstants.CARRITO_MENU);}

    public static void clickSale(){click(AutomationConstants.SALE_PRODUCTO);}

    public static void precioViejo(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.PRECIO_VIEJO));


        assertTrue(elemento.isDisplayed(), "El elemento no es visible.");


        elemento.click();
    }

    public static void precioNuevo(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.PRECIO_NUEVO));


        assertTrue(elemento.isDisplayed(), "El elemento no es visible.");


        elemento.click();
    }

    public static void ingresarRegistar(){click(AutomationConstants.MI_CUENTA);}

    public static void ingresarEmail(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.EMAIL_REGISTRO));
        elemento.sendKeys("ScarfaceUltra123@gmail.com");
    }

    public static void ingresarPassword(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.PASSWORD_REGISTRO));
        elemento.sendKeys("Scarface18001432114**");
    }

    public static void mensajeBienvenido(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.MENSAJE_BIENVENIDA));


        assertTrue(elemento.isDisplayed(), "El elemento no es visible.");


        elemento.click();
    }

    public static void ingresarEmailVacio(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.EMAIL_REGISTRO));
        elemento.sendKeys("");
    }

    public static void mensajeError(){
        WebElement elemento = DriverManager.getDriverInstance().findElement(By.cssSelector(AutomationConstants.ERROR_MENSAJE));
        String textoDelElemento = elemento.getText();
        String textoEsperado = "Texto esperado"; // Reemplaza con el texto que deseas comparar

// Usar un assert para verificar si los textos son iguales
        assertEquals(textoDelElemento, textoEsperado, "Please provide a valid email address.");

    }


    public static void hacacerClickRegistrar(){click(AutomationConstants.BUTTON_REGISTRAR);}
    
    public static void visualizarProductoCarrito()throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        WebElement parrafo = driver.findElement(By.id("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[3]/a"));

        String textoDelParrafo = parrafo.getText();
        // Compara el texto del elemento con el valor esperado utilizando un assert
        String valorEsperado = "Selenium Ruby"; // Reemplaza con el valor que esperas
        System.out.println("Texto real del elemento: " + textoDelParrafo);
        System.out.println("Valor esperado: " + valorEsperado);
        assertEquals(textoDelParrafo, valorEsperado, "El texto del elemento no coincide con el valor esperado");
    }

    public static void clickFiltro(){click(AutomationConstants.FILTRO);}

    public static void moverFiltro() throws InterruptedException {

        DriverManager.getDriverInstance().getCurrentUrl();
        DriverManager.getDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        Dimension tamañoVentana = new Dimension(1920, 1080); // Cambia estos valores según tus necesidades
        DriverManager.getDriverInstance().manage().window().setSize(tamañoVentana);

        DriverManager.getDriverInstance().findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();

        DriverManager.getDriverInstance().findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]")).isDisplayed();



        Actions actions = new Actions(DriverManager.getDriverInstance());



        DriverManager.getDriverInstance().findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]")).click();
        Thread.sleep(1000);

        actions.clickAndHold(DriverManager.getDriverInstance().findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"))).perform();


        actions.moveByOffset(-28, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);
    }

    public static void verificarPrecio(){
        DriverManager.getDriverInstance().getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriverInstance(), 10);
        WebElement elementoEsperado = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocommerce-Price-amount.amount")));
// Obtener todos los elementos con la clase CSS "woocommerce-Price-amount amount"
        List<WebElement> elementosPrecio = DriverManager.getDriverInstance().findElements(By.cssSelector(".woocommerce-Price-amount.amount"));

        for (WebElement elemento : elementosPrecio) {
            // Obtener el texto del elemento y convertirlo a un número entero
            String precioTexto = elemento.getText().replace("$", "").replace(",", "").trim();
            int precio = Integer.parseInt(precioTexto);

            // Verificar que el precio sea mayor o igual a 150 y menor o igual a 450
            assertTrue(precio >= 150 && precio <= 450, "El precio no cumple con el rango esperado.");
        }

    }


    public static void deslizarSlider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in");

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[1]/div[1]/img")); // Reemplaza con el selector correcto

        // Crea una instancia de la clase Actions
        Actions actions = new Actions(driver);

        // Inicialmente, verifica cuántos elementos visibles hay

        slider.click();

        // Haz clic y mantén presionado el botón del mouse en el slider
        actions.clickAndHold(slider).perform();

        // Mueve el cursor (arrastra) para desplazar el slider
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);

        WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[3]/div[1]/img"));
        slider2.click();

        actions.clickAndHold(slider2).perform();

        // Mueve el cursor (arrastra) para desplazar el slider
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);

        WebElement slider3 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[2]/div[1]/img"));
        slider3.click();

        actions.clickAndHold(slider3).perform();

        // Mueve el cursor (arrastra) para desplazar el slider
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);

        slider.click();
        driver.quit();

    }



    public static void visualizarSlider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in");

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[1]/div[1]/img")); // Reemplaza con el selector correcto


        Assert.assertTrue("El primer slider no es visible.", slider.isDisplayed());


        Actions actions = new Actions(driver);


        actions.clickAndHold(slider).perform();
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);

        WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[3]/div[1]/img"));


        Assert.assertTrue("El segundo slider no es visible.", slider2.isDisplayed());

        actions.clickAndHold(slider2).perform();
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();
        Thread.sleep(2000);

        WebElement slider3 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[2]/div[1]/img"));


        Assert.assertTrue("El tercer slider no es visible.", slider3.isDisplayed());

        actions.clickAndHold(slider3).perform();
        actions.moveByOffset(150, 0).perform();
        actions.release().perform();


        Assert.assertTrue("El primer slider no es visible.", slider.isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }

    public static void scroll() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Scarface\\.m2\\repository\\webdriver\\chromedriver\\win32\\117.0.5938.92\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Abre una página web
        driver.get("https://practice.automationtesting.in");

        // Asegúrate de que driver sea una instancia de JavascriptExecutor
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Hacer scroll hacia abajo
            js.executeScript("window.scrollBy(0, 500);"); // Desplaza 500 píxeles hacia abajo

            // Espera para ver el efecto del scroll
            try {
                Thread.sleep(2000); // Puedes ajustar el tiempo de espera según sea necesario
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(2000);
    }
        public static void visualizarArrivals () throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.get("https://practice.automationtesting.in");
            WebElement arrival = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]/img")); // Reemplaza con el selector correcto


            Assert.assertTrue("El primer arrival no es visible.", arrival.isDisplayed());


            Thread.sleep(2000);

            WebElement arrival2 = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img"));


            Assert.assertTrue("El segundo slider no es visible.", arrival2.isDisplayed());


            Thread.sleep(2000);

            WebElement arrival3 = driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img"));


            Assert.assertTrue("El tercer slider no es visible.", arrival3.isDisplayed());


            Thread.sleep(2000);
            driver.quit();

        }


    }

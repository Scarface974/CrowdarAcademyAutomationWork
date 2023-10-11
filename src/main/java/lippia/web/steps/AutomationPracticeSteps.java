package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.AutomationPracticeService;
import lippia.web.services.GoogleHomeService;
import lippia.web.services.GoogleSearchResultService;

public class AutomationPracticeSteps extends PageSteps {


/*--------------------------------Steps de Maldonado Gauna Esteban Joel ------------------------------------------------- */
  /*-----TP_N°2_Lippia Web Básico------- */
    @Given("el usuario se encuentra en el navegador")
    public void elUsuarioSeEncuentraEnElNavegador() {
        GoogleHomeService.navegarWeb();
    }

    @When("ingresa {string} en la barra de busqueda")
    public void ingresaPalabraEnLaBarraDeBusqueda(String palabra) {
        GoogleHomeService.enterSearchCriteria(palabra);
        GoogleHomeService.clickSearchButton();
    }

    @Then("se visualiza el mismo")
    public void seVisualizaElMismo() {
        GoogleSearchResultService.verifyResults();
    }




    /*-----TP_N°3_Lippia Web Básico parte 2------- */

    /*-------------------------------------TP_N°3_ HOME - Escenario 1 Sliders -------------------------- */
    @Before
    @Given("que el usuario se encuentra en el sitio Automation-Practice")
    public void queElUsuarioSeEncuentraEnElSitioAutomationPractice() {
        AutomationPracticeService.navegarWeb();
    }


     @When("hago click en el boton Shop")
     public void hagoClickEnElBotonShop() {
        AutomationPracticeService.clickBotonShop();
     }

     @And("hago click en el boton Menu")
     public void hagoClickEnElBotonMenu()  {
        AutomationPracticeService.clickBotonHome();
     }

    @And("deslizo los sliders")
    public void deslizoLosSliders() throws InterruptedException {
        AutomationPracticeService.deslizarSlider();
    }

    @Then("se visualiza los tres sliders")
    public void seVisualizaLosTresSliders() throws InterruptedException {
        AutomationPracticeService.visualizarSlider();
    }
    /*-------------------------------------Fin de Escenario 1 Sliders -------------------------- */


    /*-------------------------------------TP_N°3_ HOME - Escenario 2 Arrivals -------------------------- */
    
    @And("hago un scroll hasta abajo")
    public void hagoUnScrollHastaAbajo() throws InterruptedException {
        AutomationPracticeService.scroll();
    }

    @And("se visualiza los tres arrivals")
    public void seVisualizaLosTresArrivals() throws InterruptedException {
       AutomationPracticeService.visualizarArrivals();
    }
    /*-------------------------------------Fin de Escenario 2 Arrivals -------------------------- */

    /*-------------------------------------TP_N°3_ HOME - Escenario 3 Agregar Producto en el carrito -------------------------- */
    @When("hago click en un producto")
    public void hagoClickEnUnProducto() {
        AutomationPracticeService.clickProducto();
    }

    @And("hago click en add to basket")
    public void hagoClickEnAddToBasket() {
        AutomationPracticeService.clickAddToBasket();
    }

    @And("hago click en el carrito")
    public void hagoClickEnElCarrito() {
        AutomationPracticeService.clickCarrito();
    }

    @Then("se visualiza el producto en el carrito")
    public void seVisualizaElProductoEnElCarrito() throws InterruptedException {
        AutomationPracticeService.visualizarProductoCarrito();
    }


    /*-------------------------------------Fin Escenario 3 Agregar Producto en el carrito -------------------------- */

    /*-------------------------------------TP_N°3_ SHOP - Escenario 1 Filtrar Precio a 450 -------------------------- */
    @And("coloca la barra de filtro en el valor deseado")
    public void colocaLaBarraDeFiltroEnElValorDeseado() throws InterruptedException {
        AutomationPracticeService.moverFiltro();
    }

    @And("hace click en el boton filtro")
    public void haceClickEnElBotonFiltro() {
        AutomationPracticeService.clickFiltro();
    }

    @Then("se visualizan los productos con el filtro deseado")
    public void seVisualizanLosProductosConElFiltroDeseado() {
        AutomationPracticeService.verificarPrecio();
    }
    /*-------------------------------------Fin Escenario 1  Filtrar Precio a 450 -------------------------- */

    /*-------------------------------------TP_N°3_ SHOP - Escenario 2 Producto en Venta -------------------------- */
    @And("hace click en el producto que tenga la etiqueta {string}")
    public void haceClickEnElProductoQueTengaLaEtiqueta(String arg0) {
        AutomationPracticeService.clickSale();
    }

    @Then("se visualiza el precio antiguo tachado")
    public void seVisualizaElPrecioAntiguoTachado() {
        AutomationPracticeService.precioViejo();
    }

    @And("el actual del mismo")
    public void elActualDelMismo() {
        AutomationPracticeService.precioNuevo();
    }
    /*-------------------------------------Fin Escenario 2 Producto en Venta -------------------------- */

    /*-------------------------------------TP_N°3_ REGISTRAR - Escenario 1 Registrar Cuenta -------------------------- */
    @When("hace click en My Account")
    public void haceClickEnMyAccount() {
        AutomationPracticeService.ingresarRegistar();
    }

    @And("ingreso correo")
    public void ingresoCorreo() {
        AutomationPracticeService.ingresarEmail();
    }

    @And("ingreso password")
    public void ingresoPassword() {
        AutomationPracticeService.ingresarPassword();
    }

    @And("hago click en Register")
    public void hagoClickEnRegister() {
        AutomationPracticeService.hacacerClickRegistrar();
    }

    @Then("se visualiza un mensaje de bienvenida")
    public void seVisualizaUnMensajeDeBienvenida() {
        AutomationPracticeService.mensajeBienvenido();
    }


    /*-------------------------------------Fin Escenario 1 Registrar Cuenta -------------------------- */



    @And("dejo vacio el email")
    public void dejoVacioElEmail() {
        AutomationPracticeService.ingresarEmailVacio();
    }

    @Then("se visualiza un mensaje de error")
    public void seVisualizaUnMensajeDeError() {
        AutomationPracticeService.mensajeError();
    }

























    /*---------------------------------------------Fin de Scenario 1 Sliders--------------------------------------------------------------------------------*/


/*---------------------------------------------Escenario de Prueba---------------------------------------------------------------------------------------*/
   /* @Given("que el usuario se encuentra en la pagina de Automation-Practice")
    public void queElUsuarioSeEncuentraEnLaPaginaDeAutomationPractice() {
        AutomationPracticeService.navegarWeb();
    } */

  /*  @When("hago click en el slider del home page")
    public void hagoClickEnElSliderDelHomePage()  {
        AutomationPracticeService.sliderHome();
    }*/























/*  @When("hace click en el boton {string}")
     public void haceClickEnElBoton(String criteria) {
        AutomationPracticeService.enterSearchCriteria(criteria);
    }  */


}


















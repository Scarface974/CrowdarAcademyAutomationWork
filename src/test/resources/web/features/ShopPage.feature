Feature: Shop Page
  @Scar
  Scenario: Filtrar Precio a 450

    Given que el usuario se encuentra en el sitio Automation-Practice
    When  hago click en el boton Shop
    And   coloca la barra de filtro en el valor deseado
    And   hace click en el boton filtro
    Then  se visualizan los productos con el filtro deseado


  Scenario: Producto en Venta

    Given que el usuario se encuentra en el sitio Automation-Practice
    When  hago click en el boton Shop
    And  hace click en el producto que tenga la etiqueta "Sale"
    Then  se visualiza el precio antiguo tachado
    And  el actual del mismo







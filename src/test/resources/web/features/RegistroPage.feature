Feature: Registro Page
  @Scar
  Scenario: Registro-Inicio de sesión


    Given que el usuario se encuentra en el sitio Automation-Practice
    When  hace click en My Account
    And   ingreso correo
    And   ingreso password
    And   hago click en Register
    Then  se visualiza un mensaje de bienvenida

  Scenario: Registro-Inicio de sesión con email vacio


    Given que el usuario se encuentra en el sitio Automation-Practice
    When  hace click en My Account
    And   dejo vacio el email
    And   ingreso password
    And   hago click en Register
    Then  se visualiza un mensaje de error







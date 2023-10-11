@Sample
Feature: Sample

  Background:
    And header Content-Type = application/json
    And header Accept = */*


  @RickAndMorty
  Scenario Outline: Get character
    Given base url env.base_url_rickAndMorty
    And endpoint character/<id_character>
    When execute method GET
    Then the status code should be 200
    And response should be $.name = <name>
    And response should be $.status = <status>
    And validate schema character.json

    Examples:
      | id_character | name         | status |
      | 1            | Rick Sanchez | Alive  |
      | 2            | Morty Smith  | Alive  |

 @Agregar_Workspace
 Scenario:
   Given base url https://api.clockify.me/api
   And   endpoint /v1/workspaces
   And   header Content-Type = application/json
   And   header Accept = */*
   And   header x-api-key = Y2U4YzdiMDgtMDE1Yi00NDQyLWIwMzAtNDA4MGI0NDI1M2I3
   When  execute method GET
   Then  the status code should be 200
   *define idWorkspace = $.[0].id





      

  

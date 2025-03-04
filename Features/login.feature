

Feature: User login

  
  Scenario: User should login successfully with valid credential
    Given Load SignIn page
    When Enter username and password
    Then User should be in home page
    
   
     
    	
  Scenario: Regsiter a patient
    Given Load SignIn page
    When Enter username and password
    And User should be in home page
    And Clicks on Register a patient
    And Enter demographics informations
    And Enter contactinfo
    And Enter retaionships
    Then Clicks on confirm Patient should register successfully
     
    
     
  Scenario: Update a patient
    Given Load SignIn page
    When Enter username and password
    And User should be in home page
    And Clicks on Find Patient Record
    And Enter search by name
    And Select search patient
    And Clicks on edit
    And Update patient name and save
    Then Clicks on confirm and patient name should update successfully
    
    
     
     
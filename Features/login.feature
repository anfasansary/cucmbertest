

Feature: User login

  @Sanity
  Scenario Outline: User should login successfully with valid credential
    Given Load SignIn page
    When Enter <username> and <password>
    Then User should be in home page
    
    Examples:
     |username|password|
     |admin   |Admin123|
     |admin   |Admin123|
    	

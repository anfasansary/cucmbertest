
Feature: Load flipkart site and search mobile
  @Sanity
  Scenario: Able to search mobile on flipkat without login
    Given Load flipkart site
    When Enter search keyword
    Then Clicks on search button
   
  
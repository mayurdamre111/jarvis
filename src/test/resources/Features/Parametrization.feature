Feature: Study parametrization in cucumber

  Scenario: Passing parameter from step
    Given I have 9 and 7
    When I add them
    Then Verify if the result is prime

  Scenario: Passing single parameter
    Given I have a number 67

  Scenario: Passing string as parameter
    Given I have a name "Mayur D"

  Scenario: Passing data table as parameter
  	Given I have <RTO Codes>   
  	|MH| 
  	|GJ| 
  	|RJ| 
  	|DL| 
  	|MP| 
  	|CH| 
  	|TN| 
  	
  	Scenario: Passing data table as parameter for state
  	Given I have <RTO Codes> and <State_Name>
  	|'MH'| |Maharashtra|
  	|'GJ'| |Gujrat|
  	|'RJ'| |Rrajsthan|
  	|'DL'| |Delhi|
  	|'MP'| |Madhya Pradesh|
  	|'CH'| |Chatisgadh|
  	|'TN'| |Tamil Nadu
  	
  	Scenario Outline: Data driver test case demo
  	Given I have <RTO_Codes>
  	
  	Examples:
  	|RTO_Codes|
  	|MH| 
  	|GJ| 
  	|RJ| 
  	|DL|
  	|MP| 
  	|CH| 
  	|TN| 
  	

Feature: Command Ordering

    as a customer i want to make a command for someone

    Scenario: Creation of an empty Command
        Given Customer "Michel" who want to command for Someone
        When a command is make for Someone
        Then there is no product in the Command
        And the command come from Customer "Michel"

    Scenario: Add a Product for a Command
        Given Customer "Michel" who want to command for Someone
        When a command is make for Someone
        And a product is add in the command
        Then there is one product in the Command
        And the command come from Customer "Michel"

Feature: User account creation

    as a user i want to create an account to pass command
    Scenario: Inscription Formula access
        Given Visitor who want to create an account
        When Someone want access to formula
        Then there is no error

    Scenario: Creation of an account
        Given Visitor who want to create an account
        When a visitor send an email "test@test.test" a name "Test" and a password "test"
        Then there is a User account created "Test"
        And User receive a confirmation

    Scenario: User name "Test" already exist
        Given Visitor who want to create an account
        When a visitor send an email "test@test.test" a name "Test" and a password "test"
        And a product is add in the command
        Then there is the error Already Exist

Feature: User connection

    as a user i want to connect to my account to pass command
    Scenario: 


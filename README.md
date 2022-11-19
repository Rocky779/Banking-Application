# My Personal Project

## A Banking System

This project is a Banking system for a bank named *Bank of British Columbia* that can manage a checking account for its users and
allow the following operations to take place:
* Creating a new bank account for its users by asking them for a username and password. Additional details like name,residential address,phone number ,email id and SIN number are also asked and stored by the bank. 
* Allow its users to login after creating an account using the username and password and log out of te system as well.
* Allow its users to make a withdrawal of any amount that is less than or equal to amount of money remaining in the account
* Allow its users to make a deposit of any amount into their accounts.
* Display banking information such as balance remaining and account number as well as personal details.
* Allow users to request a deletion of their account.
* Store all account details in a list where each element of the list contains the relevant details of each user.
This is a system that can be used by anyone who wishes to understand basic banking and create bank accounts.

This project is of interest to me as I am interested in banking and finance. This project will allow me to use java and give the opportunity to get deeper insights into banking and data management and improve my java skills.

Comments and Citations:

* Data persistence is based on the supplied Workroom example for CPSC 210. All classes,interfaces and tests related to
data persistence have been based on the sample application supplied for CPSC 210.* https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master/src/main/persistence
* Swing components and syntax were referred from https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html
* Event handling of GUI is referred from information provided on EDX that links to https://stackoverflow.com/questions/6578205/swing-jlabel-text-change-on-the-running-application
* https://github.students.cs.ubc.ca/CPSC210/AlarmSystem was referred to while making the GUI.
## User Stories
* As a user I want to be able to create a new bank account after choosing a username and password. After doing that and giving out details like SIN,name,residential address,phone number and email address, all these details will be stored as a BankAccount data type. This account  will be added to a list which will contain such details of other users as well.
* As a user I want to be able to login after creating my new account using my username and password and log out as well. Being able to log in indicates that account details have been successfully added to the list of bank accounts.
* As a user I want to be able to view the details of my bank account like my personal information and bank balance.
* As a user I want to be able to make withdrawals and deposits to my account and be given a warning if a withdrawal fails due to insufficient balance.
* As a user I want to be able to delete my account and thus remove my details from the list of the users.
* As a user, I want to be able to save the list of bank accounts to file.
* As a user, I want to be able to be able to load the list of bank accounts from file.

## Instructions For Grader
* You can add and create your new account to the list of Bank Accounts by clicking on "Create your new account" button and after inputting the information , upon clicking "Add account to list of accounts", the account will be added.
* You can remove the latest account that was added to the list of Bank Accounts by using this GUI(Only the latest account that was  added to the list using the GUI in a current session) by using the "Delete Bank Account" button.
* You can locate my visual component as an image on the main menu panel of a Bank or by clicking "View Current Accounts", you can view two images that explain the features of a checking account.
* You can save the state of my application by clicking  on "Save account to file" button.
* You can reload the state of my application by clicking on the "Load accounts file" button.


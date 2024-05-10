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
* Event logging is based on the following workroom example supplied for CPSC 210:https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
## User Stories
* As a user I want to be able to create a new bank account after choosing a username and password. After doing that and giving out details like SIN,name,residential address,phone number and email address, all these details will be stored as a BankAccount data type. This account  will be added to a list which will contain such details of other users as well.
* As a user I want to be able to login after creating my new account using my username and password and log out as well. Being able to log in indicates that account details have been successfully added to the list of bank accounts.
* As a user I want to be able to view the details of my bank account like my personal information and bank balance.
* As a user I want to be able to make withdrawals and deposits to my account and be given a warning if a withdrawal fails due to insufficient balance.
* As a user I want to be able to delete my account and thus remove my details from the list of the users.
* As a user, I want to be able to save the list of bank accounts to file.
* As a user, I want to be able to be able to load the list of bank accounts from file.

## Instructions For Graders
* You can add and create your new account to the list of Bank Accounts by clicking on "Create your new account" button and after inputting the information , upon clicking "Add account to list of accounts", the account will be added.
* You can remove the latest account that was added to the list of Bank Accounts by using this GUI(Only the latest account that was  added to the list using the GUI in a current session) by using the "Delete Bank Account" button.
* You can locate my visual component as an image on the main menu panel of a Bank or by clicking "View Current Accounts", you can view two images that explain the features of a checking account.
* You can save the state of my application by clicking  on "Save account to file" button.
* You can reload the state of my application by clicking on the "Load accounts file" button.

## Phase 4 Task 2
For this phase, I have logged the following events:
* When a user adds a new account to the list of accounts
* When a user removes an account from the list of accounts
* When a user wishes to view the existing accounts in the list of accounts.

Below is the console output of logged events after exiting the banking application after performing my operations:

Sun Nov 27 19:21:23 PST 2022 

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account added

Sun Nov 27 19:21:23 PST 2022

Account information displayed

Sun Nov 27 19:23:13 PST 2022

Account added

Sun Nov 27 19:23:13 PST 2022

Account information displayed

Sun Nov 27 19:23:32 PST 2022

Account removed

Sun Nov 27 19:23:32 PST 2022

Account information displayed

Process finished with exit code 0

Interpretation:

* For this part of the project first I load the file , which adds all accounts that were saved in the file to the list of 
bank accounts hence showing the event "Account Added" several times initially without actually clicking the add account button.
* Then I clicked on view accounts and hence the event "Account information displayed" is shown.
* After that I created a new account and added it to the list, hence showing the event "Account Added".
* After that to check if account was added, I clicked on view existing accounts and hence the event 
"Account information displayed" is shown.
* Then I clicked on delete account which removed the latest account added to the list hence showing the event
"Account removed".
* After that I once again viewed the existing accounts hence the event "Account information displayed" is shown.
* Then after saving the changes to file, I exited the banking application.

## Phase 4 Task 3
* In the BankAccount and ListBankAccount classes, I believe cohesion is decently high as BankAccount calls only focuses
on functions and manipulating an individual Bank account whereas ListBankAccount only focuses on managing the list of 
bank accounts and not every individual bank account.
* In the BankApp and BankGui, the cohesion is low as each of these classes perform several functions related to 
multiple cohesive concepts. Cohesion can be improved here by splitting the class into several different classes where 
each class is centered around one cohesive concept.
* Coupling is at a medium level in this application where classes have associations with each other , 
a change in one class does require a remote change, but the compiler warns the developer that the change is needed.

* If I had more time for refactoring, I would do the following:
* First in BankGui, for the performButton() function that allots action commands and action listeners to the buttons, 
I would perhaps create a separate function that takes a button, an action command, and the action listener and allots the buttons the 
action command and action listener by just calling the function for each button instead of separately adding action commands and action listeners.
This can be done to reduce code duplication.
* In BankApp , the displaying of choices and performing the respective functions of those choices could be split into another class to increase cohesion. In BankGui, the creation of buttons and panels
  and the respective manipulations and designing of these buttons and panels can be split into separate classes that specifically perform those functions.
* In Bank app the code block that is similar to as follows in runBank():

System.out.println("Do you want to continue? enter y/n ");

  String ch = sc.next();

  if (ch.equals("n")) {

  System.out.println("Thank you!You have successfully logged out");

  break;

Can be refactored as a single function and then that function that can be used multiple times instead of typing the 
same block of code multiple times as done in the runBank function.

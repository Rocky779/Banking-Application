package ui;

import model.BankAccount;
import model.ListBankAccounts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistence.JsonWriter;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;


public class BankGui extends JFrame implements ActionListener {
    private static final String DATA_WORK_ACC_JSON = "./data/work-acc.json";
    private BankAccount account;
    private ListBankAccounts accList;

    private JPanel mainPanel;
    private JPanel panelAcc;
    private JButton b1;
    private JButton b2;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JTextField a1;
    private JTextField a2;
    private JTextField a3;
    private JTextField a4;
    private JTextField a5;
    private JTextField a7;

    private JTextField a6;
    private JButton addAcc;
    private JLabel email;
    private JLabel password;
    private JLabel name;
    private JLabel address;
    private JLabel mobileNumber;
    private JLabel sin;
    private JLabel bankBalance;

    private JLabel accounts;
    private JPanel listingsAcc;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: Constructs The GUI of the Banking Application by adding JButtons,JPanels,JLabels,JTextFields
    // on  the JFrame.
    public BankGui() {
        super("Banking App");
        jsonWriter = new JsonWriter(DATA_WORK_ACC_JSON);
        jsonReader = new JsonReader(DATA_WORK_ACC_JSON);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        mainMenuMaker();
        showBankAccounts();
        inputAccPanel();
        JLabel introLabel = new JLabel("Welcome to Bank of British Columbia");
        introLabel.setFont(new Font("Arial", Font.BOLD, 25));
        mainPanel.add(introLabel);
        JLabel j = new JLabel();
        j.setIcon(new ImageIcon("./data/bank.jpeg"));
        j.setMinimumSize(new Dimension(20, 20));
        mainPanel.add(j);
        createPanelObjects();
        insertButtons(b1, b2, b5, b6, b7, b8);
        performButton();
        mainPanel.setVisible(true);
    }

    //EFFECTS: Initialises the buttons that lie on the main menu panel.
    public void createPanelObjects() {
        b1 = new JButton("View current accounts");
        b2 = new JButton("Create your new account");
        b5 = new JButton("Save account to file");
        b6 = new JButton("Load accounts file");
        b7 = new JButton("Exit Banking application");
        b8 = new JButton("Delete Bank Account");
    }
//MODIFIES: this
//EFFECTS: Places the buttons on the main menu panel

    public void insertButton(JButton jbutton, JPanel panel) {
        jbutton.setFont(new Font("Arial", Font.BOLD, 10));
        jbutton.setBackground(Color.BLACK);
        panel.add(jbutton);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    //EFFECTS: Creates the main menu panel

    public void mainMenuMaker() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.CYAN);
        add(mainPanel);
        accounts = new JLabel();
        accounts.setText("No accounts available");

    }
//EFFECTS: Places a call to insertButton for each required button on the main menu panel.

    public void insertButtons(JButton b1, JButton b2, JButton b5, JButton b6,
                              JButton b7, JButton b8) {
        insertButton(b1, mainPanel);
        insertButton(b2, mainPanel);
        insertButton(b5, mainPanel);
        insertButton(b6, mainPanel);
        insertButton(b7, mainPanel);
        insertButton(b8, mainPanel);
    }

    //MODIFIES:this
    //EFFECTS:Sets action commands to the buttons.

    public void performButton() {
        b1.addActionListener(this);
        b1.setActionCommand("View Current Accounts");
        b2.addActionListener(this);
        b2.setActionCommand("Create and add your new account");
        b5.addActionListener(this);
        b5.setActionCommand("Save account to file");
        b6.addActionListener(this);
        b6.setActionCommand("load accounts to file");
        b7.addActionListener(this);
        b7.setActionCommand("Exit banking application");
        b8.addActionListener(this);
        b8.setActionCommand("Delete Bank Account");
    }
    //EFFECTS: Checks the action commands when a button is clicked and then calls the functions
    // responsible for performing the operations of the button

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().equals("View Current Accounts")) {
            makeAccountsPanel();
        } else if (a.getActionCommand().equals("Create and add your new account")) {
            initializeAccPanel();
        } else if (a.getActionCommand().equals("Add your new account")) {
            addToList();
        } else if (a.getActionCommand().equals("Save account to file")) {
            saveAcc();
        } else if (a.getActionCommand().equals("Return to main menu")) {
            comeToMainMenu();
        } else if (a.getActionCommand().equals("load accounts to file")) {
            loadAcc();
        } else if (a.getActionCommand().equals("Exit banking application")) {
            System.exit(0);
        } else if (a.getActionCommand().equals("Delete Bank Account")) {
            deleteAcc(account);
        }
    }
    //EFFECTS:Performs the function of the return to main menu button where except for the main menu
    // panel all other panels are set tp false

    public void comeToMainMenu() {
        mainPanel.setVisible(true);
        panelAcc.setVisible(false);
        listingsAcc.setVisible(false);
    }
    //MODIFIES: this
    //EFFECTS:Creates the panel that allows the user to input details of their new account

    public void inputAccPanel() {

        listingsAcc = new JPanel(new GridLayout(0, 2));
        JButton mainMenuButton = new JButton("Return to main menu");
        mainMenuButton.setActionCommand("Return to main menu");
        mainMenuButton.addActionListener(this);
        insertButton(mainMenuButton, listingsAcc);
        createAccDisplayPage();
        addLabelsToDisplay();
    }
//EFFECTS:Initialises the panel for inputting the details of account while setting other panels to false
// so user can only view the necessary panel.

    public void initializeAccPanel() {
        add(listingsAcc);
        listingsAcc.setVisible(true);
        mainPanel.setVisible(false);
        panelAcc.setVisible(false);
    }
    //MODIFIES: this
    //EFFECTS: Creates the labels and boxes for the user to type in his required information for creating the account

    public void createAccDisplayPage() {

        addAcc = new JButton("Add Account to list of accounts");
        addAcc.setActionCommand("Add your new account");
        addAcc.addActionListener(this);

        email = new JLabel("Email ID:");
        a1 = new JTextField(10);
        password = new JLabel("Password:");
        a2 = new JTextField(10);
        name = new JLabel("name:");
        a3 = new JTextField(10);
        address = new JLabel("Address:");
        a4 = new JTextField(10);
        mobileNumber = new JLabel("Mobile Number:");
        a5 = new JTextField(10);
        sin = new JLabel("Social Insurance Number");
        a6 = new JTextField(10);
        bankBalance = new JLabel("Initial money deposit");
        a7 = new JTextField(10);

        addAcc.setBackground(Color.BLACK);
        addAcc.setForeground(Color.BLACK);
        addAcc.setFont(new Font("Arial", Font.BOLD, 10));
        setLabel();
    }

    //MODIFIES: this
    //EFFECTS: Sets the parameters for designing the different labels adjoining to their respective text boxes on the
    // inputAcc panel

    public void setLabel() {
        email.setFont(new Font("Arial", Font.BOLD, 20));
        password.setFont(new Font("Arial", Font.BOLD, 20));
        name.setFont(new Font("Arial", Font.BOLD, 20));
        address.setFont(new Font("Arial", Font.BOLD, 20));
        mobileNumber.setFont(new Font("Arial", Font.BOLD, 20));
        sin.setFont(new Font("Arial", Font.BOLD, 20));
        bankBalance.setFont(new Font("Arial", Font.BOLD, 20));

    }
    //MODIFIES: this
    // EFFECTS: Adds the user input labels and boxes to the required panel

    public void addLabelsToDisplay() {
        listingsAcc.add(addAcc);
        listingsAcc.add(email);
        listingsAcc.add(a1);
        listingsAcc.add(password);
        listingsAcc.add(a2);
        listingsAcc.add(name);
        listingsAcc.add(a3);
        listingsAcc.add(address);
        listingsAcc.add(a4);
        listingsAcc.add(mobileNumber);
        listingsAcc.add(a5);
        listingsAcc.add(sin);
        listingsAcc.add(a6);
        listingsAcc.add(bankBalance);
        listingsAcc.add(a7);

    }

    // MODIFIES: this
    // EFFECTS: Adds the new account into the ListOfBankAccounts object to be displayed
    //HTML used due to linebreak error through normal printing of strings. Code syntax referred from https://docs.oracle.com/javase/tutorial/uiswing/components/html.html

    public void addToList() {
        try {
            account = new BankAccount(a1.getText(), a2.getText(), a3.getText(),
                    a4.getText(), a5.getText(), a6.getText(), Double.parseDouble(a7.getText()));
            accList.addAccount(account);
            accounts.setText("<html><pre>Current Accounts: \n" + accList.descriptionAcc() + "\n</pre></html>");

        } catch (NumberFormatException e) {
            System.out.println("Invalid entry!");
        }

    }
// MODIFIES: this
// EFFECTS: Creates the panel that displays the current  bank accounts

    public void showBankAccounts() {
        JLabel image = new JLabel();
        JLabel image2 = new JLabel();
        panelAcc = new JPanel(new GridLayout(2, 2));
        JScrollPane scroll = new JScrollPane(accounts, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JButton mainMenuObject = new JButton("Return to main menu");
        mainMenuObject.setActionCommand("Return to main menu");
        mainMenuObject.addActionListener(this);
        insertButton(mainMenuObject, panelAcc);
        addImage("./data/c.png", image);
        addImage("./data/image004.png", image2);

        accounts.setFont(new Font("ComicSans", Font.BOLD, 12));
        panelAcc.add(scroll);
    }
//MODIFIES: this
//EFFECTS: Adds images on the panelAcc panel.

    public void addImage(String file, JLabel j) {
        j.setIcon(new ImageIcon(file));
        panelAcc.add(j);

    }
//EFFECTS: Adds the current accounts panel to the screen and sets the other ones false so the user can only view the
// necessary panel

    public void makeAccountsPanel() {
        add(panelAcc);
        panelAcc.setVisible(true);
        mainPanel.setVisible(false);
        listingsAcc.setVisible(false);
    }
    // MODIFIES: this
    // EFFECTS: Removes the latest added account to the list of accounts by the user and displays a
    // message in the console
    //HTML Code syntax referred from https://docs.oracle.com/javase/tutorial/uiswing/components/html.html


    public void deleteAcc(BankAccount acc) {

        try {
            accList.delAccount(acc);
            accounts.setText("<html><pre>Current Accounts: \n" + accList.descriptionAcc() + "\n</pre></html>");
            System.out.println("The account is no longer listed");
        } catch (NullPointerException e) {
            System.out.println("Please add an account before attempting to remove it");
        }
    }


    // MODIFIES: this
    // EFFECTS: loads the accounts from work-acc.json file if any account exists, otherwise prints error
    //HTML Code syntax referred from https://docs.oracle.com/javase/tutorial/uiswing/components/html.html

    private void loadAcc() {
        try {
            this.accList = jsonReader.read();
            accounts.setText("<html><pre>Existing Accounts: \n" + accList.descriptionAcc() + "\n</pre></html>");
            System.out.println("Listings loaded from file " + DATA_WORK_ACC_JSON);
        } catch (IOException e) {
            accounts.setText("No Listings added yet");
        }
    }
// EFFECTS: saves new state of file after changes were made to it

    private void saveAcc() {
        try {
            jsonWriter.open();
            jsonWriter.write(accList);
            jsonWriter.close();
            System.out.println("Accounts saved to file ");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("Please initialize accounts file before proceeding");
        }
    }
}














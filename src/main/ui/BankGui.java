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

    private JButton b3;
    private JButton b4;
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

//EFFECTS: Constructs The GUI JFrame of the Banking Application
    public BankGui() {
        super("Banking App");
        jsonWriter = new JsonWriter(DATA_WORK_ACC_JSON);
        jsonReader = new JsonReader(DATA_WORK_ACC_JSON);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        menuMaker();
        showBankAccounts();
        inputAccPanel();
        JLabel introLabel = new JLabel("Welcome to Bank of British Columbia");
        JLabel desktop = new JLabel();
        insert(introLabel);
        imageOnMenu(desktop);
        createPanelObjects();
        insertButtons(b1, b2, b3, b4, b5, b6, b7,b8);
        performButton();
        mainPanel.setVisible(true);
    }
//EFFECTS: Constructs the panel that constitutes of the main menu and sets its background color.

    public void menuMaker() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.CYAN);
        add(mainPanel);
        accounts = new JLabel();
        accounts.setText("No accounts available");
    }

//EFFECTS: Initialises the buttons that lie on the main menu panel.
    public void createPanelObjects() {
        b1 = new JButton("View current accounts");
        b2 = new JButton("Create your new account");
        b3 = new JButton("Add account to list");
        b4 = new JButton("Return to main menu");
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
//EFFECTS: Places a call to insertButton for each required button on the main menu panel.

    public void insertButtons(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5, JButton b6,
                              JButton b7,JButton b8) {
        insertButton(b1, mainPanel);
        insertButton(b2, mainPanel);
        insertButton(b3, mainPanel);
        insertButton(b4, mainPanel);
        insertButton(b5, mainPanel);
        insertButton(b6, mainPanel);
        insertButton(b7, mainPanel);
        insertButton(b8, mainPanel);
    }
    // EFFECTS: Creates a button and adds it to the given panel different from main menu by changing the
    // color and text of the button from those on the main menu

    public void addOnMainMenu(JButton button1, JPanel panel) {
        button1.setFont(new Font("Arial", Font.BOLD, 12));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.BLACK);
        panel.add(button1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
//EFFECTS: Creates the text label that displays the Welcome message on the main menu panel.

    public void insert(JLabel j) {
        j.setFont(new Font("Arial", Font.BOLD, 25));
        mainPanel.add(j);
    }
    //EFFECTS: displays the bank image on the main menu panel

    public void imageOnMenu(JLabel j) {
        j.setIcon(new ImageIcon("./data/bank.jpeg"));
        j.setMinimumSize(new Dimension(20, 20));
        mainPanel.add(j);
    }
    //MODIFIES:this
    //EFFECTS:Sets action commands to the buttons.

    public void performButton() {
        b1.addActionListener(this);
        b1.setActionCommand("View Current Accounts");
        b2.addActionListener(this);
        b2.setActionCommand("Create and add your new account");
        b3.addActionListener(this);
        b3.setActionCommand("Add your new account");
        b4.addActionListener(this);
        b4.setActionCommand("Return to main menu");
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
            comeBack();
        } else if (a.getActionCommand().equals("load accounts to file")) {
            loadAcc();
        } else if (a.getActionCommand().equals("Exit banking application")) {
            System.exit(0);
        } else if (a.getActionCommand().equals("Delete Bank Account")) {
            deleteAcc(account);
        }
    }
    //MODIFIES: this
    //EFFECTS:Creates the panel that allows the user to input details of their new account

    public void inputAccPanel() {

        listingsAcc = new JPanel(new GridLayout(0, 2));
        JButton mainMenuButton = new JButton("Return to main menu");
        mainMenuButton.setActionCommand("Return to main menu");
        mainMenuButton.addActionListener(this);
        addOnMainMenu(mainMenuButton, listingsAcc);
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
        displayLabelSettings();
    }

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
    // EFFECTS: Changes attributes of the labels and text fields

    public void displayLabelSettings() {
        addAcc.setBackground(Color.BLACK);
        addAcc.setForeground(Color.BLACK);
        addAcc.setFont(new Font("Arial", Font.BOLD, 10));

        email.setFont(new Font("ComicSans", Font.BOLD, 20));
        password.setFont(new Font("ComicSans", Font.BOLD, 20));
        name.setFont(new Font("ComicSans", Font.BOLD, 20));
        address.setFont(new Font("ComicSans", Font.BOLD, 20));
        mobileNumber.setFont(new Font("ComicSans", Font.BOLD, 20));
        sin.setFont(new Font("ComicSans", Font.BOLD, 20));
        bankBalance.setFont(new Font("ComicSans", Font.BOLD, 20));


        a1.setMaximumSize(new Dimension(1000, 300));
        a2.setMaximumSize(new Dimension(1000, 300));
        a3.setMaximumSize(new Dimension(1000, 300));
        a4.setMaximumSize(new Dimension(1000, 300));
        a5.setMaximumSize(new Dimension(1000, 300));
        a6.setMaximumSize(new Dimension(1000, 300));
        a7.setMaximumSize(new Dimension(1000, 300));
    }
    // MODIFIES: this
    // EFFECTS: Adds the new account into the ListOfBankAccounts object to be displayed
    //HTML Code syntax referred from https://docs.oracle.com/javase/tutorial/uiswing/components/html.html

    public void addToList() {
        try {
            account = new BankAccount(a1.getText(), a2.getText(), a3.getText(),
                    a4.getText(), a5.getText(), a6.getText(), Double.parseDouble(a7.getText()));
            accList.addAccount(account);
            accounts.setText("<html><pre>Current Accounts: \n" + accList.descriptionAcc() + "\n</pre></html>");

        } catch (NumberFormatException e) {
            System.out.println("Invalid entry!");
        } catch (IndexOutOfBoundsException e) {
            accounts.setText("Please initialize accounts file before proceeding");
        }

    }
// MODIFIES: this
// EFFECTS: Creates the panel that displays the current  bank accounts

    public void showBankAccounts() {
        JLabel image = new JLabel();
        JLabel image2 = new JLabel();
        panelAcc = new JPanel(new GridLayout(2, 2));
        JScrollPane scroll = new JScrollPane(accounts, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton mainMenuObject = new JButton("Return to main menu");
        mainMenuObject.setActionCommand("Return to main menu");
        mainMenuObject.addActionListener(this);
        addOnMainMenu(mainMenuObject, panelAcc);

        image.setIcon(new ImageIcon("./data/c.png"));
        image.setMinimumSize(new Dimension(20,20));
        panelAcc.add(image);

        image2.setIcon(new ImageIcon("./data/image004.png"));
        image2.setMinimumSize(new Dimension(20,20));
        panelAcc.add(image2);

        accounts.setFont(new Font("ComicSans", Font.BOLD, 12));
        panelAcc.add(scroll);
    }
//EFFECTS: Adds the  current accounts panel to the screen and sets the other ones false so the user can only view the
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

    public void deleteAcc(BankAccount acc) {

        try {
            accList.delAccount(acc);
            accounts.setText("<html><pre>Current Accounts: \n" + accList.descriptionAcc() + "\n</pre></html>");
            System.out.println("The account is no longer listed");
        } catch (NullPointerException e) {
            System.out.println("Please add an account before attempting to remove it");
        } catch (IndexOutOfBoundsException e) {
            accounts.setText("Initialise file");
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
        } catch (IndexOutOfBoundsException e) {
            accounts.setText("Please initialize listings file before proceeding");
        }
    }
// EFFECTS: saves new state of file after changes were made to it

    private void saveAcc() {
        try {
            jsonWriter.open();
            jsonWriter.write(accList);
            jsonWriter.close();
            System.out.println("Accounts saved to file ");
        } catch (NullPointerException e) {
            System.out.println("Please load the file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // EFFECTS: Performs the function of the return to main menu button where except for the main menu
    // panel all other panels are set to false

    public void comeBack() {
        mainPanel.setVisible(true);
        panelAcc.setVisible(false);
        listingsAcc.setVisible(false);
    }


}














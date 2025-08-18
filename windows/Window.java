package windows;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import functions.AccountManager;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame {
    AccountManager account_manager = new AccountManager();

    JLabel jl_agency = new JLabel("Código da Agência");
    JTextField jtf_agency = new JTextField();

    JLabel jl_account = new JLabel("Número da Conta");
    JTextField jtf_account = new JTextField();

    JSeparator jseparator01 = new JSeparator();

    JLabel jl_name = new JLabel("Nome: ");
    JTextField jtf_name = new JTextField();

    JLabel jl_address = new JLabel("Endereço: ");
    JTextField jtf_address = new JTextField();

    JLabel jl_phone = new JLabel("Telefone: ");
    JTextField jtf_phone = new JTextField();

    JLabel jl_cpf = new JLabel("CPF: ");
    JTextField jtf_cpf = new JTextField();

    JRadioButton jrb_checking_account = new JRadioButton("Conta Corrente");
    JRadioButton jrb_savings_account = new JRadioButton("Conta Poupança");
    ButtonGroup bg_account_type = new ButtonGroup();

    JSeparator jseparator02 = new JSeparator();

    JButton jb_consult = new JButton("Consultar");
    JButton jb_update = new JButton("Atualizar");
    JButton jb_create = new JButton("Criar");

    // Constructor method
    Window() {
        super("Java Swing - Desenvolvimento de Sistemas");
        setSize(400, 275);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Add listeners
        ActionListener form_update_listener = e -> {
            System.out.println("Update");
            updateButtons();
        };  
        DocumentListener text_field_update_listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Update Text");
                updateButtons();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Update Text");
                updateButtons();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                return;
            }
        };
        // Setting size and position of elements
        jl_agency.setBounds(10, 10, 110, 18);
        jtf_agency.setBounds(125, 10, 50, 20);

        jl_account.setBounds(205, 10, 105, 18);
        jtf_account.setBounds(315, 10, 60, 20);

        jseparator01.setBounds(10,40,365,10);

        // Name
        jl_name.setBounds(10,50,60,18);
        jl_name.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf_name.setBounds(75,50,300,20);

        // Address
        jl_address.setBounds(10,75,60,18);
        jl_address.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf_address.setBounds(75,75,300,20);

        // Phone
        jl_phone.setBounds(10,100, 60,18);
        jl_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf_phone.setBounds(75,100,300,20);

        // Cpf
        jl_cpf.setBounds(10,125, 60,18);
        jl_cpf.setHorizontalAlignment(SwingConstants.RIGHT);
        jtf_cpf.setBounds(75,125,300,20);

        // Radio buttons
        jrb_checking_account.setBounds(100,150,111,20);
        jrb_checking_account.setSelected(true);
        jrb_checking_account.setMnemonic(KeyEvent.VK_C);

        jrb_savings_account.setBounds(225, 150, 118, 20);
        jrb_savings_account.setMnemonic(KeyEvent.VK_P);

        bg_account_type.add(jrb_checking_account);
        bg_account_type.add(jrb_savings_account);

        jseparator02.setBounds(10,180,365,10);
        
        // Consult, update and close buttons
        jb_consult.setBounds(35,190,100,23);
        jb_consult.setMnemonic(KeyEvent.VK_S);

        jb_update.setBounds(145,190,100,23);
        jb_update.setMnemonic(KeyEvent.VK_A);
        jb_update.setEnabled(false);

        jb_create.setBounds(255,190,100,23);
        jb_create.setMnemonic(KeyEvent.VK_C);

        jtf_agency.getDocument().addDocumentListener(text_field_update_listener);
        jtf_account.getDocument().addDocumentListener(text_field_update_listener);
        jtf_name.getDocument().addDocumentListener(text_field_update_listener);
        jtf_address.getDocument().addDocumentListener(text_field_update_listener);
        jtf_phone.getDocument().addDocumentListener(text_field_update_listener);
        jtf_cpf.getDocument().addDocumentListener(text_field_update_listener);
        jrb_checking_account.addActionListener(form_update_listener);
        jrb_savings_account.addActionListener(form_update_listener);

        getContentPane().add(jl_agency);
        getContentPane().add(jtf_agency);
        
        getContentPane().add(jl_account);
        getContentPane().add(jtf_account);
        
        getContentPane().add(jseparator01);
        
        getContentPane().add(jl_name);
        getContentPane().add(jtf_name);

        getContentPane().add(jl_address);
        getContentPane().add(jtf_address);
        
        getContentPane().add(jl_phone);
        getContentPane().add(jtf_phone);

        getContentPane().add(jl_cpf);
        getContentPane().add(jtf_cpf);

        getContentPane().add(jrb_checking_account);
        getContentPane().add(jrb_savings_account);

        getContentPane().add(jseparator02);

        getContentPane().add(jb_consult);
        getContentPane().add(jb_update);
        getContentPane().add(jb_create);
    }

    private void updateButtons() {
        int agency = Integer.parseInt(jtf_agency.getText());
        int account_number = Integer.parseInt(jtf_account.getText());

        // Query if the account exists
        boolean account_exists = account_manager.queryAccount(agency, account_number);

        if (account_exists) {
            jb_create.setEnabled(true);
            jb_update.setEnabled(false);
        } else {
            jb_create.setEnabled(false);
            jb_update.setEnabled(true);
        }

    }

    private void createAccount() {
        int agency = Integer.parseInt(jtf_agency.getText());
        int account_number = Integer.parseInt(jtf_account.getText());

        String name = jtf_name.getText();
        String phone = jtf_phone.getText();
        String address = jtf_address.getText();
        String cpf = jtf_address.getText();

        AccountManager.AccountType account_type;
        if (jrb_checking_account.isSelected()) {
            account_type = AccountManager.AccountType.CHECKING;
        } else {
            account_type = AccountManager.AccountType.SAVINGS;
        }

        account_manager.createAccount(agency, account_number, name, address, phone, cpf, account_type);
    }

    private void updateAccount() {
        int agency = Integer.parseInt(jtf_agency.getText());
        int account_number = Integer.parseInt(jtf_account.getText());

        String name = jtf_name.getText();
        String phone = jtf_phone.getText();
        String address = jtf_address.getText();
        String cpf = jtf_address.getText();

        AccountManager.AccountType account_type;
        if (jrb_checking_account.isSelected()) {
            account_type = AccountManager.AccountType.CHECKING;
        } else {
            account_type = AccountManager.AccountType.SAVINGS;
        }

        account_manager.updateAccount(agency, account_number, name, address, phone, cpf, account_type);
    }

    private void queryAccount() {
        // Check if the account exists
    }

    private void centralize() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension window_size = getSize();

        if (window_size.height > screen.height) {
            setSize(window_size.width, screen.height);
        }
            
        if (window_size.width > screen.width) {
            setSize(screen.width, window_size.height);
        }

        setLocation((screen.width - window_size.width) / 2,
                    (screen.height - window_size.height) / 2
        );
    }

    public static void main(String args[]) {
        Window window = new Window();
        window.setVisible(true);

        window.centralize();
    }
}
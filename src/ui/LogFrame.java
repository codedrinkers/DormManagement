package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import connection.Connector;
import model.Administrater;

public class LogFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JLabel name = new JLabel("–’√˚£∫");
    private JLabel paswd = new JLabel("√‹¬Î£∫");
    private JLabel welcm = new JLabel("ª∂”≠Ω¯»ÎÀﬁ…·π‹¿ÌœµÕ≥");
    private JTextField IDText = new JTextField();
    private JPasswordField pasText = new JPasswordField();
    private JButton login = new JButton("µ«¬Ω");
    private JButton reset = new JButton("÷ÿ÷√");
    private Connector conn = new Connector("jdbc:sqlserver://localhost:1433;DatabaseName=", "sa", "", "DormManagement");
    private List tmp;

    public LogFrame() {
        super("Àﬁ…·π‹¿ÌœµÕ≥");
        this.setSize(300, 250);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.loadComponet();
        this.setLocationRelativeTo(null);
    }

    public void loadComponet() {
        this.add(welcm);
        welcm.setBounds(50, 20, 200, 30);
        welcm.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));

        this.add(name);
        name.setBounds(50, 70, 50, 30);
        name.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));

        this.add(paswd);
        paswd.setBounds(50, 110, 50, 30);
        paswd.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));

        this.add(IDText);
        IDText.setBounds(100, 70, 150, 30);
        IDText.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));

        this.add(pasText);
        pasText.setBounds(100, 110, 150, 30);
        pasText.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));

        this.add(login);
        login.setBounds(60, 160, 80, 30);
        login.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 14));
        login.setFocusable(false);
        login.addActionListener(this);

        this.add(reset);
        reset.setBounds(170, 160, 80, 30);
        reset.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 14));
        reset.setFocusable(false);
        reset.addActionListener(this);
    }

    public static void main(String[] args) {
        new LogFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            tmp = conn.query("*", "ADMINISTRATER");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if (e.getSource() == login) {
            boolean isLogin = true;
            for (Object admin : tmp) {
                if (IDText.getText().equals(((Administrater) admin).getEMPNO())) {

                    if (String.valueOf(pasText.getPassword()).equals(((Administrater) admin).getEMPPASWD())) {
                        isLogin = false;
                        MainFrame MF = new MainFrame();
                        MF.setLocationRelativeTo(this);
                    } else
                        JOptionPane.showMessageDialog(null, "√‹¬Î¥ÌŒÛ", "æØ∏Ê", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (isLogin) {
                JOptionPane.showMessageDialog(null, "’ ∫≈≤ª¥Ê‘⁄", "æØ∏Ê", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == reset) {
            IDText.setText(null);
            pasText.setText(null);
        }
    }

}

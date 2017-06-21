package ui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel title = new JLabel("宿舍管理系统");

    public MainFrame() {
        super("宿舍管理系统");
        this.setSize(1024, 678);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.loadComponet();       
    }

    public void loadComponet() {
        title.setBounds(412, 120, 200, 30);
        title.setFont(new Font("微软雅黑", Font.BOLD, 26));
        this.add(title);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}

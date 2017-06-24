package ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SelectFrame extends JFrame{

    private static final long serialVersionUID = 1L;
    private JScrollPane jsp;
    private JTable tab;

    public SelectFrame() {
        this(new String[][] { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
                 { "", "", "", "", "" },  }, new String[] { "1", "2", "3", "4", "5" });

    }

    public SelectFrame(Object[][] culomn, Object[] name) {
        super("²éÑ¯½á¹û");
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(500, 350);
        this.tab = new JTable(culomn, name);
        this.tab.setEnabled(false);
        this.jsp = new JScrollPane(tab);
        this.jsp.setBounds(0, 10, 500, 300);
        this.add(jsp);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new SelectFrame();
    }

}

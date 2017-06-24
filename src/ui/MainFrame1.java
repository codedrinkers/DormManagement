package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import connection.Connector;
import model.Student;

public class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JPanel jPanel1;
    private JPanel jPanel4;
    private JTabbedPane jTabbedPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private Connector conn = new Connector("jdbc:sqlserver://localhost:1433;DatabaseName=", "sa", "", "DormManagement");
    private List tmp;
    private String[] name = { "学号", "性别", "姓名", "专业", "入学年份", "班级", "楼号", "宿舍号", };

    public MainFrame() {
        super("宿舍管理系统");
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(503, 500);
        this.setVisible(true);
    }

    private void initComponents() {

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jButton2 = new JButton();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jButton3 = new JButton();
        jLabel5 = new JLabel();
        jTextField4 = new JTextField();
        jButton4 = new JButton();
        jPanel4 = new JPanel();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jLabel8 = new JLabel();
        jTextField5 = new JTextField();
        jLabel14 = new JLabel();
        jTextField6 = new JTextField();
        jLabel15 = new JLabel();
        jTextField7 = new JTextField();
        jLabel16 = new JLabel();
        jTextField8 = new JTextField();
        jLabel17 = new JLabel();
        jTextField9 = new JTextField();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jTextField10 = new JTextField();
        jTextField11 = new JTextField();
        jTextField12 = new JTextField();
        jLabel6 = new JLabel();
        jLabel1 = new JLabel();

        jTabbedPane1.setFont(new java.awt.Font("微软雅黑", 0, 12));

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel2.setText("按姓名查询：");

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton1.setText("查询");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel3.setText("按学号查询：");

        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton2.setText("查询");

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel4.setText("按年级查询：");

        jButton3.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton3.setText("查询");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel5.setText("按宿舍查询：");

        jButton4.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton4.setText("查询");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(64, 64, 64).addGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(83, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(63, 63, 63)));

        jTabbedPane1.addTab("查询学生信息", jPanel1);

        jButton5.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton5.setText("提交");
        jButton5.setPreferredSize(new java.awt.Dimension(80, 30));

        jButton6.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jButton6.setText("重置");
        jButton6.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel8.setText("学号：");

        jLabel14.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel14.setText("性别：");

        jLabel15.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel15.setText("*班级：");

        jLabel16.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel16.setText("楼号：");

        jLabel17.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel17.setText("专业：");

        jLabel18.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel18.setText("姓名：");

        jLabel19.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel19.setText("入学年份：");

        jLabel20.setFont(new java.awt.Font("微软雅黑", 0, 14));
        jLabel20.setText("宿舍号：");

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 16));
        jLabel6.setText("请录入学生信息（*可以为空）");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout
                        .createSequentialGroup().addGap(39, 48, Short.MAX_VALUE).addGroup(jPanel4Layout
                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(
                                        jPanel4Layout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel16, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 128,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField8,
                                                                GroupLayout.PREFERRED_SIZE, 128,
                                                                GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField5, GroupLayout.Alignment.TRAILING,
                                                        GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField6, GroupLayout.Alignment.TRAILING,
                                                        GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel20)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                                                jTextField11, GroupLayout.PREFERRED_SIZE, 128,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING,
                                        jPanel4Layout.createSequentialGroup().addComponent(jLabel19)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 128,
                                                        GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING,
                                                jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel17, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 128,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel18)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 128,
                                                        GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45))
                .addGroup(GroupLayout.Alignment.TRAILING,
                        jPanel4Layout.createSequentialGroup().addGap(102, 102, 102)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel6)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                jPanel4Layout.createSequentialGroup().addGap(33, 33, 33).addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

        jTabbedPane1.addTab("增加学生信息", jPanel4);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 18));
        jLabel1.setText("宿舍信息管理系统");

        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jButton3.setFocusable(false);
        jButton4.setFocusable(false);
        jButton5.setFocusable(false);
        jButton6.setFocusable(false);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(177, 177, 177).addComponent(jLabel1).addGap(177, 177,
                        177))
                .addComponent(jTabbedPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 498,
                        GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[][] temp;
        if (e.getSource() == jButton1) {// 按学号查询

            System.out.println(jTextField3.getText());

            if (!"".equals(jTextField3.getText())) {
                try {
                    tmp = conn.query("SNO,SSEX,SNAME,SMAJOR,SGRADE,SCLASS,SBNO,SDNO", "STUDENT",
                            "SNO = " + jTextField3.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "没有此人", "警告", JOptionPane.WARNING_MESSAGE);
                }

                if (tmp.size() > 0) {
                    temp = new String[tmp.size()][];

                    for (int i = 0; i < tmp.size(); i++) {
                        temp[i] = ((Student) tmp.get(i)).toArray();
                    }

                    SelectFrame tmp = new SelectFrame(temp, name);
                    tmp.setLocationRelativeTo(this);
                } else {
                    JOptionPane.showMessageDialog(null, "没有此人", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请填写内容", "警告", JOptionPane.WARNING_MESSAGE);
            }
            temp = null;
        }
        if (e.getSource() == jButton2) { // 按姓名查询

            System.out.println(jTextField1.getText());

            if (!"".equals(jTextField1.getText())) {
                try {
                    tmp = conn.query("SNO,SSEX,SNAME,SMAJOR,SGRADE,SCLASS,SBNO,SDNO", "STUDENT",
                            "SNAME = " + jTextField1.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "没有此人", "警告", JOptionPane.WARNING_MESSAGE);
                }

                if (tmp.size() > 0) {
                    temp = new String[tmp.size()][];

                    for (int i = 0; i < tmp.size(); i++) {
                        temp[i] = ((Student) tmp.get(i)).toArray();
                    }

                    SelectFrame tmp = new SelectFrame(temp, name);
                    tmp.setLocationRelativeTo(this);
                } else {
                    JOptionPane.showMessageDialog(null, "没有此人", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请填写内容", "警告", JOptionPane.WARNING_MESSAGE);
            }
            temp = null;
        }
        if (e.getSource() == jButton3) {// 年级
            System.out.println(jTextField2.getText());

            if (!"".equals(jTextField2.getText())) {
                try {
                    tmp = conn.query("SNO,SSEX,SNAME,SMAJOR,SGRADE,SCLASS,SBNO,SDNO", "STUDENT",
                            "SGRADE = " + jTextField2.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "该年级没有人", "警告", JOptionPane.WARNING_MESSAGE);
                }

                if (tmp.size() > 0) {
                    temp = new String[tmp.size()][];

                    for (int i = 0; i < tmp.size(); i++) {
                        temp[i] = ((Student) tmp.get(i)).toArray();
                    }

                    SelectFrame tmp = new SelectFrame(temp, name);
                    tmp.setLocationRelativeTo(this);
                } else {
                    JOptionPane.showMessageDialog(null, "该年级没有人", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请填写内容", "警告", JOptionPane.WARNING_MESSAGE);
            }
            temp = null;
        }
        if (e.getSource() == jButton4) {// 宿舍
            System.out.println(jTextField4.getText());

            if (!"".equals(jTextField4.getText())) {
                try {
                    tmp = conn.query("*", "STUDENT", "SDNO = " + jTextField4.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "该宿舍没有人", "警告", JOptionPane.WARNING_MESSAGE);
                }

                if (tmp.size() > 0) {
                    temp = new String[tmp.size()][];

                    for (int i = 0; i < tmp.size(); i++) {
                        temp[i] = ((Student) tmp.get(i)).toArray();
                    }

                    SelectFrame tmp = new SelectFrame(temp, name);
                    tmp.setLocationRelativeTo(this);
                } else {
                    JOptionPane.showMessageDialog(null, "该宿舍没有人", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请填写内容", "警告", JOptionPane.WARNING_MESSAGE);
            }
            temp = null;
        }

        if (e.getSource() == jButton5) {
            System.out.println("学号" + jTextField5.getText());
            System.out.println("姓名" + jTextField9.getText());
            System.out.println("性别" + jTextField6.getText());
            System.out.println("专业" + jTextField10.getText());
            System.out.println("班级" + jTextField8.getText());
            System.out.println("入学年份" + jTextField12.getText());
            System.out.println("楼号" + jTextField7.getText());
            System.out.println("宿舍号" + jTextField11.getText());
            if (!("".equals(jTextField5.getText()) || "".equals(jTextField9.getText())
                    || "".equals(jTextField6.getText()) || "".equals(jTextField10.getText())
                    || "".equals(jTextField12.getText()) || "".equals(jTextField7.getText())
                    || "".equals(jTextField11.getText()))) {
                Student stu = new Student();
                stu.setSNO(jTextField5.getText());
                stu.setSNAME(jTextField9.getText());
                stu.setSSEX(jTextField6.getText());
                stu.setSMAJOR(jTextField10.getText());
                stu.setSCLASS(jTextField8.getText());
                stu.setSGRADE(jTextField12.getText());
                stu.setSBNO(jTextField7.getText());
                stu.setSDNO(jTextField11.getText());
            } else {
                JOptionPane.showMessageDialog(null, "请填写内容", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == jButton6) {
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            jTextField12.setText("");
        }
    }

    public static void main(String args[]) {
        new MainFrame();
    }

}

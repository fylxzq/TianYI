package com.fy.tianyi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 */
public class StartSwing extends JDialog implements ActionListener{
    private static final long serialVersionUID = 1L;

    private final JPanel content_panel = new JPanel();
    private JTextField appkey_field;
    private JTextField appsecret_field;
    private JTextField productID_field;
    private JTextField DeviceID_field;
    private JButton btn_query;
    private JButton btn_motorcontrol;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            StartSwing dialog = new StartSwing();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Create the dialog.
     */
    public StartSwing() {
        setTitle("天翼数据监控客户端");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        setBounds(100, 100, 531, 261);
        getContentPane().setLayout(new BorderLayout());
        content_panel.setBackground(Color.WHITE);
        content_panel.setBorder(new LineBorder(SystemColor.textHighlight));
        getContentPane().add(content_panel, BorderLayout.CENTER);
        content_panel.setLayout(new BoxLayout(content_panel, BoxLayout.Y_AXIS));

        {
            JPanel panel_appkey = new JPanel();
            panel_appkey.setBackground(Color.WHITE);
            content_panel.add(panel_appkey);
            panel_appkey.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            {
                JLabel label_appkey = new JLabel("   appkey:");
                label_appkey.setHorizontalAlignment(SwingConstants.RIGHT);
                label_appkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                label_appkey.setBackground(Color.WHITE);
                panel_appkey.add(label_appkey);
            }
            {
                appkey_field = new JTextField();
                appkey_field.setHorizontalAlignment(SwingConstants.LEFT);
                appkey_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                panel_appkey.add(appkey_field);
                appkey_field.setColumns(20);
            }
        }
        {
            JPanel panel_appsecret = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_appsecret.setBackground(Color.WHITE);
            content_panel.add(panel_appsecret);
            {
                JLabel label_appsecret= new JLabel("appsecret:");
                label_appsecret.setHorizontalAlignment(SwingConstants.CENTER);
                label_appsecret.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_appsecret.add(label_appsecret);
            }
            {
                appsecret_field = new JTextField();
                appsecret_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                appsecret_field.setHorizontalAlignment(SwingConstants.LEFT);
                appsecret_field.setColumns(20);
                panel_appsecret.add(appsecret_field);
            }
        }
        {
            JPanel panel_productID = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_productID.setBackground(Color.WHITE);
            content_panel.add(panel_productID);
            {
                JLabel label_product = new JLabel("productID:");
                label_product.setHorizontalAlignment(SwingConstants.CENTER);
                label_product.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_productID.add(label_product);
            }
            {
                productID_field = new JTextField();
                productID_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                productID_field.setHorizontalAlignment(SwingConstants.LEFT);
                productID_field.setColumns(20);
                panel_productID.add(productID_field);
            }
        }
        {
            JPanel panel_deviceID = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_deviceID.setBackground(Color.WHITE);
            content_panel.add(panel_deviceID);
            {
                JLabel label_devicdID = new JLabel("  devicdID:");
                label_devicdID.setHorizontalAlignment(SwingConstants.CENTER);
                label_devicdID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_deviceID.add(label_devicdID);
            }
            {
                DeviceID_field = new JTextField();
                DeviceID_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                DeviceID_field.setHorizontalAlignment(SwingConstants.LEFT);
                DeviceID_field.setColumns(20);
                panel_deviceID.add(DeviceID_field);
            }
        }

        {
            JPanel button_pane = new JPanel();
            button_pane.setBackground(Color.WHITE);
            FlowLayout fl_button_pane = new FlowLayout(FlowLayout.CENTER);
            fl_button_pane.setVgap(20);
            fl_button_pane.setHgap(20);
            button_pane.setLayout(fl_button_pane);
            getContentPane().add(button_pane, BorderLayout.SOUTH);
            {
                btn_query = new JButton("数据查询");
                btn_query.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_query.setBackground(Color.WHITE);
                btn_query.setActionCommand("query");
                button_pane.add(btn_query);
                getRootPane().setDefaultButton(btn_query);
                btn_query.addActionListener(this);
            }
            {
                btn_query = new JButton("电机控制");
                btn_query.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_query.setBackground(Color.WHITE);
                btn_query.setActionCommand("control");
                button_pane.add(btn_query);
                getRootPane().setDefaultButton(btn_query);
                btn_query.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*InputUserUtils.appsecret = appsecret_field.getText().trim();
        InputUserUtils.productId  = productID_field.getText().trim();
        InputUserUtils.deviceId = DeviceID_field.getText().trim();
        InputUserUtils.appkey = appkey_field.getText().trim();*/
        boolean lengthjudge = (InputUserUtils.appkey.length()==11) && (InputUserUtils.appsecret.length()==10);
        boolean digitjudge =true;
        try {
            Long.parseLong(InputUserUtils.productId);
        } catch (NumberFormatException numberFormatException) {
            digitjudge = false;
        }
        if(/*lengthjudge && digitjudge*/true) {
            this.setVisible(false);
            if(e.getActionCommand().equals("query")){
                this.setVisible(false);
                DataShowDialog dataShowDialog = new DataShowDialog(this);
                dataShowDialog.setVisible(true);
            }
            else{
                this.setVisible(false);
                MotorControlDialog motorControlDialog = new MotorControlDialog(this);
                System.out.println(motorControlDialog.hashCode());
                motorControlDialog.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(new Panel(), "请检查输入是否有误", "错误",JOptionPane.WARNING_MESSAGE);
        }
    }
}



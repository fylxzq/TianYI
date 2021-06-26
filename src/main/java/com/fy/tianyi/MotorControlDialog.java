package com.fy.tianyi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Classname MotorControlDialog
 * @Description TODO
 * @Date 2021/6/17 16:29
 * @Created by fy
 */

/*
*
* */

public class MotorControlDialog extends JDialog implements ActionListener {

    private final JPanel content_panel = new JPanel();
    //masterkey输入框
    private JTextField materkey_field;
    //控制整型输入框
    private JTextField control_int_field;
    //结果显示框
    private JTextField show_result_field;
    private JButton btn_click;
    private JButton btn_back;
    private StartSwing startSwing;


    public MotorControlDialog(StartSwing startSwing) {
        this.startSwing = startSwing;
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
            //masterkey输入框
            JPanel panel_masterkey = new JPanel();
            panel_masterkey.setBackground(Color.WHITE);
            content_panel.add(panel_masterkey);
            panel_masterkey.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            {
                JLabel label_masterkey = new JLabel("masterkey:");
                label_masterkey.setHorizontalAlignment(SwingConstants.RIGHT);
                label_masterkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                label_masterkey.setBackground(Color.WHITE);
                panel_masterkey.add(label_masterkey);
            }
            {
                materkey_field = new JTextField();
                materkey_field.setHorizontalAlignment(SwingConstants.LEFT);
                materkey_field.setFont(new Font("微软雅黑", Font.PLAIN, 15));
                panel_masterkey.add(materkey_field);
                materkey_field.setColumns(20);
            }
        }
        {
            //控制整型输入框
            JPanel panel_controlint = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_controlint.setBackground(Color.WHITE);
            content_panel.add(panel_controlint);
            {
                JLabel label_controlint = new JLabel("controlint:");
                label_controlint.setHorizontalAlignment(SwingConstants.CENTER);
                label_controlint.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_controlint.add(label_controlint);
            }
            {
                control_int_field= new JTextField();
                control_int_field.setFont(new Font("微软雅黑", Font.PLAIN, 15));
                control_int_field.setHorizontalAlignment(SwingConstants.LEFT);
                control_int_field.setColumns(20);
                panel_controlint.add(control_int_field);
            }
        }
        {
            //结果显示框
            JPanel panel_rst = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_rst.setBackground(Color.WHITE);
            content_panel.add(panel_rst);
            {
                JLabel label_rst = new JLabel("     result:");
                label_rst.setHorizontalAlignment(SwingConstants.CENTER);
                label_rst.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_rst.add(label_rst);
            }
            {
                show_result_field = new JTextField();
                show_result_field.setFont(new Font("微软雅黑", Font.PLAIN, 15));
                show_result_field.setHorizontalAlignment(SwingConstants.LEFT);
                show_result_field.setColumns(20);
                panel_rst.add(show_result_field);
            }
        }
        {
            //确认按钮，点击则实现指令下发
            JPanel button_pane = new JPanel();
            button_pane.setBackground(Color.WHITE);
            FlowLayout fl_button_pane = new FlowLayout(FlowLayout.CENTER);
            fl_button_pane.setVgap(20);
            fl_button_pane.setHgap(20);
            button_pane.setLayout(fl_button_pane);
            getContentPane().add(button_pane, BorderLayout.SOUTH);
            {
                btn_click = new JButton("确认");
                btn_click.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_click.setBackground(Color.WHITE);
                btn_click.setActionCommand("ok");
                button_pane.add(btn_click);
                getRootPane().setDefaultButton(btn_click);
                btn_click.addActionListener(this);
            }
            {
                btn_back = new JButton("返回");
                btn_back.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_back.setBackground(Color.WHITE);
                btn_back.setActionCommand("back");
                button_pane.add(btn_back);
                getRootPane().setDefaultButton(btn_back);
                btn_back.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ok")){
            //接收用户输入的masterkey
            String masterkey = materkey_field.getText().trim();
            //接收用户输入的controlint，并解析程整型
            int control_int = Integer.parseInt(control_int_field.getText().trim());
            //创建向天翼平台发送指令的对象
            CommandUpload uploadcmd = new CommandUpload(masterkey,control_int);
            //调用对象的uploadcommand函数，发送指令并返回指令下发结果的状态码
            int statuscode = uploadcmd.uploadcommand();
            //如果状态码是200即指令发送成功
            if(statuscode==200){
                if(control_int==1){
                    show_result_field.setText("启动指令已发出");
                }
                else{
                    show_result_field.setText("停止指令已发出");
                }
            }
            else{
                JOptionPane.showMessageDialog(new Panel(), "请检查输入是否有误", "错误",JOptionPane.WARNING_MESSAGE);
            }

        }
        else{
            //返回开始的初始界面，和程序启动时创建的对象是同一个
            System.out.println(startSwing.hashCode());
            startSwing.setVisible(true);
            this.dispose();
        }

    }
}


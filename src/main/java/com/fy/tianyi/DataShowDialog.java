package com.fy.tianyi;

import com.fy.tianyi.DeviceStatusReciever;
import com.fy.tianyi.Infomation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Classname DataShowDialog
 * @Description TODO
 * @Date 2021/6/16 20:51
 * @Created by fy
 */

public class DataShowDialog extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;

    private final JPanel content_panel = new JPanel();
    /*
     * 显示数据内容的窗口
     * */
    private JTextField uptime_field;
    private JTextField humidity_field;
    private JTextField temperature_field;
    private JButton btn_click;
    private JButton btn_back;
    private StartSwing startSwing;


    public DataShowDialog(StartSwing startSwing) {
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
            JPanel panel_uptime = new JPanel();
            panel_uptime.setBackground(Color.WHITE);
            content_panel.add(panel_uptime);
            panel_uptime.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            {
                JLabel label_appkey = new JLabel("时间:");
                label_appkey.setHorizontalAlignment(SwingConstants.RIGHT);
                label_appkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                label_appkey.setBackground(Color.WHITE);
                panel_uptime.add(label_appkey);
            }
            {
                uptime_field = new JTextField();
                uptime_field.setHorizontalAlignment(SwingConstants.LEFT);
                uptime_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                panel_uptime.add(uptime_field);
                uptime_field.setColumns(20);
            }
        }
        {
            JPanel panel_temperature = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_temperature.setBackground(Color.WHITE);
            content_panel.add(panel_temperature);
            {
                JLabel label_temperature = new JLabel("温度:");
                label_temperature.setHorizontalAlignment(SwingConstants.CENTER);
                label_temperature.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_temperature.add(label_temperature);
            }
            {
                temperature_field= new JTextField();
                temperature_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                temperature_field.setHorizontalAlignment(SwingConstants.LEFT);
                temperature_field.setColumns(20);
                panel_temperature.add(temperature_field);
            }
        }
        {
            JPanel panel_humidity = new JPanel();
            //FlowLayout flowLayout = (FlowLayout) panel_password.getLayout();
            panel_humidity.setBackground(Color.WHITE);
            content_panel.add(panel_humidity);
            {
                JLabel label_product = new JLabel("湿度:");
                label_product.setHorizontalAlignment(SwingConstants.CENTER);
                label_product.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                panel_humidity.add(label_product);
            }
            {
                humidity_field = new JTextField();
                humidity_field.setFont(new Font("Consolas", Font.PLAIN, 15));
                humidity_field.setHorizontalAlignment(SwingConstants.LEFT);
                humidity_field.setColumns(20);
                panel_humidity.add(humidity_field);
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
                btn_click = new JButton("查询");
                btn_click.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_click.setBackground(Color.WHITE);
                btn_click.setActionCommand("OK");
                button_pane.add(btn_click);
                getRootPane().setDefaultButton(btn_click);
                btn_click.addActionListener(this);
            }

            {
                btn_back = new JButton("返回");
                btn_back.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                btn_back.setBackground(Color.WHITE);
                btn_back.setActionCommand("NO");
                button_pane.add(btn_back);
                getRootPane().setDefaultButton(btn_back);
                btn_back.addActionListener(this);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if(e.getActionCommand().equals("OK")){
                //创建获取天翼平台数据的对象
                DeviceStatusReciever dsr = new DeviceStatusReciever();
                //调用对象的recieveStatus方法，将封装数据的Infomation对象返回
                Infomation info = dsr.recieveStatus();
                //成功获取到对象则在输入框内显示内容

                if(info.getDesc().equals("Ok")){
                    //显示上传时间
                    uptime_field.setText(info.getUptime());
                    //显示温度
                    temperature_field.setText(info.getTemperature()+"");
                    //显示湿度
                    humidity_field.setText(info.getHumidity()+"");
                }
                else{
                    JOptionPane.showMessageDialog(new Panel(), info.getDesc(), "错误",JOptionPane.WARNING_MESSAGE);
                }


            }

            else{
                //返回开始的初始界面，和程序启动时创建的对象是同一个
                System.out.println(startSwing.hashCode());
                startSwing.setVisible(true);
                this.dispose();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(new Panel(), "请检查输入是否有误", "错误",JOptionPane.WARNING_MESSAGE);
        }

    }
}

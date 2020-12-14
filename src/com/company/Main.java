package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.*;

public class Main extends JFrame {
    JTextField axp = new JTextField(10);
    JButton button = new JButton("Удачки");
    Random random = new Random();
    int k = 0, b = random.nextInt(21);
    JFrame frame =new JFrame("Test");

    Main() {
        super("Казино 3 топора");
        setLayout(new FlowLayout());
        setSize(250, 150);
        add(new JLabel("Номер: "));
        add(axp);
        add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.out.println(b);
                if (k < 3) {
                    try {
                        k++;
                        int x = Integer.parseInt(axp.getText().trim());
                        if (x == b) {
                            JOptionPane.showMessageDialog(null, "Your so lucky ", "Win", JOptionPane.INFORMATION_MESSAGE);
                            k = 0;
                            b = random.nextInt(21);
                        } else if (x > b) {
                            JOptionPane.showMessageDialog(null, "Номер проиграл", "No", JOptionPane.INFORMATION_MESSAGE);
                        } else if (x < b) {
                            JOptionPane.showMessageDialog(null, "Попробуй еще  ", "No", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Неправильный номер ", "Воу Воу потише",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (k == 3) {
                    k = 0;
                    b = random.nextInt(21);
                    JOptionPane.showMessageDialog(null, "Ну попробуй позже еще разок:)", "Нет шансов 0_0", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();

    }
}

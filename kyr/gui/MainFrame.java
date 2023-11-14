package kyr.gui;

import kyr.login.LoginMember;
import kyr.gui.Body;
import kyr.gui.Head;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Head head = new Head();
    Body body = new Body(this);

    MainFrame() {
        LoginMember.setLoginMember(null);
        setDesign();
    }

    void setDesign() {
        setTitle("Cookeryket");
        setSize(1280,760);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
}

package Source;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener {

  Server() {
    setTitle("Server");
    setLayout(null);

    JPanel p1 = new JPanel();
    p1.setBackground(new Color(7, 94, 84));
    p1.setBounds(0, 0, 450, 70);
    add(p1);
    p1.setLayout(null);

    // Adding back button
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Group Chatting Icons/3 (1).png"));
    Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel exit = new JLabel(i3);
    exit.setBounds(5, 20, 25, 25);
    p1.add(exit);

    exit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        System.exit(0);
      }
    });

    // Adding profile picture
    ImageIcon i4 = new ImageIcon(
        ClassLoader.getSystemResource("Group Chatting Icons/mirzapur.png"));
    Image i5 = i4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel profile = new JLabel(i6);
    profile.setBounds(40, 10, 25, 50);
    p1.add(profile);

    // Adding Video
    ImageIcon i10 = new ImageIcon(
        ClassLoader.getSystemResource("Group Chatting Icons/video (1).png"));
    Image i11 = i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
    ImageIcon i12 = new ImageIcon(i11);
    JLabel video = new JLabel(i12);
    video.setBounds(300, 20, 30, 30);
    p1.add(video);

    // Adding Phone
    ImageIcon i13 = new ImageIcon(
        ClassLoader.getSystemResource("Group Chatting Icons/phone (1).png"));
    Image i14 = i13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
    ImageIcon i15 = new ImageIcon(i14);
    JLabel phone = new JLabel(i15);
    phone.setBounds(340, 20, 35, 30);
    p1.add(phone);

    // Adding 3 dots
    ImageIcon i16 = new ImageIcon(
        ClassLoader.getSystemResource("Group Chatting Icons/3icon (1).png"));
    Image i17 = i16.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
    ImageIcon i18 = new ImageIcon(i17);
    JLabel dots = new JLabel(i18);
    dots.setBounds(400, 20, 10, 30);
    p1.add(dots);

    JLabel name = new JLabel("Mirzapur");
    name.setBounds(110, 15, 100, 18);
    name.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.BOLD, 16));
    name.setForeground(Color.WHITE);
    p1.add(name);

    JLabel status = new JLabel("Active Now");
    status.setBounds(110, 35, 100, 16);
    status.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.BOLD, 10));
    status.setForeground(Color.WHITE);
    p1.add(status);

    JPanel a1 = new JPanel();
    a1.setBounds(5, 75, 440, 570);
    add(a1);

    JTextField text = new JTextField();
    text.setBounds(5, 655, 310, 40);
    text.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.PLAIN, 16));
    add(text);

    JButton send = new JButton("Send");
    send.setBounds(320, 655, 123, 40);
    send.setBackground(new Color(7, 94, 84));
    send.setForeground(Color.WHITE);
    send.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.PLAIN, 16));
    add(send);

    setSize(450, 700);
    setUndecorated(true);
    setVisible(true);
    setLocation(200, 50);
    getContentPane().setBackground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new Server();
  }

  @Override
  public void actionPerformed(ActionEvent ae) {

  }
}

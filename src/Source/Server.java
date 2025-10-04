package Source;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Server implements ActionListener {

  static DataOutputStream dout;
  static Box vertical = Box.createVerticalBox();
  static JFrame f = new JFrame();
  JTextField text;
  JPanel a1;

  Server() {
    f.setTitle("Server");
    f.setLayout(null);

    JPanel p1 = new JPanel();
    p1.setBackground(new Color(7, 94, 84));
    p1.setBounds(0, 0, 450, 70);
    f.add(p1);
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

    // Adding Name
    JLabel name = new JLabel("Mirzapur");
    name.setBounds(110, 15, 100, 18);
    name.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.BOLD, 16));
    name.setForeground(Color.WHITE);
    p1.add(name);

    // Adding Status
    JLabel status = new JLabel("Active Now");
    status.setBounds(110, 35, 100, 16);
    status.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.BOLD, 10));
    status.setForeground(Color.WHITE);
    p1.add(status);

    // Adding message area
    a1 = new JPanel();
    a1.setBounds(5, 75, 440, 570);
    f.add(a1);

    // Adding text field
    text = new JTextField();
    text.setBounds(5, 655, 310, 40);
    text.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.PLAIN, 16));
    f.add(text);

    // Adding send button
    JButton send = new JButton("Send");
    send.setBounds(320, 655, 123, 40);
    send.setBackground(new Color(7, 94, 84));
    send.setForeground(Color.WHITE);
    send.addActionListener(this);
    send.setFont(new java.awt.Font("SAN_SERIF", java.awt.Font.PLAIN, 16));
    f.add(send);

    f.setSize(450, 700);
    f.setUndecorated(true);
    f.setVisible(true);
    f.setLocation(200, 50);
    f.getContentPane().setBackground(Color.WHITE);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // function to format the label
  // this function will take the string and return the panel
  // which contains the string and the time
  // in a formatted way
  public static JPanel formatLabel(String out) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
    output.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
    output.setBackground(new Color(37, 211, 102));
    output.setOpaque(true);
    output.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 50));
    panel.add(output);

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    JLabel time = new JLabel();
    time.setText(sdf.format(cal.getTime()));
    panel.add(time);
    return panel;
  }

  public static void main(String[] args) {
    new Server();

    try {
      ServerSocket skt = new ServerSocket(6001);

      // this outer while loop is used to keep the server running and accepting multiple clients
      // but if we have only one client then we can remove this outer while loop
      while (true) {
        Socket s = skt.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());

        while (true) {
          String msg = din.readUTF();
          JPanel panel = formatLabel(msg);

          // this is used to align the panel to the left
          JPanel left = new JPanel(new BorderLayout());
          // this will add the panel to the left side of the screen
          left.add(panel, BorderLayout.LINE_START);
          vertical.add(left);

          // this will add a vertical space between two messages
          f.validate();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    try {
      String out = text.getText();
      JPanel p2 = formatLabel(out);

      a1.setLayout(new BorderLayout());
      JPanel right = new JPanel(new BorderLayout());
      right.add(p2, BorderLayout.LINE_END);
      vertical.add(right);
      vertical.add(Box.createVerticalStrut(15));
      a1.add(vertical, BorderLayout.PAGE_START);

      dout.writeUTF(out);
      text.setText("");

      f.repaint();
      f.invalidate();
      f.validate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

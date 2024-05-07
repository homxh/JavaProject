import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RvsApp implements ActionListener{
    JTextField jtf;
    JButton jbtnRev, jbtnTes;
    JLabel jlabPrompt, jlabContents;

    RvsApp(){
        //create a new JFrame container.
        JFrame jfrm = new JFrame("Reverse whatever your input");

        //specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        //give the frame an initial size.
        jfrm.setSize(480,240);

        //terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a text field.
        jtf = new JTextField(40);

        //set the action commands for the text field.
        jtf.setActionCommand("myTF");

        //Create the reverse button.
        JButton jbtnRev = new JButton("Reverse");
        JButton jbtnTes = new JButton("Test");

        //add action listeners.
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);
        jbtnTes.addActionListener(this);

        //create the labels.
        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        //add the components to the content pane.
        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jbtnTes);
        jfrm.add(jlabContents);

        //display the frame.
        jfrm.setVisible(true);
    }

    //handle action events.
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getActionCommand().equals("Reverse")) {
            //the Reverse button was pressed.
            String orgStr = jtf.getText();
            String rvsStr = "";

            //reverse the string in the text field.
            for (int i = orgStr.length() - 1; i >= 0; i--)
                rvsStr += orgStr.charAt(i);

            //store the reversed string in the text field.
            jtf.setText(rvsStr);
        }
        else
            //enter was pressed while focus was in the text field.
        jlabContents.setText("You pressed ENTER. Text is: " + jtf.getText());
    }
    public static void main(String[] args){
        //create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RvsApp();
            }
        });

        //be replaced with method reference:
        SwingUtilities.invokeLater(RvsApp::new);


        //also can be replaced with lambda:
        SwingUtilities.invokeLater(() -> new RvsApp());
    }
}

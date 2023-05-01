import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextStringParch extends JPanel {

    JTextField textFieldParch = new JTextField(20);

    public TextStringParch(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passengers parch: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.textFieldParch.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.textFieldParch);


            JButton btn = new JButton("choose parch");
            btn.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(btn);
            btn.addActionListener(e -> {

                rangeOfParch(textFieldParch.getText());

            });

            this.textFieldParch.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    textFieldParch.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textFieldParch.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.revalidate();
        }
    }

    public void rangeOfParch(String parch){
        int parchNum = Integer.parseInt(parch);
        for (Passenger pas: Constants.passengers) {
            int pasParch = Integer.parseInt(pas.parch);
            if (pasParch == parchNum) System.out.println("Passenger Id: " + pas.getPassengerId() + ", amount of parch: " + pas.parch);
        }
    }
}


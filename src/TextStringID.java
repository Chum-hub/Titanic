import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextStringID extends JPanel {

    private JTextField minTextField = new JTextField(20);
    private JTextField maxTextField = new JTextField(20);

    public TextStringID(int x, int y, int width, int height){
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passenger ID: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.minTextField.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1,survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.minTextField);
            this.maxTextField.setBounds(minTextField.getX() + survivedLabel.getX() + survivedLabel.getWidth() + 20,survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.maxTextField);

            JButton btn = new JButton("choose ID");
            btn.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(btn);
            btn.addActionListener(e->{

                    rangeOfIDs(minTextField.getText(), maxTextField.getText());

            });

            this.minTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // обновляем размеры поля при получении фокуса
                    minTextField.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    minTextField.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.maxTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    maxTextField.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    maxTextField.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.revalidate();
        }
    }
    public void rangeOfIDs(String min, String max){
        try{
            int minID = Integer.parseInt(min);
            int maxID = Integer.parseInt(max);

            for (Passenger pas: Constants.passengers) {
                int pasID = Integer.parseInt(pas.passengerId);
                if (pasID >= minID && pasID <= maxID) System.out.println(" Here your passengers: ID-" + pas.passengerId + ", Name: " + pas.name);
            }
        } catch (NumberFormatException e){
            System.out.println("This is not a number: Error " + e.getMessage());
        }
    }

}

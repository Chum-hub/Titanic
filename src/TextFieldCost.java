import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextFieldCost extends JPanel {

    private JTextField minTextField = new JTextField(20);
    private JTextField maxTextField = new JTextField(20);

    public TextFieldCost(int x, int y, int width, int height){
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passengers ticket cost: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.minTextField.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1,survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.minTextField);
            this.maxTextField.setBounds(minTextField.getX() + survivedLabel.getX() + survivedLabel.getWidth() + 20,survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.maxTextField);

            JButton btn = new JButton("choose cost");
            btn.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(btn);
            btn.addActionListener(e->{

                rangeOfCost(minTextField.getText(), maxTextField.getText());

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
    public void rangeOfCost(String min, String max){
        try{
            double minCost = Double.parseDouble(min);
            double maxCost = Double.parseDouble(max);

            for (Passenger pas: Constants.passengers) {
                double pasCost = Double.parseDouble(pas.fare);
                if (pasCost >= minCost && pasCost <= maxCost) System.out.println(" Here your passengers: ID-" + pas.passengerId + ", COst: " + pas.fare);
            }
        } catch (NumberFormatException e){
            System.out.println("This is not a number: Error " + e.getMessage());
        }
    }
}

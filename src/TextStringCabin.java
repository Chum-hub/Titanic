import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextStringCabin extends JPanel {

    JTextField textFieldCabin = new JTextField(20);

    public TextStringCabin(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel cabin = new JLabel("Passengers Cabin: ");
            cabin.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(cabin);

            this.textFieldCabin.setBounds(cabin.getX() + cabin.getWidth() + 1, cabin.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.textFieldCabin);

            this.textFieldCabin.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    Constants.cabin = textFieldCabin.getText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    Constants.cabin = textFieldCabin.getText();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    Constants.cabin = textFieldCabin.getText();
                }

            });
            this.textFieldCabin.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    textFieldCabin.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textFieldCabin.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.revalidate();
        }
    }
}

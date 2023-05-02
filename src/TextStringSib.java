import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextStringSib extends JPanel {
    JTextField textFieldSib = new JTextField(20);

    public TextStringSib(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passengers Siblings: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.textFieldSib.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.textFieldSib);
            this.textFieldSib.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    Constants.sibs = textFieldSib.getText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    Constants.sibs = textFieldSib.getText();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    Constants.sibs = textFieldSib.getText();
                }

            });
            this.textFieldSib.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    textFieldSib.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textFieldSib.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.revalidate();
        }
    }
}

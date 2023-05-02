import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

public class TextSringName extends JPanel {

    JTextField textFieldName = new JTextField(20);

    public TextSringName(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {
            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passengers Name: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.textFieldName.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
            this.add(this.textFieldName);

            this.textFieldName.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    Constants.name = textFieldName.getText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    Constants.name = textFieldName.getText();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    Constants.name = textFieldName.getText();
                }

            });

            this.textFieldName.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    textFieldName.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    textFieldName.setSize(Constants.TEXT_WIDTH, Constants.TEXT_HEIGHT);
                }
            });
            this.revalidate();
        }
    }
}


import javax.swing.*;
import java.io.File;

public class ManageScreenEmbarked extends JPanel {
    private JComboBox<String> survivedFrom;

    public ManageScreenEmbarked(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {

            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passenger Embarked from: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedFrom = new JComboBox<>(Constants.PASSENGER_FROM_OPTIONS);
            this.survivedFrom.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedFrom);

            this.survivedFrom.addActionListener((e) -> {
                int selected = survivedFrom.getSelectedIndex();
                Constants.embarked = "" + selected;
            });
        }
    }
}

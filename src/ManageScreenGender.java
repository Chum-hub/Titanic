import javax.swing.*;
import java.io.File;

public class ManageScreenGender extends JPanel {

    private JComboBox<String> survivedSex;
    public  ManageScreenGender(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {

            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passenger Gender: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedSex = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
            this.survivedSex.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedSex);

            this.survivedSex.addActionListener((e) -> {
                int selected = survivedSex.getSelectedIndex();
                Constants.sex = "" + selected;
            });
        }
    }
}

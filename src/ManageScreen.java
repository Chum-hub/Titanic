import javax.swing.*;
import java.io.File;

public class ManageScreen extends JPanel {
    private JComboBox<String> survivedComboBox;

    public ManageScreen(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        if (file.exists()) {

            this.setLayout(null);
            this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

            JLabel survivedLabel = new JLabel("Passenger Class: ");
            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

            this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
            this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
            this.add(this.survivedComboBox);

            this.survivedComboBox.addActionListener((e) -> {
                int selected = survivedComboBox.getSelectedIndex();
                getPClassSurvive(selected);
            });
            survivedComboBox.revalidate();
        }
    }
    public void getPClassSurvive(int index) {
        int survived = 0;
        int notSurvived = 0;
        for (Passenger pas : Constants.passengers) {
            switch (index) {
                case 0:
                    if (pas.getSurvive().equals("1")) {
                        survived++;
                    } else {
                        notSurvived++;
                    }
                    break;
                case 1:
                    if (pas.getSurvive().equals("1") && pas.getpClass().equals("1")) {
                        survived++;
                    } else if(pas.getSurvive().equals("0") && pas.getpClass().equals("1")){
                        notSurvived++;
                    }
                    break;

                case 2:
                    if (pas.getSurvive().equals("1") && pas.getpClass().equals("2")) {
                        survived++;
                    } else if(pas.getSurvive().equals("0") && pas.getpClass().equals("2")){
                        notSurvived++;
                    }
                    break;

                case 3:
                    if (pas.getSurvive().equals("1") && pas.getpClass().equals("3")) {
                        survived++;
                    } else if(pas.getSurvive().equals("0") && pas.getpClass().equals("3")){
                        notSurvived++;
                    }
                    break;
            }
        }
        System.out.println("total: " + (survived + notSurvived) + " (survived: " + survived + ", not survived: " + notSurvived + ")");
    }
}

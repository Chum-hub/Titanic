import javax.swing.*;
import java.io.*;

class Titanic extends JFrame {

    public static void main(String[] args) throws IOException {

        new Titanic();
        excelReader();
    }

    public static void excelReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.PATH_TO_DATA_FILE));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Passenger passenger = new Passenger(values);
                Constants.passengers.add(passenger);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
    public Titanic() {
        this.setTitle("Titanic Passengers Data");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.add(new ManageScreen(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new TextStringID(0, 60, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new TextSringName(0, 90, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new ManageScreenGender(0, 120, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new TextStringSib(0, 180, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new TextStringParch(0, 210, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.add(new TextFieldCost(0, 240, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));

        this.setVisible(true);

    }
}
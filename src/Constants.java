import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Constants {
    public static final String PATH_TO_DATA_FILE = "./src/data/titanic.csv";
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;
    public static final String[] PASSENGER_CLASS_OPTIONS = { "All", "1st", "2nd", "3rd"};
    public static final String[] PASSENGER_SEX_OPTIONS = {"All", "Male", "Female"};
    public static final String[] PASSENGER_FROM_OPTIONS = {"All", "S", "Q", "C"};
    public static final int MARGIN_FROM_TOP = 10;
    public static final int MARGIN_FROM_LEFT = 5;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 30;
    public static final int COMBO_BOX_WIDTH = 80;

    public static final int TEXT_WIDTH = 120;
    public static final int COMBO_BOX_HEIGHT = 30;

    public static final int TEXT_HEIGHT = 30;
    public static ArrayList<Passenger> passengers = new ArrayList<>();
    public static CopyOnWriteArrayList<Passenger> temp = new CopyOnWriteArrayList<>();

    public static String pClass;
    public static String minID;
    public static String maxID;
    public static String name;
    public static String sex;
    public static String sibs;
    public static String parch;
    public static String ticket;
    public static String minCost;
    public static String maxCost;
    public static String cabin;
    public static String embarked;
}

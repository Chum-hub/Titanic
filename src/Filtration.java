import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Filtration extends JPanel {

    private String pasClass;

    private int counter = 1;
    public Filtration(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        JButton btn = new JButton("Filter");
        btn.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(btn);
        btn.addActionListener((e) -> {
            System.out.println("passenger class: " + Constants.pClass);
            System.out.println("min: " + Constants.minID + ", max: " + Constants.maxID);
            System.out.println("passenger name: " + Constants.name);
            System.out.println("passenger sex: " + Constants.sex);
            System.out.println("passenger sibs: " + Constants.sibs);
            System.out.println("passenger parch: " + Constants.parch);
            System.out.println("passengers ticket: " + Constants.ticket);
            System.out.println("ticket min cost: " + Constants.minCost + ", max cost: " + Constants.maxCost);
            System.out.println("passenger cabin: " + Constants.cabin);
            System.out.println("from: " + Constants.embarked);

            filter(Constants.pClass, Constants.minID, Constants.maxID, Constants.name, Constants.sex, Constants.sibs, Constants.parch, Constants.minCost, Constants.maxCost, Constants.cabin, Constants.embarked);
            JLabel survivedLabel = new JLabel(getCounter());

            survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            this.add(survivedLabel);

        });
    }

    public void filter(String pClass, String minID, String maxID, String name, String sex, String sibs, String parch, String minCost, String maxCost, String cabin, String embarked) {
        Constants.temp.clear();
        getClassFiltered(pClass);
        getIDFiltered(minID, maxID);
        getNameFiltered(name);
        getSexFiltered(sex);
        getSibFiltered(sibs);
        getParchFiltered(parch);
        getCostFiltered(minCost, maxCost);
        getCabinFiltered(cabin);
        getEmbarkedFiltered(embarked);
        counter++;

        try {
            FileWriter wr = new FileWriter("passengers"+counter+".csv");

            wr.append("Survived, PClass, Sex,Name,Sex,Age,Sib,Parch,Ticket,Fare,Cabin, Embarked\n");

            for (Passenger pas : Constants.temp) {
                wr.append(pas.getSurvive());
                wr.append(",");
                wr.append(String.valueOf(pas.getPClass()));
                wr.append(",");
                wr.append(pas.getSex());
                wr.append(",");
                wr.append(pas.getName());
                wr.append(",");
                wr.append(pas.getAge());
                wr.append(",");
                wr.append(pas.getSibSp());
                wr.append(",");
                wr.append(pas.getParch());
                wr.append(",");
                wr.append(pas.getTicket());
                wr.append(",");
                wr.append(pas.getFare());
                wr.append(",");
                wr.append(pas.getCabin());
                wr.append(",");
                wr.append(pas.getEmbarked());
                wr.append(",");
                wr.append("\n");
            }

            wr.flush();
            wr.close();

            System.out.println("Passengers data has been written to passengers.csv");
        } catch (IOException e) {
            System.out.println("An error occurred while writing passengers data to file: " + e.getMessage());
        }
    }
    public String getCounter(){
        int survived = 0;
        int notSurvived = 0;
        for (Passenger pas: Constants.temp) {
            if (pas.getSurvive().equals("0")){
                notSurvived++;
            } else {
                survived++;
            }
        }
        System.out.println("total: " + (survived+notSurvived) + "(survived: " + survived + ", notSurvived: " + notSurvived + ")");
        return "total: " + (survived+notSurvived) + "(survived: " + survived + ", notSurvived: " + notSurvived + ")";
    }

    public void getEmbarkedFiltered(String embarked) {
        for (Passenger pas : Constants.temp) {
            if (embarked == null) {
                return;
            }
            switch (embarked) {
                case "0":
                    return;
                case "1":
                    if (!pas.getEmbarked().equals("S")) {
                        Constants.temp.remove(pas);
                    }
                    break;

                case "2":
                    if (!pas.getEmbarked().equals("Q")) {
                        Constants.temp.remove(pas);
                    }
                    break;
                case "3":
                    if (!pas.getEmbarked().equals("C")) {
                        Constants.temp.remove(pas);
                    }
                    break;
            }
        }
    }

    private void getCabinFiltered(String cabin) {
        if (cabin == null) return;
        for (Passenger pas : Constants.temp) {
            if (!pas.getCabin().equals(cabin)) {
                Constants.temp.remove(pas);
            }
        }
    }

    public void getCostFiltered(String min, String max) {
        if (min == null && max == null) {
            return;
        } else if (max == null) {
            max = "10";
        } else if (min == null) {
            min = "0";
        }
        try {
            double minCost = Double.parseDouble(min);
            double maxCost = Double.parseDouble(max);

            for (Passenger pas : Constants.temp) {
                double pasCost = Double.parseDouble(pas.getFare());
                if (!(pasCost >= minCost && pasCost <= maxCost)) {
                    Constants.temp.remove(pas);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("This is not a number: Error " + e.getMessage());
        }
    }

    public void getParchFiltered(String parch) {
        if (parch == null) return;
        for (Passenger pas : Constants.temp) {
            if (!pas.getParch().equals(parch)) {
                Constants.temp.remove(pas);
            }
        }
    }

    public void getSibFiltered(String sibs) {
        if (sibs == null) return;
        for (Passenger pas : Constants.temp) {
            if (!pas.getSibSp().equals(sibs)) {
                Constants.temp.remove(pas);
            }
        }
    }

    public void getSexFiltered(String sex) {
        for (Passenger pas : Constants.temp) {
            if (sex == null) {
                return;
            }
            switch (sex) {
                case "0":
                    return;
                case "1":
                    if (!pas.getSex().equals("male")) {
                        Constants.temp.remove(pas);
                    }
                    break;

                case "2":
                    if (!pas.getSex().equals("female")) {
                        Constants.temp.remove(pas);
                    }
                    break;
            }
        }
    }

    public void getNameFiltered(String name) {
        if (name == null) return;
        for (Passenger pas : Constants.temp) {
            if (!pas.getName().contains(name)) {
                Constants.temp.remove(pas);
            }
        }
    }

    public void getIDFiltered(String min, String max) {
        if (min == null && max == null) {
            return;
        } else if (max == null) {
            max = "1000";
        } else if (min == null) {
            min = "0";
        }
        int minID = Integer.parseInt(min);
        int maxID = Integer.parseInt(max);
        for (Passenger pas : Constants.temp) {
            int pasID = Integer.parseInt(pas.getPassengerId());
            if (!(pasID >= minID && pasID <= maxID)) {
                Constants.temp.remove(pas);
            }
        }
    }

    public void getClassFiltered(String index) {

        for (Passenger pas : Constants.passengers) {
            if (index == null) {
                Constants.temp.add(pas);
                continue;
            }
            switch (index) {
                case "0":
                    Constants.temp.add(pas);
                    break;
                case "1":
                    if (pas.getPClass().equals("1")) {
                        Constants.temp.add(pas);
                    }
                    break;

                case "2":
                    if (pas.getPClass().equals("2")) {
                        Constants.temp.add(pas);
                    }
                    break;

                case "3":
                    if (pas.getPClass().equals("3")) {
                        Constants.temp.add(pas);
                    }
                    break;
            }
        }
    }
}

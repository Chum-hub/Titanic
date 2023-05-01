public class Passenger {
    public String passengerId;
    public String survive;
    public String pClass;
    public String name;
    public String sex;
    public String age;
    public String sibSp;
    public String parch;
    public String ticket;
    public String fare;
    public String cabin;
    public String embarked;

    public String getPassengerId() {
        return passengerId;
    }

    public String getSurvive() {
        return survive;
    }

    public String getpClass() {
        return pClass;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getSibSp() {
        return sibSp;
    }

    public String getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public String getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public Passenger(String[] values) throws ArrayIndexOutOfBoundsException {
        try {
            this.passengerId = values[0];
            this.survive = values[1];
            this.pClass = values[2];
            this.name = getFormattedName(values[4] + values[3]);
            this.sex = values[5];
            this.age = values[6];
            this.sibSp = values[7];
            this.parch = values[8];
            this.ticket = values[9];
            this.fare = values[10];
            this.cabin = values[11];
            this.embarked = values[12];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no value on point: embarked" + e.getMessage());
        }
        //System.out.println(sex);
    }

    public static String getFormattedName(String value) {
        String modifiedName = value.substring(value.indexOf(".") + 2);
        modifiedName = modifiedName.replace("\"\"", " ");

        return modifiedName;
    }

}

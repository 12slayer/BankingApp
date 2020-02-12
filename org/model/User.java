package org.model;

public class User {
    private int id;
    private int AcNum;
    private String name;
    private double ammount;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcNum() {
        return AcNum;
    }

    public void setAcNum(int acNum) {
        AcNum = acNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", AcNum=" + AcNum +
                ", name='" + name + '\'' +
                ", ammount=" + ammount +
                ", address='" + address + '\'' +
                '}';
    }
}
 /*  try {

                            File obj = new File("C:\\\\Users\\\\susha\\\\IdeaProjects\\\\BankingApplication2\\\\src\\"+user.getAcNum());
                            Scanner myReader=new Scanner(obj);
                            while ((myReader.hasNextLine())){
                                String data=myReader.nextLine();
                                System.out.println(data);

                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }*/

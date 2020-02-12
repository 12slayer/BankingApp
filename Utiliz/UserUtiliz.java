package Utiliz;

import org.model.Message;
import org.model.User;

import java.io.*;
import java.util.Scanner;

public class UserUtiliz {
    User user = new User();
    Message message = new Message();
    private String dbPath;
    public UserUtiliz(){
        dbPath="C:\\\\\\\\Users\\\\\\\\susha\\\\\\\\IdeaProjects\\\\\\\\BankingApplication2\\\\\\\\src\\\\";
    }
    public Message saveUserDetails(User user) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\\\\\\\Users\\\\\\\\susha\\\\\\\\IdeaProjects\\\\\\\\BankingApplication2\\\\\\\\src\\\\"+user.getAcNum());
            fileWriter.write("name=" + user.getName() + System.lineSeparator());
            fileWriter.write("ammount=" + user.getAmmount() + System.lineSeparator());
            fileWriter.write("address=" + user.getAddress() + System.lineSeparator());

            fileWriter.close();
            message.setSuccess(true);
            message.setErrorMessage(null);
        } catch (IOException e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setErrorMessage(null);
        }
        return message;
    }

    public User getUserDetails(int AcNum) {
        User user = null;
        try {
            FileReader fileReader = new FileReader("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\susha\\\\\\\\\\\\\\\\IdeaProjects\\\\\\\\\\\\\\\\BankingApplication2\\\\\\\\\\\\\\\\src\\\\\\\\"+AcNum);

            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            user = new User();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String lines[] = line.split("=");
                System.out.println(lines[0]);
                System.out.println(lines[1]);
                if (lines[0].equalsIgnoreCase("Account")) {
                    user.setAcNum(Integer.parseInt(lines[1]));

                } else if (lines[0].equalsIgnoreCase("address")) {
                    user.setAddress(lines[1]);
                }else if (lines[0].equalsIgnoreCase("name")) {
                    user.setName(lines[1]);
                }else if (lines[0].equalsIgnoreCase("ammount")) {
                    user.setAmmount(Double.parseDouble(lines[1]));
                } else {

                }

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean deleteUser(int AccNum){
        File f=new File("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\susha\\\\\\\\\\\\\\\\IdeaProjects\\\\\\\\\\\\\\\\BankingApplication2\\\\\\\\\\\\\\\\src\\\\\\\\"+AccNum);
        if(f.delete()){
            System.out.println("is deleted");
            return true;
        }else{
            System.out.println("not been deleted");
            return false;
        }
    }
}

/*
package Utiliz;

import org.model.Message;
import org.model.User;

import java.io.*;
//interface is used to implement userCrudUtility to UserCrudFileUtility
public class UserCrudFileUtility implements UserCrudUtility{

    @Override
    public User transferUserbalance(int accnum) {
        Message m=new Message();
        User user=new User();

        user.getAmmount();
        if(user!=null){

        }

        return user;
    }

    @Override
    public Message saveUserDetails(User user) {
        //if we return wanted to return instance of object than we can return onjects instance
        Message message = new Message();
        try {
            FileWriter fileWriter = new FileWriter("C:\\\\\\\\Users\\\\\\\\susha\\\\\\\\IdeaProjects\\\\\\\\BankingApplication2\\\\\\\\src\\\\"+user.getAcNum());
            fileWriter.write("Account=" + user.getAcNum() + System.lineSeparator());
            fileWriter.write("name=" + user.getName() + System.lineSeparator());
            fileWriter.write("ammount=" + user.getAmmount() + System.lineSeparator());
            fileWriter.write("address=" + user.getAddress() + System.lineSeparator());

            fileWriter.close();
            message.setSuccess(true);
            message.setErrorMessage(null);
            message.setData(user);

        } catch (IOException e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setErrorMessage(e.getMessage());
            message.setData(null);

        }
        return message;
    }


    @Override
    public User getUserDetails(int accNum) {
        //getting user details
        User user = null;
        try {
            FileReader fileReader = new FileReader("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\susha\\\\\\\\\\\\\\\\IdeaProjects\\\\\\\\\\\\\\\\BankingApplication2\\\\\\\\\\\\\\\\src\\\\\\\\"+ accNum);

            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            user = new User();
            while ((line = reader.readLine()) != null) {
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

            System.out.println(line);
            fileReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User deleteUser(int AccNum) {
        File f=new File("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\susha\\\\\\\\\\\\\\\\IdeaProjects\\\\\\\\\\\\\\\\BankingApplication2\\\\\\\\\\\\\\\\src\\\\\\\\"+AccNum);
        if(f.delete()){
            System.out.println("is deleted");

        }else{
            System.out.println("not been deleted");

        }
        return null;
    }

}

*/

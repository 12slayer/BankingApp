package Utiliz;

import org.model.Message;
import org.model.User;

import java.sql.*;

public class UserCrudDButility implements  UserCrudUtility {
Message message=new Message();
    @Override
    public Message saveUserDetails(User user) {
        if(user.getId()==0){
            return insertUser(user);
        }else{
            return updateUser(user);
        }
    }

    @Override
    public User getUserDetails(int accNum) {
        //1.open Db Connection to mysql
        //2.Hold Connection using Connection Object
        //3.prepare query using this accountNumber i.e use select query
        //4.hold resultSet object
        //5.Ilerate through resultSet object using its next() function
        //Set Values to User object
        //7.return User object
        User user = null;
        ResultSet resultSet = null;
        try {


            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/db_banking_app";
            String userName = "root";
            String password = "12Slayer34";
            Connection connection = DriverManager.getConnection(url, userName, password);
            String querygive = "select * from tbl_user\n" +
                    "where account_number=?;";

            PreparedStatement preparedStatement = connection.prepareStatement(querygive);
            preparedStatement.setInt(1, accNum);


            resultSet = preparedStatement.executeQuery();
            //checking if user exists or not

                user = new User();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    int accum = resultSet.getInt("account_number");
                    Double amount = resultSet.getDouble("ammount");

                    user.setId(id);
                    user.setName(name);
                    user.setAddress(address);
                    user.setAcNum(accum);
                    user.setAmmount(amount);

                }

            connection.close();


            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
            }

        return user;

    }

    @Override
    public void deleteUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_banking_app";
            String userName = "root";
            String password = "12Slayer34";
            Connection connection = DriverManager.getConnection(url, userName, password);
            String deleteU="Delete from tbl_user where id=?;";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteU);
            preparedStatement.setInt(1, user.getId());


             preparedStatement.execute();
             connection.close();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User transferUserbalance(int accnum) {
        return null;
    }



    public Message updateUser(User user){
        System.out.println(user);
        Message message=new Message();
        try{

            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/db_banking_app";
            String userName="root";
            String password="12Slayer34";
            Connection connection = DriverManager.getConnection( url,userName,password );

            String insertQuery="update tbl_user set ammount=? where id=?";

            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            preparedStatement.setDouble(1,user.getAmmount());
            preparedStatement.setInt(2,user.getId());

            preparedStatement.execute();

            message.setSuccess(true);
            message.setErrorMessage(null);
            message.setData(user);

            connection.close();
        } catch (Exception e) {
            message.setSuccess(false);
            message.setErrorMessage(e.getMessage());
            message.setData(null);
            e.printStackTrace();
        }
        return message;
    }

    public Message insertUser(User user){
        Message message=new Message();
        try{

            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/db_banking_app";
            String userName="root";
            String password="12Slayer34";
            Connection connection = DriverManager.getConnection( url,userName,password );

            String insertQuery="insert into tbl_user(\n" +
                    "account_number,name,address,ammount)\n" +
                    "values\n" +
                    "(?,?,?,?);";

            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1,user.getAcNum());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setDouble(4,user.getAmmount());
            boolean flag=preparedStatement.execute();
            message.setSuccess(true);
            message.setErrorMessage(null);
            message.setData(user);
            connection.close();
        } catch (Exception e) {
            message.setSuccess(false);
            message.setErrorMessage(e.getMessage());
            message.setData(null);
            e.printStackTrace();
        }
        return message;
    }
}

package kz.bitlab.models;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlab_shop?useUnicode=true&serverTimezone=UTC","root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addItem(Items item){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (id, name, description, price)" +
                    "VALUES (NULL, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getAllItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, description, price FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                items.add(new Items(id,name,desc,price));
                System.out.println("name " + name);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Users getUser(String email, String password){
       Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new Users(resultSet.getLong("id"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("full_name"));

            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static Users getUserById(Long id){
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new Users(resultSet.getLong("id"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("full_name"));

            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

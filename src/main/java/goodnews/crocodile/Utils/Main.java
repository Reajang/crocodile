package goodnews.crocodile.Utils;

import goodnews.crocodile.config.DbConfig;
import goodnews.crocodile.model.Message;
import goodnews.crocodile.model.User;
import goodnews.crocodile.model.statusEnum.UserRole;
import goodnews.crocodile.services.implementations.UserServiceTemplate;
import goodnews.crocodile.services.interfaces.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.*;

/***
 * Временнай класс для проверки всякого
 */
public class Main {

    public static void main(String[] args) {

        GenericApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        UserService service = context.getBean(UserServiceTemplate.class);
        service.delete(3L);
        //service.delete(11L);

        /*User user1 = new User();
        user1.setUserName("Aspecter");
        user1.setPassword("123456789");
        user1.getRole().add(UserRole.USER);
        Message message1 = new Message();
        message1.setAuthor(user1);
        message1.setText(";sldifk;jsl");
        Message message2 = new Message();
        message2.setAuthor(user1);
        message2.setText("dfgddfg");
        user1.getMessages().add(message1);
        user1.getMessages().add(message2);
        System.out.println("Из метода main до аспекта");
        service.save(user1);*/

        /*try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/croc", "postgres", "root")){
            String query = "SELECT * FROM croc_users WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            //ResultSet resultSet = statement.executeQuery(query);
            statement.setInt(1, 5);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()){
                System.out.println(resultSet.getString("username"));
            }

        }
        catch (SQLException e ){
            e.printStackTrace();
        }*/



        /*User user = service.findUserById(1L).get();
        Message message = new Message();
        for(int i=0; i<10; i++){
            message.setAuthor(user);
            message.setText("Новое сообщение" + i);
            user.getMessages().add(message);
            user.setUserName("qqqqqqqqqqqqqqqqqqq");
            service.save(user);
        }*/

        /*
        User user2 = new User();
        user2.setUserName("zxc");
        user2.setPassword("789");
        user2.getRole().add(UserRole.USER);
        user2.getRole().add(UserRole.DELETE);
        user2.getRole().add(UserRole.ADMIN);
        Message message4 = new Message();
        message4.setAuthor(user2);
        message4.setText("Новое сообщение3");
        user2.getMessages().add(message4);
        service.createUser(user2);

        User user5 = new User();
        user5.setUserName("asd");
        user5.setPassword("456");
        user5.getRole().add(UserRole.USER);
        user5.getRole().add(UserRole.ADMIN);
        Message message5 = new Message();
        message5.setAuthor(user5);
        message5.setText("Новое сообщение10");
        message5.setText("Новое сообщение1");
        user5.getMessages().add(message5);
        service.createUser(user5);*/
    }
}

package books.Integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import books.domain.Book;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Book book)  {
        try {
            //convert person to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String contactString = objectMapper.writeValueAsString(book);
            System.out.println("Sending a JMS message:" + contactString);
            jmsTemplate.convertAndSend("books-queue", contactString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

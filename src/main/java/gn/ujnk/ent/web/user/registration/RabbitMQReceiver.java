package gn.ujnk.ent.web.user.registration;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQReceiver {

  private CountDownLatch latch = new CountDownLatch(1);

  @RabbitListener(queues = "user-registration-queue")
  public void receiveMessage(Message message) {
      System.out.println("Received <" + message.toString() + ">");
      latch.countDown();
  }

  public CountDownLatch getLatch() {
      return latch;
  }

}
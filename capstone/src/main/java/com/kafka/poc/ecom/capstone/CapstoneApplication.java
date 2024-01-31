package com.kafka.poc.ecom.capstone;

import com.kafka.poc.ecom.capstone.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CapstoneApplication {

  @Autowired private ICustomerService customerService;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(CapstoneApplication.class, args);
    System.out.println("Application started!!");
    context.getBean("customerService");
  }

  /**
   * processing the input stream from topic (wrong-passwords)
   * 1) creating window of 5 mins (only considering requests with in 15 mins window)
   * 2) grouping by key(username)
   * 3)filtering if number of request is greater than 3
   * 4)send to outputstream for topic(blocked-accounts)
   */
  @Bean
  public Function<KStream<String,String>, KStream<String,Long>>processWrongPasswords(){

    KeyValueMapper<Windowed<String>,Long,KeyValue<String,Long>> keyValueMap =(windowKey, value)->new KeyValue<>(windowKey.key(),value);

    Function<KStream<String,String>, KStream<String,Long>>function=
            inputStream->inputStream
                    .groupByKey()
                    .windowedBy(TimeWindows.ofSizeAndGrace(Duration.ofMinutes(5),Duration.ofSeconds(30)))
                    .count()
                    .filter((windowStream,count)->count>=3)
                    .toStream()
                    .map(keyValueMap)
                    .peek((key,value)-> System.out.println("blocked key="+key+" value="+value));
    return function;

  }

  /**
   * processing input stream of topic(blocked-accounts)
   * currently blocking the users here but blocking operation can be a complex/costly
   * operation depending on business usecase and there can be a separate blocking microservice
   * for that
   */
  @Bean
  public Consumer<KStream<String,Long>>processBlocked(){
    Consumer< KStream<String,Long>>consumer=
            inputStream->inputStream
                    .foreach((usernameKey,value)->customerService.block(usernameKey) );
    return consumer;
  }

}

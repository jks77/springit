package com.vega.springit;

import com.vega.springit.model.Comment;
import com.vega.springit.model.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//dit runt de application
@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

//    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2", "https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link);

                       Comment comment = new Comment("This Spring boot 2 link is awesome", link);
            commentRepository.save(comment);
            link.addComment(comment);


            Link linkOne = new Link("Nieuwe link gemaakt", "https://google.com");
            linkRepository.save(linkOne);

            Comment commentOne = new Comment("This Google link is pretty good", linkOne);
            commentRepository.save(commentOne);
            linkOne.addComment(commentOne);
            System.out.println(linkOne.getUrl());

            System.out.println("We just inserted link into comment");
            System.out.println("=============================");
        };
    }
}

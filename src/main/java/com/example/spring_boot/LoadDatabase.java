package com.example.spring_boot;

import com.example.spring_boot.transactions.Transaction;
import com.example.spring_boot.transactions.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // TODO: remove this after integrating a database
    @Bean
    CommandLineRunner initializeDatabase(TransactionRepository repository){
        return args -> {
            log.info("Preloading {}", repository.save(new Transaction("Swiggy", 1030.0)));
            log.info("Preloading {}", repository.save(new Transaction("Instamart", 237.0)));
        };
    }
}


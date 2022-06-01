/**
 *  Author(s): @Everyone
 *  Contributor(s):
 *  Purpose: Main Driver for Revamedia Application. Starts up spring boot application.
 */
package com.revature.Revamedia;

import com.revature.Revamedia.beans.services.*;
import com.revature.Revamedia.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.revature.Revamedia")
public class RevamediaApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(RevamediaApplication.class, args);
        context.start();
    }
}


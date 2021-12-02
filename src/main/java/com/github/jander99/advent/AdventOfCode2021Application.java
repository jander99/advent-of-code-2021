package com.github.jander99.advent;

import com.github.jander99.advent.problems.Problem1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventOfCode2021Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdventOfCode2021Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Problem1 problem1 = new Problem1();
//        problem1.run1();

        problem1.run2();

    }
}

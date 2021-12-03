package com.github.jander99.advent;

import com.github.jander99.advent.problems.Day1;
import com.github.jander99.advent.problems.Day2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AdventOfCode2021Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdventOfCode2021Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        day2();
    }

    private void day1() throws IOException {
        Day1 day1 = new Day1();
        day1.run1();
        day1.run2();
    }

    private void day2() throws Exception {
        Day2 day2 = new Day2();
        day2.problem1();
        day2.problem2();
    }
}

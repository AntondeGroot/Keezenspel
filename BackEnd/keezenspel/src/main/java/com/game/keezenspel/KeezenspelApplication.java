package com.game.keezenspel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.game.keezenspel.BoardGeneration.BoardGenerator;

@SpringBootApplication
public class KeezenspelApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KeezenspelApplication.class, args);
		BoardGenerator boardHTMLGenerator = new BoardGenerator(3,600);
		boardHTMLGenerator.printOutDIVs();
	}

}

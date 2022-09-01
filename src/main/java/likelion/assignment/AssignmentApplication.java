package likelion.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(String.format("금액을 넣으세요 : ", br));
//
//		int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//		int money = Integer.parseInt(String.valueOf(br.read()));
//		for (int i = 0; i <= currency.length; i++) {
//			System.out.println(currency[i] + "원 " + money / currency[i] + "개");
//			money = money - currency[i] * (money / currency[i]);
//		}

	}
}

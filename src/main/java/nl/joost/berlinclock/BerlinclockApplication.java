package nl.joost.berlinclock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BerlinclockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BerlinclockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (args.length != 1) {
			return;
		}

		var digitalTime = args[0];
		System.out.printf("Digital Time: %s, Berlin Clock: %s%n", digitalTime, getEntireBerlinClock(digitalTime));
	}

	public String getSingleMinutesRow(String digitalTime) {
		int minutes = getTimeAsInt(digitalTime, TimeUnit.MINUTES);
		int singleMinutes = minutes % 5;

		StringBuilder singleMinutesRow = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			singleMinutesRow.append(singleMinutes > i ? "Y" : "O");
		}

		return singleMinutesRow.toString();
	}

	public String  getFiveMinutesRow(String digitalTime) {
		int minutes = getTimeAsInt(digitalTime, TimeUnit.MINUTES);
		int fiveMinutes = minutes / 5;

		StringBuilder fiveMinutesRow = new StringBuilder();
		for (int i = 0; i < 11; i++) {
			if (fiveMinutes > i) {
				if ((i + 1) % 3 == 0) {
					fiveMinutesRow.append("R");
				} else {
					fiveMinutesRow.append("Y");
				}
			} else {
				fiveMinutesRow.append("O");
			}
		}

		return fiveMinutesRow.toString();
	}

	public String getSingleHoursRow(String digitalTime) {
		int hours = getTimeAsInt(digitalTime, TimeUnit.HOURS);
		int singleHours = hours % 5;

		StringBuilder singleHoursRow = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			singleHoursRow.append(singleHours > i ? "R" : "O");
		}

		return singleHoursRow.toString();
	}

	public String getFiveHoursRow(String digitalTime) {
		int hours = getTimeAsInt(digitalTime, TimeUnit.HOURS);
		int fiveHours = hours / 5;

		StringBuilder fiveHoursRow = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			fiveHoursRow.append(fiveHours > i ? "R" : "O");
		}

		return fiveHoursRow.toString();
	}

	public String getSecondsLamp(String digitalTime) {
		int seconds = getTimeAsInt(digitalTime, TimeUnit.SECONDS);

		return seconds % 2 == 0 ? "Y" : "O";
	}

	public String getEntireBerlinClock(String digitalTime) {

		return getSecondsLamp(digitalTime) +
				getFiveHoursRow(digitalTime) +
				getSingleHoursRow(digitalTime) +
				getFiveMinutesRow(digitalTime) +
				getSingleMinutesRow(digitalTime);
	}

	private int getTimeAsInt(String digitalTime, TimeUnit timeUnit) {
		int splitIndex = 0;
		switch (timeUnit) {
			case SECONDS -> splitIndex = 2;
			case MINUTES -> splitIndex = 1;
			case HOURS -> splitIndex = 0;
		}

		String splitTime = digitalTime.split(":")[splitIndex];
		return Integer.parseInt(splitTime);
	}
}

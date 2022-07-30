package nl.joost.berlinclock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BerlinclockApplicationTests {

	@InjectMocks
	private BerlinclockApplication berlinclockApplication;

	@Test
	void testGetSingleMinutesRow() {

		var result = berlinclockApplication.getSingleMinutesRow("00:00:00");
		Assertions.assertEquals("OOOO", result);

		result = berlinclockApplication.getSingleMinutesRow("23:59:59");
		Assertions.assertEquals("YYYY", result);

		result = berlinclockApplication.getSingleMinutesRow("12:32:00");
		Assertions.assertEquals("YYOO", result);

		result = berlinclockApplication.getSingleMinutesRow("12:34:00");
		Assertions.assertEquals("YYYY", result);

		result = berlinclockApplication.getSingleMinutesRow("12:35:00");
		Assertions.assertEquals("OOOO", result);
	}

	@Test
	void testGetFiveMinutesRow() {

		var result = berlinclockApplication.getFiveMinutesRow("00:00:00");
		Assertions.assertEquals("OOOOOOOOOOO", result);

		result = berlinclockApplication.getFiveMinutesRow("23:59:59");
		Assertions.assertEquals("YYRYYRYYRYY", result);

		result = berlinclockApplication.getFiveMinutesRow("12:04:00");
		Assertions.assertEquals("OOOOOOOOOOO", result);

		result = berlinclockApplication.getFiveMinutesRow("12:23:00");
		Assertions.assertEquals("YYRYOOOOOOO", result);

		result = berlinclockApplication.getFiveMinutesRow("12:35:00");
		Assertions.assertEquals("YYRYYRYOOOO", result);
	}

	@Test
	void testGetSingleHoursRow() {

		var result = berlinclockApplication.getSingleHoursRow("00:00:00");
		Assertions.assertEquals("OOOO", result);

		result = berlinclockApplication.getSingleHoursRow("23:59:59");
		Assertions.assertEquals("RRRO", result);

		result = berlinclockApplication.getSingleHoursRow("02:04:00");
		Assertions.assertEquals("RROO", result);

		result = berlinclockApplication.getSingleHoursRow("08:23:00");
		Assertions.assertEquals("RRRO", result);

		result = berlinclockApplication.getSingleHoursRow("14:35:00");
		Assertions.assertEquals("RRRR", result);
	}

	@Test
	void testGetFiveHoursRow() {

		var result = berlinclockApplication.getFiveHoursRow("00:00:00");
		Assertions.assertEquals("OOOO", result);

		result = berlinclockApplication.getFiveHoursRow("23:59:59");
		Assertions.assertEquals("RRRR", result);

		result = berlinclockApplication.getFiveHoursRow("02:04:00");
		Assertions.assertEquals("OOOO", result);

		result = berlinclockApplication.getFiveHoursRow("08:23:00");
		Assertions.assertEquals("ROOO", result);

		result = berlinclockApplication.getFiveHoursRow("16:35:00");
		Assertions.assertEquals("RRRO", result);
	}

	@Test
	void testGetSecondsLamp() {

		var result = berlinclockApplication.getSecondsLamp("00:00:00");
		Assertions.assertEquals("Y", result);

		result = berlinclockApplication.getSecondsLamp("23:59:59");
		Assertions.assertEquals("O", result);
	}

	@Test
	void testGetEntireBerlinClock() {

		var result = berlinclockApplication.getEntireBerlinClock("00:00:00");
		Assertions.assertEquals("YOOOOOOOOOOOOOOOOOOOOOOO", result);

		result = berlinclockApplication.getEntireBerlinClock("23:59:59");
		Assertions.assertEquals("ORRRRRRROYYRYYRYYRYYYYYY", result);

		result = berlinclockApplication.getEntireBerlinClock("16:50:06");
		Assertions.assertEquals("YRRROROOOYYRYYRYYRYOOOOO", result);

		result = berlinclockApplication.getEntireBerlinClock("11:37:01");
		Assertions.assertEquals("ORROOROOOYYRYYRYOOOOYYOO", result);
	}
}

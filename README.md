# Berlin Clock Kata
https://agilekatas.co.uk/katas/BerlinClock-Kata

### Local Development
You can start the application locally by running the following command: `gradlew bootRun`.
Commands can be passed along like this: `./gradlew bootrun -Pargs=12:34:00`.

### Code / Choices Explanation
- I am used to running Web backend services, not command line applications. This means there was
some figuring out to do on my part, and I might not be following best practices. (I usually use c# when writing console applications)
- There is no check for invalid arguments passed to the application (other than length == 0).
My focus was on the logic of the Kata, not input parsing. I mostly used [Bealdung](https://www.baeldung.com/spring-boot-console-app) for figuring this out.
- There is still some overlap/code duplication between getting some of the rows for the berlin clock.
For example `getSingleMinutesRow` and `getSingleHoursRow` only differ in whether they get minutes or hours, and whether they return "Y" or "R". However, in my opinion, generalizing this more doesn't improve code readability.
- I chose Gradle instead of Maven because I am slightly more familiar with it.
- Skeleton of project was set up using https://start.spring.io/

package background.checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrimeCheckTest {
  @Test
  void crimeCheckBehaviors() {
    assertAll(
      () -> {
        Response response = CrimeCheck.evaluate("123456609");
        assertTrue(response.status);
        assertEquals("", response.reason);
      },
      () -> {
        Response response = CrimeCheck.evaluate("123451799");
        assertFalse(response.status);
        assertEquals("felony found in criminal history", response.reason);
      }
    );
  }
}
package background.checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenshipTest {
  @Test
  void citizenCheckBehaviors() {
    assertAll(
      () -> {
        Response response = CitizenCheck.evaluate("123456609");
        assertTrue(response.status);
        assertEquals("", response.reason);
      },
      () -> {
        Response response = CitizenCheck.evaluate("123455789");
        assertFalse(response.status);
        assertEquals("not a citizen", response.reason);
      }
    );
  }
}
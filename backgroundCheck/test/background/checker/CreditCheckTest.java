package background.checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCheckTest {
  @Test
  void canary() {
    assert(true);
  }

  @Test
  void creditCheckBehaviors() {
    assertAll(
        () -> {
            Response response = CreditCheck.evaluate("123456609");
            assertTrue(response.status);
            assertEquals("", response.reason);
        },
        () -> {
            Response response = CreditCheck.evaluate("123451789");
            assertFalse(response.status);
            assertEquals("poor credit score", response.reason);
        }
    );
  }
}
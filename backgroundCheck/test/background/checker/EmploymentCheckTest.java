package background.checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmploymentCheckTest {
    @Test
    void employmentCheckBehaviors() {
        assertAll(
                () -> {
                    Response response = EmploymentCheck.evaluate("123455409");
                    assertTrue(response.status);
                    assertEquals("", response.reason);
                },
                () -> {
                    Response response = EmploymentCheck.evaluate("123451249");
                    assertFalse(response.status);
                    assertEquals("no employment history found",
                      response.reason);
                }
        );
    }
}
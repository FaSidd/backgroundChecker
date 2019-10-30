package background.checker;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundCheckTest {

  @Test
  void noFailureCandidateBehaviors() {
    Response result = BackgroundCheck.evaluate(
      "123456789",
      CitizenCheck::evaluate,
      CreditCheck::evaluate,
      CrimeCheck::evaluate,
      EmploymentCheck::evaluate
    );

    assertTrue(result.status);
    assertEquals("", result.reason);
  }

  @Test
  void oneFailureCandidateBehaviors() {
    Response result = BackgroundCheck.evaluate(
      "123456755",
      CitizenCheck::evaluate,
      CreditCheck::evaluate,
      CrimeCheck::evaluate,
      EmploymentCheck::evaluate
    );

    assertFalse(result.status);
    assertEquals("not a citizen", result.reason);
  }

  @Test
  void twoFailureCandidateBehaviors() {
    Response result = BackgroundCheck.evaluate(
      "553454789",
      CitizenCheck::evaluate,
      CreditCheck::evaluate,
      CrimeCheck::evaluate,
      EmploymentCheck::evaluate
    );

    assertFalse(result.status);
    assertEquals("not a citizen, poor credit score", result.reason);
  }

  @Test
  void threeFailureCandidateBehaviors() {
    Response result = BackgroundCheck.evaluate(
      "553454799",
      CitizenCheck::evaluate,
      CreditCheck::evaluate,
      CrimeCheck::evaluate,
      EmploymentCheck::evaluate
    );

    assertFalse(result.status);
    assertEquals("not a citizen, poor credit score, felony found in criminal history", result.reason);
  }
}
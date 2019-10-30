package background.checker;

public interface CreditCheck {
  static Response evaluate(String ssn) {
    if(Integer.parseInt(ssn) / 10 % 1000 >= 500) {
      return new Response(true, "");
    }

    return new Response(false, "poor credit score");
  }
}

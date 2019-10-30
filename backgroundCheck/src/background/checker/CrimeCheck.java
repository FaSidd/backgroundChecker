package background.checker;

public interface CrimeCheck {
  static Response evaluate(String ssn) {
    if(!ssn.contains("99")){
      return new Response(true, "");
    }

    return new Response(false, "felony found in criminal history");
  }
}

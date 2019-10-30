package background.checker;

public interface CitizenCheck {
  static Response evaluate(String ssn) {
    if(!ssn.contains("55")){
      return new Response(true,"");
    }

    return new Response(false, "not a citizen");
  }
}

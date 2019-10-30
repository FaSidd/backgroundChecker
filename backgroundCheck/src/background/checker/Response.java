package background.checker;

public class Response {
  public final boolean status;
  public final String reason;

  public Response(boolean pass, String message) {
    status = pass;
    reason = message;
  }
}

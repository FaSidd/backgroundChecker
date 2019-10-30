package background.checker;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface BackgroundCheck {
  @SafeVarargs
  static Response evaluate(String ssn, Function<String, Response>... evaluators) {
    String reasons = Arrays.stream(evaluators)
                       .map(ev -> ev.apply(ssn))
                       .filter(res -> !res.status)
                       .map(res -> res.reason)
                       .collect(Collectors.joining(", "));

    return new Response(reasons.isBlank(), reasons);
  }
}

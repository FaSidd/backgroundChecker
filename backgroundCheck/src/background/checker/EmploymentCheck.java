package background.checker;

public interface EmploymentCheck {
    static Response evaluate(String ssn){
        if(!ssn.contains("24")){
            return new Response(true, "");
        }

        return new Response(false,"no employment history found");
    }
}

package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoHome extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user.getId() == 1){
        return "customerpage";
    }
            if(user.getId() == 2){
        return "employeepage";
    }
                    if(user.getId() == 1){
        return "adminpage";
    }
    return "customerpage";
    }
    
    
}

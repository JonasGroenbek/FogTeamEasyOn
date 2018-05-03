package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBuilder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {       
        LogicFacade.updateBuilder(Integer.parseInt(request.getParameter("orderId")),
                Integer.parseInt(request.getParameter("builder")));
    return "employeepage";
    }
    
}

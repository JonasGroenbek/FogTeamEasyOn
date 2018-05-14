package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Shed;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        int material = Integer.parseInt(request.getParameter("material"));
        int roof = Integer.parseInt(request.getParameter("roof"));
        int lengthShed = Integer.parseInt(request.getParameter("lengthShed"));
        int widthShed = Integer.parseInt(request.getParameter("widthShed"));
        int length = Integer.parseInt(request.getParameter("length")) * 100;
        int width = Integer.parseInt(request.getParameter("width")) * 100;
        int height = Integer.parseInt(request.getParameter("height"));
        SVGBuilder svg = new SVGBuilder(roof, length, width, lengthShed, widthShed, material);

        Order order = new Order(length, width, height);
        Shed shed = new Shed(lengthShed, widthShed, 500);
        session.setAttribute("svg", svg.buildSvg(svg));

        LogicFacade.createShed(shed, email);
        LogicFacade.createOrder(user.getEmail(), 500, order, material, roof, shed);

        return "placedorderpage";

    }
}

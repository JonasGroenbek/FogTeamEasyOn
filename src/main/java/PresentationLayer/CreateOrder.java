package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.BillCalc;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.Shed;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int userID = user.getId();
            int material = Integer.parseInt(request.getParameter("material"));
            int roof = Integer.parseInt(request.getParameter("roof"));
            int lengthShed = Integer.parseInt(request.getParameter("lengthShed"));
            int widthShed = Integer.parseInt(request.getParameter("widthShed"));
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = 300;
            //Bom Data
            BillCalc calc = new BillCalc();
            ArrayList<Integer> bom = new ArrayList();
            int underSternFAB = calc.underSternBoardFrontAndBack(length);
            System.out.println(underSternFAB + " " + length);
            bom.add(underSternFAB);
            int underSternS = calc.underSternBoardSides(width);
            bom.add(underSternS);
            int overSternF = calc.overSternBoardFront(length);
            bom.add(overSternF);
            int overSternS = calc.overSternBoardSides(width);
            bom.add(overSternS);
            bom.add(calc.zOnDoor(lengthShed, widthShed));
            int tiesgabled = calc.interTiesShedGabled(lengthShed);
            bom.add(tiesgabled);
            int tiessides = calc.interTiesChedSides(widthShed);
            bom.add(tiessides);
            bom.add(calc.remsOnSides(widthShed, lengthShed));
            bom.add(calc.remsOnShed(widthShed));
            int rafter = calc.rafter(width, length);
            bom.add(rafter);
            int posts = calc.posts(width, length, lengthShed);
            bom.add(posts);
            int cladding = calc.cladding(widthShed, lengthShed);
            bom.add(cladding);
            bom.add(calc.vandbraetOnSternSides(overSternS));
            bom.add(calc.vandbraetOnSternFront(overSternF));
            int bigRoof = calc.bigRoofPlates(length);
            bom.add(bigRoof);
            int smallRoof = calc.SmallRoofPlates(length);
            bom.add(smallRoof);
            bom.add(calc.roofScrews(bigRoof + smallRoof));
            bom.add(calc.holeband());
            int rb = calc.rafterBracketRight(rafter);
            bom.add(rb);
            int lb = calc.rafterBracketLeft(rafter);
            bom.add(lb);
            bom.add(calc.screwsVandbraetAndStern(underSternFAB, underSternS, overSternF, overSternS));
            bom.add(calc.screwsForUniAndBand(lb + rb));
            bom.add(calc.carriageBolt(posts));
            bom.add(calc.squareSlices(posts));
            bom.add(calc.claddingScrewsExternal(cladding));
            bom.add(calc.claddingScrewsInternal(cladding));
            bom.add(calc.handle(widthShed, lengthShed));
            bom.add(calc.tHinge(widthShed, lengthShed));
            bom.add(calc.angleBrackets(tiesgabled, tiessides));

            Shed shed = new Shed(lengthShed, widthShed, 500);
            SVGBuilderTop svgTop = new SVGBuilderTop(roof, length, width, shed, material);
            SVGBuilderSide svgSide = new SVGBuilderSide(roof, length, width, shed, material);
            session.setAttribute("SVGTopView", svgTop.buildSvgTopView(svgTop));
            session.setAttribute("SVGSideView", svgSide.buildSvgSideView(svgSide));
            Order order = new Order(height, length, width);

            int shedID = LogicFacade.createShed(shed, userID);
            LogicFacade.createOrder(userID, 500, order, roof, shedID);
            OrderMapper.createBill(bom, OrderMapper.getUserLatestOrder(user.getId()));
            return "customerpage";
        } catch (OrderException ex) {
            request.setAttribute("error", ex.getStackTrace());
            return "errorPage";
        }
    }
}

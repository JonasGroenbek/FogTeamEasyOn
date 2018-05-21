package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillCalc {

private ArrayList<Integer> list = new ArrayList();
    

    private void underSternBoardFrontAndBack(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        list.add(boards * 2);
    }

    private void underSternBoardSides(int width) {
        int boards = width / 540;
        if (width % 540 != 0) {
            boards++;
        }

         list.add(boards);
    }

    private void overSternBoardFront(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        list.add(boards*2);
    }

    private void overSternBoardSides(int length) {
        int boards = length / 540;
        if (length % 540 != 0) {
            boards++;
        }
        list.add(boards);
    }

    private void zOnDoor(int id) {
        int door = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            door = 1;
        }
        list.add(door);
    }

    private void interTiesShedGabled(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        int interTies = (shedLength / 270);
        if (shedLength % 270 != 0) {
            interTies++;
        }
        interTies *= 2;
        list.add(interTies *= 2);
    }

    private void interTiesChedSides(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedWidth = shed.getWidth();
        int interTies = shedWidth / 240;
        if (shedWidth % 240 != 0) {
            interTies++;
        }
        list.add(interTies * 2);
    }

    private void remsOnSides(int width, int OrderID) throws ClassNotFoundException, SQLException, LoginSampleException {
        if (OrderMapper.getOrder(OrderID).getShed() == 0) {
            int boards = width / 600;
            if (width % 600 != 0) {
                boards++;
                list.add(boards * 2);
            }
        }
        if (OrderMapper.getOrder(OrderID).getShed() != 0) {
            Order order = OrderMapper.getOrder(OrderID);
            Shed shed = OrderMapper.getShed(order.getShed());
            int shedLength = shed.getLength();
            int boards = (width - shedLength) / 600;
            if ((width - shedLength) % 600 != 0) {
                boards++;
                list.add(boards * 2);
            }
        }

        
    }

    private void remsOnShed(int shedWidth) {
        int boards = shedWidth / 480;
        if (shedWidth % 480 != 0) {
            boards++;
        }
        if (shedWidth / 2 <= 480) {
            list.add(boards);
        } else {
            list.add(boards * 2);
        }

    }

    private void rafter(int width, int length) {
        int rafter = 0;
        if (length <= 600) {
            rafter = (width - rafter * 2) / (60 + rafter) + 2;
            list.add(rafter);
        } else {
            int rest = length - 600;
            rafter = (width - rafter * 2) / (60 + rafter) + 2 + (600 / rest);
            list.add(rafter);
        }
    }

    private void posts(int width, int ID, int length) throws ClassNotFoundException, SQLException, LoginSampleException {
        int posts = 1;
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        if (OrderMapper.getOrder(ID).getShed() == 0) {
            posts += (width / 250) * 2 + (length / 250);
            list.add(posts);
        } else if (length - 70 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 3;
            list.add(posts);
        } else if ((length - 70) / 2 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 2;
            list.add(posts);
        } else {
            posts += (width / 250) * 2 + (length / 250) + 3;
            list.add(posts);
        }
    }

    private void cladding(int shedWidth, int shedLength) throws ClassNotFoundException, SQLException, LoginSampleException {
        int circumference = (shedLength * 2) + (shedWidth * 2);
        int cladding = circumference / 6;
        if (circumference % 6 != 0) {
            cladding++;
        }
        list.add(cladding);
    }

    private void vandbraetOnSternSides(int overSternBoardsSides) {
        int vandbreat = overSternBoardsSides;
        list.add(vandbreat);
    }

    private void vandbraetOnSternFront(int overSternBoardsFront) {
        int vandbraet = overSternBoardsFront;
        list.add(vandbraet);
    }

    private void bigRoofPlates(int length) {
        int plates = length / 10;
        if (length % 10 != 0) {
            plates++;
        }
        list.add(plates);
    }

    private void SmallRoofPlates(int length) {
        int plates = length / 10;
        if (length % 10 != 0) {
            plates++;
        }
        list.add(plates);
    }

    private void roofScrews(int roofplates) {
        int screws = roofplates / 2;
        if (roofplates % 2 != 0) {
            screws++;
        }
        list.add(screws);
    }

    private void holeband() {
        int holeband = 2;
        list.add(holeband);
    }

    private void rafterBracketRight(int rafters) {
        int brackets = rafters;
        list.add(brackets);
    }

    private void rafterBracketLeft(int rafters) {
        int brackets = rafters;
        list.add(brackets);
    }
    
    private void screwsVandbraetAndStern(int underSternFrontAndBack, int underSternSides, int overSternFront, int overSternSides ){
     int screws = (overSternFront+overSternSides)*2+underSternFrontAndBack+underSternSides*10/200;
     if((overSternFront+overSternSides)*2+underSternFrontAndBack+underSternSides*10%200 != 0){
     screws++;
     }
     list.add(screws);
    }

    private void screwsForUniAndBand(int uniBrackets) {
        int screws = 250 / (uniBrackets * 2 + 2) / 3;
        if (250 % (uniBrackets * 2 + 2) / 3 != 0) {
            screws++;
        }
        list.add(screws);
    }

    private void carriageBolt(int posts, int id) {
        int screws = posts*2;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            screws -= 4;
        }
        list.add(screws);
    }

    private void squareSlices(int posts) {
        int slices = posts;
        list.add(slices);
    }

    private void claddingScrewsExternal(int cladding) {
        list.add(cladding / 100);
    }

    private void claddingScrewsInternal(int cladding) {
        list.add(cladding / 100);
    }

    private void handle(int id) {
        int handle = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            handle = 1;
        }
        list.add(handle);
    }

    private void tHinge(int id) {
        int hinge = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            hinge = 2;
        } 
        list.add(hinge);
    }

    private void angleBrackets(int interTiesGabel, int interTiesSides) {
        int brackets = (interTiesGabel + interTiesSides) * 2;
        list.add(brackets);
    }

    public ArrayList<Integer> getList() {
        return list;
    }
    
}

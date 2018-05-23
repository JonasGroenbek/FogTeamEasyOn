package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;

public class BillCalc {


    

    public int underSternBoardFrontAndBack(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    public int underSternBoardSides(int width) {
        int boards = width / 540;
        if (width % 540 != 0) {
            boards++;
        }

         return boards;
    }

    public int overSternBoardFront(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards*2;
    }

    public int overSternBoardSides(int length) {
        int boards = length / 540;
        if (length % 540 != 0) {
            boards++;
        }
        return boards;
    }

    public int zOnDoor(int id) {
        int door = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            door = 1;
        }
        return door;
    }

    public int interTiesShedGabled(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        int interTies = (shedLength / 270);
        if (shedLength % 270 != 0) {
            interTies++;
        }
        interTies *= 2;
        return interTies *= 2;
    }

    public int interTiesChedSides(int ID) throws ClassNotFoundException, SQLException, LoginSampleException {
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedWidth = shed.getWidth();
        int interTies = shedWidth / 240;
        if (shedWidth % 240 != 0) {
            interTies++;
        }
        return interTies * 2;
    }

    public int remsOnSides(int width, int OrderID) throws ClassNotFoundException, SQLException, LoginSampleException {
        if (OrderMapper.getOrder(OrderID).getShed() == 0) {
            int boards = width / 600;
            if (width % 600 != 0) {
                boards++;
                return boards * 2;
            }
        }
        if (OrderMapper.getOrder(OrderID).getShed() != 0) {
            Order order = OrderMapper.getOrder(OrderID);
            Shed shed = OrderMapper.getShed(order.getShed());
            int shedLength = shed.getLength();
            int boards = (width - shedLength) / 600;
            if ((width - shedLength) % 600 != 0) {
                boards++;
                return boards * 2;
            }
        }
        return 0;
        
    }

    public int remsOnShed(int shedWidth) {
        int boards = shedWidth / 480;
        if (shedWidth % 480 != 0) {
            boards++;
        }
        if (shedWidth / 2 <= 480) {
            return boards;
        } else {
            return boards * 2;
        }

    }

    public int rafter(int width, int length) {
        int rafter = 0;
        if (length <= 600) {
            rafter = (width - rafter * 2) / (60 + rafter) + 2;
            return rafter;
        } else {
            int rest = length - 600;
            rafter = (width - rafter * 2) / (60 + rafter) + 2 + (600 / rest);
            return rafter;
        }
    }

    public int posts(int width, int ID, int length) throws ClassNotFoundException, SQLException, LoginSampleException {
        int posts = 1;
        Order order = OrderMapper.getOrder(ID);
        Shed shed = OrderMapper.getShed(order.getShed());
        int shedLength = shed.getLength();
        if (OrderMapper.getOrder(ID).getShed() == 0) {
            posts += (width / 250) * 2 + (length / 250);
            return posts;
        } else if (length - 70 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 3;
            return posts;
        } else if ((length - 70) / 2 == shed.getLength()) {
            posts += (width / 250) * 2 + (length / 250) + 2;
            return posts;
        } else {
            posts += (width / 250) * 2 + (length / 250) + 3;
            return posts;
        }
    }

    public int cladding(int shedWidth, int shedLength) throws ClassNotFoundException, SQLException, LoginSampleException {
        int circumference = (shedLength * 2) + (shedWidth * 2);
        int cladding = circumference / 6;
        if (circumference % 6 != 0) {
            cladding++;
        }
        return cladding;
    }

    public int vandbraetOnSternSides(int overSternBoardsSides) {
        int vandbreat = overSternBoardsSides;
        return vandbreat;
    }

    public int vandbraetOnSternFront(int overSternBoardsFront) {
        int vandbraet = overSternBoardsFront;
        return vandbraet;
    }

    public int bigRoofPlates(int length) {
        int plates = length / 10;
        if (length % 10 != 0) {
            plates++;
        }
        return plates;
    }

    public int SmallRoofPlates(int length) {
        int plates = length / 10;
        if (length % 10 != 0) {
            plates++;
        }
        return plates;
    }

    public int roofScrews(int roofplates) {
        int screws = roofplates / 2;
        if (roofplates % 2 != 0) {
            screws++;
        }
        return screws;
    }

    public int holeband() {
        int holeband = 2;
        return holeband;
    }

    public int rafterBracketRight(int rafters) {
        int brackets = rafters;
        return brackets;
    }

    public int rafterBracketLeft(int rafters) {
        int brackets = rafters;
        return brackets;
    }
    
    public int screwsVandbraetAndStern(int underSternFrontAndBack, int underSternSides, int overSternFront, int overSternSides ){
     int screws = (overSternFront+overSternSides)*2+underSternFrontAndBack+underSternSides*10/200;
     if((overSternFront+overSternSides)*2+underSternFrontAndBack+underSternSides*10%200 != 0){
     screws++;
     }
     return screws;
    }

    public int screwsForUniAndBand(int uniBrackets) {
        int screws = 250 / (uniBrackets * 2 + 2) / 3;
        if (250 % (uniBrackets * 2 + 2) / 3 != 0) {
            screws++;
        }
        return screws;
    }

    public int carriageBolt(int posts, int id) {
        int screws = posts*2;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            screws -= 4;
        }
        return screws;
    }

    public int squareSlices(int posts) {
        int slices = posts;
        return slices;
    }

    public int claddingScrewsExternal(int cladding) {
        return cladding / 100;
    }

    public int claddingScrewsInternal(int cladding) {
        return cladding / 100;
    }

    public int handle(int id) {
        int handle = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            handle = 1;
        }
        return handle;
    }

    public int tHinge(int id) {
        int hinge = 0;
        if (OrderMapper.getOrder(id).getShed() != 0) {
            hinge = 2;
        } 
        return hinge;
    }

    public int angleBrackets(int interTiesGabel, int interTiesSides) {
        int brackets = (interTiesGabel + interTiesSides) * 2;
        return brackets;
    }


    
}

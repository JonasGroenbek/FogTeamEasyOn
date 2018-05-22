package FunctionLayer;

import DBAccess.OrderMapper;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillCalc {
    
    public static void main(String[] args) {
    }

    public int underSternBoardFrontAndBack(int length) {
        int boards =  length/360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    public int underSternBoardSides(int width) {
        int boards = width/540;
        if (width % 540 != 0) {
            boards++;
        }

        return boards*2;
    }

    public int overSternBoardFront(int length) {
        int boards = length / 360;
        if (length % 360 != 0) {
            boards++;
        }
        return boards * 2;
    }

    public int overSternBoardSides(int length) {
        int boards = length / 540;
        if (length % 540 != 0) {
            boards++;
        }
        return boards;
    }

    public int zOnDoor(int shedl, int shedw) {
        int door = 0;
        if (shedl != 0 || shedw != 0) {
            door = 1;
        }
        return door;
    }

    public int interTiesShedGabled(int shedl) {
        int interTies = (shedl / 270);
        if (shedl % 270 != 0) {
            interTies++;
        }
        interTies *= 2;
        return interTies *= 2;
    }

    public int interTiesChedSides(int shedw) {

        int interTies = shedw / 240;
        if (shedw % 240 != 0) {
            interTies++;
        }
        return interTies * 2;
    }

    public int remsOnSides(int width, int shedl) {
        if (shedl == 0) {
            int boards = width / 600;
            if (width % 600 != 0) {
                boards++;
                return boards * 2;
            }
        } else {
            int boards = (width - shedl) / 600;
            if ((width - shedl) % 600 != 0) {
                boards++;
                return boards * 2;
            }
        }
        return 0;

    }

    public int remsOnShed(int shedWidth) {
        if (shedWidth == 0) {
            return 0;
        } else {
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

    public int posts(int width, int length, int shedl){
        int posts = 1;
        if (shedl == 0) {
            posts += (width / 250) * 2 + (length / 250);
            return posts;
        } else if (length - 70 == shedl){
            posts += (width / 250) * 2 + (length / 250) + 3;
            return posts;
        } else if ((length - 70) / 2 == shedl) {
            posts += (width / 250) * 2 + (length / 250) + 2;
            return posts;
        } else {
            posts += (width / 250) * 2 + (length / 250) + 3;
            return posts;
        }
    }

    public int cladding(int shedWidth, int shedLength){
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

    public int screwsVandbraetAndStern(int underSternFrontAndBack, int underSternSides, int overSternFront, int overSternSides) {
        int screws = (overSternFront + overSternSides) * 2 + underSternFrontAndBack + underSternSides * 10 / 200;
        if ((overSternFront + overSternSides) * 2 + underSternFrontAndBack + underSternSides * 10 % 200 != 0) {
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

    public int carriageBolt(int posts) {
        int bolts = posts;
        return bolts;
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

    public int handle(int shedw, int shedl) {
        int handle = 0;
        if (shedl != 0 && shedl != 0 ) {
            handle = 1;
        }
        return handle;
    }

    public int tHinge(int shedw, int shedl) {
        int hinge = 0;
        if (shedl != 0 && shedl != 0) {
            hinge = 2;
        }
        return hinge;
    }

    public int angleBrackets(int interTiesGabel, int interTiesSides) {
        int brackets = (interTiesGabel + interTiesSides) * 2;
        return brackets;
    }

}

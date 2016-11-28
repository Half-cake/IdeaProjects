package Boxes;

/**
 * Created by Aleksey Zhulanov on 25.10.2016.
 */

class Box {
    //Переменные для Box
    double hight;
    double wight;
    double dept;

    Box (Box ob){
        hight = ob.hight;
        wight = ob.wight;
        dept = ob.dept;
    }

    //Конструктор для Box
    Box(double d, double h, double w) {
        dept = d;
        wight = w;
        hight = h;
    }
    //Конструктор для Cube
    Box(double len){
        wight = hight = dept = len;
    }

        //Метод расчета объема
        double volume() {
            return dept * hight * wight;
        }

        //переопределение метода для того что бы сравнивать объекты
        boolean equals(Box ob){
            if (ob.hight == hight && ob.wight == wight && ob.dept == dept) {
                return true;
            } else {
                return false;
            }
        }
    }

class BoxDemo {
    public static void main (String[] args) {
        double vol;
        Box box1 = new Box(46.07,69.07,78.08);
        Box box2 = new Box(67.07,99.07,78.08);
        Box box3 = new Box(67.07,99.07,78.08);
        Box cube1 = new Box(10);

        System.out.println("Кробка 2 и 3:"+box2.equals(box3));

        System.out.println("Объем коробки " + box1.volume());
        System.out.println("Объем куба " + cube1.volume());
        System.out.println("Объем коробки " + box2.volume());
    }


}



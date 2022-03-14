package com.zhangs.design;


import com.zhangs.design.principle.dependency.after.Cpu;
import com.zhangs.design.principle.dependency.after.Disk;
import com.zhangs.design.principle.dependency.after.JinShanCpu;
import com.zhangs.design.principle.dependency.after.Memory;
import com.zhangs.design.principle.dependency.before.Computer;
import com.zhangs.design.principle.dependency.before.IntelCpu;
import com.zhangs.design.principle.dependency.before.KingstonMemory;
import com.zhangs.design.principle.dependency.before.XiJieHardDisk;
import com.zhangs.design.principle.openClose.Boss;
import com.zhangs.design.principle.openClose.XiaoHong;
import com.zhangs.design.principle.openClose.XiaoMing;
import com.zhangs.design.principle.quarantine.after.ItcastSafetyDoor;
import com.zhangs.design.principle.quarantine.before.HeimaSafetyDoor;
import com.zhangs.design.principle.richter.Rectangle;
import com.zhangs.design.principle.richter.RectangleDemo;
import com.zhangs.design.principle.richter.Square;
import com.zhangs.pattern.factory.abstarct_factory.*;
import com.zhangs.pattern.factory.before.CoffeeStore;
import com.zhangs.pattern.factory.config_factory.Coffee4;
import com.zhangs.pattern.factory.config_factory.CoffeeFactory4;
import com.zhangs.pattern.factory.factory_method.*;
import com.zhangs.pattern.factory.simple_factory.CoffeeStore1;
import com.zhangs.pattern.single.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignApplicationTests {

    /*
     *设计原则
     * ==============================================================================
     */
    //开闭原则
    @Test
    public void contextLoads() {
        //假设老板需要招会炒鸡蛋的厨师
        Boss boss=new Boss();
        boss.recruit(new XiaoMing());

        //加入几天后老板又需要找会炒土豆的厨师，  这时候我们只需要重新加一个会炒土豆的xiaohong, 不需要更改原来的代码
        boss.recruit(new XiaoHong());
    }

    //里氏代换原则
    @Test
    public void richterTest(){
        //当对长方形进行拓宽方法时没问题
        RectangleDemo rectangleDemo=new RectangleDemo();
        Rectangle rectangle=new Rectangle();
        rectangle.setWide(5);
        rectangle.setLength(6);
        rectangleDemo.resize(rectangle);

        //但是如果对长方形的子类正方形拓宽，进入死循环，  违背了里氏代替原则
        Square square=new Square();
        square.setWide(5);
        rectangleDemo.resize(square);
    }

    //依赖倒转原则
    @Test
    public void dependencyTest(){
        Computer computer=new Computer();
        computer.setIntelCpu(new IntelCpu());
        computer.setKingstonMemory(new KingstonMemory());
        computer.setXiJieHardDisk(new XiJieHardDisk());
        computer.run();

        /*
         *此时电脑虽然可以运行，但是cpu,硬盘，内存条都是固定的，如果我要换一个cup,内存条,硬盘，还需要修改电脑类，这样不方便扩展
         * 所以在电脑里面依赖的应该是cup ,  硬盘,  内存条的抽象类或接口, 当需要修改是,  只需要多态向下转型，使用不同的子对象
         */
        com.zhangs.design.principle.dependency.after.Computer afterComputer=new com.zhangs.design.principle.dependency.after.Computer();
        Cpu cpu=new com.zhangs.design.principle.dependency.after.IntelCpu();
        afterComputer.setIntelCpu(cpu);
        Memory memory=new com.zhangs.design.principle.dependency.after.KingstonMemory();
        afterComputer.setKingstonMemory(memory);
        Disk disk=new com.zhangs.design.principle.dependency.after.XiJieHardDisk();
        afterComputer.setXiJieHardDisk(disk);
        afterComputer.run();
        System.out.println("更改cpu------------------------------------------------------");
        //更换cpu
        Cpu jinCpu=new JinShanCpu();
        afterComputer.setIntelCpu(jinCpu);
        afterComputer.run();

    }


    //接口隔离原则
    @Test
    public void quarantineTest(){
        //将防火，防盗，防水功能做成独立接口,  不同类型的门实现不同接口，就可以灵活的具有不同功能了
        //创建黑马安全门对象
        HeimaSafetyDoor door = new HeimaSafetyDoor();
        //调用功能
        //调用功能
        door.antiTheft();
        door.fireProof();
        door.waterProof();

        System.out.println("============");
        //创建传智安全门对象
        ItcastSafetyDoor door1 = new ItcastSafetyDoor();

        //调用功能
        door1.antiTheft();
        door1.fireproof();

    }


    /*
     *================================================
     * 设计模式
     */

    //单例模式
    @Test
    public void singletonTest() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //饿汉模式
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 =Singleton.getSingleton();
        if(singleton==singleton1){
            System.out.println("饿汉模式: 单例模式只会创建一个对象");
        }

        Singleton1 singleton2 = Singleton1.getSingleton();
        Singleton1 singleton3 = Singleton1.getSingleton();
        if(singleton2==singleton3){
            System.out.println("饿汉模式: 单例模式只会创建一个对象");
        }

        //懒汉模式
        Singleton2 singleton4 = Singleton2.getSingleton();

        //懒汉模式     静态内部类创建对象
        Singleton4 singleton5 = Singleton4.getSingleton();
        Singleton4 singleton6 = Singleton4.getSingleton();
        if(singleton2==singleton3){
            System.out.println("懒汉模式: 静态内部类创建对象");
        }

        /*
        *单例模式破坏方式
        * 1：序列化        2：反射
        */
        //序列化破坏单例模式   以懒汉模式 ,静态内部类举例
        //----将对象输出到文件中
        Singleton5 singleton7 = Singleton5.getSingleton();
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("C:\\designMode\\a.txt"));
        outputStream.writeObject(singleton7);
        outputStream.close();
        //  读取文件转为对象
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("C:\\designMode\\a.txt"));
        Singleton5 singleton8 = (Singleton5) objectInputStream.readObject();
        ObjectInputStream objectInputStream1=new ObjectInputStream(new FileInputStream("C:\\designMode\\a.txt"));
        Singleton5 singleton9 = (Singleton5) objectInputStream1.readObject();
        objectInputStream.close();
        objectInputStream1.close();
        if(singleton8!=singleton9){
            System.out.println("不构成单例模式定义，单例模式被破坏");
        }


        //反射破坏单例模式   解决方法，在构造方法中进行对象判断
        //获取字节码对象
        Class<Singleton5> singleton5Class = Singleton5.class;
        //获取无参构造对象
        Constructor declaredConstructors = singleton5Class.getDeclaredConstructor();
        //取消访问检查
        declaredConstructors.setAccessible(true);
        //创建对象
        Singleton5 singleton10 = (Singleton5) declaredConstructors.newInstance();
        Singleton5 singleton11 = (Singleton5) declaredConstructors.newInstance();
        System.out.println(singleton10);
        System.out.println(singleton11);

        Class<Singleton6> singleton6Class = Singleton6.class;
        //获取无参构造对象
        Constructor declaredConstructors1 = singleton6Class.getDeclaredConstructor();
        //取消访问检查
        declaredConstructors1.setAccessible(true);
        //创建对象
        Singleton6 singleton12 = (Singleton6) declaredConstructors1.newInstance();
        System.out.println("singleton12:"+singleton12);
        Singleton6 singleton13 = (Singleton6) declaredConstructors1.newInstance();
        System.out.println(singleton13);



        //单例模式实例  ：runTime
//        Runtime runtime1 = Runtime.getRuntime();
//        Runtime runtime2 = Runtime.getRuntime();
//        System.out.println("runtime1:"+runtime1);
//        System.out.println("runtime2:"+runtime2);

    }


    //创建者模式
    @Test
    public void createUserTest(){
        //以咖啡为类。  现有摩卡和拿铁两种咖啡， 咖啡店可以订购不同类型咖啡
        CoffeeStore coffeeStore=new CoffeeStore();
        coffeeStore.orderCoffee("latte");
        coffeeStore.orderCoffee("mocha");
        /*
        *上面这种设计然看可以实现业务需求，但是咖啡店和咖啡的耦合度太高。 假如现在新出了一款咖啡，
        * 那么我还需要在咖啡店类里面修改代码，显然不符合开闭原则
        */

        System.out.println("简单工厂模式==================================================");

        /*
         * 简单工厂模式   并没有遵从开闭原则
         */
        CoffeeStore1 coffeeStore1=new CoffeeStore1();
        coffeeStore1.orderCoffee("mocha");
        coffeeStore1.orderCoffee("latte");


        /*
         * 工厂方法模式   遵从了开闭原则
         */
        System.out.println("工厂方法模式==================================================");
        CoffeeStore2 coffeeStore2=new CoffeeStore2();
        CoffeeFactory2 coffeeFactory2=new LatteCoffeeFactory2();
        coffeeStore2.setCoffeeFactory2(coffeeFactory2);
        coffeeStore2.orderCoffee();
        CoffeeFactory2 mochaCoffeeFactory2=new MochaCoffeeFactory2();
        coffeeStore2.setCoffeeFactory2(mochaCoffeeFactory2);
        coffeeStore2.orderCoffee();


        /**
         *抽象工厂模式
         * 一个工厂生产不同产品等级的商品
         */
        System.out.println("抽象工厂模式==================================================");
        DessertFactory arabDessertFactory=new ArabDessertFactory();
        Coffee3 coffee = arabDessertFactory.createCoffee();
        Dessert dessert = arabDessertFactory.createDessert();
        coffee.getName();
        dessert.show();

        DessertFactory arabDessertFactory1=new ItalyDessertFactory();
        Coffee3 coffee1 = arabDessertFactory1.createCoffee();
        Dessert dessert1 = arabDessertFactory1.createDessert();
        coffee1.getName();
        dessert1.show();


        /*
        * 扩展模式
        */
        System.out.println("模式扩展==================================================");
        CoffeeFactory4 coffeeFactory4=new CoffeeFactory4();
        Coffee4 mocha = coffeeFactory4.getCoffee("mocha");
        mocha.getName();
        Coffee4 latte = coffeeFactory4.getCoffee("latte");
        latte.getName();

    }


//    @Test
//    public void getUUID(){
//        for(int i=0;i<460;i++){
//            String uuid = "P" + IdWorker.getIdStr();
//            System.out.println(uuid);
//        }
//    }



}

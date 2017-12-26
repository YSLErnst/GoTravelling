package com.hand.ysl.demo.design.compositeDesign.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Ernst on 2017/9/7.
 */
public abstract class CompositeEquipment extends Equipment{

    private int i=0;

    private List<Equipment> equipmentList = new ArrayList();

    public CompositeEquipment(String name) {
        super(name);
    }

    public boolean add(Equipment equipment){
        if(equipment instanceof Disk && this instanceof Chassis){
            System.out.println("在盘盒里放了个硬盘");
        }else if(equipment instanceof Chassis && this instanceof Cabinet){
            System.out.println("在柜子里放了个盘盒");
        }
        this.equipmentList.add(equipment);
        return true;
    }

    public double originPrice(){
        double originPrice = 0.0;
        if(this instanceof Chassis){
            System.out.println("我是盘盒，盘盒本身价格是："+Chassis.chassisOriginPrice);
        }else if(this instanceof Cabinet){
            System.out.println("我是柜子，柜子本身价格是："+Cabinet.originCabinetPrice);
        }

        Iterator<Equipment> iterator = equipmentList.iterator();
        while (iterator.hasNext()){
            Equipment e = iterator.next();
            if(e instanceof Chassis){
                System.out.println("在柜子里面发现一个盘盒，计算它的价格");
            }else if(e instanceof Cabinet){
                System.out.println("在盘盒里发下一个硬盘，计算它的价格");
                System.out.println("硬盘本身价格为："+Disk.diskOriginPrice);
            }
            originPrice +=e.originPrice();
        }
        return originPrice;
    }

    public double discountPrice(){
        double discountPrice = 0.0;
        Iterator<Equipment> iterator = equipmentList.iterator();
        while(iterator.hasNext()){
            Equipment e = iterator.next();
            discountPrice += e.discountPrice();
        }
        return discountPrice;
    }

    // 这里提供用于访问自己组合体内的部件方法。
    // 上面Disk之所以没有，是因为Disk是个单独(Primitive)的元素.
    public Iterator iter() {
        return equipmentList.iterator();
    }

    // 重载Iterator方法
    public boolean hasNext() {
        return i < equipmentList.size();
    }

    // 重载Iterator方法
    public Object next() {
        if (hasNext())
            return equipmentList.get(i++);
        else
            throw new NoSuchElementException();
    }


}

package com.hand.ysl.demo.design.TemplateDesign.controller;


import com.hand.ysl.demo.design.TemplateDesign.dto.FloatBubleSort;
import com.hand.ysl.demo.design.TemplateDesign.dto.IntBubleSort;
import com.hand.ysl.demo.design.strategyDesign.Interface.ICaculator;
import com.hand.ysl.demo.design.strategyDesign.dto.Plus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/9/13.
 * 模板方法模式
 *　模板方法模式通过把不变的行为搬移到超类，去除了子类中的重复代码。
 *  子类实现算法的某些细节，有助于算法的扩展。
 *　通过一个父类调用子类实现的操作，通过子类扩展增加新的行为，符合“开放-封闭原则”。
 *
 */
@Controller("BubleSortController")
@RequestMapping("/template")
public class BubleSortController {

    /*
    浅拷贝
     */
    @RequestMapping(value = "/templateTest", method = RequestMethod.GET)
    public void strategyTest() {
        int[] intArr = new int[]{1,7,5,9,3,6,4};
        IntBubleSort intBubleSort = new IntBubleSort();
        intBubleSort.Sort(intArr);
        for(int a:intArr){
            System.out.println(a);
        }

        float[] floatArr = new float[]{1.0f,8.0f,9.0f,5.0f,3.0f,7.0f,5.0f};
        FloatBubleSort floatBubleSort = new FloatBubleSort();
        floatBubleSort.Sort(floatArr);
        for(float a:floatArr){
            System.out.println(a);
        }
    }

}

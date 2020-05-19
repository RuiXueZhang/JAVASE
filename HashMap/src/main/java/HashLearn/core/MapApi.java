package HashLearn.core;

//import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapApi {

    public void relationship(){

        //HashMap根据键的hashcode值存储元素，大多数情况下会很快定位到他的值，所以具有很快的访问速度，但是遍历顺序是不一定的
        //HashMap最多只允许一条记录的键为null，允许多条记录的值为null，HashMap为非线程安全
        //问题：如何让HashMap拥有线程安全的能力

        HashMap<String,String> map = new HashMap();
        map.put("name","ruix");

        System.out.println(map);

        //HashTable是遗留类，不需要线程安全的场合可以使用HashMap，需要线程安全的使用currentHashMap
        //HashTable的使用场景

        Hashtable<String,String> hashtable = new Hashtable();
        hashtable.put("name","ruix");

        System.out.println(hashtable);

        //LinkedHashMap :HashMap的子类，保留记录的插入顺序
        //用iterator遍历的时候得到的记录肯定是先插入的

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("age",23);



        //可以在构造的时候带参数

        LinkedHashMap linkedHashMap1 = new LinkedHashMap(map);


        //可以按照访问次序排序


        //TreeMap 实现 SortedMap接口，将保留的记录根据键排序，默认按键值的升序排序

        TreeMap treeMap = new TreeMap();

        //也可以指定排序的比较器

        //用iterator遍历TreeMap的时候，得到的记录时排过序的

        //在使用TreeMap的时候，key必须实现Comparable接口或者在构造TreeMap传入自定义的Comparable

    }

    public static void main(String[] args){

        System.out.println((boolean)Boolean.FALSE);
        System.out.println((Boolean)null);
        //System.out.println("true".equals(null));
    }
}

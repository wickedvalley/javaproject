package com.wickedvalley.datastructure.test;

import com.wickedvalley.datastructure.domain.Person;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import org.jooq.lambda.Seq;

public class Main {

    public static void main(String[] args) {
        List<String> listA = Arrays.asList("1-10", "1-11");

        List<String> listB = Arrays.asList("1-10", "1-13");

        boolean exist = listA.containsAll(listB) && listB.containsAll(listA);

        System.out.println(exist);

        Person personA = new Person(1001, "AAA", 25);
        Person personB = new Person(1002, "BBB", 23);
        Person personC = new Person(1003, "CCC", 27);

        System.out.println("A是否和B相同："+personA.equals(personB));

        List<Person> personList = new ArrayList<>();
        personList.add(personA);
        personList.add(personB);
        personList.add(personC);

        //list转为map
        Map<Integer, String> result = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName));

        //lambda表达式扩展：对list集合处理
        List<Person> list = Seq.seq(personList).map(person -> {
            person.setName(person.getName() + new Random().nextInt(10));
            return person;
        }).filter(person -> person != null)
                .toList();
        System.out.println(list);

        //对象转为Optional
        try {
            Person person = Optional.of(personA).orElseThrow(() -> new Exception());
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Seq中groupBy使用
        Seq.range(1, 10).groupBy(integer -> integer % 2 == 0).forEach((key, value) -> {
            if (key){
                System.out.println(value);
            }
        });

        //通过seq生成想要的对象
        String  seq = Seq.of(1, 2, 3, 4, 5).toString(", ");
        Set<Integer> set = Seq.of(1, 2, 3, 4, 5,2).collect(Collectors.toSet());
        System.out.println(seq);
        System.out.println(set);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now().minusSeconds(5*60), ZoneId.systemDefault());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);


    }


}

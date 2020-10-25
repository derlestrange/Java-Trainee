package hiber.main;

import hiber.dao.HumanDaoImplements;
import hiber.entity.Human;
import hiber.service.ServiceImplements;
import hiber.service.IService;
import hiber.util.HibernateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        IService<Human> humanGenericService = new ServiceImplements<Human>
                (Human.class, HibernateUtil.getSessionFactory());


        List<Human> humanList = humanGenericService.getAll();
//        if (humanList != null) {
//           humanList.forEach(System.out::println);
//        }

//        humanGenericService.get(6);
//
//        Date date = new Date(2, Calendar.MARCH, 1983);
//        Integer i = 9;
//        Human human = new Human("Tim", "Los Angeles", date, true);
//        humanGenericService.save(human);


        humanGenericService.delete(humanList.get(7));


    }

}

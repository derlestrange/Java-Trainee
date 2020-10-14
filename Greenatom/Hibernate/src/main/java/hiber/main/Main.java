package hiber.main;

import hiber.entity.Human;
import hiber.service.ServiceImplements;
import hiber.service.IService;
import hiber.util.HibernateUtil;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        IService<Human> humanGenericService = new ServiceImplements<Human>
                (Human.class, HibernateUtil.getSessionFactory());

        List<Human> humanList = humanGenericService.getAll();
        if (humanList != null) {
            for (Human human : humanList) {
                System.out.println("Id: " + human.getId());
                System.out.println("Name: " + human.getName());
                System.out.println("Age: " + human.getBirth().toString());
                System.out.println("Married: " + human.getMarried().toString());
                System.out.println("Address: " + human.getAdress());
            }
        }


    }

}

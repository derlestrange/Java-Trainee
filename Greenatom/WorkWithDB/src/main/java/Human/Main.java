package Human;

public class Main {
    public static void main(String[] args) {
        try {
            HumanDao humanDao = new HumanDao();
            //humanDao.delete(7);
            humanDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        try {
//            HumanDao humanDao = new HumanDao();
//            Date date = new Date(2, Calendar.MARCH, 1983);
//            Human h = new Human("Tim", "Los Angeles", date, true);
//            humanDao.insert(h);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

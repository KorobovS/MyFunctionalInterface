import java.util.ArrayList;
import java.util.List;

public class TaskInterface {
    public static void main(String[] args) {

        List<Man> listMan = new ArrayList<>();
        listMan.add(new Man("Vasya"));
        listMan.add(new Man("Misha"));
        listMan.add(new Man("Bob"));

        System.out.println(listMan);

//        Lesson.Man.newName(listMan, new Bro() {
//            @Override
//            public String starBro(Man man) {
//                return "* " + man.name + " *";
//            }
//        });

        TaskInterface.Man.newName(listMan, n -> "--" + n + "--");

        System.out.println(listMan);
    }

    @FunctionalInterface
    static interface Bro {
        String starBro(Man man);
    }

    static class Man {
        String name;

        public Man(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public static List<Man> newName(List<Man> mans, Bro bro) {
            List<Man> newMans = new ArrayList<>();
            for (Man man : mans) {
                man.name = bro.starBro(man);
                newMans.add(man);
            }
            return newMans;
        }
    }
}

package ru.matevosyan.start;

import ru.matevosyan.models.Item;
import ru.matevosyan.models.Task;

/**
 * Created class StartUI for starting the program.
 * Created on 25.11.2016.
 * @since 1.0
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class StartUI {

    /**
     * The static main method which is starting our program.
     * @param args array of String elements
     */

    public static void main(String[] args) {

        /**
         * Instance variable tracker.
         */

        Tracker tracker = new Tracker();
        tracker.add(new Task("TaskName", "TaskDesk"));
        tracker.add(new Task("TaskName2", "TaskDesk"));
        tracker.add(new Item("TaskName3", "TaskDesk"));
        for (Item item : tracker.getAll()) {
            System.out.println(item);
        }

    }

}
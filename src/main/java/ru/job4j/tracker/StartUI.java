package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem(Input input, Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] result = tracker.findAll();
        for (Item i : result) {
            System.out.println(i);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edit success");
        } else {
            System.out.println("Edit failed!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Delete success");
        } else {
            System.out.println("Delete failed!");
        }
    }

    public static void foundItemById(Input input, Tracker tracker) {
        System.out.println("==== Found item ====");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item with this id found!");
        } else {
            System.out.println("Item not found!");
        }
    }

    public static void foundItemByName(Input input, Tracker tracker) {
        System.out.println("==== Found items by enter name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item i : items) {
                System.out.println(i);
            }
        } else {
            System.out.println("Items not found!");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.foundItemById(input, tracker);
            } else if (select == 5) {
                StartUI.foundItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

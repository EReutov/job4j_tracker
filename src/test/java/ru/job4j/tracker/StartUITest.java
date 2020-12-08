package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0","1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindId() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("One"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );

        UserAction[] actions = {
                new FoundByIdAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Found by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Found item by id ====" + System.lineSeparator() +
                        "Item with this id found!" +
                        System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. Found by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("One"));
        Input in = new StubInput(
                new String[] {"0", "One", "1"}
        );

        UserAction[] actions = {
                new FoundByNameAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Found by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Found items by enter name ====" + System.lineSeparator() +
                        "Item{id=1, name='One', created=" + item.getCreated() + "}" +
                        System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. Found by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("One"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );

        UserAction[] actions = {
                new ShowAllAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "==== Show all items ====" + System.lineSeparator() +
                        "Item{id=1, name='One', created=" + item.getCreated() + "}" +
                        System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. Show all" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

}
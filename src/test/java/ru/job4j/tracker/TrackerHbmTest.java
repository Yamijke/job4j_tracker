package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

public class TrackerHbmTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenReplaceItemThenGetNewName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            Item item2 = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.replace(item.getId(), item2);
            Item result = tracker.findById(item2.getId());
            assertThat(result.getName(), is(item2.getName()));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findByName("test1");
            assertThat(result, hasItem(item));
        }
    }
}

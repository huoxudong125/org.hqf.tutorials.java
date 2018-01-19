import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import  com.google.common.collect.Lists;

import static org.hamcrest.core.IsEqual.equalTo;

public class HumanTest {

    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        Collections.sort(humans, new Comparator<Human>() {

            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });
        System.out.println("humans = " + humans.get(0));
        Assert.assertEquals(humans.get(0).getName(),"Jack");
    }


    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

       // humans.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));
        Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }


    @Test
    public void givenInstanceMethod_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

        Collections.sort(humans, Comparator.comparing(Human::getName));
        Assert.assertEquals(humans.get(0).getName(),"Jack");
    }

    @Test
    public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        Assert.assertEquals(humans.get(0).getName(),"Sarah");
    }
}
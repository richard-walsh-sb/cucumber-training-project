package com.cucumber.training;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @DataTableType
    public PersonLocation defineGrocery(Map<String, String> entry) {
        return new PersonLocation(entry.get("name"), Integer.parseInt(entry.get("x")), Integer.parseInt(entry.get("y")));
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocations) {
        personLocations.forEach(p -> shouty.setLocation(p.getName(), p.getLocation()));
    }

    @Given("{word} is at {int}, {int}")
    public void personIsAt(String person, int xCoord, int yCoord) {
        shouty.setLocation(person, new Coordinate(xCoord, yCoord));
    }

    @When("{word} shouts")
    public void personShouts(String person) {
        shouty.shout(person, ARBITRARY_MESSAGE);
    }

    @When("{word} should hear Sean")
    public void lucy_should_hear_sean(String person) {
        assertTrue(shouty.getShoutsHeardBy(person).containsKey("Sean"));
    }

    @Then("{word} should hear nothing")
    public void person_should_hear_nothing(String person) {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy(person));
    }

    @Then("{word} should not hear {word}")
    public void lucyShouldNotHearOscar(String person, String otherPerson) {
        assertFalse(shouty.getShoutsHeardBy(person).containsKey(otherPerson));
    }

    @Then("Lucy should hear {int} shouts from Sean")
    public void lucyShouldHearShoutsFromSean(int shouts) {
        assertEquals(shouts, shouty.getShoutsHeardBy("Lucy").get("Sean").size());
    }

}
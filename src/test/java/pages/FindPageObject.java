package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class FindPageObject {

    /*
    <div id='level1elem1' name='LEVEL1 ELEMENT1'>
        <div id='level2elem1' name='LEVEL2 ELEMENT1'></div>
        <div id='level2elem2' name='LEVEL2 ELEMENT2'></div>
    </div>
     */

    //This will match an element (id of level2elem1) inside a parent element (id of level1elem1).
    //Refer to test - testFindBys.
    //Return a POSITIVE match.
    @FindBys({
            @FindBy(id="level1elem1"),
            @FindBy(id="level2elem1")
    })
    private WebElement singleFindBys;

    //This NEEDS TO MATCH an element (id of level1elem1) inside a parent element (id of level2elem1).
    //Refer to test - testFindBysRev.
    //Return a NoSuchElementException as element heirarchy is not present.
    @FindBys({
            @FindBy(id="level2elem1"),
            @FindBy(id="level1elem1")
    })
    private WebElement singleFindBysRev;

    //This will match the first element that matches any of the 3 criterion.
    //Refer to test - testFindByAll.
    //Return a POSITIVE match of top most element (id of level1elem1).
    @FindAll({
            @FindBy(id="level1elem1"),
            @FindBy(id="level2elem1"),
            @FindBy(id="level2elem2")
    })
    private WebElement singleFindAllUI;

    //This will match the first element that matches any of the 3 criterion.
    //In this case the inner elemnts FindBy are placed first.
    //Refer to test - testFindByAllRev.
    //Return a POSITIVE match of top most element (id of level2elem2).
    @FindAll({
            @FindBy(id="level2elem2"),
            @FindBy(id="level2elem1"),
            @FindBy(id="level1elem1")
    })
    private WebElement singleFindAllUIRev;

    //This will match all the elements for each criterion.
    //Refer to test - testFindByAllMultiple.
    //Return a POSITIVE match of a list of all the elements of size 3.
    @FindAll({
            @FindBy(id="level1elem1"),
            @FindBy(id="level2elem1"),
            @FindBy(id="level2elem2"),
    })
    private List<WebElement> multipleFindAll;

    //This will match all the elements for each criterion.
    //Element(id of level1elem1 & name LEVEL1 ELEMENT1) will be returned twice as it matches the first and last findby.
    //Refer to test - testFindByAllMultipleDuplicate.
    //Return a POSITIVE match of a list of all the elements of size 4.
    @FindAll({
            @FindBy(id="level1elem1"),
            @FindBy(id="level2elem1"),
            @FindBy(id="level2elem2"),
            @FindBy(name="LEVEL1 ELEMENT1"),
    })
    private List<WebElement> multipleFindAllDuplicate;

    //This will match all the elements that satisfy the xpath.
    //Though it has 4 matchers returns only 3 elements.
    //Refer to test - testXpathAlls.
    //Return a POSITIVE match of a list of all the elements of size 3.
    @FindBy(xpath="//div[@id='level1elem1' or @id='level2elem2' or @id='level2elem1' or @name='LEVEL1 ELEMENT1']")
    private List<WebElement> xpathAlls;
}

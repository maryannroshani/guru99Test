import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class Guru99 {
    AndroidDriver driver;


    @Before
    public void setUp() {

        String sessionId;
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "5");
        cap.setCapability("deviceName", "Galaxy Note 3");
        cap.setCapability("appPackage", "com.vector.guru99");
        cap.setCapability("appActivity", "BaseActivity");


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            sessionId = driver.getSessionId().toString();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void welcomeText() {
        assertTrue(driver.findElement(By.id("android:id/action_bar_title")).isDisplayed());
    }

    @Test
    public void courseCategoeryDisplay(){
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
       driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]")).isSelected();
    }

    @Test
    public void courseCategoeryList() {
        List<WebElement> coursesOffered = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));


        System.out.println("coourse offered are and their state");
        for (WebElement course : coursesOffered) {
            String coursee = course.getText();
            System.out.print(course); //Print each course name
            if (course.isEnabled())
                System.out.print(" and it is enabled");
            else
                System.out.print(" and it is not enabled");
            System.out.println();
        }

    }

    @Test
    public void homeScreen (){
        driver.findElement(By.id("android:id/action_bar_title")).isDisplayed();
    }


    @Test
     public void sapDisplay() {

        Set<String> allElementsText = new HashSet<String>();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]")).click();
        List<WebElement> courseList = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));
        courseList.get(0).click();


        List<WebElement> sapChildElements = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
        for(WebElement element: sapChildElements)
        {
            String text = element.getText();
            allElementsText.add(text);
        }


        String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\"com.vector.guru99:id/lvExp\")";
        String neededElement_finder = "new UiSelector().text(\"SAP BI\")";

        driver.findElementByAndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                ".scrollIntoView(" + neededElement_finder + ")");



       List<WebElement>sapChildElements2 = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));
        for(WebElement element: sapChildElements2)
        {
            String text = element.getText();
            allElementsText.add(text);
        }


        for(String s : allElementsText)
        {
            System.out.println(s);
        }

        int childElementsCount = allElementsText.size();
        if(childElementsCount == 11)
        {
            System.out.println("Sap course Sub Contents are equal ");
        }
        }

      @Test

     public void verifyQuiz (){
          assertTrue(driver.findElement(By.id("android:id/action_bar_title")).isDisplayed());
          driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
          driver.findElement(By.id("android:id/content")).isDisplayed();

          List<WebElement> quizQuest = driver.findElements(By.id("com.vector.guru99:id/lblListItem"));


          System.out.println("Quiz questions and their state");
          for (WebElement quiz : quizQuest) {
              String questions = quiz.getText();
              System.out.println(quiz);
              if (quiz.isEnabled())
              System.out.println("quiz is enabled");
              else
                  System.out.println("quiz is not enabled");
          }
      }

     @Test
    public void playQualityCenter (){
         driver.findElement(By.id("com.vector.guru99:id/action_quiz")).click();
         driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
         assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout")).isDisplayed());
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/timer")).isDisplayed());
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/radiobuttons")).isEnabled());
         assertFalse(driver.findElement(By.id("com.vector.guru99:id/option1")).isSelected());

         driver.findElement(By.id("com.vector.guru99:id/option2")).click();
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/next")).isDisplayed());
         driver.findElement(By.id("com.vector.guru99:id/next")).click();
         driver.findElement(By.id("com.vector.guru99:id/option1")).click();
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/finish")).isDisplayed());
         driver.findElement(By.id("com.vector.guru99:id/finish")).click();

         if(driver.findElement(By.id("com.vector.guru99:id/heading")).isDisplayed())
         {
             System.out.println("Test Result is ");
             System.out.println(driver.findElement(By.id("com.vector.guru99:id/score")).getText());
         }
     }

     @Test
    public void interviewQuestions(){
         assertTrue(driver.findElement(By.id("android:id/action_bar_title")).isDisplayed());
         driver.findElement(By.id("com.vector.guru99:id/action_interview")).click();

         List<WebElement> javaQuiz = driver.findElements(By.id("com.vector.guru99:id/lblinterviewHeader"));
               javaQuiz.get(2).click();


         assertTrue(driver.findElement(By.id("com.vector.guru99:id/lvExpInter")).isDisplayed());
         driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]")).click();
         driver.findElement(By.id("com.vector.guru99:id/show_answer")).click();
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/scrollview")).isDisplayed());
         driver.findElement(By.id("com.vector.guru99:id/next")).click();
         assertTrue(driver.findElement(By.id("com.vector.guru99:id/interview_question")).isDisplayed());
     }

     @Test
    public void courseLessons (){
         assertTrue(driver.findElement(By.id("android:id/action_bar_title")).isDisplayed());
         driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]")).click();

         String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\"com.vector.guru99:id/course_list\")";
         String neededElement_finder = "new UiSelector().text(\"PHP\")";

         driver.findElementByAndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
                 ".scrollIntoView(" + neededElement_finder + ")");

         List<WebElement> coursesList = driver.findElements(By.id("android:id/text1"));

         WebElement phpElement = findListItemByText(coursesList,"PHP");
         assertNotNull(phpElement);

         phpElement.click();

         List<WebElement> lesssonOne = driver.findElements(By.id("com.vector.guru99:id/heading_text"));
         lesssonOne.get(0).click();

         driver.findElement(By.id("com.vector.guru99:id/next")).click();


     }

    private WebElement findListItemByText(List<WebElement> coursesList, String text) {
        WebElement phpElement = null;
        for(WebElement courseElement:coursesList) {
            if(courseElement.getText().equals(text)) {
                phpElement = courseElement;
            }
        }
        return phpElement;
    }
}




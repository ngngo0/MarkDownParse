import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;
//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testOriginalFile() throws IOException {
        Path fileName = Path.of("break0.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile1() throws IOException {
        Path fileName = Path.of("break1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile2() throws IOException {
        Path fileName = Path.of("break2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile3() throws IOException {
        Path fileName = Path.of("break3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void lab1() throws IOException{
        Path fileName = Path.of("snipOne.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("`google.com","google.com","ucsd.edu"),MarkdownParse.getLinks(contents));
    }

    @Test
    public void lab2() throws IOException{
        Path fileName = Path.of("snipTwo.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("a.com","a.com(())","example.com"),MarkdownParse.getLinks(contents));
    }
    @Test
    public void lab3() throws IOException{
        Path fileName = Path.of("snipThree.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"),MarkdownParse.getLinks(contents));
    }
    
}
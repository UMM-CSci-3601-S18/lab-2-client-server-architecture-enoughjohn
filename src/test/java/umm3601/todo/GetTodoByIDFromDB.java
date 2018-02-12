package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDFromDB {

  @Test
  //test the second todo from todos.json
  public void get58895985c1849992336c219b() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985c1849992336c219b");
    assertEquals("Incorrect body",
      "Ipsum esse est ullamco magna tempor anim laborum non officia deserunt veniam commodo. Aute minim incididunt ex commodo.",
      todo.body);
  }

  @Test
  //test second to last
  public void get58895985f0a4bbea24084abf() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985f0a4bbea24084abf");
    assertEquals("Incorrect body",
      "Adipisicing ea eu adipisicing esse ullamco. Qui sunt velit qui ut amet veniam eiusmod occaecat reprehenderit exercitation est occaecat.",
      todo.body);
  }
}

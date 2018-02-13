package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullTodoListFromDB {

  @Test
  public void totalUserCount() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    assertEquals("Incorrect Total Number of Users", 300,allTodos.length);
  }
}

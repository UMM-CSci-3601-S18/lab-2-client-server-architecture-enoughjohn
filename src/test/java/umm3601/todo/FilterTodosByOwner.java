package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
public class FilterTodosByOwner {

  @Test
  public void filterTodosByOwner() throws IOException {
    DatabaseTodo db = new DatabaseTodo("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] blancheTodos = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of todos with owner Blanche", 43,
    blancheTodos.length);
  }
}

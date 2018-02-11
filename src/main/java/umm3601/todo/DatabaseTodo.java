package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class DatabaseTodo {

  private Todo[] allTodos;

  public DatabaseTodo(String userDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(userDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }


  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodo = allTodos;

    if (queryParams.containsKey("owner")) {
      int targetOwner = Integer.parseInt(queryParams.get("owner")[0]);
      filteredTodo = filterTodoByOwner(filteredTodos, targetOwner);
    }

    return filteredTodo;

    public Todo[] filterUsersByAge(Todo[] todos, String targetOwner) {
      return Arrays.stream(todos).filter(x -> x.owner == targetOwner).toArray(Todo[]::new);
    }

  }

}

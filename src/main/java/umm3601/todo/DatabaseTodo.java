package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class DatabaseTodo {

  private Todo[] allTodos;

  public DatabaseTodo(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get todo specified by id
   * @param id
   * @return Todo with given id, or numm
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all todos satisfying the queries in the params
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of todos matching the criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    //filter owner
    if(queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    //filter category
    if(queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    //filter status
    if(queryParams.containsKey("status")) {
      Boolean targetStatus = Boolean.getBoolean(queryParams.get("status")[0]);
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    //

    return filteredTodos;
  }

  /**
   * Get array of todos with target owner
   *
   * @param todos list of todos
   * @param targetOwner owner to look for
   * @return
   */
  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner){
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }

  /**
   * Get todos with given status
   *
   * @param todos list of todos
   * @param targetStatus status to look for
   * @return array of todos with target status
   */
  public Todo[] filterTodosByStatus(Todo[] todos, Boolean targetStatus){
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  /**
   * get todos with given category
   *
   * @param todos
   * @param targetCategory
   * @return
   */
  public Todo[] filterTodosByCategory(Todo[] todos, String targetCategory){
    return Arrays.stream(todos).filter(x -> x.category.equals(targetCategory)).toArray(Todo[]::new);
  }
}

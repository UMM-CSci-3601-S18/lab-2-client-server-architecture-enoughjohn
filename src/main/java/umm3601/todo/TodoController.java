package umm3601.todo;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static umm3601.Util.*;

public class TodoController {

  private final Gson gson;
  private DatabaseTodo databaseTodo;

  public TodoController(DatabaseTodo  databaseTodo) {
    gson = new Gson();
    this.databaseTodo = databaseTodo;
  }


  /**
   * Get single todo specified by 'id' parameter in the request.
   *
   * @param req HTTP request
   * @param res HTTP response
   * @return successful JSON object if id is found, otherwise a fail JSON object
   */
  public JsonObject getToDo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = databaseTodo.getTodo(id);
    if (todo != null) {
      return buildSuccessJsonResponse("user", gson.toJsonTree(todo));
    } else {
      String message = "ToDo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }


  /**
   * Get a JSON response with a list of all todos in the database
   *
   * @param req HTTP request
   * @param res HTTP response
   * @return a success JSON object containing all todos
   */
  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] todos = databaseTodo.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("users", gson.toJsonTree(todos));
  }


}


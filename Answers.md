❓ 1 What is the purpose of .gitignore?
 Answer:  The .gitignore makes sure that the specific untracked file gets intentionally ignored. 
 For example, our .gitignore makes sure "Ignore Gradle GUI config, gradle-app.setting". 
                                        

❓ 2 What role is Gradle playing in the project, and what is the purpose of build.gradle?
 Answer: Gradle is for automating tasks. We use Gradle to run our server application.

❓ 3 What is the purpose of Travis-CI? 
  Travis-CI is used to test our software and track build history.

❓ 4 Explain what a route is. 
  Routes are the main tools of Spark. 
  A route is made up of a verb(get, put, etc.), path, and callback.

❓ 5 What is the purpose of umm3601.Server class? What is the purpose of the umm3601.user.UserController class?
    The server class defines the endpoints and what the users can ask for. The server file contains all the 
    functions so that when a person uses "get" to get api/users or such, it redirects it to the Json file and 
    gets the data.
 
 Explain what happens when a user accesses each of the following URLs:
 

    ❓ The page users: Gives us an option to list all users. Also has a formatting bar where
    you can get users on the database specific to their age.
    ❓ The page api/users: Gives us a Json format file of all the users, with the id,name, age, company and email. 
    ❓ The page api/users?age=25: Gives us a Json format file of all the users with the specific age 25.
    ❓ The page api/users/588935f5de613130e931ffd5: Gives us a Json Format file of the user with that specific ID.
    

❓ 6 What are the contents of the public folder? What is the purpose of each of the HTML files there?
  Public contains the html and css files. There are html pages for about, index, and users.
  
❓ 7 Describe what happens when you filter users by age in the client? What is read from the web page, and what request is sent to the server? What is received, and how/where is it displayed? :

    When you filter users by age, a request is sent to the server for users with the age that you requested. The users with appropriate age and their information is displayed in the client.
❓ 8 Where is the client-side JavaScript defined? Name the file(s) in which it is used.
    users.js and todo.js

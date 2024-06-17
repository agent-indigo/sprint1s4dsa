package com.keyin.hynes.braden.sprint1s4dsa.classes;
import java.util.LinkedList;
import java.util.Scanner;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.Task;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.User;
import com.keyin.hynes.braden.sprint1s4dsa.enums.Status;
public final class App {
    private String selectionPrompt;
    private Scanner scanner;
    private int selection;
    private String invalidInputMessage;
    private LinkedList<User> users;
    private int userId;
    private User newUser;
    private boolean userExists;
    private LinkedList<Task> tasks;
    private int taskId;
    private Task newTask;
    protected boolean taskExists;
    private App() {
        this.selectionPrompt = "\nEnter selection:\n";
        this.scanner = new Scanner(System.in);
        this.selection = -1;
        this.invalidInputMessage = "\nInvalid input.\n";
        this.users = new LinkedList<User>();
        this.userId = 1;
        this.newUser = new User();
        this.userExists = false;
        this.tasks = new LinkedList<Task>();
        this.taskId = 1;
        this.newTask = new Task();
        this.taskExists = false;
    }
    public static void main(String[] args) {
        App app = new App();
        try {
            app.mainMenu();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        } finally {
            if (app.scanner != null) app.scanner.close();
        }
    }
    private void mainMenu() {
        while (selection != 2) {
            System.out.println("\nMain Menu\n");
            System.out.println("1: Users Menu");
            System.out.println("2: Exit");
            System.out.println(selectionPrompt);
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1: {
                        this.selection = -1;
                        usersMenu();
                        break;
                    } case 2: {
                        System.exit(0);
                    } default: {
                        this.selection = -1;
                        System.err.println(invalidInputMessage);
                        break;
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(invalidInputMessage);
            }
        }
    }
    private void usersMenu() {
        while (selection != 3) {
            System.out.println("\nUsers Menu\n");
            System.out.println("1: Add User");
            System.out.println("2: Users List");
            System.out.println("3: Main Menu");
            System.out.println(selectionPrompt);
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1 : {
                        this.selection = -1;
                        addUser();
                        break;
                    } case 2: {
                        this.selection = -1;
                        usersList();
                        break;
                    } case 3: {
                        this.selection = -1;
                        mainMenu();
                        break;
                    } default: {
                        this.selection = -1;
                        System.err.println(invalidInputMessage);
                        break;
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println(invalidInputMessage);
            }
        }
    }
    private void addUser() {
        System.out.println("\nEnter user name:\n");
        newUser.setId(userId);
        newUser.setName(scanner.nextLine());
        users.addLast(newUser);
        userId++;
        System.out.println("\nUser successfully created.\n");
        mainMenu();
    }
    private void usersList() {
        while (selection != 0) {
            System.out.println("\nUsers List\n");
            for (User user : users) {
                System.out.printf("%d: %s", user.getId(), user.getName());
            }
            System.out.println("\nEnter 0 to return the users menu.\n");
            System.out.println("\nEnter a user ID to view available actions.\n");
            System.out.println(selectionPrompt);
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 0: {
                        this.selection = -1;
                        usersMenu();
                        break;
                    } default: {
                        for (User user : users) {
                            if (user.getId() == selection) {
                                this.selection = -1;
                                this.userExists = true;
                                userMenu(user.getId());
                                break;
                            }
                        }
                        if (!userExists) {
                            this.selection = -1;
                            System.err.println(invalidInputMessage);
                            break;
                        }
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println(invalidInputMessage);
            }
        }
    }
    private void userMenu(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                while (selection != 5) {
                    System.out.printf("\n%s\n", user.getId());
                    System.out.println("1: Task List");
                    System.out.println("2: Add Task");
                    System.out.println("3: Rename");
                    System.out.println("4: Delete");
                    System.out.println("5: Users List");
                    System.out.println(selectionPrompt);
                    try {
                        this.selection = Integer.parseInt(scanner.nextLine());
                        switch (selection) {
                            case 1: {
                                this.selection = -1;
                                tasksList(id);
                                break;
                            } case 2: {
                                this.selection = -1;
                                addTask(id);
                                break;
                            } case 3: {
                                this.selection = -1;
                                renameUser(id);
                                break;
                            } case 4: {
                                this.selection = -1;
                                deleteUser(id);
                                break;
                            } case 5: {
                                this.selection = -1;
                                usersList();
                                break;
                            } default: {
                                this.selection = -1;
                                System.err.println(invalidInputMessage);
                                break;
                            }
                        }
                    } catch (NumberFormatException numberFormatException) {
                        System.err.println(invalidInputMessage);
                    }
                }
            }
        }
    }
    private void tasksList(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                while (selection != 0) {
                    System.out.printf("\n%s's Task List\n", user.getName());
                    for (Task task : user.getTasks()) {
                        System.out.printf("%d: %s: %s", task.getId(), task.getDescription(), task.getStatus().toString());
                    }
                    System.out.println("\nEnter 0 to return to the user menu.\n");
                    System.out.println("\nEnter a task ID to view available actions.\n");
                    System.out.println(selectionPrompt);
                    try {
                        this.selection = Integer.parseInt(scanner.nextLine());
                        switch (selection) {
                            case 0: {
                                this.selection = -1;
                                userMenu(userId);
                                break;
                            } default: {
                                for (Task task : user.getTasks()) {
                                    if (task.getId() == selection) {
                                        this.selection = -1;
                                        this.taskExists = true;
                                        taskMenu(userId, task.getId());
                                        break;
                                    }
                                }
                                if (!taskExists) {
                                    this.selection = -1;
                                    System.err.println(invalidInputMessage);
                                    break;
                                }
                            }
                        }
                    } catch (NumberFormatException numberFormatException) {
                        System.err.println(invalidInputMessage);
                    }
                }
            }
        }
    }
    private void addTask(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                System.out.println("\nEnter task description:\n");
                newTask.setId(taskId);
                newTask.setDescription(scanner.nextLine());
                newTask.setStatus(Status.ToDo);
                tasks.addLast(newTask);
                taskId++;
                System.out.println("\nTask successfully added.\n");
            }
        }
        userMenu(userId);
    }
    private void renameUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("\nEnter new name:\n");
                user.setName(scanner.nextLine());
                System.out.println("\nName successfully changed.\n");
            }
        }
        userMenu(id);
    }
    private void deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setId(0);
                user.setName(null);
                for (Task task : user.getTasks()) {
                    task.setId(0);
                    task.setDescription(null);
                    task.setStatus(null);
                }
                System.out.println("\nUser successfully deleted.\n");
            }
        }
        mainMenu();
    }
    private void taskMenu(
        int userId,
        int taskId
    ) {}
}
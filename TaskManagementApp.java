package taskmanagement;

import org.bson.types.ObjectId;
import taskmanagement.model.project;
import taskmanagement.model.task;
import taskmanagement.service.taskService;

import java.util.Scanner;

public class TaskManagementApp {
    public static void main(String[] args) {
        taskService taskService = new taskService();
        Scanner scanner = new Scanner(System.in);

        // Add a new task
        System.out.println("Enter task details:");
        System.out.print("Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Description: ");
        String taskDescription = scanner.nextLine();
        System.out.print("Deadline (YYYY-MM-DD): ");
        String taskDeadline = scanner.nextLine();
        System.out.print("Priority: ");
        String taskPriority = scanner.nextLine();
        System.out.print("Status: ");
        String taskStatus = scanner.nextLine();

        task newTask = new task(taskName, taskDescription, taskDeadline, taskPriority, taskStatus);
        taskService.addTask(newTask);

        // Add a new project
        System.out.println("Enter project details:");
        System.out.print("Name: ");
        String projectName = scanner.nextLine();
        System.out.print("Description: ");
        String projectDescription = scanner.nextLine();
        System.out.print("Start Date (YYYY-MM-DD): ");
        String projectStartDate = scanner.nextLine();
        System.out.print("End Date (YYYY-MM-DD): ");
        String projectEndDate = scanner.nextLine();
        System.out.print("Is Active (true/false): ");
        boolean projectIsActive = Boolean.parseBoolean(scanner.nextLine());

        project newProject = new project(projectName, projectDescription, projectStartDate, projectEndDate, projectIsActive);
        taskService.addProject(newProject);

        // View all tasks
        System.out.println("\nAll Tasks:");
        for (task task : taskService.getAllTasks()) {
            System.out.println(task.getName() + ": " + task.getDescription());
        }

        // View all projects
        System.out.println("\nAll Projects:");
        for (project project : taskService.getAllProjects()) {
            System.out.println(project.getName() + ": " + project.getDescription());
        }

        // Update a task status
        System.out.println("\nEnter ID of task to update:");
        ObjectId taskIdToUpdate = new ObjectId(scanner.nextLine());
        System.out.println("Enter new status for the task:");
        String newTaskStatus = scanner.nextLine();
        taskService.updateTask(taskIdToUpdate, newTaskStatus);

        // Delete a project
        System.out.println("\nEnter ID of project to delete:");
        ObjectId projectIdToDelete = new ObjectId(scanner.nextLine());
        taskService.deleteProject(projectIdToDelete);

        // Close MongoDB connection
        taskService.close();
        scanner.close();
    }
}

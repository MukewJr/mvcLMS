package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Task;
import peaksoft.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping("/allTasks/{lessonId}")
    private String getAllTasks(@PathVariable("lessonId")Long lessonId, Model model) {
        model.addAttribute("allTasks", service.getAllTasks(lessonId));
        model.addAttribute("lessonId",lessonId);
        return "task/mainTask";
    }

    @GetMapping("{lessonId}/newTask")
    private String newTask(@PathVariable("lessonId")Long id,Model model) {
        model.addAttribute("newTask",new Task());
        model.addAttribute("lessonId",id);
        return "task/newTask";
    }

    @PostMapping("{lessonId}/saveTask")
    private String saveTask(@PathVariable("lessonId")Long id, @ModelAttribute("newTask")Task task) {
        service.saveTask(id,task);
        return "redirect:/tasks/allTasks/ "+ id;
    }

    @GetMapping("/getTask/{taskId}")
    private String getLessonById(@PathVariable("taskId")Long id,Model model) {
        model.addAttribute("task",service.getTaskById(id));
        return "task/mainTask";
    }

    @GetMapping("/updateTask/{taskId}")
    private String updateTask(@PathVariable("taskId")Long taskId,Model model) {
        Task task = service.getTaskById(taskId);
        model.addAttribute("task",task);
        model.addAttribute("lessonId",task.getLessons().getLessonId());
        return "task/updateTask";
    }

    @PostMapping("/{lessonId}/{taskId}/saveUpdateTask")
    private String saveUpdateTask(@PathVariable("lessonId")Long lessonId,
                                  @PathVariable("taskId")Long taskId,
                                  @ModelAttribute("task")Task task) {
        service.updateTask(taskId,task);
        return "redirect:/tasks/allTasks/ " + lessonId;

    }


    @PostMapping("/{lessonId}/{taskId}/deleteTask")
    private String deleteTask(@PathVariable("lessonId")Long id,@PathVariable("taskId")Long taskId) {
        service.deleteTaskById(taskId);
        return "redirect:/tasks/allTasks/ " + id;
    }

}

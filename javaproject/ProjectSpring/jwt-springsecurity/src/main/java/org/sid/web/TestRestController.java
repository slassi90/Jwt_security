package org.sid.web;

import java.util.List;

import org.sid.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.sid.Dao.TaskRepository;

@RestController
public class TestRestController {
@Autowired
private TaskRepository taskRepository;


@GetMapping("/tasks")
public List<Task> ListTask(){
	
	return taskRepository.findAll();
}
@PostMapping("/tasksadd")
public Task savetask(@RequestBody Task t) {
	return taskRepository.save(t);
	
	
}

}
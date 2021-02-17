package com.hcl.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	@Autowired
	TaskRepository taskRepo;

	public void addTask(Task newTask) {
		taskRepo.save(newTask);
	}

	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	public void updateTask(long id, Task updatedTask) {
		taskRepo.updateTask(id, 
							updatedTask.getTaskName(), 
							updatedTask.getStartDate(), 
							updatedTask.getEndDate(),
							updatedTask.getDescription(),
							updatedTask.getEmail(),
							updatedTask.getSeverity(),
							updatedTask.getOwner());
	}
	
	public Task getSingleTask(long id) {
		return taskRepo.findById(id).get();
	}

}
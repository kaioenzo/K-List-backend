package com.kaio.klist.repository;

import com.kaio.klist.entity.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>
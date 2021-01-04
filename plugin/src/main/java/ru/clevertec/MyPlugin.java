package ru.clevertec;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import ru.clevertec.tasks.MyTask;

public class MyPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("downloadResources", MyTask.class);
    }

} 
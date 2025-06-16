package org.example.todoexercise.services;

import org.example.todoexercise.models.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ToDoService {
   private Map<Integer, ToDo> toDoList = new HashMap<>();
   private static int compt = 1;

    public ToDoService() {
        toDoList.put(1,new ToDo(compt++,"1","azertyu",true));
        toDoList.put(2,new ToDo(compt++,"2","qsdfg",false));
        toDoList.put(3,new ToDo(compt++,"3","wxcvb",true));
    }

    public List<ToDo> getToDoList() {
        return new ArrayList<>(toDoList.values());
    }

    public ToDo getToDo(int id) {
        return toDoList.get(id);
    }

    public ToDo addToDo(ToDo toDo){
        toDoList.put(compt++,toDo);
        return toDo;
    }
    public ToDo updateToDo(int id,ToDo toDo){
        toDoList.replace(id,toDo);
        return toDo;
    }

    public boolean deleteToDo(int id) {
        toDoList.remove(id);
        return true;
    }
}

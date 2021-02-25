package com.udacity.jdnd.course1;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class MessageListService {
    private ArrayList<String> list;

    @PostConstruct
    public void postConstruct(){
        list = new ArrayList<String>();
    }

    public void addMessage(String message){
        list.add(message);
    }

    public ArrayList<String> getMessages(){
        return list;
    }
}

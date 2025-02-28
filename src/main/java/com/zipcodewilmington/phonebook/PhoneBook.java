package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private static Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        phonebook = map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<>();
    }

    public static void add(String name, String phoneNumber) {
        List<String> phoneNumList = Arrays.asList(phoneNumber);
        phonebook.put(name, phoneNumList);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> phoneNumList = Arrays.asList(phoneNumbers);
        phonebook.put(name, phoneNumList);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> returnList = new ArrayList<>();
        for (String i : phonebook.keySet()) {
            returnList.add(i);
        }
        return returnList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
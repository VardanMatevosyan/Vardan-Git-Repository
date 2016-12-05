package ru.matevosyan.models;

import java.util.Arrays;

/**
 * This class was created for items, that's determine specific and hole description and hold it together as item.
 * Created on 15.11.2016.
 * @since 1.0
 * @author Matevosyan Vardan
 * @version 1.0
 *
 */

public class Item {

    /**
     * Instance variable id which is the Items identifier.
     */

    private String id;

    /**
     * Instance variable name which is the Items name.
     */

    private String name;

    /**
     * Instance variable description which is the Items description.
     */

    private String description;

    /**
     * Instance variable create Items create date.
     */

    private long create;

    /**
     * Variable commentPosition is position in Comments array which in addComments method is increment own value which is start from the 0.
     */

    private int commentPosition = 0;

    /**
     * Variable COMMENTS_CAP is comments array capacity.
     */

    private static final int COMMENTS_CAP = 5;

    /**
     * Instance variable comments is array of comments that hold all comments and store it in Item.
     */

    private Comments[] comments = new Comments[COMMENTS_CAP];

    /**
     * Created for override the default constructor.
     */

    public Item() {
    }

    /**
     * Created for override the parameters we have the constructor.
     * @param name which is the Items name
     * @param description which is the Items description
     */

    public Item(String name, String description) {
        this.id = getId();
        this.name = name;
        this.description = description;
        this.create = getCreateDate();
    }

    /**
     * Create getter for field name.
     * @return  <code>name</code>
     */

    public String getName() {

        return this.name;
    }

    /**
     * Create getter for field description.
     * @return  <code>description</code>
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Create getter for field create.
     * @return  <code>create</code>
     */

    public long getCreate() {
        return this.create;
    }

    /**
     * Create setter for field id.
     * @param id  value for set the Items id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Create getter for field create.
     * @return  <code>id</code>
     */

    public String getId() {
        return this.id;
    }

    /**
     * addComments method created for adding comments to Items, we can find the items which of them we want to add and added.
     * @param comment it is the String type, we type the comment add send it to addComment method
     * @return  <code>comments</code>
     */

    public Comments[] addComment(String comment) {
        comments[commentPosition] = (new Comments(comment));
        commentPosition++;
        return comments;
    }

    /**
     * Create getter for field comments in array of comments.
     * @return  <code>comments</code>
     */

    public Comments[] getComments() {
        return comments;
    }

    /**
     * Create getter for field create for create the date in millisecond.
     * @return currentTime
     */

    public long getCreateDate() {
        return System.currentTimeMillis();
    }

    /**
     * Override toString method for print out formatting items.
     * @return the formatting line
     */

       @Override
    public String toString() {

       return String.format("Id: %s; Name: %s; Description: %s; Date: %s; Comments: %s", this.id, this.name, this.description, this.create, Arrays.toString(this.comments));

    }



}
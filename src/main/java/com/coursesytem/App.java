package com.coursesytem;

import com.coursesytem.model.Course;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Course c = new Course("MATH100", 3);
        System.out.println(c.toString());
    }
}

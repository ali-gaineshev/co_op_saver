package com.main;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main {

    private static boolean print_cont = false;

    public static link parse_args(String[] args)
    {

        String link1 = "";
        String link2 = "";

        LocalDate date_now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        String date = date_now.format(formatter);
        date += " (" + date_now.getDayOfWeek().toString() + ")";


        for(String arg : args)
        {
            if(arg.contains("--print"))
            {
                print_cont = true;
            }

            else if(link1.equals(""))
            {
                link1 = arg;
            }

            else if(link2.equals(""))
            {
                link2 = arg;
            }
        }
        if(!link1.isEmpty())
            return new link(0, link1, link2, date);

        return null;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java main [--print] link1 [link2]");
        }

        jsonTools tool = new jsonTools();
        //tool.delete_all(); //TEST
        List<link> links = tool.read_json();

        link new_link = parse_args(args);

        if(new_link != null)
        {

            if (!check_valid_link(links, new_link))//link already exists in the file!
            {

                System.out.println("You already applied for this job!");
            } else {
                links.add(new_link);
                tool.write_json(links);
            }

        }

        if (print_cont) //only print
        {
            print_all(links);
        }


    }



    public static boolean check_valid_link(List<link> links, link new_link)
    {
        for(link other_link: links)
        {
            if(new_link.compareTo(other_link) == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void print_all(List<link> links)
    {
        if(links.isEmpty()){
            System.out.println("You haven't applied for any jobs!");
            return;
        }

        System.out.println("-----------------------");
        for(link job: links)
        {
            System.out.println(job);
            System.out.println("-----------------------");
        }
    }
}
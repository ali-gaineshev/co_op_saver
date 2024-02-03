import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {

    private static boolean print = false;

    public static link parse_args(String[] args)
    {

        String link1 = "";
        String link2 = "";
        String date = "";
        for(String arg : args)
        {
            if(arg.contains("--print"))
            {
                print = true;
                if(args.length == 1)
                {
                    return null;
                }
                continue;
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
        link new_link = new link(0, link1, link2, "TBD");
        System.out.println(new_link);
        return new_link;
    }

    public static void main(String[] args) {
        jsonTools tool = new jsonTools();
        List<link> links = tool.read_json();

        link new_link = parse_args(args);
        if(new_link == null)
        {
            int filler;
            //print("PRINT ALL LINKS HERE");
        }else {
            if(!check_valid_link(links, new_link))//link already exists in the file!
            {
                int filler;
            }
        }


    }



    public static boolean check_valid_link(List<link> links, link new_link)
    {
        for(link other_link: links)
        {
            if(new_link.compareTo(other_link) != 0)
            {
                return false;
            }
        }
        return true;
    }
}
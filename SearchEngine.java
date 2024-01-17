import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> words = new ArrayList<String>(); 

    public String handleRequest(URI url) {
        String result = "";
        if (url.getPath().equals("/")) {
            return String.format(words.toString());
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            words.add(parameters[1]);
            return String.format("String Added!");
        } else {
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                for (String item : words){
                    if (item.contains(parameters[1])){
                        result += item;
                        result += " ";
                    }
                }
                return result;
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        StringServer.start(port, new Handler());
    }
}

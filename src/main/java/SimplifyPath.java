import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Qing (Chris) Yuan on Feb/07/2018 12:02 AM
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/a/";
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.simplifyPath(path);

    }

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;

        StringBuilder sb = new StringBuilder();
        sb.append(path.charAt(0));
        for(int i = 1; i < path.length(); i++) if(!(path.charAt(i) == '/' && path.charAt(i - 1) == '/')) sb.append(path.charAt(i));
        String cleanedPath = sb.toString();

        Deque<String> deque = new ArrayDeque<>();
        int slash;
        String head;

        while(cleanedPath.length() > 0){
            slash = cleanedPath.indexOf('/',1);
            if( slash == -1 ) {
                head = cleanedPath.substring(1);
                cleanedPath = "";
            } else {
                head = cleanedPath.substring(1, slash);
                cleanedPath = cleanedPath.substring(slash);
            }
            if(head.equals("..")){
                deque.poll();
            }else if(head.length() > 0 && !head.equals(".")){
                deque.push(head);
            }
        }

        StringBuilder resBuilder = new StringBuilder();
        while(deque.size() > 0)  {
            resBuilder.append('/');
            resBuilder.append(deque.pollLast());
        }

        return resBuilder.toString();
    }
}

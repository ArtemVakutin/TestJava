package threads;

import java.util.*;

public class Main1Collections {
    List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
    Map<String, String> map = Collections.synchronizedMap(new HashMap<String,String>());
}

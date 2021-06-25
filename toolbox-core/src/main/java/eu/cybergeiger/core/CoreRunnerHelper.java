package eu.cybergeiger.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CoreRunnerHelper {

  //private static List<CoreRunnerTask> componentList = new Vector<>();
  private static Map<CoreRunnerTask, String> componentMap = new LinkedHashMap<>();

  public static void start(String[] args) {
    // add your task here to start (beware of the sequence)
    // FIXME add splashscreen here
    componentMap.put(new DemoPluginRunner(), "");
    //componentList.add(new DemoPluginRunner());
    // FIXME add components here
    // FIXME add UI here as last entry

    // no changes beyond this point unless you know what you are doing
    /*
    for(CoreRunnerTask t:componentList) {
      t.startup();
    }
    */
    // call each CoreRunnerTask with their respective arguments
    for(Map.Entry<CoreRunnerTask, String> e : componentMap.entrySet()) {
      e.getKey().startup(e.getValue());
    }
  }

  /**
   * <p>This should be called by the UI when shutting down the application.</p>
   */
  public static void stop() {
    List<CoreRunnerTask> l = new ArrayList<>(componentMap.keySet());
    //List<CoreRunnerTask> l = new ArrayList<>(componentList);
    Collections.reverse(l);
    for(CoreRunnerTask t : l) {
      t.shutdown();
    }
  }

}

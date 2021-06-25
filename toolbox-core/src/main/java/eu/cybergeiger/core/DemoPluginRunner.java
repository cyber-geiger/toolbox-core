package eu.cybergeiger.core;

import eu.cybergeiger.demo.DemoPlugin;
import eu.cybergeiger.demo.DemoPluginFeatures;

public class DemoPluginRunner extends CoreRunnerTask {

  private DemoPlugin plugin = new DemoPlugin(DemoPluginFeatures.FEATURE_ALL.getId());
  
  @Override
  public void shutdown() {
    plugin.stop();
  }

  @Override
  public void run() {
    plugin.start();
  }
}

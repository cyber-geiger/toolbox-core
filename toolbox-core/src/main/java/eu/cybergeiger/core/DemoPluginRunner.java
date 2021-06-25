package eu.cybergeiger.core;

import eu.cybergeiger.demo.DemoPlugin;
import eu.cybergeiger.demo.DemoPluginFeatures;

public class DemoPluginRunner extends CoreRunnerTask {

  // potential Arguments to be used for startup/shutdown
  private String args;

  private final DemoPlugin plugin = new DemoPlugin(DemoPluginFeatures.FEATURE_ALL.getId());


  public DemoPluginRunner(String args) {
    this.args = args;
  }

  @Override
  public void startup() {
    // do something that needs to be done before starting this plugin
    // if nothing is to be added, this method does not need to get overridden
    this.start();
  }

  @Override
  public void shutdown() {
    plugin.stop();
  }

  @Override
  public void run() {
    plugin.start();
  }
}

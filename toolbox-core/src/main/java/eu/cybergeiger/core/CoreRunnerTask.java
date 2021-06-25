package eu.cybergeiger.core;

public abstract class CoreRunnerTask extends Thread {

  String args;

  /**
   * <p>Called to start up plugin.</p>
   */
  public void startup() {
    this.start();
  }

  /**
   * <p>Called to stop the plugin.</p>
   *
   * <p>
   *   Make sure that all subsequently generated threads are either daemonized or stopped.
   * </p>
   */
  public abstract void shutdown();

  @Override
  public abstract void run();

}

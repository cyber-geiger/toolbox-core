package eu.cybergeiger.core;

import com.geiger.toolbox.ToolboxUi;
import com.geiger.toolbox.ToolboxUiMainWindow;
import totalcross.TotalCrossApplication;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;

public class CoreRunner extends MainWindow {

  private String firebaseToken = null;
  private ToolboxUi wrapper = null;
  private Object lock = new Object();

  static {
    Settings.applicationId = "geig";
    Settings.appVersion = "0.0.1";
    Settings.iosCFBundleIdentifier = "com.geiger.toolbox-core";
    Settings.appDescription = "The GEIGER toolbox core application";
  }

  /**
   * <p>Empty constructor.</p>
   */
  public CoreRunner() {
    super("GEIGER Toolbox", ROUND_BORDER);
  }

  @Override
  public void initUI() {
    ToolboxUiMainWindow.initSplash(this);
    CoreRunnerHelper.start(new String[0]);
    ToolboxUiMainWindow.initMain(this);
  }

  public static void main(String[] args) {
    TotalCrossApplication.run(CoreRunner.class, "/scr", "1125x2436", "/scale", "0.6");
  }

}

package eu.cybergeiger.indicator;
import ch.fhnw.geiger.localstorage.StorageException;
import ch.fhnw.geiger.localstorage.db.GenericController;
import ch.fhnw.geiger.localstorage.db.mapper.DummyMapper;

public class GEIGERIndicatorRunner extends CoreRunnerTask{


    // potential Arguments to be used for startup/shutdown
    private String args;

    //private GeigerIndicator plugin;
    private final GeigerIndicator plugin;
    /*{
        try {
            plugin = new GeigerIndicator(new GenericController("theOwner", new DummyMapper()));
        } catch (StorageException e) {
            e.printStackTrace();
        }
    }*/


    public GEIGERIndicatorRunner(String args) {
        this.args = args;
        plugin=new GeigerIndicator();
    }

    @Override
    public void startup() {
        // do something that needs to be done before starting this plugin
        // if nothing is to be added, this method does not need to get overridden
        //executeprefitter
        try {
            GeigerStoragePrefitter.init(plugin.getControllerTrial(),true);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        this.start();
    }

    @Override
    public void shutdown() {
        //plugin.stop(); //might be needed in the future, shldnt be needed if GEIGERindicator is executed from scan button
    }

    @Override
    public void run() {
        try {
            plugin.run();
        } catch (StorageException e) {
            e.printStackTrace();
        }
    }

}

package com.ilya.test.config;

/**
 * Demo application to track config files
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args.length == 0) {
    		System.out.println( "Please pass full path to the config file as an argument" );
    	}
    	
    	String filePath = args[0];
    	ConfigFile configFile;
		
		configFile = new ConfigFile(filePath);
		
    	configFile.subscribe(new Observer(configFile)
    	{

			@Override
			public void update() {
				// Implementation to track network changes in the config
				System.out.println("File " + this.config.fileName + " has been changed. Process network setting.");				
			}
    		
    	});
    	
    	configFile.subscribe(new Observer(configFile)
    	{

			@Override
			public void update() {
				// Implementation to track path settings in the config
				System.out.println("File " + this.config.fileName + " has been changed. Process path setting.");				
			}
    		
    	});
    	
    	while(true) {
    		try {
    			configFile.trackChanges();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}

    	
    }
}

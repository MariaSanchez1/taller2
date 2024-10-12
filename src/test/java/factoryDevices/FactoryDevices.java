package factoryDevices;

import java.util.HashMap;
import java.util.Map;

public class FactoryDevices {
    /**
     * fabrica de dispositivos - necesitamos utilzar esta clase para obtener un dispositivo especifico
     * @param type : android/ios/windowsphone/cloud
     * @return
     */
    public static IDevices make(String type){
        Map<String,IDevices> devicesMap = new HashMap<>();
        devicesMap.put("android",new Android());
        devicesMap.put("ios",new Ios());
        devicesMap.put("windowsphone",new WindowPhone());
        devicesMap.put("cloud", new AndroidCloud());

        return devicesMap.containsKey(type.toLowerCase())?
                  devicesMap.get(type.toLowerCase()):
                devicesMap.get("android");

    }
}

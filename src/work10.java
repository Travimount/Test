import java.io.*;
import java.util.*;
class WifiDevice {
    private String address;
    private String essid;
    private String mode;
    private Byte channel;
    private Byte signal;  // 单位为dBm
    private String quality;
    private String encryption;

    // 构造函数
    public WifiDevice(String address, String essid, String mode, Byte channel, Byte signal, String quality, String encryption) {
        this.address = address;
        this.essid = essid;
        this.mode = mode;
        this.channel = channel;
        this.signal = signal;
        this.quality = quality;
        this.encryption = encryption;
    }

    // Getter 和 Setter 略
    // getter 方法
    public String getAddress() { return address; }
    public String getEssid() { return essid; }
    public String getMode() { return mode; }
    public Byte getChannel() { return channel; }
    public Byte getSignal() { return signal; }
    public String getQuality() { return quality; }
    public String getEncryption() { return encryption; }

    // 打印设备信息的方法
    public void printDeviceInfo() {
        System.out.println("Address: " + address);
        System.out.println("ESSID: " + essid);
        System.out.println("Mode: " + mode);
        System.out.println("Channel: " + channel);
        System.out.println("Signal: " + signal + " dBm");
        System.out.println("Quality: " + quality);
        System.out.println("Encryption: " + encryption);
    }
    // 用于打印设备信息的方法
    @Override
    public String toString() {
        return "WifiDevice{" +
                "address='" + address + '\'' +
                ", essid='" + essid + '\'' +
                ", mode='" + mode + '\'' +
                ", channel=" + channel +
                ", signal=" + signal + " dBm" +
                ", quality='" + quality + '\'' +
                ", encryption='" + encryption + '\'' +
                '}';
    }
}

class DeviceList {
    private List<WifiDevice> devices = new ArrayList<>();

    public DeviceList(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            String address = "", essid = "", mode = "", quality = "", encryption = "";
            Byte channel = 0;
            int signal = 0;

            while ((line = br.readLine()) != null) {
                if (line.contains("Address:")) {
                    address = line.split("Address: ")[1].trim();
                } else if (line.contains("ESSID:")) {
                    essid = line.split("\"")[1].trim();
                } else if (line.contains("Mode:")) {
                    mode = line.split("Mode: ")[1].split(" ")[0].trim();
                    channel = Byte.parseByte(line.split("Channel: ")[1].trim());
                } else if (line.contains("Signal:")) {
                    signal = Integer.parseInt(line.split("Signal: ")[1].split(" ")[0]);
                    quality = line.split("Quality: ")[1].trim();
                } else if (line.contains("Encryption:")) {
                    encryption = line.split("Encryption: ")[1].trim();
                }

                // 当读取到一个完整的设备信息后，添加到列表
                if (!address.isEmpty() && !essid.isEmpty() && !mode.isEmpty() && channel != 0 && signal != 0 && !quality.isEmpty() && !encryption.isEmpty()) {
                    devices.add(new WifiDevice(address, essid, mode, channel, (byte) signal, quality, encryption));
                    // 重置所有变量，准备下一个设备的读取
                    address = "";
                    essid = "";
                    mode = "";
                    channel = 0;
                    signal = 0;
                    quality = "";
                    encryption = "";
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getDeviceByAddress(String address) {
        for (WifiDevice device : devices) {
            if (device.getAddress().equals(address)) {
                device.printDeviceInfo();
                return;
            }
        }
        System.out.println("Address为（" + address + "）的设备不存在。");
    }

    public void getDevicesByEssid(String essid) {
        boolean found = false;
        for (WifiDevice device : devices) {
            if (device.getEssid().equals(essid)) {
                device.printDeviceInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("ESSID为（" + essid + "）的设备不存在。");
        }
    }

    public void getDevicesBySignal(Byte signal) {
        boolean found = false;
        for (WifiDevice device : devices) {
            if (device.getSignal() > signal) {
                device.printDeviceInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("信号强度大于（" + signal + "）的设备不存在。");
        }
    }

    public void getDevicesByChannel(Byte channel) {
        boolean found = false;
        for (WifiDevice device : devices) {
            if (device.getChannel().equals(channel)) {
                device.printDeviceInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Channel为（" + channel + "）的设备不存在。");
        }
    }

    public void getAllAddress() {
        for (WifiDevice device : devices) {
            System.out.println(device.getAddress());
        }
    }

    public void getAllEssid() {
        for (WifiDevice device : devices) {
            System.out.println(device.getEssid());
        }
    }

    public void getAllChannel() {
        for (WifiDevice device : devices) {
            System.out.println(device.getChannel());
        }
    }
}
public class work10{
    public static void main(String[] args) {
        // 创建 DeviceList 实例
        DeviceList deviceList = new DeviceList("src/scanlist.txt");

        // 测试 getDeviceByAddress 方法
        System.out.println("Testing getDeviceByAddress:");
        deviceList.getDeviceByAddress("88:C3:97:C9:CC:7E");
        deviceList.getDeviceByAddress("58:33:d7:f9:C1:2E");

        // 测试 getDevicesByEssid 方法
        System.out.println("\nTesting getDevicesByEssid:");
        deviceList.getDevicesByEssid("Haochuang");
        deviceList.getDevicesByEssid("shichuan");
        deviceList.getDevicesByEssid("unknown");
        // 测试 getDevicesBySignal 方法
        System.out.println("\nTesting getDevicesBySignal:");
        deviceList.getDevicesBySignal((byte) -100);
        deviceList.getDevicesBySignal((byte) 0);

        // 测试 getDevicesByChannel 方法
        System.out.println("\nTesting getDevicesByChannel:");
        deviceList.getDevicesByChannel((byte) 6);
        deviceList.getDevicesByChannel((byte) 66);

        // 测试 getAllAddress 方法
        System.out.println("\nTesting getAllAddress:");
        deviceList.getAllAddress();

        // 测试 getAllEssid 方法
        System.out.println("\nTesting getAllEssid:");
        deviceList.getAllEssid();

        // 测试 getAllChannel 方法
        System.out.println("\nTesting getAllChannel:");
        deviceList.getAllChannel();
    }
}

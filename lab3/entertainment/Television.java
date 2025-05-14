package lab3.entertainment;

import lab3.base.ElectricAppliance;

public class Television extends ElectricAppliance {
    private int screenSize; // у дюймах
    private int channel;

    public Television(String name, int powerConsumption, int screenSize) {
        super(name, powerConsumption);
        this.screenSize = screenSize;
        this.channel = 1;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (channel > 0) {
            this.channel = channel;
            System.out.println(getName() + " переключено на канал " + channel);
        } else {
            System.out.println("Неправильний номер каналу");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Розмір екрану: " + screenSize + "\", Канал: " + channel + "]";
    }
}
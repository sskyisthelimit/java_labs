package lab4.entertainment;
import lab4.base.ElectricAppliance;
import lab4.exceptions.InvalidParameterException;

import java.io.Serializable;

public class Television extends ElectricAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int screenSize; // у дюймах
    private int channel;

    public Television(String name, int powerConsumption, int screenSize) throws InvalidParameterException {
        super(name, powerConsumption);

        if (screenSize <= 0) {
            throw new InvalidParameterException("Розмір екрану повинен бути більше 0 дюймів");
        }

        this.screenSize = screenSize;
        this.channel = 21;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) throws InvalidParameterException {
        if (channel > 0) {
            this.channel = channel;
            System.out.println(getName() + " переключено на канал " + channel);
        } else {
            throw new InvalidParameterException("Неправильний номер каналу. Номер каналу повинен бути більше 0");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Розмір екрану: " + screenSize + "\", Канал: " + channel + "]";
    }
}
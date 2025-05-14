package lab3.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Apartment {
    private List<ElectricAppliance> appliances;

    public Apartment() {
        this.appliances = new ArrayList<>();
    }

    public void addAppliance(ElectricAppliance appliance) {
        appliances.add(appliance);
    }

    public void removeAppliance(ElectricAppliance appliance) {
        appliances.remove(appliance);
    }

    public List<ElectricAppliance> getAllAppliances() {
        return new ArrayList<>(appliances);
    }

    public List<ElectricAppliance> getPluggedInAppliances() {
        return appliances.stream()
                .filter(ElectricAppliance::isPluggedIn)
                .collect(Collectors.toList());
    }

    public List<ElectricAppliance> getTurnedOnAppliances() {
        return appliances.stream()
                .filter(ElectricAppliance::isOn)
                .collect(Collectors.toList());
    }

    public int getTotalPowerConsumption() {
        return appliances.stream()
                .mapToInt(ElectricAppliance::getCurrentPowerUsage)
                .sum();
    }

    public void sortByPowerConsumption() {
        Collections.sort(appliances, Collections.reverseOrder());
    }

    public List<ElectricAppliance> findAppliancesByPowerRange(int minPower, int maxPower) {
        return appliances.stream()
                .filter(a -> a.getPowerConsumption() >= minPower && a.getPowerConsumption() <= maxPower)
                .collect(Collectors.toList());
    }
}
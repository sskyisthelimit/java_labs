package lab4.base;
import lab4.exceptions.OperationException;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Apartment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<ElectricAppliance> appliances;

    public Apartment() {
        this.appliances = new HashSet<>();
    }

    public void addAppliance(ElectricAppliance appliance) {
        appliances.add(appliance);
    }

    public void removeAppliance(ElectricAppliance appliance) {
        appliances.remove(appliance);
    }

    public Set<ElectricAppliance> getAllAppliances() {
        return new HashSet<>(appliances);
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

    public List<ElectricAppliance> getSortedByPowerConsumption() {
        List<ElectricAppliance> sorted = new ArrayList<>(appliances);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted;
    }

    public List<ElectricAppliance> findAppliancesByPowerRange(int minPower, int maxPower) {
        return appliances.stream()
                .filter(a -> a.getPowerConsumption() >= minPower && a.getPowerConsumption() <= maxPower)
                .collect(Collectors.toList());
    }

    public ElectricAppliance findApplianceByName(String name) {
        return appliances.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public int getApplianceCount() {
        return appliances.size();
    }

    public void turnAllOff() {
        for (ElectricAppliance appliance : appliances) {
            if (appliance.isOn()) {
                appliance.turnOff();
            }
        }
    }

    public void plugAllIn() {
        for (ElectricAppliance appliance : appliances) {
            if (!appliance.isPluggedIn()) {
                appliance.plugIn();
            }
        }
    }

    public void unplugAll() {
        for (ElectricAppliance appliance : appliances) {
            try {
                if (appliance.isPluggedIn()) {
                    appliance.unplug();
                }
            } catch (OperationException e) {
                System.out.println("Помилка при відключенні " + appliance.getName() + ": " + e.getMessage());
            }
        }
    }
}

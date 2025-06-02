package practice_Mid.khdl.countrylistmanager.countrylistmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CountryListManager {
    // Singleton pattern
    private static CountryListManager instance;

    private List<AbstractCountry> countryList;

    private CountryListManager() {
        countryList = new LinkedList<>();
    }

    public static CountryListManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new CountryListManager();
        }
        return instance;
    }

    public List<AbstractCountry> getCountryList() {
        return this.countryList;
    }

    public void append(AbstractCountry country) {
        /* TODO */
        this.countryList.add(country);
    }

    public void add(AbstractCountry country, int index) {
        /* TODO */
        this.countryList.add(index, country);
    }

    public void remove(int index) {
        /* TODO */
        this.countryList.remove(index);
    }

    public void remove(AbstractCountry country) {
        /* TODO */
        this.countryList.remove(country);
    }

    public AbstractCountry countryAt(int index) {
        /* TODO */
        return this.countryList.get(index);
    }

    public List<AbstractCountry> sortPopulationIncreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort(Comparator.comparingInt(
                AbstractCountry::getPopulation));
        return newList;
    }

    public List<AbstractCountry> sortPopulationDecreasing() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort(Collections.reverseOrder(
                Comparator.comparingInt(AbstractCountry::getPopulation)));
        return newList;
    }

    public List<AbstractCountry> sortAreaIncreasing() {
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort((left, right) -> {
            if (left.getArea() > right.getArea()) {
                return 1;
            } else if (left.getArea() < right.getArea()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortAreaDecreasing() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort(Collections.reverseOrder((left, right) -> {
            if (left.getArea() > right.getArea()) {
                return 1;
            } else if (left.getArea() < right.getArea()) {
                return -1;
            } else {
                return 0;
            }
        }));
        return newList;
    }

    public List<AbstractCountry> sortGdpIncreasing() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort((left, right) -> {
            if (left.getGdp() > right.getGdp()) {
                return 1;
            } else if (left.getGdp() < right.getGdp()) {
                return -1;
            } else {
                return 0;
            }
        });
        return newList;
    }

    public List<AbstractCountry> sortGdpDecreasing() {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>(this.countryList);
        newList.sort(Collections.reverseOrder((left, right) -> {
            if (left.getGdp() > right.getGdp()) {
                return 1;
            } else if (left.getGdp() < right.getGdp()) {
                return -1;
            } else {
                return 0;
            }
        }));
        return newList;
    }

    public List<AbstractCountry> filterContinent(String continent) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : this.countryList) {
            if (country.getClassName().equals(continent + "Country")) {
                newList.add(country);
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesMostPopulous(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortPopulationDecreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesLeastPopulous(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortPopulationIncreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesLargestArea(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortAreaDecreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesSmallestArea(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortAreaIncreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesHighestGdp(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortGdpDecreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public List<AbstractCountry> filterCountriesLowestGdp(int howMany) {
        /* TODO */
        List<AbstractCountry> newList = new LinkedList<>();
        for (AbstractCountry country : sortGdpIncreasing()) {
            if (howMany > 0) {
                newList.add(country);
                howMany--;
            }
        }
        return newList;
    }

    public static String codeOfCountriesToString(List<AbstractCountry> countryList) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (AbstractCountry country : countryList) {
            codeOfCountries.append(country.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(List<AbstractCountry> countryList) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (AbstractCountry country : countryList) {
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}

package com.Rick_Cavallaro.Week_11;

import java.util.*;

interface WeatherDataSource {
    public void addListener(WeatherDataListener listener);
    public void update();
}

interface WeatherDataListener {
    public void update(WeatherData Data);
}

abstract class WeatherData {
        private String dataType;
        private double measuredValue;

    public WeatherData(String dataType, double measuredValue) {
        this.dataType = dataType;
        this.measuredValue = measuredValue;
    }

    public String getDataType() {
        return dataType;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }

    abstract public String getUpdateMessage();
}

class TemperatureSensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double temperature;

    TemperatureSensor() {
        readSensor();
    }

    public double getTemperature() {
        return temperature;
    }

    private void readSensor() {
        temperature = new Random().nextDouble() * 100.0;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("TemperatureSensor: getting new data");
        readSensor();
        for (WeatherDataListener listener: listeners) {
            listener.update(new WeatherData("temperature", temperature) {
                @Override
                public String getUpdateMessage() {
                    return "The new temperature is " + getMeasuredValue();
                }
            });
        }
    }
}

class HumiditySensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double humidity;

    HumiditySensor() {
        readSensor();
    }

    public double getHumidity() {
        return humidity;
    }

    private void readSensor() {
        humidity = new Random().nextDouble() * 100.0;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("HumiditySensor: getting new data");
        readSensor();
        for (WeatherDataListener listener: listeners) {
            listener.update(new WeatherData("humidity", humidity) {
                @Override
                public String getUpdateMessage() {
                    return "The new humidity is " + getMeasuredValue();
                }
            });
        }
    }
}

class PressureSensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double pressure;

    PressureSensor() {
        readSensor();
    }

    public double getPressure() {
        return pressure;
    }

    private void readSensor() {
        pressure = new Random().nextDouble() * 100.0;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("PressureSensor: getting new data");
        readSensor();
        for (WeatherDataListener listener: listeners) {
            listener.update(new WeatherData("pressure", pressure) {
                @Override
                public String getUpdateMessage() {
                    return "The new pressure is " + getMeasuredValue();
                }
            });
        }
    }
}

class WeatherStation implements WeatherDataListener {
    private Map<String, Double> weatherData = new HashMap<>();
    private List<String> log = new ArrayList<>();

    @Override
    public void update(WeatherData data) {
        System.out.println("WeatherStation: updating with new data: "
                + data.getDataType() + ", " + data.getMeasuredValue());
        weatherData.put(data.getDataType(),data.getMeasuredValue());
        log.add(data.getUpdateMessage());
    }

    public void displayCurrent() {
        System.out.println("Weather Report");
        for (String dataType: weatherData.keySet()) {
            System.out.println(dataType + ": " + weatherData.get(dataType));
        }
    }

    public void displayLog() {
        System.out.println("Log Messages");
        for (String message: log) {
            System.out.println(message);
        }
    }
}
/*abstract
class Rectangle{
    abstract public double getWidth();
    abstract public double getHeight();

    //static member class
    static class DoubleRectangle extends Rectangle {
        static double width, height;

        DoubleRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }
    }

    static class FloatRectangle extends Rectangle {
        static double width, height;

        FloatRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }

        private void Rectangle(){}

        double getArea(){
            return getHeight() * getWidth();
        }
    }


}
*/
/*
 * Created by Rick on 11/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main: creating instances");
        WeatherStation localWeatherStation = new WeatherStation();

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        temperatureSensor.addListener(localWeatherStation);
        humiditySensor.addListener(localWeatherStation);
        pressureSensor.addListener(localWeatherStation);

        System.out.println("Main: simulating updates from sensors");
        temperatureSensor.update();
        humiditySensor.update();
        pressureSensor.update();

        System.out.println("Main: display current conditions and log");
        localWeatherStation.displayCurrent();
        localWeatherStation.displayLog();
    }
}

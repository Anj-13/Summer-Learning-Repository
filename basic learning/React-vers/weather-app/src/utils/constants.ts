import { WeatherDataMap } from './formatWeather';

export const weatherData: WeatherDataMap = {
    london: {
        city: "London",
        temperature: 21,
        condition: "Cloudy",
        humidity: 70,
        windSpeed: 12,
        feelsLike: 20,
        type: "cloudy",
        forecast: [
            { day: "Mon", temperature: 21, condition: "Cloudy" },
            { day: "Tue", temperature: 19, condition: "Light rain" },
            { day: "Wed", temperature: 23, condition: "Sunny" },
            { day: "Thu", temperature: 22, condition: "Cloudy" },
            { day: "Fri", temperature: 18, condition: "Rain" }
        ]
      },
      tokyo: {
        city: "Tokyo",
        temperature: 29,
        condition: "Sunny",
        humidity: 58,
        windSpeed: 9,
        feelsLike: 31,
        type: "sunny",
        forecast: [
            { day: "Mon", temperature: 29, condition: "Sunny" },
            { day: "Tue", temperature: 30, condition: "Sunny" },
            { day: "Wed", temperature: 27, condition: "Cloudy" },
            { day: "Thu", temperature: 26, condition: "Rain" },
            { day: "Fri", temperature: 28, condition: "Clear" }
        ]
      },
      sydney: {
        city: "Sydney",
        temperature: 18,
        condition: "Light rain",
        humidity: 76,
        windSpeed: 17,
        feelsLike: 17,
        type: "rainy",
        forecast: [
            {day: "Mon", temperature: 18, condition: "Rain"},
            {day: "Tue", temperature: 20, condition: "Cloudy"},
            {day: "Wed", temperature: 21, condition: "Sunny"},
            {day: "Thu", temperature: 19, condition: "Breezy"},
            {day: "Fri", temperature: 22, condition: "Clear"},
        ]
      },
      nairobi: {
        city: "Nairobi",
        temperature: 24,
        condition: "Sunny",
        humidity: 46,
        windSpeed: 10,
        feelsLike: 24,
        type: "sunny",
        forecast: [
            {day: "Mon", temperature: 24, condition: "Sunny"},
            {day: "Tue", temperature: 25, condition: "Clear"},
            {day: "Wed", temperature: 23, condition: "Cloudy"},
            {day: "Thu", temperature: 24, condition: "Sunny"},
            {day: "Fri", temperature: 22, condition: "Rain"},
        ]
      },
      paris: {
        city: "Paris",
        temperature: 22,
        condition: "Cloudy",
        humidity: 62,
        windSpeed: 11,
        feelsLike: 21,
        type: "cloudy",
        forecast: [
            {day: "Mon", temperature: 22, condition: "Cloudy"},
            {day: "Tue", temperature: 24, condition: "Sunny"},
            {day: "Wed", temperature: 21, condition: "Rain"},
            {day: "Thu", temperature: 19, condition: "Cloudy"},
            {day: "Fri", temperature: 23, condition: "Sunny"},
        ]
      }
};

export const defaultFavourites = ["London", "Tokyo", "Sydney"];
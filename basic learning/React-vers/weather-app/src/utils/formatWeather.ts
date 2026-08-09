import { weatherData } from './constants';

export type WeatherType = 'sunny' | 'cloudy' | 'rainy' | 'stormy';

export interface forecastDay {
    day: string;
    temperature: number;
    condition: string;
}

export interface WeatherData {
    city: string;
    temperature: number;
    condition: string;
    humidity: number;
    windSpeed: number;
    feelsLike: number;
    type: WeatherType;
    forecast: forecastDay[];
}

export type WeatherDataMap = Record<string, WeatherData>;

export function titleCase(value: string): string {
    return value.trim()
        .toLowerCase()
        .split(/\s+/)
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(" ");
}

export function generatedWeather(city: string): WeatherData {
    const seed = [...city].reduce((total, letter) => total + letter.charCodeAt(0), 0);

    const conditions: Array<{ label: string; type: WeatherType }> = [
        { label: "Sunny", type: "sunny" },
        { label: "Cloudy", type: "cloudy" },
        { label: "Light rain", type: "rainy" },
        { label: "Storm clouds", type: "stormy" }
    ];

    const picked = conditions[seed % conditions.length];
    const base = 14 + (seed % 18);
    const days = ["Mon", "Tue", "Wed", "Thu", "Fri"];

    const forecast: forecastDay[] = days.map((day, index) => {
        const condition = conditions[(seed + index) % conditions.length].label;
        return {
            day,
            temperature: base + ((index % 3) - 1),
            condition
        };
    });

    return {
        city,
        temperature: base,
        condition: picked.label,
        humidity: 42 + (seed % 45),
        windSpeed: 6 + (seed % 20),
        feelsLike: base + ((seed % 5) - 2),
        type: picked.type,
        forecast
    };
}

export function getWeather(cityName: string): WeatherData {
    const normalized  = cityName.trim().toLowerCase();
    const existing = weatherData[normalized];

    if (existing) {
        return existing;
    }

    return generatedWeather(titleCase(cityName));
}

export function formatDate(date: Date = new Date()): string {
    return new Intl.DateTimeFormat("en", {
        weekday: "long",
        month: "long",
        day: "numeric"
    }).format(date);
}

export function validateCity(city: string): { valid: boolean; error?: string } {
    const trimmed = city.trim();
    
    if (!trimmed) {
      return { valid: false, error: "Please enter a city name." };
    }
    
    if (!/^[a-zA-Z\s.-]{2,}$/.test(trimmed)) {
      return { valid: false, error: "Use a valid city name with letters, spaces, periods, or hyphens." };
    }
    
    return { valid: true };
  }
import { defaultFavourites } from "./constants";

const STORAGE_KEY = "weather-favourites";

export function getFavorites(): string[] {
  const stored = localStorage.getItem(STORAGE_KEY);

  if (stored) {
    try {
      return JSON.parse(stored);
    } catch {
      return [];
    }
  }

  localStorage.setItem(STORAGE_KEY, JSON.stringify(defaultFavourites));
  return [...defaultFavourites];
}

export function saveFavorites(favourites: string[]): void {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(favourites));
}

export function addFavorites(favourites: string[], city: string): string[]{
    if(favourites.includes(city)) {
        return favourites;
    }
    return [city, ...favourites].slice(0,8);
}

export function removeFavorites(favourites: string[], city: string): string[] {
    return favourites.filter(c => c !== city);
}
import { useState, useEffect, useCallback } from 'react';
import { getFavorites, saveFavorites, addFavorites, removeFavorites } from '@/utils/favorites';

interface useFavoritesReturn {
    favorites: string[];
    addFavorite: (city:string) => void;
    removeFavorite: (city:string) => void;
    isFavorites: (city:string) => boolean;
}

export function useFavorites(): useFavoritesReturn {
    const [favorites, setFavorites] = useState<string[]>([]);

    useEffect(() => {
        const stored = getFavorites();
        setFavorites(stored);
    }, []);

    const addFavorite = useCallback((city: string) => {
        setFavorites(prev => {
            const updated = addFavorites(prev, city);
            saveFavorites(updated);
            return updated;
        });
    }, []);

    const removeFavorite = useCallback((city: string) => {
        setFavorites(prev => {
            const updated = removeFavorites(prev, city);
            saveFavorites(updated);
            return updated;
        });
    }, []);

    const isFavorites = useCallback((city: string) => {
        return favorites.includes(city);
    }, [favorites]);

    return {
        favorites,
        addFavorite,
        removeFavorite,
        isFavorites
    }
}
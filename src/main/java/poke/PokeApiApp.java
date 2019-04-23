package poke;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;


public class PokeApiApp {

    public static void main(String[] args) {
        try {

            int pokemonId = Integer.parseInt(args[0]);
            PokeApi pokeApi = new PokeApiClient();
            Pokemon pokemon = pokeApi.getPokemon(pokemonId);

            for (PokemonType type : pokemon.getTypes()) {
                System.out.println(type.getType().getName());
            }

        } catch (Exception e) {
            System.out.println("Exception in POKEMON API:- " + e);
        }
    }

}
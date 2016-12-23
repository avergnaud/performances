package com.catamania.crud;

import java.util.*;

public class CRUDService {

static HashMap<Integer,Personne> cache = new HashMap<>();

public List<Personne> getAllCountries()
{
        System.out.println("getAllCountries " + cache.values());
        return new ArrayList<Personne>(cache.values());
}

public Personne ajoutePersonne(Personne country)
{
        System.out.println("addCountry " + country);
        country.setId(cache.size()+1);
        cache.put(country.getId(), country);
        return country;
}

public Personne metAJourPersonne(Personne country)
{
        if(country.getId()<=0)
                return null;
        cache.put(country.getId(), country);
        return country;

}

public void SupprimePersonne(int id)
{
        cache.remove(id);
}

}

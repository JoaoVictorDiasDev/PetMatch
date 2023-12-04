package usp.br.petmatch.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class ChatGptModelResponse implements Serializable {
    public String age_baby;
    public String age_young;
    public String age_adult;
    public String age_senior;
    public String size_small;
    public String size_medium;
    public String size_large;
    public String size_extra_large;
    public String coat_curly;
    public String coat_short;
    public String coat_medium;
    public String coat_long;
    public String coat_wire;
    public String sex;
    public String neutered;
    public String special_needs;
    public String vaccinated;
    public String good_with_children;
    public String good_with_dogs;
    public String good_with_cats;
    public String house_trained;

    public PetModel getPetModel() {
        return new PetModel(
                age_senior != null && age_senior.equals("1"),
                age_adult != null && age_adult.equals("1"),
                age_young != null && age_young.equals("1"),
                age_baby != null && age_baby.equals("1"),
                size_extra_large != null && size_extra_large.equals("1"),
                size_large != null &&  size_large.equals("1"),
                size_medium != null &&  size_medium.equals("1"),
                size_small != null &&  size_small.equals("1"),
                coat_curly != null &&   coat_curly.equals("1"),
                coat_long != null && coat_long.equals("1"),
                coat_medium != null && coat_medium.equals("1"),
                coat_short != null && coat_short.equals("1"),
                coat_wire != null && coat_wire.equals("1"),
                sex != null && sex.equals("1"),
                neutered != null && neutered.equals("1"),
                house_trained != null && house_trained.equals("1"),
                special_needs != null && special_needs.equals("1"),
                vaccinated != null && vaccinated.equals("1"),
                good_with_children != null && good_with_children.equals("1"),
                good_with_dogs != null && good_with_dogs.equals("1"),
                good_with_cats != null && good_with_cats.equals("1"));
    }
}

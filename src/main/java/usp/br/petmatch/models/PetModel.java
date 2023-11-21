package usp.br.petmatch.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PETS")
public class PetModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPet;

    @Column(name = "name")
    private String name;

    @Column(name = "breed_primary")
    private String primaryBreed;

    @Column(name = "color_primary")
    private String primaryColor;

    @Column(name = "age_senior")
    private boolean seniorAge;

    @Column(name = "age_adult")
    private boolean adultAge;

    @Column(name = "age_young")
    private boolean youngAge;

    @Column(name = "age_babe")
    private boolean babeAge;

    @Column(name = "size_extra_large")
    private boolean extraLargeSize;

    @Column(name = "size_large")
    private boolean largeSize;

    @Column(name = "size_medium")
    private boolean mediumSize;

    @Column(name = "size_small")
    private boolean smallSize;

    @Column(name = "coat_curly")
    private boolean curlyCoat;

    @Column(name = "coat_long")
    private boolean longCoat;

    @Column(name = "coat_medium")
    private boolean mediumCoat;

    @Column(name = "coat_short")
    private boolean shortCoat;

    @Column(name = "coat_wire")
    private boolean wireCoat;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "fixed")
    private boolean fixed;

    @Column(name = "house_trained")
    private boolean houseTrained;

    @Column(name = "special_needs")
    private boolean specialNeeds;

    @Column(name = "vaccinated")
    private boolean vaccinated;

    @Column(name = "env_kids")
    private boolean goodWithKids;

    @Column(name = "env_dogs")
    private boolean goodWithDogs;

    @Column(name = "env_cats")
    private boolean goodWithCats;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;

    @Column(name = "posted")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime posted;

    @Column(name = "url")
    private String url;

    @Transient
    private double distanceToCurrentReference;

    public int[] toBinaryArray(){
        return new int[]{
            seniorAge ? 1 : 0,
            adultAge ? 1 : 0,
            youngAge ? 1 : 0,
            babeAge ? 1 : 0,
            extraLargeSize ? 1 : 0,
            largeSize ? 1 : 0,
            mediumSize ? 1 : 0,
            smallSize ? 1 : 0,
            curlyCoat ? 1 : 0,
            longCoat ? 1 : 0,
            mediumCoat ? 1 : 0,
            shortCoat ? 1 : 0,
            wireCoat ? 1 : 0,
            sex ? 1 : 0,
            fixed ? 1 : 0,
            houseTrained ? 1 : 0,
            specialNeeds ? 1 : 0,
            vaccinated ? 1 : 0,
            goodWithKids ? 1 : 0,
            goodWithDogs ? 1 : 0,
            goodWithCats ? 1 : 0,
        };
    }

    public UUID getIdPet() {
        return idPet;
    }

    public void setIdPet(UUID idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryBreed() {
        return primaryBreed;
    }

    public void setPrimaryBreed(String primaryBreed) {
        this.primaryBreed = primaryBreed;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public boolean isSeniorAge() {
        return seniorAge;
    }

    public void setSeniorAge(boolean seniorAge) {
        this.seniorAge = seniorAge;
    }

    public boolean isAdultAge() {
        return adultAge;
    }

    public void setAdultAge(boolean adultAge) {
        this.adultAge = adultAge;
    }

    public boolean isYoungAge() {
        return youngAge;
    }

    public void setYoungAge(boolean youngAge) {
        this.youngAge = youngAge;
    }

    public boolean isBabeAge() {
        return babeAge;
    }

    public void setBabeAge(boolean babeAge) {
        this.babeAge = babeAge;
    }

    public boolean isExtraLargeSize() {
        return extraLargeSize;
    }

    public void setExtraLargeSize(boolean extraLargeSize) {
        this.extraLargeSize = extraLargeSize;
    }

    public boolean isLargeSize() {
        return largeSize;
    }

    public void setLargeSize(boolean largeSize) {
        this.largeSize = largeSize;
    }

    public boolean isMediumSize() {
        return mediumSize;
    }

    public void setMediumSize(boolean mediumSize) {
        this.mediumSize = mediumSize;
    }

    public boolean isSmallSize() {
        return smallSize;
    }

    public void setSmallSize(boolean smallSize) {
        this.smallSize = smallSize;
    }

    public boolean isCurlyCoat() {
        return curlyCoat;
    }

    public void setCurlyCoat(boolean curlyCoat) {
        this.curlyCoat = curlyCoat;
    }

    public boolean isLongCoat() {
        return longCoat;
    }

    public void setLongCoat(boolean longCoat) {
        this.longCoat = longCoat;
    }

    public boolean isMediumCoat() {
        return mediumCoat;
    }

    public void setMediumCoat(boolean mediumCoat) {
        this.mediumCoat = mediumCoat;
    }

    public boolean isShortCoat() {
        return shortCoat;
    }

    public void setShortCoat(boolean shortCoat) {
        this.shortCoat = shortCoat;
    }

    public boolean isWireCoat() {
        return wireCoat;
    }

    public void setWireCoat(boolean wireCoat) {
        this.wireCoat = wireCoat;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public void setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isGoodWithKids() {
        return goodWithKids;
    }

    public void setGoodWithKids(boolean goodWithKids) {
        this.goodWithKids = goodWithKids;
    }

    public boolean isGoodWithDogs() {
        return goodWithDogs;
    }

    public void setGoodWithDogs(boolean goodWithDogs) {
        this.goodWithDogs = goodWithDogs;
    }

    public boolean isGoodWithCats() {
        return goodWithCats;
    }

    public void setGoodWithCats(boolean goodWithCats) {
        this.goodWithCats = goodWithCats;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getDistanceToCurrentReference() {
        return distanceToCurrentReference;
    }

    public void setDistanceToCurrentReference(double distanceToCurrentReference) {
        this.distanceToCurrentReference = distanceToCurrentReference;
    }
}

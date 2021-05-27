package com.example.myapplication.data.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class SearchResult(
    val response: String,
    val results: ArrayList<SuperHero>,
    val resultsFor: String
)

data class SuperHeroResponse(
    val error: String,
    val response: String,
    val superHero: ArrayList<SuperHero>
)

data class SuperHero(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Appearance::class.java.classLoader)!!,
        parcel.readParcelable(Biography::class.java.classLoader)!!,
        parcel.readParcelable(Connections::class.java.classLoader)!!,
        parcel.readString()?:"",
        parcel.readParcelable(Image::class.java.classLoader)!!,
        parcel.readString()?:"",
        parcel.readParcelable(Powerstats::class.java.classLoader)!!,
        parcel.readString()?:"",
        parcel.readParcelable(Work::class.java.classLoader)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(appearance, flags)
        parcel.writeParcelable(biography, flags)
        parcel.writeParcelable(connections, flags)
        parcel.writeString(id)
        parcel.writeParcelable(image,flags)
        parcel.writeString(name)
        parcel.writeParcelable(powerstats, flags)
        parcel.writeString(response)
        parcel.writeParcelable(work, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SuperHero> {
        override fun createFromParcel(parcel: Parcel): SuperHero {
            return SuperHero(parcel)
        }

        override fun newArray(size: Int): Array<SuperHero?> {
            return arrayOfNulls(size)
        }
    }
}

data class Appearance(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.createStringArrayList()?: emptyList(),
        parcel.readString()?:"",
        parcel.createStringArrayList()?: emptyList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(eyeColor)
        parcel.writeString(gender)
        parcel.writeString(hairColor)
        parcel.writeStringList(height)
        parcel.writeString(race)
        parcel.writeStringList(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Appearance> {
        override fun createFromParcel(parcel: Parcel): Appearance {
            return Appearance(parcel)
        }

        override fun newArray(size: Int): Array<Appearance?> {
            return arrayOfNulls(size)
        }
    }
}

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList()?: emptyList(),
        parcel.readString()?: "",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(aliases)
        parcel.writeString(alignment)
        parcel.writeString(alterEgos)
        parcel.writeString(firstAppearance)
        parcel.writeString(fullName)
        parcel.writeString(placeOfBirth)
        parcel.writeString(publisher)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Biography> {
        override fun createFromParcel(parcel: Parcel): Biography {
            return Biography(parcel)
        }

        override fun newArray(size: Int): Array<Biography?> {
            return arrayOfNulls(size)
        }
    }
}

data class Connections(
    val groupAffiliation: String,
    val relatives: String
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(groupAffiliation)
        parcel.writeString(relatives)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Connections> {
        override fun createFromParcel(parcel: Parcel): Connections {
            return Connections(parcel)
        }

        override fun newArray(size: Int): Array<Connections?> {
            return arrayOfNulls(size)
        }
    }
}
data class Image(
    val url: String
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()?:"") {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}

data class Powerstats(
    val combat: String,
    val durability: String,
    val intelligence: String,
    val power: String,
    val speed: String,
    val strength: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(combat)
        parcel.writeString(durability)
        parcel.writeString(intelligence)
        parcel.writeString(power)
        parcel.writeString(speed)
        parcel.writeString(strength)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Powerstats> {
        override fun createFromParcel(parcel: Parcel): Powerstats {
            return Powerstats(parcel)
        }

        override fun newArray(size: Int): Array<Powerstats?> {
            return arrayOfNulls(size)
        }
    }
}

data class Work(
    val base: String,
    val occupation: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(base)
        parcel.writeString(occupation)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Work> {
        override fun createFromParcel(parcel: Parcel): Work {
            return Work(parcel)
        }

        override fun newArray(size: Int): Array<Work?> {
            return arrayOfNulls(size)
        }
    }
}

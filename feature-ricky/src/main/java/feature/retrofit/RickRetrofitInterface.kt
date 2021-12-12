package feature.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {
    @SerializedName("characters")
    @Expose
    var characters: String? = null

    @SerializedName("locations")
    @Expose
    var locations: String? = null

    @SerializedName("episodes")
    @Expose
    var episodes: String? = null
}
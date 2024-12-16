package de.zelkulon.timezelkulon.tool
import com.google.gson.JsonDeserializer
import com.google.gson.JsonParseException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date> {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

    override fun deserialize(
        json: com.google.gson.JsonElement,
        typeOfT: java.lang.reflect.Type,
        context: com.google.gson.JsonDeserializationContext
    ): Date {
        return try {
            dateFormat.parse(json.asString)!!
        } catch (e: ParseException) {
            throw JsonParseException("Failed to parse Date", e)
        }
    }
}

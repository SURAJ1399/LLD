import java.io.File
import com.beust.klaxon.*

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Usage: kotlin FilterJson.kt <field_name> <filter_value>")
        return
    }

    // Path to the JSON file
    val jsonFilePath = "/path/to/your/json/file.json"

    // Read the JSON file
    val jsonString = File(jsonFilePath).readText()

    // Parse JSON
    val parser: Parser = Parser.default()
    val json: JsonObject = parser.parse(StringBuilder(jsonString)) as JsonObject

    // Get filter field name and value from command-line arguments
    val fieldName = args[0]
    val filterValue = args[1]

    // Filter JSON objects based on command-line arguments
    val filteredObjects = json.array<JsonObject>("your_array_key")?.filter {
        it.string(fieldName) == filterValue
    }

    // Print the filtered objects
    filteredObjects?.forEach {
        println(it.toJsonString(prettyPrint = true))
    }
}

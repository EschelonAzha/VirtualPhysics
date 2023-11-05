package symmetrical.cosmic.__transpectors.transpectors

object Doubles {
    // This fixes a big where numbers with decimal points are reported as integers
    // and integers are reported as doubles
    fun isDouble(value: Any?): Boolean {
        if (value == null)
            return false
        if (value is Double)
            return value.toString().contains(".")
        if (value is Int) {
            return !value.toString().contains(".")
        }
        return false
    }
    fun isInt(value: Any?): Boolean {
        if (value == null)
            return false
        if (value is Double)
            return !value.toString().contains(".")
        if (value is Int) {
            return !value.toString().contains(".")
        }
        return false
    }
}
package symmetrical.cosmic.transpectors.printable_characters


class LowerCase : Characters {
    companion object {
        const val LOWERCASE: String = "abcdefghijklmnopqrstuvwxyz";
    }
    constructor() : super() {
    }

    fun i() : LowerCase {
        super.i(LOWERCASE);
        return this;
    }
}
package symmetrical.cosmic.transpectors.printable_characters


class UpperCase : Characters {

    companion object {
        const val UPPERCASE: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    constructor() : super() {
    }

    fun i() : UpperCase {
        super.i(UPPERCASE);
        return this;
    }
}
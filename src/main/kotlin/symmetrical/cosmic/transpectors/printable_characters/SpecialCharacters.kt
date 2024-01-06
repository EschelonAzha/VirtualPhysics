package symmetrical.cosmic.transpectors.printable_characters


class SpecialCharacters : Characters {

    companion object {
        const val SPECIAL: String = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~"
    }
    constructor() : super() {
    }

    fun i() : SpecialCharacters {
        super.i(SPECIAL);
        return this;
    }
}